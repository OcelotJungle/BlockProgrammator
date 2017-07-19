package ru.ocelotjungle.blockprogrammer.events.events;

import java.sql.SQLException;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.DatabaseManager;
import ru.ocelotjungle.blockprogrammer.actions.ActionManager.ActionType;
import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
import ru.ocelotjungle.blockprogrammer.events.EventManager.EventType;

public class OnAttackEvent {
	
	public static void execute(PlayerInteractEvent evt) throws SQLException {
		if (evt.getAction() == Action.LEFT_CLICK_BLOCK) {
			DatabaseManager databaseManager = BlockProgrammer.plugin.getDatabaseManager();
			
			BlockProgram blockProgram = databaseManager.getBlockProgram(EventType.onAttack, evt.getClickedBlock().getLocation());
			
			for(ActionType actionType : ActionType.values()) {
				Object actionValue = blockProgram.getActionValue(actionType);
				if (actionValue != null || (actionValue instanceof Boolean && (Boolean)actionValue == Boolean.TRUE))
				actionType.getAction().execute(actionValue);
			}
		}
	}
}
