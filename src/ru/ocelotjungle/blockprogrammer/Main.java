package ru.ocelotjungle.blockprogrammer;

import java.util.LinkedHashSet;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import ru.ocelotjungle.blockprogrammer.commands.CommandManager;
import ru.ocelotjungle.blockprogrammer.events.EventListener;

public class Main extends JavaPlugin {
	
	public static Server server;
	public static Main plugin;
	public static final LinkedHashSet<Location> stepBlockList = new LinkedHashSet<Location>();
	
	public void onEnable() {
		
		server = getServer();
		plugin = this;
		
		new CommandManager(this);
		new EventListener(this);
		
		World world = server.getWorld("world");

		stepBlockList.add(new Location(world, -209, 63, 113));
		stepBlockList.add(new Location(world, -209, 63, 115));
		stepBlockList.add(new Location(world, -206, 63, 115));
		
		Logger.log("[BlockProgrammer] Enabled");
	}
	
	public void onDisable() {
		
		Logger.log("[BlockProgrammer] Disabled");
	}
}
