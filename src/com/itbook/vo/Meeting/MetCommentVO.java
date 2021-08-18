package com.itbook.vo.Meeting;

/**
 * 모임게시글댓글번호
 * 모임게시글댓글내용
 * 모임게시글댓글작성일자
 * 회원명
 * 회원번호
 * 모임게시글번호
 * @author 정원
 */

import java.sql.Date;

public class MetCommentVO {
	
	private String metComtNum;
	private String metComtContent;
	private Date metComtDate;
	private String memName;
	private String memNum;
	private String metBrdNum;
	
	public String getMetComtNum() {
		return metComtNum;
	}
	public void setMetComtNum(String metComtNum) {
		this.metComtNum = metComtNum;
	}
	public String getMetComtContent() {
		return metComtContent;
	}
	public void setMetComtContent(String metComtContent) {
		this.metComtContent = metComtContent;
	}
	public Date getMetComtDate() {
		return metComtDate;
	}
	public void setMetComtDate(Date metComtDate) {
		this.metComtDate = metComtDate;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getMetBrdNum() {
		return metBrdNum;
	}
	public void setMetBrdNum(String metBrdNum) {
		this.metBrdNum = metBrdNum;
	}
	
	
	@Override
	public String toString() {
		return "MetCommentVO [metComtNum=" + metComtNum + ", metComtContent=" + metComtContent + ", metComtDate="
				+ metComtDate + ", memName=" + memName + ", memNum=" + memNum + ", metBrdNum=" + metBrdNum + "]";
	}
	
}
