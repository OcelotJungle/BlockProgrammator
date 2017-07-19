package ru.ocelotjungle.blockprogrammer.events;

import java.sql.SQLException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.events.events.OnAttackEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnBreakEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnClickEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnContainerOpenEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnMoveByPistonEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnRedstoneEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnRelianceEvent;
import ru.ocelotjungle.blockprogrammer.events.events.OnStepEvent;

public class EventManager implements Listener {
	
	public enum EventType {
		onAttack, onBreak, onClick, onContainerOpen, onMoveByPiston, onRedstone, onReliance, onStep
	}
	
	public EventManager(BlockProgrammer plugin) {
		
		plugin.getBukkitServer().getPluginManager().registerEvents(this, plugin);

	}
	
	@EventHandler
	public void onAttack(PlayerInteractEvent evt) throws SQLException {
		OnAttackEvent.execute(evt);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent evt) {
		OnBreakEvent.execute(evt);
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent evt) {
		OnClickEvent.execute(evt);
	}
	
	@EventHandler
	public void onMove(BlockPistonExtendEvent evt) {
		OnMoveByPistonEvent.execute(evt);
	}
	
	@EventHandler
	public void onMove(BlockPistonRetractEvent evt) {
		OnMoveByPistonEvent.execute(evt);
	}
	
	@EventHandler
	public void onOpen(PlayerInteractEvent evt) {
		OnContainerOpenEvent.execute(evt);
	}
	
	@EventHandler
	public void onRedstone(BlockRedstoneEvent evt) {
		OnRedstoneEvent.BlockPoweredByRedstoneEvent.execute(evt);
	}
	
	@EventHandler
	public void onStep(PlayerMoveEvent evt) {
		OnStepEvent.execute(evt);
	}
	
	@EventHandler
	public void onReliance(BlockPlaceEvent evt) {
		OnRelianceEvent.execute(evt);
	}
}
