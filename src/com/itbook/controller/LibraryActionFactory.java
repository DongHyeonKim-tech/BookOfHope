package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.library.AdminLibraryList;
import com.itbook.controller.action.library.LibraryDeleteAction;
import com.itbook.controller.action.library.LibraryListAction;
import com.itbook.controller.action.library.LibraryRegAction;
import com.itbook.controller.action.library.LibraryRegFormAction;
import com.itbook.controller.action.library.LibraryUpdateAction;
import com.itbook.controller.action.library.LibraryUpdateFormAction;


/**
 * @author �닔�븘
 */

public class LibraryActionFactory {

	private static LibraryActionFactory instance = new LibraryActionFactory();

	private LibraryActionFactory() {
		super();
	}

	public static LibraryActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("LibraryActionFactory : " + command);

		if (command.equals("main")) {
			action = new MainAction();

			// �룄�꽌愿� 由ъ뒪�듃濡� �씠�룞
		} else if (command.equals("libraryList")) {
			action = new LibraryListAction();

			// 愿�由ъ옄 �룄�꽌愿� 由ъ뒪�듃
		} else if (command.equals("adminLibraryList")) {
			action = new AdminLibraryList();

			// �룄�꽌愿� �벑濡�
		} else if (command.equals("libraryReg")) {
			action = new LibraryRegAction();

			// �룄�꽌愿� �벑濡� �뤌
		} else if (command.equals("libraryRegForm")) {
			action = new LibraryRegFormAction();

			// �룄�꽌愿� �닔�젙
		} else if (command.equals("libraryUpdate")) {
			action = new LibraryUpdateAction();

			// �룄�꽌愿� �닔�젙 �뤌
		} else if (command.equals("libraryUpdateForm")) {
			action = new LibraryUpdateFormAction();

			// �룄�꽌愿� �궘�젣
		}else if(command.equals("libraryDelete")) {
			action = new LibraryDeleteAction();
		}
		return action;
	}

}
