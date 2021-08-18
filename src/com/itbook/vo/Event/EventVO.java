package com.itbook.vo.Event;

import java.sql.Date;

public class EventVO {
	
	private String eventNo;
	private String memNum;
	private String eventName;
	private String writer;
	private String eventDate;
	private String eventPlace;
	private String eventContents;
	private String eventFile;
	private Date regDate;
	private int eventCount;
	public String getEventNo() {
		return eventNo;
	}
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventPlace() {
		return eventPlace;
	}
	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}
	public String getEventContents() {
		return eventContents;
	}
	public void setEventContents(String eventContents) {
		this.eventContents = eventContents;
	}
	public String getEventFile() {
		return eventFile;
	}
	public void setEventFile(String eventFile) {
		this.eventFile = eventFile;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getEventCount() {
		return eventCount;
	}
	public void setEventCount(int eventCount) {
		this.eventCount = eventCount;
	}
	@Override
	public String toString() {
		return "EventVO [eventNo=" + eventNo + ", memNum=" + memNum + ", eventName=" + eventName + ", writer=" + writer
				+ ", eventDate=" + eventDate + ", eventPlace=" + eventPlace + ", eventContents=" + eventContents
				+ ", eventFile=" + eventFile + ", regDate=" + regDate + ", eventCount=" + eventCount + "]";
	}

	
	
	

}
