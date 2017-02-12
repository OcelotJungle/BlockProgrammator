package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import ru.ocelotjungle.blockprogrammer.Logger;

public class OnRelianceEvent {

	public static boolean execute(PlayerInteractEvent evt) {
		
		if (evt.getAction() == Action.RIGHT_CLICK_BLOCK && evt.isBlockInHand() && !evt.isCancelled()) {
			
			Logger.log("Block used as a reliance.");
		}
		
		return true;
	}

}
