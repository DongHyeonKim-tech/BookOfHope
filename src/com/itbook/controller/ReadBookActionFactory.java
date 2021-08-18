package com.itbook.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.readBook.FileDownloadAction;
import com.itbook.controller.action.readBook.ReadBookDeleteAction;
import com.itbook.controller.action.readBook.ReadBookListAction;
import com.itbook.controller.action.readBook.ReadBookRegisterAction;
import com.itbook.controller.action.readBook.ReadBookRegisterFormAction;
import com.itbook.controller.action.readBook.ReadBookUpdateAction;
import com.itbook.controller.action.readBook.ReadBookUpdateFormAction;
import com.itbook.controller.action.readBook.ReadBookViewAction;

public class ReadBookActionFactory {

	private static ReadBookActionFactory instance = new ReadBookActionFactory();

	private ReadBookActionFactory() {
		super();
	}

	public static ReadBookActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		
		String curtime = format.format(time);

		System.out.println(curtime + " - ReadBookActionFactory : " + command);

		if (command.equals("main")) {
			action = new MainAction();

			// 리스트로 이동
		} else if (command.equals("readBookList")) {
			action = new ReadBookListAction();

		} else if (command.equals("readBookView")) {
			action = new ReadBookViewAction();

		} else if (command.equals("readBookInsertForm")) {
			action = new ReadBookRegisterFormAction();

		} else if (command.equals("readBookInsert")) {
			action = new ReadBookRegisterAction();

		} else if (command.equals("readBookDelete")) {
			action = new ReadBookDeleteAction();

		} else if (command.equals("readBookUpdateForm")) {
			action = new ReadBookUpdateFormAction();

		} else if (command.equals("readBookUpdate")) {
			action = new ReadBookUpdateAction();

		} /*
			 * else if (command.equals("topReport")) { action = new
			 * TopReportAction(); }
			 */
		else if (command.equals("fileDownloadAction")) {

			action = new FileDownloadAction();
		}

		return action;
	}

}
