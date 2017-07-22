package ru.ocelotjungle.blockprogrammer.events.events;

import java.sql.SQLException;

import org.bukkit.event.block.BlockBreakEvent;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
import ru.ocelotjungle.blockprogrammer.events.EventManager.EventType;

public class OnBreakEvent {
	
	public static void execute(BlockBreakEvent evt) throws SQLException {
		BlockProgram blockProgram = BlockProgrammer.plugin.getDatabaseManager().getBlockProgram(evt.getBlock().getLocation(), EventType.onBreak);
		if(blockProgram != null) {
			BlockProgrammer.plugin.getActionManager().execute(blockProgram);
		}
	}
}
