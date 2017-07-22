package ru.ocelotjungle.blockprogrammer.events.events;

import java.sql.SQLException;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
import ru.ocelotjungle.blockprogrammer.events.EventManager.EventType;

public class OnClickEvent {
	
	public static void execute(PlayerInteractEvent evt) throws SQLException {
		if (evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
			BlockProgram blockProgram = BlockProgrammer.plugin.getDatabaseManager().getBlockProgram(evt.getClickedBlock().getLocation(), EventType.onClick);
			if(blockProgram != null) {
				BlockProgrammer.plugin.getActionManager().execute(blockProgram);
			}
		}
	}
}
