package com.itbook.vo.Meeting;

import java.util.Date;

/**
 * 모임게시글번호
 * 제목
 * 분류
 * 내용
 * 작성일자
 * 조회수
 * 첨부파일
 * 회원명
 * 회원번호
 * 모임번호
 * @author 정원
 *
 */
public class MetBoardVO {
	
	private String metBrdNum;
	private String metBrdName;
	private String metBrdCategory;
	private String metBrdContent;
	private Date regDate;
	private int metBrdCount;
	private String metBrdFile;
	private String memName;
	private String metNum;
	private String memNum;
	
	public String getMetBrdNum() {
		return metBrdNum;
	}
	public void setMetBrdNum(String metBrdNum) {
		this.metBrdNum = metBrdNum;
	}
	public String getMetBrdName() {
		return metBrdName;
	}
	public void setMetBrdName(String metBrdName) {
		this.metBrdName = metBrdName;
	}
	public String getMetBrdCategory() {
		return metBrdCategory;
	}
	public void setMetBrdCategory(String metBrdCategory) {
		this.metBrdCategory = metBrdCategory;
	}
	public String getMetBrdContent() {
		return metBrdContent;
	}
	public void setMetBrdContent(String metBrdContent) {
		this.metBrdContent = metBrdContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getMetBrdCount() {
		return metBrdCount;
	}
	public void setMetBrdCount(int metBrdCount) {
		this.metBrdCount = metBrdCount;
	}
	public String getMetBrdFile() {
		return metBrdFile;
	}
	public void setMetBrdFile(String metBrdFile) {
		this.metBrdFile = metBrdFile;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMetNum() {
		return metNum;
	}
	public void setMetNum(String metNum) {
		this.metNum = metNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	
	@Override
	public String toString() {
		return "MetBoardVO [metBrdNum=" + metBrdNum + ", metBrdName=" + metBrdName + ", metBrdCategory="
				+ metBrdCategory + ", metBrdContent=" + metBrdContent + ", regDate=" + regDate + ", metBrdCount="
				+ metBrdCount + ", metBrdFile=" + metBrdFile + ", memName=" + memName + ", metNum=" + metNum
				+ ", memNum=" + memNum + "]";
	}
	
}
