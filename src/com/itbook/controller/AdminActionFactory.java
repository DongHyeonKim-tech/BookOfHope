package com.itbook.controller;
import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.admin.AdminBookDeleteAction;
import com.itbook.controller.action.admin.AdminBookListFormAction;
import com.itbook.controller.action.admin.AdminMemberListDeleteAction;
import com.itbook.controller.action.admin.AdminFeePaymentListAction;
import com.itbook.controller.action.admin.AdminMeetingAcceptListAction;
import com.itbook.controller.action.admin.AdminMeetingDeleteAction;
import com.itbook.controller.action.admin.AdminMeetingListAction;
import com.itbook.controller.action.admin.AdminMeetingRefuseAction;
import com.itbook.controller.action.admin.AdminMeetingUpdateAction;
import com.itbook.controller.action.admin.AdminMemberDeleteAction;
import com.itbook.controller.action.admin.AdminMemberEmailListFormAction;
import com.itbook.controller.action.admin.AdminMemberListAction;
import com.itbook.controller.action.admin.AdminMemberListFormAction;
import com.itbook.controller.action.admin.AdminNoticeDeleteAction;
import com.itbook.controller.action.admin.AdminNoticeListFormAction;
import com.itbook.controller.action.admin.AdminReportDeleteAction;
import com.itbook.controller.action.admin.AdminReportListForm;
import com.itbook.controller.action.admin.AdminTaxListAction;
import com.itbook.controller.action.admin.AdminTodayBookDeleteAction;
import com.itbook.controller.action.admin.AdminTodayBookListFormAction;
import com.itbook.controller.action.admin.MailPopupForm;

public class AdminActionFactory {
	private static AdminActionFactory instance = new AdminActionFactory();
	
	private AdminActionFactory() {
		super();
	}
	
	public static AdminActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("AdminActionFactory : " + command);
		
		if(command.equals("main")) {
			action = new MainAction();
		} else if (command.equals("memberListForm")) {
			action = new AdminMemberListFormAction();
		} else if (command.equals("memberDelete")) {
			action = new AdminMemberDeleteAction();
		} else if (command.equals("bookListForm")) {
			action = new AdminBookListFormAction();
		} else if (command.equals("bookDelete")) {
			action = new AdminBookDeleteAction();
		} else if (command.equals("noticeListForm")) {
			action = new AdminNoticeListFormAction();
		}else if (command.equals("noticeDelete")) {
			action = new AdminNoticeDeleteAction();
		
			//�룆�썑媛� 由ъ뒪�듃濡� �씠�룞
		}else if(command.equals("mailPopupForm")) {
			action = new MailPopupForm();
		}
		else if(command.equals("reportListForm")) {
			action = new AdminReportListForm();
			//�룆�썑媛� 紐⑸줉 �궘�젣
		}else if(command.equals("reportDelete")) {
			action = new AdminReportDeleteAction();
			//�씠�떖�쓽 梨� 愿�由ъ옄 �솕硫댁쑝濡� �씠�룞
		}else if(command.equals("todayBookList")) {
			action = new AdminTodayBookListFormAction();
			//�씠�떖�쓽 梨� �궘�젣
		}else if(command.equals("todayBookDelete")) {
			action = new AdminTodayBookDeleteAction();
			//紐⑥엫 �듅�씤嫄곗젅 �솕硫댁쑝濡� �씠�룞
		}else if(command.equals("meetingAcceptListForm")) {
			action = new AdminMeetingAcceptListAction();
			//紐⑥엫 �듅�씤
		}else if(command.equals("meetingUpdate")) {
			action = new AdminMeetingUpdateAction();
			//紐⑥엫 由ъ뒪�듃(�듅�씤�맂 紐⑥엫�뱾) �궘�젣�솕硫댁쑝濡�
		}else if(command.equals("meetingListForm")) {
			action = new AdminMeetingListAction();
			//紐⑥엫 �궘�젣
		}else if(command.equals("meetingDelete")) {
			action = new AdminMeetingDeleteAction();
			//�썑�썝 愿�由�
		}else if(command.equals("feePaymentList")) {
			action = new AdminFeePaymentListAction();
			//紐⑥엫嫄곗젅
		}else if(command.equals("meetingRefuseAction")) {
			action = new AdminMeetingRefuseAction();
			//�쁺�닔利� �떊泥��궡�뿭
		}else if(command.equals("taxList")) {
			action = new AdminTaxListAction();
			
		}else if (command.equals("deleteMemberAction")) {
			action = new AdminMemberListDeleteAction();
			
		}else if(command.equals("adminMemberListAction")) {
			action = new AdminMemberListAction();
			
		}
		
			return action;
	}
}