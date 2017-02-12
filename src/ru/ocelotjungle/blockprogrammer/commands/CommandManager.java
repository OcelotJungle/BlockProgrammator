package ru.ocelotjungle.blockprogrammer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ru.ocelotjungle.blockprogrammer.Main;

public class CommandManager implements CommandExecutor {
	
	public CommandManager(Main plugin) {
		plugin.getCommand("blockprogrammer").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return true;
	}
}
