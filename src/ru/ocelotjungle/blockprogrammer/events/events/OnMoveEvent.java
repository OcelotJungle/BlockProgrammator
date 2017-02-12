package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import ru.ocelotjungle.blockprogrammer.Logger;

public interface OnMoveEvent {
	
	public static boolean execute(BlockPistonExtendEvent evt) {

		/*Logger.log("------------");
		Logger.log("Block = " + evt.getBlock());
		Logger.log("Blocks = " + evt.getBlocks());
		for (Block movedBlock : evt.getBlocks()) {
			Logger.log("-- Moved block: " + movedBlock);
		}
		Logger.log("Direction = " + evt.getDirection());
		Logger.log("Event Name = " + evt.getEventName());
		Logger.log("isSticky = " + evt.isSticky());*/
		
		Logger.log("Piston extended");
		
		return true;
	}
	
	public static boolean execute(BlockPistonRetractEvent evt) {

		/*Logger.log("------------");
		Logger.log("Block = " + evt.getBlock());
		Logger.log("Blocks = " + evt.getBlocks());
		for (Block movedBlock : evt.getBlocks()) {
			Logger.log("-- Moved block: " + movedBlock);
		}
		Logger.log("Direction = " + evt.getDirection());
		Logger.log("Event Name = " + evt.getEventName());
		Logger.log("isSticky = " + evt.isSticky());*/
		
		Logger.log("Piston retracted");
		
		return true;
	}
}
