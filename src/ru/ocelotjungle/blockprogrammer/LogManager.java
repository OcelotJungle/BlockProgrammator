package ru.ocelotjungle.blockprogrammer;

import java.util.logging.Logger;

public class LogManager {
	
	private Logger logger;
	
	public LogManager(BlockProgrammer plugin) {
		logger = plugin.getBukkitServer().getLogger();
	}
	
	public void log(Object Log) {
		logger.info(validate(Log));
	}

	public void log(Object... Logs) {
		StringBuilder result = new StringBuilder();
		for (Object Log : Logs) {
			result.append(Log.toString());
		}
		log(result);
	}

	public void error(Object Err) {
		logger.severe(validate(Err));
	}

	public void error(Object... Errs) {
		StringBuilder result = new StringBuilder();
		for (Object Err : Errs) {
			result.append(Err.toString());
		}
		error(result);
	}
	
	private String validate(Object object) {
		return object == null ? "null" : object.toString();
	}
}
