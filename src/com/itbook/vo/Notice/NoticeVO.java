package com.itbook.vo.Notice;

import java.sql.Date;

/**
 * 
 * 공지사항 등록, 수정, 삭제, 조회를 할 수 있는 클래스(싱글톤)
 * 
 * @author 김정민
 *
 */

public class NoticeVO {
	
	private String noticeNum;
	private String noticeTitle;
	private String noticeCategory;
	private String noticeContent;
	private Date noticeDate;
	private int noticeCount;
	private String noticeFile;
	private String memNum;
	
	
	public String getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(String noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeCategory() {
		return noticeCategory;
	}
	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public int getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	public String getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	

	@Override
	public String toString() {
		return "NoticeVO [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeCategory="
				+ noticeCategory + ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", noticeCount="
				+ noticeCount + ", noticeFile=" + noticeFile + ", memNum=" + memNum + "]";
	}

	
}
