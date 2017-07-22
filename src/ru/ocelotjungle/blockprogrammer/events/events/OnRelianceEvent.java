package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.event.block.BlockPlaceEvent;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
import ru.ocelotjungle.blockprogrammer.events.EventManager.EventType;

public class OnRelianceEvent {

	public static void execute(BlockPlaceEvent evt) {
		if (evt.canBuild()) {
			BlockProgram blockProgram = BlockProgrammer.plugin.getDatabaseManager().getBlockProgram(evt./* îé ÷¸ò õç ÿ */, EventType.onAttack);
			if(blockProgram != null) {
				BlockProgrammer.plugin.getActionManager().execute(blockProgram);
			}
		}
	}
}
