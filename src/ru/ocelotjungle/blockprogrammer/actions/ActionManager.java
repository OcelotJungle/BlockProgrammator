package ru.ocelotjungle.blockprogrammer.actions;

import java.sql.SQLException;

import ru.ocelotjungle.blockprogrammer.actions.actions.CommandExecution;
import ru.ocelotjungle.blockprogrammer.actions.actions.CycledFormChanging;
import ru.ocelotjungle.blockprogrammer.actions.actions.DeleteProgram;
import ru.ocelotjungle.blockprogrammer.actions.actions.RandomFormChanging;
import ru.ocelotjungle.blockprogrammer.actions.actions.RandomFormChangingWithRepeats;
import ru.ocelotjungle.blockprogrammer.blockprogram.BlockProgram;
public class ActionManager {
	
	public enum ActionType {
		commandExecution("CE", new CommandExecution()), cycledFormChanging("CFC", new CycledFormChanging()), 
		randomFormChanging("RFC", new RandomFormChanging()), randomFormChangingWithRepeats("RFCWR", new RandomFormChangingWithRepeats()), 
		deleteProgram("DP", new DeleteProgram());
		
		private String shortname;
		private BaseAction action;
		
		ActionType(String shortname, BaseAction action) {
			this.shortname = shortname;
			this.action = action;
		}
		
		public String getShortname() {
			return shortname;
		}
		
		public BaseAction getAction() {
			return action;
		}
	}

	public void execute(BlockProgram blockProgram) throws SQLException {
		for(ActionType actionType : ActionType.values()) { // for all types of actions
			Object actionValue = blockProgram.getActionValue(actionType); // get value of this action from program
			if (actionValue != null || (actionValue instanceof Boolean && (Boolean)actionValue == Boolean.TRUE)) { // if value exists or means true
				actionType.getAction().execute(blockProgram.getLocation(), actionValue); // execute appropriate action with got value 
			}
		}
	}
}