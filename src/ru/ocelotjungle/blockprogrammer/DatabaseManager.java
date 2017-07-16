package ru.ocelotjungle.blockprogrammer;

import java.sql.*;

public class DatabaseManager {
	
	private BlockProgrammer plugin;
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public DatabaseManager(BlockProgrammer plugin) throws SQLException {
		this.plugin = plugin;
		
		connectDatabase();
		validateDatabase();
	}
	
	private void connectDatabase() throws SQLException {
		connection = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");
		statement = connection.createStatement();
	}
	
	private void validateDatabase() throws SQLException {
		String[] tableNames = {"onClick","onAttack","onBreak","onRedstone","onMove","onStep","onOpen"};
		for(String tableName : tableNames) {
			createTable(tableName);
		}
	}
	
	private void createTable(String tableName) throws SQLException {
		statement.execute("CREATE TABLE if not exists '" + tableName + "' "
				+ "('id' INT UNSIGNED NOT NULL PRIMARY KEY AUTOINCREMENT, "
				+ "'x' INT NOT NULL, 'y' TINYINT UNSIGNED NOT NULL, 'z' INT NOT NULL, "
				+ "'CE' VARCHAR(2048) NULL, 'CFC' VARCHAR(1024) NULL, 'RFC' VARCHAR(1024) NULL, 'RFCWR' VARCHAR(1024) NULL, "
				+ "'DP' BOOL NOT NULL DEFAULT 'false');");
	}
	
	private void closeDatabase() throws SQLException {
		connection.close();
		statement.close();
		resultSet.close();
	}
}
