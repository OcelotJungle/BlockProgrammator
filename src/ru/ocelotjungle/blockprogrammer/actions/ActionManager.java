package ru.ocelotjungle.blockprogrammer.actions;

import ru.ocelotjungle.blockprogrammer.actions.actions.*;
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
	
	public void execute(ActionType actionType, String value) {
		actionType.getAction().execute(value);
	}
}