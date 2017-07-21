package ru.ocelotjungle.blockprogrammer.actions.actions;

import java.sql.SQLException;

import org.bukkit.Location;

import ru.ocelotjungle.blockprogrammer.BlockProgrammer;
import ru.ocelotjungle.blockprogrammer.actions.BaseAction;

public class DeleteProgram extends BaseAction {

	@Override
	public void execute(Location location, Object value) throws SQLException {
		if((Boolean)value == Boolean.TRUE) {
			BlockProgrammer.plugin.getDatabaseManager().deleteProgram(location);
		}
	}
}
