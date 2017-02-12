package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.event.block.BlockBreakEvent;

import ru.ocelotjungle.blockprogrammer.Logger;

public interface OnBreakEvent {
	
	public static boolean execute(BlockBreakEvent evt) {
		
		Logger.log("Block broken");
		
		return true;
	}
}
