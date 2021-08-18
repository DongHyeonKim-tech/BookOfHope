package com.itbook.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itbook.controller.action.Action;

import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.event.EventRegisterAction;
import com.itbook.controller.action.event.EventRegisterFormAction;
import com.itbook.controller.action.event.EventUpdateAction;
import com.itbook.controller.action.event.EventUpdateFormAction;
import com.itbook.controller.action.event.EventDeleteAction;
import com.itbook.controller.action.event.EventListAction;
import com.itbook.controller.action.event.EventViewAction;
import com.itbook.controller.action.event.FileDownloadAction;

public class EventActionFactory {

	private static EventActionFactory instance = new EventActionFactory();

	private EventActionFactory() {
		super();
	}

	public static EventActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		
		String curtime = format.format(time);

		System.out.println(curtime + " - EventActionFactory : " + command);

		if (command.equals("main")) {
			action = new MainAction();

			// 기타 행사 리스트로 이동
		} else if (command.equals("eventList")) {
			action = new EventListAction();

		} else if (command.equals("eventView")) {
			action = new EventViewAction();

		} else if (command.equals("eventInsertForm")) {
			action = new EventRegisterFormAction();

		} else if (command.equals("eventInsert")) {
			action = new EventRegisterAction();

		} else if (command.equals("eventDelete")) {
			action = new EventDeleteAction();

		} else if (command.equals("eventUpdateForm")) {
			action = new EventUpdateFormAction();

		} else if (command.equals("eventUpdate")) {
			action = new EventUpdateAction();
			
		} else if (command.equals("fileDownloadAction")) {
			action = new FileDownloadAction();
		}

		return action;
	}

}
