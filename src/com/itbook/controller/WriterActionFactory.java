package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.writer.AdminWriterDeleteAction;
import com.itbook.controller.action.writer.AdminWriterListAction;
import com.itbook.controller.action.writer.AdminWriterRegisterAction;
import com.itbook.controller.action.writer.AdminWriterRegisterFormAction;
import com.itbook.controller.action.writer.AdminWriterUpdateAction;
import com.itbook.controller.action.writer.AdminWriterUpdateFormAction;
import com.itbook.controller.action.writer.WriterListAction;
import com.itbook.controller.action.writer.WriterViewAction;

public class WriterActionFactory {

	private static WriterActionFactory instance = new WriterActionFactory();

	private WriterActionFactory() {
		super();
	}

	public static WriterActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("WriterActionFactory : " + command);

		if (command.equals("main")) {
			action = new MainAction();
			// 관리자가 이달의 책 리스트 화면으로 이동.
		} else if (command.equals("adminWriterList")) {
			action = new AdminWriterListAction();

			// 관리가자 이달의 책리스트에서 등록버튼을 눌렀을 때 등록폼으로 이동.(리스트-->등록폼)
		} else if (command.equals("adminWriterRegisterFormAction")) {
			action = new AdminWriterRegisterFormAction();

			// 관리자가 이달의 책 등록하기.
		} else if (command.equals("adminWriterRegister")) {
			action = new AdminWriterRegisterAction();

			// 관리자가 이달의 책 수정폼으로 이동하기.(제목을 클릭했을 때)
		} else if (command.equals("adminWriterUpdateFormAction")) {
			action = new AdminWriterUpdateFormAction();

			// 관리자가 이달의 책 수정하기.
		} else if (command.equals("adminWriterUpdate")) {
			action = new AdminWriterUpdateAction();

			// 관리자가 이달의 책 삭제하기.
		} else if (command.equals("adminWriterDelete")) {
			action = new AdminWriterDeleteAction();
			
		} else if (command.equals("writerView")) {
			action = new WriterViewAction();
			// 이달의 책 리스트
		} else if (command.equals("writerList")) {
			action = new WriterListAction();

		}

		return action;
	}
}
