package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnClickEvent {
	
	public static void execute(PlayerInteractEvent evt) {

		if (evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
		}
		
	}
}
