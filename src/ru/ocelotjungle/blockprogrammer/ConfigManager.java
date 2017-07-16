package ru.ocelotjungle.blockprogrammer;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	private FileConfiguration mainConfig;
	private BlockProgrammer plugin;
	private File configFile = new File(plugin.getDataFolder(), "config.yml");
	
	public ConfigManager(BlockProgrammer plugin) {
		this.plugin = plugin;
	}
	
	public void saveConfig() {
		try {
			mainConfig.save(configFile);
		} catch (IOException ioe) {
			plugin.getLogManager().error("Cannot save config to disk with reason: ", ioe.getMessage());
		}
	}
	
	public void reloadConfig() {
		if (!configFile.exists()) {
			plugin.saveDefaultConfig();
		}
		mainConfig = YamlConfiguration.loadConfiguration(configFile);
	}
}
