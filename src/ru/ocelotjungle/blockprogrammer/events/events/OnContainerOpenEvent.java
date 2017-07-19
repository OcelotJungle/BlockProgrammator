package ru.ocelotjungle.blockprogrammer.events.events;

import org.bukkit.block.Lockable;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;

public class OnContainerOpenEvent {
	
	public static void execute(PlayerInteractEvent evt) {
		if (evt.getAction() == Action.RIGHT_CLICK_BLOCK && evt.getClickedBlock().getState() instanceof InventoryHolder) {
			
			Lockable lockable = (Lockable) evt.getClickedBlock().getState();
			String itemName = evt.getItem() != null ? evt.getItem().getItemMeta().getDisplayName() : "hand",
					lock = lockable.getLock();
			
			if (!lockable.isLocked() || (itemName != null && itemName.equals(lock))) {
				
			}
		}
	}
}
