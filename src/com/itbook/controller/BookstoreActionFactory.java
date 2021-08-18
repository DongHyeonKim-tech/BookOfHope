package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.bookstore.AdminBookstoreList;
import com.itbook.controller.action.bookstore.BookstoreDelete;
import com.itbook.controller.action.bookstore.BookstoreListAction;
import com.itbook.controller.action.bookstore.BookstoreRegister;
import com.itbook.controller.action.bookstore.BookstoreRegisterForm;
import com.itbook.controller.action.bookstore.BookstoreUpdate;
import com.itbook.controller.action.bookstore.BookstoreUpdateForm;

public class BookstoreActionFactory {
	
private static BookstoreActionFactory instance = new BookstoreActionFactory();
	
	private BookstoreActionFactory() {
		super();
	}
	
	public static BookstoreActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("BookstoreActionFactory : " + command);
		
		if(command.equals("main")) {
			action = new MainAction();
			//책방리스트로 이동
		}else if(command.equals("bookstoreList")) {
			action = new BookstoreListAction();
			
			//책방리스트로 이동(관리자)
		}else if(command.equals("adminBookstoreList")) {
			action = new AdminBookstoreList();
			
			//책방등록폼으로 이동(관리자)
		}else if(command.equals("bookstoreRegisterForm")) {
			action = new BookstoreRegisterForm();
			
			//책방등록(관리자)
		}else if(command.equals("bookstoreRegister")) {
			action = new BookstoreRegister();
			
			//책방 수정폼으로 이동(관리자)
		}else if(command.equals("bookstoreUpdateForm")) {
			action = new BookstoreUpdateForm();
			
			//책방 수정(관리자)
		}else if(command.equals("bookstoreUpdate")) {
			action = new BookstoreUpdate();
			
			//책방 삭제(관리자)
		}else if(command.equals("bookstoreDelete")) {
			action = new BookstoreDelete();
		}
		
		
		return action;
}
	
}