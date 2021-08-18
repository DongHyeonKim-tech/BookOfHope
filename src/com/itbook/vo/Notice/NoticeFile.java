package com.itbook.vo.Notice;
/**공지사항첨부파일 테이블
 * 공지사항파일번호
 * 파일명
 * 등록일
 * 공지사항번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class NoticeFile {
	
	private String noticeFileNum;
	private String noticeFileName;
	private Date noticeFileDate;
	private String noticeNum;
	public String getNoticeFileNum() {
		return noticeFileNum;
	}
	public void setNoticeFileNum(String noticeFileNum) {
		this.noticeFileNum = noticeFileNum;
	}
	public String getNoticeFileName() {
		return noticeFileName;
	}
	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}
	public Date getNoticeFileDate() {
		return noticeFileDate;
	}
	public void setNoticeFileDate(Date noticeFileDate) {
		this.noticeFileDate = noticeFileDate;
	}
	public String getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(String noticeNum) {
		this.noticeNum = noticeNum;
	}
	
	@Override
	public String toString() {
		return "NoticeFile [noticeFileNum=" + noticeFileNum + ", noticeFileName=" + noticeFileName + ", noticeFileDate="
				+ noticeFileDate + ", noticeNum=" + noticeNum + "]";
	}
	
	
}
