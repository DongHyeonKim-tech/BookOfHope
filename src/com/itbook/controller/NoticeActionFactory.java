package com.itbook.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.notice.DonationListFormAction;
import com.itbook.controller.action.notice.DonationWriteFormAction;
import com.itbook.controller.action.notice.FileDownloadAction;
import com.itbook.controller.action.notice.IntroAction;
import com.itbook.controller.action.notice.IntroBusinessFormAction;
import com.itbook.controller.action.notice.MapAction;
import com.itbook.controller.action.notice.NoticeDeleteAction;
import com.itbook.controller.action.notice.NoticeInsertAction;
import com.itbook.controller.action.notice.NoticeInsertFormAction;
import com.itbook.controller.action.notice.NoticeListFormAction;
import com.itbook.controller.action.notice.NoticeUpdateAction;
import com.itbook.controller.action.notice.NoticeUpdateFormAction;
import com.itbook.controller.action.notice.NoticeViewAction;
import com.itbook.controller.action.notice.TeamAction;
import com.itbook.controller.action.notice.TimeLineAction;
import com.itbook.controller.action.notice.YearEndTaxFormAction;
import com.itbook.controller.action.notice.YearEndTaxInsertAction;

/**
 * request로 받아온 매개변수의 command의 값으로 
 * 각 기능을 수행할 액션을 분기하는 클래스
 * 
 * action추가 시 최대한 기능별로 정렬될 수 있도록 한다.
 * 
 * @author 김정민
 *
 */

public class NoticeActionFactory {

	public static NoticeActionFactory instance = new NoticeActionFactory();
	
	private NoticeActionFactory() {
		super();
	}
	
	public static NoticeActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		
		String curtime = format.format(time);
		
		System.out.println(curtime + " - NoticeActionFactory : " + command);
		
		if (command.equals("main")) {
			action = new MainAction();
		}	else if (command.equals("noticeListFormAction")) {
			
			action = new NoticeListFormAction();
			
		} else if (command.equals("noticeInsertFormAction")) {
			
			action = new NoticeInsertFormAction();
			
		} else if (command.equals("noticeInsertAction")) {
			
			action = new NoticeInsertAction();
			
		} else if (command.equals("noticeViewAction")) {

			action = new NoticeViewAction();

		} else if (command.equals("noticeUpdateAction")) {

			action = new NoticeUpdateAction();

		} else if (command.equals("noticeUpdateFormAction")) {

			action = new NoticeUpdateFormAction();

		} else if (command.equals("noticeDeleteAction")) {

			action = new NoticeDeleteAction();

		} else if (command.equals("fileDownloadAction")) {

			action = new FileDownloadAction();

		} else if (command.equals("introAction")) {

			action = new IntroAction();

		} else if (command.equals("donationListFormAction")) {

			action = new DonationListFormAction();

		} else if (command.equals("donationWriteFormAction")) {

			action = new DonationWriteFormAction();

		} else if (command.equals("introBusinessFormAction")) {

			action = new IntroBusinessFormAction();

		} else if (command.equals("yearEndTaxFormAction")) {

			action = new YearEndTaxFormAction();

		} else if (command.equals("yearEndTaxInsertAction")) {

			action = new YearEndTaxInsertAction();

		} else if (command.equals("timeLineAction")) {

			action = new TimeLineAction();

		} else if (command.equals("teamAction")) {

			action = new TeamAction();

		} else if (command.equals("mapAction")) {

			action = new MapAction();

		}
		
		return action;
		
	}
	
	
	
	
}
