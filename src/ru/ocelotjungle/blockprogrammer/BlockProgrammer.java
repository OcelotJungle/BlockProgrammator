package ru.ocelotjungle.blockprogrammer;

import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import ru.ocelotjungle.blockprogrammer.commands.CommandManager;
import ru.ocelotjungle.blockprogrammer.events.EventManager;

public class BlockProgrammer extends JavaPlugin {
	
	private Server minecraftServer;
	private BlockProgrammer blockProgrammer;
	private ConfigManager configManager;
	private DatabaseManager databaseManager;
	private LogManager logManager;
	private EventManager eventManager;
	private CommandManager commandManager;
	
	public BlockProgrammer() throws SQLException {
		getLogger().setLevel(Level.OFF);
		
		minecraftServer = getServer();
		blockProgrammer = this;
		configManager = new ConfigManager(this);
		databaseManager = new DatabaseManager(this);
		logManager = new LogManager(this);
		eventManager = new EventManager(this);
		commandManager = new CommandManager(this);
	}
	
	public void onEnable() {
		getLogManager().log("[BlockProgrammer] Enabled");
	}
	
	public void onDisable() {
		getLogManager().log("[BlockProgrammer] Disabled");
	}
	
	public Server getBukkitServer() {
		return minecraftServer;
	}
	
	public BlockProgrammer getPlugin() {
		return blockProgrammer;
	}
	
	public ConfigManager getConfigManager() {
		return configManager;
	}
	
	public DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	public LogManager getLogManager() {
		return logManager;
	}
	
	public EventManager getEventManager() {
		return eventManager;
	}
	
	public CommandManager getCommandManager() {
		return commandManager;
	}
}
