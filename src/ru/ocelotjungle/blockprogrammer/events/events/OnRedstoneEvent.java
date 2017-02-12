package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.event.block.BlockRedstoneEvent;

public class OnRedstoneEvent {

	public static boolean execute(BlockRedstoneEvent evt) {

		/*Logger.log("-------------");
		Logger.log(evt.getBlock());
		Logger.log(evt.getEventName());
		Logger.log(evt.getNewCurrent());
		Logger.log(evt.getOldCurrent());
		Logger.log("-------------");*/
		
		/*Block block = Main.server.getWorld("world").getBlockAt(-205, 64, 125);
		
		int oldBlockPower = block.getBlockPower();
		
		Main.server.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
				if (block.getBlockPower() != oldBlockPower) {
					Logger.log("Block Power changed -> " + block.getBlockPower());
				}
			}
		});*/
		
		return true;
	}

}
