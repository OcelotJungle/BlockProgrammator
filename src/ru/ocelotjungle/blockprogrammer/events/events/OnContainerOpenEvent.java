package ru.ocelotjungle.blockprogrammer.events.events;

import java.sql.SQLException;

import org.bukkit.block.Lockable;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
import ru.ocelotjungle.blockprogrammer.events.EventManager.EventType;

public class OnContainerOpenEvent {
	
	public static void execute(PlayerInteractEvent evt) throws SQLException {
		if (evt.getAction() == Action.RIGHT_CLICK_BLOCK && evt.getClickedBlock().getState() instanceof InventoryHolder) {
			
			Lockable lockable = (Lockable) evt.getClickedBlock().getState();
			String itemName = evt.getItem() != null ? evt.getItem().getItemMeta().getDisplayName() : "hand",
					lock = lockable.getLock();
			
			if (!lockable.isLocked() || (itemName != null && itemName.equals(lock))) {
				BlockProgram blockProgram = BlockProgrammer.plugin.getDatabaseManager().getBlockProgram(evt.getClickedBlock().getLocation(), EventType.onContainerOpen);
				if(blockProgram != null) {
					BlockProgrammer.plugin.getActionManager().execute(blockProgram);
				}
			}
		}
	}
}
