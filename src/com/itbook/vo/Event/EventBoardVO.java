package com.itbook.vo.Event;
/**
 * 행사게시판번호
 * 행사제목
 * 행사내용
 * 작성일자
 * 조회수
 * 행사번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class EventBoardVO {
	
	private int eventBrdNum;
	private String eventBrdTitle;
	private String eventBrdContent;
	private Date eventBrdDate;
	private int eventCount;
	private int eventNum;
	private int memNum;
	public int getEventBrdNum() {
		return eventBrdNum;
	}
	public void setEventBrdNum(int eventBrdNum) {
		this.eventBrdNum = eventBrdNum;
	}
	public String getEventBrdTitle() {
		return eventBrdTitle;
	}
	public void setEventBrdTitle(String eventBrdTitle) {
		this.eventBrdTitle = eventBrdTitle;
	}
	public String getEventBrdContent() {
		return eventBrdContent;
	}
	public void setEventBrdContent(String eventBrdContent) {
		this.eventBrdContent = eventBrdContent;
	}
	public Date getEventBrdDate() {
		return eventBrdDate;
	}
	public void setEventBrdDate(Date eventBrdDate) {
		this.eventBrdDate = eventBrdDate;
	}
	public int getEventCount() {
		return eventCount;
	}
	public void setEventCount(int eventCount) {
		this.eventCount = eventCount;
	}
	public int getEventNum() {
		return eventNum;
	}
	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "EventBoard [eventBrdNum=" + eventBrdNum + ", eventBrdTitle=" + eventBrdTitle + ", eventBrdContent="
				+ eventBrdContent + ", eventBrdDate=" + eventBrdDate + ", eventCount=" + eventCount + ", eventNum="
				+ eventNum + ", memNum=" + memNum + "]";
	}
	
	
}
