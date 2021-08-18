package com.itbook.vo.Report;
/**����媛�寃��������대�
 * ����媛�寃�����踰���
 * ����媛���紐�
 * ����媛��댁��
 * ���깆�쇱��
 * 議고����
 * 梨�踰���
 * ����踰���
 * @author 醫���
 *
 */

import java.sql.Date;

public class ReportBoardVO {

	private String reportNum;
	private String reportTitle;
	private String reportContent;
	private Date reportDate;
	private int reportCount;
	private String memName;
	private String writer;
	private String publisher;
	private String reportCategory;
	private String bookNum;
	private String memNum;
	private String bookTitle;
	public String getReportNum() {
		return reportNum;
	}
	public void setReportNum(String reportNum) {
		this.reportNum = reportNum;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public int getReportCount() {
		return reportCount;
	}
	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getReportCategory() {
		return reportCategory;
	}
	public void setReportCategory(String reportCategory) {
		this.reportCategory = reportCategory;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	@Override
	public String toString() {
		return "ReportBoardVO [reportNum=" + reportNum + ", reportTitle=" + reportTitle + ", reportContent="
				+ reportContent + ", reportDate=" + reportDate + ", reportCount=" + reportCount + ", memName=" + memName
				+ ", writer=" + writer + ", publisher=" + publisher + ", reportCategory=" + reportCategory
				+ ", bookNum=" + bookNum + ", memNum=" + memNum + ", bookTitle=" + bookTitle + "]";
	}

	
	
	
}
