package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.event.player.PlayerMoveEvent;

public class OnStepEvent {

	public static void execute(PlayerMoveEvent evt) {
		
		/*BlockVector oldPos = evt.getFrom().toVector().toBlockVector(),
					newPos = evt.getTo().toVector().toBlockVector();
		
		//BlockVector oldPos = new BlockVector
		
		if (oldPos.getBlockX() != newPos.getBlockX() ||
			oldPos.getBlockY() != newPos.getBlockY() ||
			oldPos.getBlockZ() != newPos.getBlockZ()) {
			
			newPos.setY(newPos.getBlockY() - 1);
			
			if (Main.stepBlockList.contains(newPos.toLocation(Main.server.getWorld("world")))) {
				evt.getPlayer().sendMessage(String.format("CONT %d %d %d", newPos.getBlockX(), newPos.getBlockY(), newPos.getBlockZ()));
				
			} else {
				
				evt.getPlayer().sendMessage(String.format("NOT CONT %d %d %d", newPos.getBlockX(), newPos.getBlockY(), newPos.getBlockZ()));
			}	
		} */
		
		
		/*Vector player = evt.getTo().toVector();
		BlockVector intPlayer = new BlockVector(player.getBlockX(), player.getBlockY() - 1, player.getBlockZ());
		
		if (Main.stepBlockList.contains(intPlayer.toLocation(Main.server.getWorld("world")))) {
			
			Logger.log("CONTAINS");
			
			Vector blockPos = loc.toVector().toBlockVector();
			BlockVector block = new BlockVector(blockPos.getBlockX(), blockPos.getBlockY(), blockPos.getBlockZ()),
						player = new BlockVector(playerPos.getBlockX(), playerPos.getBlockY() - 1, playerPos.getBlockZ());
			
			if (block.equals(player)) {
				
			}
		} else {
			Logger.log("NOT CONTAINS");
		}*/
		
	}
}
