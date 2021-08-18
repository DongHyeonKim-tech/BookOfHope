package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.report.ReportDetailFormAction;
import com.itbook.controller.action.report.ReportDeleteFormAction;
import com.itbook.controller.action.report.ReportListFormAction;
import com.itbook.controller.action.report.ReportRegAction;
import com.itbook.controller.action.report.ReportRegFormAction;
import com.itbook.controller.action.report.ReportUpdateAction;
import com.itbook.controller.action.report.ReportUpdateFormAction;

/**
 * @author 수아
 */

public class ReportActionFactory {

	private static ReportActionFactory instance = new ReportActionFactory();

	private ReportActionFactory() {
		super();
	}

	public static ReportActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("regActionFactory : " + command);

			// 독후감 리스트
		if (command.equals("Report_List")) {
			action = new ReportListFormAction();

			// 독후감 상세보기
		} else if (command.equals("Report_Detail")) {
			action = new ReportDetailFormAction();

			// 독후감 등록폼으로 이동
		} else if (command.equals("Report_Reg_Form")) {
			action = new ReportRegFormAction();

			// 독후감 등록
		} else if (command.equals("Report_Reg")) {
			action = new ReportRegAction();

			// 독후감 수정
		} else if (command.equals("Report_Update_Form")) {
			action = new ReportUpdateFormAction();
		
			// 독후감 수정확인
		} else if (command.equals("Report_Update")) {
			action = new ReportUpdateAction();

			// 독후감 삭제
		} else if (command.equals("Report_Delete")) {
			action = new ReportDeleteFormAction();

		
		}
		
		return action;
	}

}
