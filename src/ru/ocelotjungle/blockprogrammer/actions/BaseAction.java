package ru.ocelotjungle.blockprogrammer.actions;

import java.sql.SQLException;

import org.bukkit.Location;

public abstract class BaseAction {
	
	public abstract void execute(Location location, Object value) throws SQLException;
}
