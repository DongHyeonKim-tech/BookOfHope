package com.itbook.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.booktalk.BookTalkDeleteAction;
import com.itbook.controller.action.booktalk.BookTalkInsertAction;
import com.itbook.controller.action.booktalk.BookTalkInsertFormAction;
import com.itbook.controller.action.booktalk.BookTalkListFormAction;
import com.itbook.controller.action.booktalk.BookTalkUpdateAction;
import com.itbook.controller.action.booktalk.BookTalkUpdateFormAction;
import com.itbook.controller.action.booktalk.BookTalkViewAction;
import com.itbook.controller.action.booktalk.FileDownloadAction;



public class BookTalkActionFactory {
public static BookTalkActionFactory instance = new BookTalkActionFactory();
	
	private BookTalkActionFactory() {
		super();
	}
	
	public static BookTalkActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		
		String curtime = format.format(time);
		
		System.out.println(curtime + " - BookTalkActionFactory : " + command);
		
		if (command.equals("main")) {
			action = new MainAction();
		}	else if (command.equals("bookTalkListFormAction")) {
			
			action = new BookTalkListFormAction();
			
		} else if (command.equals("bookTalkInsertFormAction")) {
			
			action = new BookTalkInsertFormAction();
			
		} else if (command.equals("bookTalkInsertAction")) {
			
			action = new BookTalkInsertAction();
			
		} else if (command.equals("bookTalkViewAction")) {

			action = new BookTalkViewAction();

		} else if (command.equals("bookTalkUpdateAction")) {

			action = new BookTalkUpdateAction();

		} else if (command.equals("bookTalkUpdateFormAction")) {

			action = new BookTalkUpdateFormAction();

		} else if (command.equals("bookTalkDeleteAction")) {

			action = new BookTalkDeleteAction();

		} 
		else if (command.equals("fileDownloadAction")) {

			action = new FileDownloadAction();

		}
		
		
		return action;
}
}