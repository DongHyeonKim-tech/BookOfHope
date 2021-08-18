package com.itbook.vo.Report;
/**독후감답글 테이블
 * 독후감답글번호
 * 내용
 * 작성일자
 * 독후감댓글번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class ReportRippleVO {
	
	private String reportRipNum;
	private String reportRipContent;
	private Date reportRipDate;
	private String reportComtNum;
	private String memNum;
	public String getReportRipNum() {
		return reportRipNum;
	}
	public void setReportRipNum(String reportRipNum) {
		this.reportRipNum = reportRipNum;
	}
	public String getReportRipContent() {
		return reportRipContent;
	}
	public void setReportRipContent(String reportRipContent) {
		this.reportRipContent = reportRipContent;
	}
	public Date getReportRipDate() {
		return reportRipDate;
	}
	public void setReportRipDate(Date reportRipDate) {
		this.reportRipDate = reportRipDate;
	}
	public String getReportComtNum() {
		return reportComtNum;
	}
	public void setReportComtNum(String reportComtNum) {
		this.reportComtNum = reportComtNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "ReportRipple [reportRipNum=" + reportRipNum + ", reportRipContent=" + reportRipContent
				+ ", reportRipDate=" + reportRipDate + ", reportComtNum=" + reportComtNum + ", memNum=" + memNum + "]";
	}
	
	
}
