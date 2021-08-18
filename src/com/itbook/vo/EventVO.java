package com.itbook.vo;
/**
 * 행사번호
 * 행사명
 * 행사일자
 * 행사장소
 * 주최자
 * 내용
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class EventVO {
	
	private int eventNum;
	private String eventTitle;
	private Date eventDate;
	private String eventPlace;
	private String promoter;
	private String eventContent;
	private int memNum;
	public int getEventNum() {
		return eventNum;
	}
	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventPlace() {
		return eventPlace;
	}
	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}
	public String getPromoter() {
		return promoter;
	}
	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "Event [eventNum=" + eventNum + ", eventTitle=" + eventTitle + ", eventDate=" + eventDate
				+ ", eventPlace=" + eventPlace + ", promoter=" + promoter + ", eventContent=" + eventContent
				+ ", memNum=" + memNum + "]";
	}
	
	
}
