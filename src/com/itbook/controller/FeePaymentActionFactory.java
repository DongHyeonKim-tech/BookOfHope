package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.feePayment.FeePaymentRegisterAction;

public class FeePaymentActionFactory {

	private static FeePaymentActionFactory instance = new FeePaymentActionFactory();

	private FeePaymentActionFactory() {
		super();
	}

	public static FeePaymentActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("FeePaymentActionFactory : " + command);

		if (command.equals("main")) {
			action = new MainAction();
			//  이동
		} else if (command.equals("feePaymentRegister")) {
			action = new FeePaymentRegisterAction();
		}
		return action;
	}
}