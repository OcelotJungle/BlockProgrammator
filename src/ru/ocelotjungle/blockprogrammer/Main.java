package ru.ocelotjungle.blockprogrammer;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ru.ocelotjungle.blockprogrammer.commands.CommandManager;
import ru.ocelotjungle.blockprogrammer.events.EventListener;

public class Main extends JavaPlugin {
	
	public static Server server;
	public static Main plugin;
	/*public static final LinkedHashSet<Location> stepBlockList = new LinkedHashSet<Location>();*/
	
	public Main() {
		
		getLogger().setLevel(Level.OFF);
	}
	
	public void onEnable() {
		
		server = getServer();
		plugin = this;
		
		new CommandManager(this);
		new EventListener(this);
		
		/*World world = server.getWorld("world");
		stepBlockList.add(new Location(world, -209, 63, 113));
		stepBlockList.add(new Location(world, -209, 63, 115));
		stepBlockList.add(new Location(world, -206, 63, 115));*/
		
		Logger.log(DB.Connect());
		Logger.log(DB.Create());
		
		//Statement stmt = DB.statement;
		
		//try {
			//stmt.execute("DELETE FROM 'blocks'");
			//stmt.execute("VACUUM");
			
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "cfg.yml"));
			
			//DB.connection.setAutoCommit(true);
			
			//String sql = "INSERT INTO 'blocks' VALUES (?, ?, ?, ?);";
			
			//PreparedStatement ps = DB.connection.prepareStatement(sql);
			
			for (int i = 0; i < 100; i++) {
				Logger.log("Next: " + i);
				for (int j = 0; j < 100; j++) {
				
					/*ps.setString(1, "playername" + i + "-" + j);
					ps.setInt(2, 255);
					ps.setInt(3, 255);
					ps.setInt(4, 255);
					
					ps.addBatch();*/
					
					//cfg.set("players.playername" + i, "0xFFFFFF");
					
					cfg.set("players.playername" + i + "-" + j, "0xFFFFFF");
					Logger.log("--Writing: " + j);
				}
				//ps.executeBatch();
			}
			//ps.executeBatch();
			
			//DB.connection.commit();
			
			//stmt.execute("INSERT INTO 'blocks' VALUES ('playername" + i + "', 255, 255, 255)");
			
			try { cfg.save(new File(getDataFolder(), "cfg.yml")); } 
			catch (IOException e) { e.printStackTrace(); }
			
		/*} catch (SQLException e) { e.printStackTrace(); }*/
		
		//Logger.log(DB.Log());
		//Logger.log(DB.Close());
		
		Logger.log("[BlockProgrammer] Enabled");
	}
	
	public void onDisable() {
		
		Logger.log("[BlockProgrammer] Disabled");
	}
}
