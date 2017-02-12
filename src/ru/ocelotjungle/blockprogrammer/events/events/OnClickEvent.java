package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import ru.ocelotjungle.blockprogrammer.Logger;

public interface OnClickEvent {
	
	public static boolean execute(PlayerInteractEvent evt) {
		/*Logger.log("------------");
		Logger.log("Action = " + evt.getAction());
		Logger.log("BlockFace = " + evt.getBlockFace());
		Logger.log("ClickedBlock = " + evt.getClickedBlock());
		Logger.log("EventName = " + evt.getEventName());
		Logger.log("Hand = " + evt.getHand());
		Logger.log("Item = " + evt.getItem());
		Logger.log("Material = " + evt.getMaterial());
		Logger.log("Player = " + evt.getPlayer());
		Logger.log("hasBlock = " + evt.hasBlock());
		Logger.log("hasItem = " + evt.hasItem());
		Logger.log("isBlockInHand = " + evt.isBlockInHand());
		Logger.log("isCancelled = " + evt.isCancelled());
		Logger.log("Material name = " + evt.getMaterial().name());*/
		
		if (evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Logger.log("Click to block");
		}
		
		return true;
	}
}
