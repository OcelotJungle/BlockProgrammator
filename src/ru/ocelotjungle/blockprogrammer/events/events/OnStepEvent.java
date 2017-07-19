package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnStepEvent {

	public static void execute(PlayerMoveEvent evt) {
		Location from = evt.getFrom(), to = evt.getTo();
		if(from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ()) {
			
		}
	}
}
