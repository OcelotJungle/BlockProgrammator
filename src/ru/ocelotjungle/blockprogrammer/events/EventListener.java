package ru.ocelotjungle.blockprogrammer.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import ru.ocelotjungle.blockprogrammer.Main;
import ru.ocelotjungle.blockprogrammer.events.events.OnBreakEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnClickEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnMoveEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnOpenEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnRedstoneEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnStepEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnRelianceEvent;

public class EventListener implements Listener {
	
	public EventListener(Main plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static boolean onBreak(BlockBreakEvent evt) {
		return OnBreakEvent.execute(evt);
	}
	
	@EventHandler
	public static boolean onClick(PlayerInteractEvent evt) {
		return OnClickEvent.execute(evt);
	}
	
	@EventHandler
	public static boolean onMove(BlockPistonExtendEvent evt) {
		return OnMoveEvent.execute(evt);
	}
	
	@EventHandler
	public static boolean onMove(BlockPistonRetractEvent evt) {
		return OnMoveEvent.execute(evt);
	}
	
	@EventHandler
	public static boolean onOpen(PlayerInteractEvent evt) {
		return OnOpenEvent.execute(evt);
	}
	
	@EventHandler
	public static boolean onRedstone(BlockRedstoneEvent evt) {
		return OnRedstoneEvent.execute(evt);
	}
	
	@EventHandler
	public static boolean onStep(PlayerMoveEvent evt) {
		return OnStepEvent.execute(evt);
	}
	
	@EventHandler
	public static boolean onReliance(PlayerInteractEvent evt) {
		return OnRelianceEvent.execute(evt);
	}
}
