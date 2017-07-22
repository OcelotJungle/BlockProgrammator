package ru.ocelotjungle.blockprogrammer.events.events;

import java.sql.SQLException;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
import ru.ocelotjungle.blockprogrammer.events.EventManager.EventType;

public class OnStepEvent {

	public static void execute(PlayerMoveEvent evt) throws SQLException {
		Location from = evt.getFrom(), to = evt.getTo();
		if(from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ()) {
			BlockProgram blockProgram = BlockProgrammer.plugin.getDatabaseManager().getBlockProgram(evt.getTo().getBlock().getLocation(), EventType.onStep);
			if(blockProgram != null) {
				BlockProgrammer.plugin.getActionManager().execute(blockProgram);
			}
		}
	}
}
