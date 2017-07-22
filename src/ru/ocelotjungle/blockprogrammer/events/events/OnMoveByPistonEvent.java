package ru.ocelotjungle.blockprogrammer.events.events;

import java.sql.SQLException;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
import ru.ocelotjungle.blockprogrammer.events.EventManager.EventType;

public class OnMoveByPistonEvent {
	
	public static void execute(BlockPistonExtendEvent evt) throws SQLException {
		for(Block block : evt.getBlocks()) {
			execute(block.getLocation());
		}
	}
	
	public static void execute(BlockPistonRetractEvent evt) throws SQLException {
		for(Block block : evt.getBlocks()) {
			execute(block.getLocation());
		}
	}
	
	private static void execute(Location location) throws SQLException {
		BlockProgram blockProgram = BlockProgrammer.plugin.getDatabaseManager().getBlockProgram(location, EventType.onMoveByPiston);
		if(blockProgram != null) {
			BlockProgrammer.plugin.getActionManager().execute(blockProgram);
		}
	}
}
