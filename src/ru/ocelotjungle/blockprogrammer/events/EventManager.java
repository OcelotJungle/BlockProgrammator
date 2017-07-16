package ru.ocelotjungle.blockprogrammer.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.events.events.OnBreakEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnClickEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnMoveByPistonEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnContainerOpenEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnRedstoneEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnStepEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnRelianceEvent;

public class EventManager implements Listener {
	
	public EventManager(BlockProgrammer plugin) {
		
		plugin.getBukkitServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void onBreak(BlockBreakEvent evt) {
		OnBreakEvent.execute(evt);
	}
	
	@EventHandler
	public static void onClick(PlayerInteractEvent evt) {
		OnClickEvent.execute(evt);
	}
	
	@EventHandler
	public static void onMove(BlockPistonExtendEvent evt) {
		OnMoveByPistonEvent.execute(evt);
	}
	
	@EventHandler
	public static void onMove(BlockPistonRetractEvent evt) {
		OnMoveByPistonEvent.execute(evt);
	}
	
	@EventHandler
	public static void onOpen(PlayerInteractEvent evt) {
		OnContainerOpenEvent.execute(evt);
	}
	
	@EventHandler
	public static void onRedstone(BlockRedstoneEvent evt) {
		OnRedstoneEvent.execute(evt);
	}
	
	@EventHandler
	public static void onStep(PlayerMoveEvent evt) {
		OnStepEvent.execute(evt);
	}
	
	@EventHandler
	public static void onReliance(PlayerInteractEvent evt) {
		OnRelianceEvent.execute(evt);
	}
}
