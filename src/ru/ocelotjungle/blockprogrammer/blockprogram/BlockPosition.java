package ru.ocelotjungle.blockprogrammer.blockprogram;

import org.bukkit.Location;

public class BlockPosition {
	private long id;
	private Location location;
	
	public BlockPosition(long id, Location location) {
		this.id = id;
		this.location = location;
	}
	
	public long getId() {
		return id;
	}
	
	public Location getLocation() {
		return location;
	}
}
