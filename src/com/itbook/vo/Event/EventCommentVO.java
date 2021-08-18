package com.itbook.vo.Event;
/**행사댓글 테이블
 * 행사답글번호
 * 내용
 * 작성일자
 * 행사게시글번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class EventCommentVO {
	
	private int eventComtNum;
	private String eventComtContent;
	private Date eventComtDate;
	private int eventBrdNum;
	private int memNum;
	public int getEventComtNum() {
		return eventComtNum;
	}
	public void setEventComtNum(int eventComtNum) {
		this.eventComtNum = eventComtNum;
	}
	public String getEventComtContent() {
		return eventComtContent;
	}
	public void setEventComtContent(String eventComtContent) {
		this.eventComtContent = eventComtContent;
	}
	public Date getEventComtDate() {
		return eventComtDate;
	}
	public void setEventComtDate(Date eventComtDate) {
		this.eventComtDate = eventComtDate;
	}
	public int getEventBrdNum() {
		return eventBrdNum;
	}
	public void setEventBrdNum(int eventBrdNum) {
		this.eventBrdNum = eventBrdNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "EventCommentVO [eventComtNum=" + eventComtNum + ", eventComtContent=" + eventComtContent
				+ ", eventComtDate=" + eventComtDate + ", eventBrdNum=" + eventBrdNum + ", memNum=" + memNum + "]";
	}
	
	
}
