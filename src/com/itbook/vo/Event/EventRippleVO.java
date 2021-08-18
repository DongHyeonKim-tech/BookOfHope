package com.itbook.vo.Event;
/** 행사답글테이블
 * 행사답글번호
 * 내용
 * 작성일자
 * 행사댓글번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class EventRippleVO {
 
	private int eventRipNum;
	private String eventRipContent;
	private Date eventRipDate;
	private int evnetComtNum;
	private int memNum;
	public int getEventRipNum() {
		return eventRipNum;
	}
	public void setEventRipNum(int eventRipNum) {
		this.eventRipNum = eventRipNum;
	}
	public String getEventRipContent() {
		return eventRipContent;
	}
	public void setEventRipContent(String eventRipContent) {
		this.eventRipContent = eventRipContent;
	}
	public Date getEventRipDate() {
		return eventRipDate;
	}
	public void setEventRipDate(Date eventRipDate) {
		this.eventRipDate = eventRipDate;
	}
	public int getEvnetComtNum() {
		return evnetComtNum;
	}
	public void setEvnetComtNum(int evnetComtNum) {
		this.evnetComtNum = evnetComtNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "EventRipple [eventRipNum=" + eventRipNum + ", eventRipContent=" + eventRipContent + ", eventRipDate="
				+ eventRipDate + ", evnetComtNum=" + evnetComtNum + ", memNum=" + memNum + "]";
	}
	
	
}
