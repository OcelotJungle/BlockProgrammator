package ru.ocelotjungle.blockprogrammer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Location;
import org.bukkit.World;

import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
import ru.ocelotjungle.blockprogrammer.events.EventManager.EventType;

public class DatabaseManager {
	
	private BlockProgrammer plugin;
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	private String tablePrefix;
	
	public DatabaseManager(BlockProgrammer plugin) throws SQLException {
		this.plugin = plugin;
		tablePrefix = plugin.getConfigManager().getTablePrefix();
	}
	
	public void initializeDatabase() throws SQLException {
		connectDatabase();
		validateDatabase();
		
		connection.setAutoCommit(true);
	}
	
	private void connectDatabase() throws SQLException {
		connection = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");
		statement = connection.createStatement();
	}
	
	private void validateDatabase() throws SQLException {
		for(EventType tableName : EventType.values()) {
			createTable(tableName.name());
		}
		
		createDimensionTable();
	}
	
	private void createTable(String tableName) throws SQLException {
		statement.execute("CREATE TABLE IF NOT EXISTS '" + tablePrefix + "_" + tableName + "' "
				+ "('id' INT UNSIGNED NOT NULL PRIMARY KEY AUTOINCREMENT, "
				+ "'dimensionid' INT NOT NULL, 'x' INT NOT NULL, 'y' TINYINT UNSIGNED NOT NULL, 'z' INT NOT NULL, "
				+ "'CE' TEXT NULL, 'CFC' TEXT NULL, 'RFC' TEXT NULL, 'RFCWR' TEXT NULL, "
				+ "'DP' BOOL NOT NULL DEFAULT 'false');");
	}
	
	private void createDimensionTable() throws SQLException {
		statement.execute("CREATE TABLE IF NOT EXISTS '" + tablePrefix + "_dimensions' "
				+ "('id' INT UNSIGNED NOT NULL PRIMARY KEY AUTOINCREMENT, 'dimension' TEXT);");
		
		for(World world : plugin.getBukkitServer().getWorlds()) {
			statement.execute("INSERT INTO '" + tablePrefix + "_dimensions' ('dimension') VALUES ('" + world.getName() + "');");
		}
	}
	
	/*public void saveDatabase() throws SQLException {
		connection.commit();
	}*/
	
	public void closeDatabase() throws SQLException {
		connection.close();
		statement.close();
		resultSet.close();
	}
	
	public BlockProgram getBlockProgram(Location location, EventType eventType) throws SQLException {
		
		resultSet = statement.executeQuery("SELECT 'CE', 'CFC', 'RFC', 'RFCWR', 'DP' from '" + tablePrefix + "_" + eventType.name() + "' "
				+ "WHERE " + getBlockInfo(location) + ";");
		
		return new BlockProgram(location, resultSet.getString("CE"), resultSet.getString("CFC"), 
								resultSet.getString("RFC"), resultSet.getString("RFCWR"), resultSet.getBoolean("DP"));
		
	}
	
	public void deleteProgram(Location location) throws SQLException {
		
		for(EventType eventType : EventType.values()) {
			statement.execute("DELETE FROM '" + tablePrefix + "_" + eventType.name() + "' "
					+ "WHERE " + getBlockInfo(location) + ";");
		}
	}
	
	private String getBlockInfo(Location location) throws SQLException {
		return String.format("'x' = %d AND 'y' = %d AND 'z' = %d AND dimensionid = %d", 
							location.getBlockX(), location.getBlockY(), location.getBlockZ(), getDimensionId(location.getWorld().getName()));
	}
	
	private int getDimensionId(String dimensionName) throws SQLException {
		int dimensionId = statement.executeQuery("SELECT 'id' FROM '" + tablePrefix + "_dimensions' "
				+ "WHERE 'dimension' = '" + dimensionName + "';").getInt("id");
		
		return dimensionId;
	}
}
