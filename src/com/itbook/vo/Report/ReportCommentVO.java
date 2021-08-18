package com.itbook.vo.Report;
/**독후감댓글테이블
 * 독후감댓글번호
 * 내용
 * 작성일자
 * 독후감게시글번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class ReportCommentVO {
	
	private String reportComtNum;
	private String reportComtContent;
	private Date reportComtDate;
	private String reportNum;
	private String memNum;
	private String memName;
	
	public String getReportComtNum() {
		return reportComtNum;
	}
	public void setReportComtNum(String reportComtNum) {
		this.reportComtNum = reportComtNum;
	}
	public String getReportComtContent() {
		return reportComtContent;
	}
	public void setReportComtContent(String reportComtContent) {
		this.reportComtContent = reportComtContent;
	}
	public Date getReportComtDate() {
		return reportComtDate;
	}
	public void setReportComtDate(Date reportComtDate) {
		this.reportComtDate = reportComtDate;
	}
	public String getReportNum() {
		return reportNum;
	}
	public void setReportNum(String reportNum) {
		this.reportNum = reportNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	@Override
	public String toString() {
		return "ReportCommentVO [reportComtNum=" + reportComtNum + ", reportComtContent=" + reportComtContent
				+ ", reportComtDate=" + reportComtDate + ", reportNum=" + reportNum + ", memNum=" + memNum
				+ ", memName=" + memName + "]";
	}
	
	
}
