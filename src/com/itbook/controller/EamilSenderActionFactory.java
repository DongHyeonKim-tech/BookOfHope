package com.itbook.controller;

import com.itbook.controller.action.SendEmail;
import com.itbook.controller.action.admin.SendEmailAction;

public class EamilSenderActionFactory {

	private static EamilSenderActionFactory instance = new EamilSenderActionFactory();

	private EamilSenderActionFactory() {
		super();
	}

	public static EamilSenderActionFactory getInstance() {
		return instance;
	}

	public SendEmail getAction(String command) {
		SendEmail action = null;

		System.out.println("EmailSenderActionFactory : " + command);

		//독후감
		if (command.equals("senderEmail")) {
			action = new SendEmailAction();

		}
		return action;
	}

}
