package com.itbook.controller;
import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.book.AdminTodayBookDeleteAction;
import com.itbook.controller.action.book.AdminTodayBookListAction;
import com.itbook.controller.action.book.AdminTodayBookRegisterAction;
import com.itbook.controller.action.book.AdminTodayBookRegisterFormAction;
import com.itbook.controller.action.book.AdminTodayBookSelectSearchAction;
import com.itbook.controller.action.book.AdminTodayBookUpdateAction;
import com.itbook.controller.action.book.AdminTodayBookUpdateFormAction;
import com.itbook.controller.action.book.AdminTodaybookSearchAction;
import com.itbook.controller.action.book.BookDeleteAction;
import com.itbook.controller.action.book.BookListAction;
import com.itbook.controller.action.book.BookRegisterAction;
import com.itbook.controller.action.book.BookRegisterFormAction;
import com.itbook.controller.action.book.BookUpdateAction;
import com.itbook.controller.action.book.BookUpdateFormAction;
import com.itbook.controller.action.book.TodayBookListAction;

public class BookActionFactory {
	private static BookActionFactory instance = new BookActionFactory();
	
	private BookActionFactory() {
		super();
	}
	
	public static BookActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("BookActionFactory : " + command);
		
		if(command.equals("main")) {
			action = new MainAction();
			//관리자가 이달의 책  리스트 화면으로 이동.
		}else if(command.equals("adminTodayBookList")) {
			action = new AdminTodayBookListAction();
			
			//관리가자 이달의 책리스트에서 등록버튼을 눌렀을 때 등록폼으로 이동.(리스트-->등록폼)
		}else if(command.equals("adminTodayBookRegFormAction")) {
			action = new AdminTodayBookRegisterFormAction();
			
			//관리자가 이달의 책 등록하기.
		}else if(command.equals("adminTodayBookRegister")) {
			action = new AdminTodayBookRegisterAction();
			
			//관리자가 이달의 책 수정폼으로 이동하기.(제목을 클릭했을 때)
		}else if(command.equals("adminTodayBookUpdateFormAction")) {
			action = new AdminTodayBookUpdateFormAction();
			
			//관리자가 이달의 책 수정하기.
		}else if(command.equals("adminTodayBookUpdate")) {
			action = new AdminTodayBookUpdateAction();	
			
			//관리자가 이달의 책 삭제하기.
		}else if(command.equals("adminTodayBookDelete")) {
			action = new AdminTodayBookDeleteAction();				
			
			//이달의 책 리스트
		}else if(command.equals("todayBookList")) {
			action = new TodayBookListAction();	
			
			//책 검색 팝업 눌렀을 때 등록된 모든 책 출력
		} else if (command.equals("bookPopup")) {
			action = new AdminTodayBookSelectSearchAction();
			
			//이달의 책에서 책 검색할 때
		}
		else if(command.equals("bookListSearch")) {
			action = new AdminTodaybookSearchAction();	
			
			//첵 리스트화면으로 이동하기.
		}else if(command.equals("bookList")) {
			action = new BookListAction();
			
			//책리스트에서 등록버튼을 눌렀을 때 등록폼으로 이동.
		}else if(command.equals("bookRegFormAction")) {
			action = new BookRegisterFormAction();
			
			//책등록폼에서 등록할 때
		}else if(command.equals("bookRegister")) {
			action = new BookRegisterAction();
			
			//책리스트에서 책번호를 눌렀을때 수정폼으로 이동
		}else if(command.equals("bookUpdateFormAction")) {
			action = new BookUpdateFormAction();
			
			//책 수정폼에서 수정할 때
		}else if(command.equals("bookUpdate")) {
			action = new BookUpdateAction();
			
			//책 삭제할 때
		}else if(command.equals("bookDelete")) {
			action = new BookDeleteAction();
			
		}
		
		
			return action;
	}
}