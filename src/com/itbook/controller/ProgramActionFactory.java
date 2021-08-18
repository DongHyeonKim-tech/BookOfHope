package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.program.ProgramDeleteAction;
import com.itbook.controller.action.program.ProgramInsertAction;
import com.itbook.controller.action.program.ProgramInsertFormAction;
import com.itbook.controller.action.program.ProgramListFormAction;
import com.itbook.controller.action.program.ProgramUpdateAction;
import com.itbook.controller.action.program.ProgramUpdateFormAction;
import com.itbook.controller.action.program.ProgramViewAction;

public class ProgramActionFactory {
	public static  ProgramActionFactory instance = new  ProgramActionFactory();
	
	private ProgramActionFactory() {
		super();
	}
	public static ProgramActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		
		if (command.equals("main")) {
			action = new MainAction();
		}	else if (command.equals("programListFormAction")) {
			
			action = new ProgramListFormAction();
			
		} else if (command.equals("programInsertFormAction")) {
			
			action = new ProgramInsertFormAction();
			
		} else if (command.equals("programInsertAction")) {
			
			action = new ProgramInsertAction();
			
		} else if (command.equals("programViewAction")) {

			action = new ProgramViewAction();

		} else if (command.equals("programUpdateAction")) {

			action = new ProgramUpdateAction();

		} else if (command.equals("programUpdateFormAction")) {

			action = new ProgramUpdateFormAction();

		} else if (command.equals("programDeleteAction")) {

			action = new ProgramDeleteAction();

		} 
		return action;
	}
}
