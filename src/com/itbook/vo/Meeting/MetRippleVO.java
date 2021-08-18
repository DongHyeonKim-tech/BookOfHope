package com.itbook.vo.Meeting;
/**
 * 모임답글번호
 * 내용
 * 작성일자
 * 모임댓글번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class MetRippleVO {
	
	private String metRipNum;
	private String metRipContent;
	private Date metRipDate;
	private String metComtNum;
	private String memNum;
	public String getMetRipNum() {
		return metRipNum;
	}
	public void setMetRipNum(String metRipNum) {
		this.metRipNum = metRipNum;
	}
	public String getMetRipContent() {
		return metRipContent;
	}
	public void setMetRipContent(String metRipContent) {
		this.metRipContent = metRipContent;
	}
	public Date getMetRipDate() {
		return metRipDate;
	}
	public void setMetRipDate(Date metRipDate) {
		this.metRipDate = metRipDate;
	}
	public String getMetComtNum() {
		return metComtNum;
	}
	public void setMetComtNum(String metComtNum) {
		this.metComtNum = metComtNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "MetRipple [metRipNum=" + metRipNum + ", metRipContent=" + metRipContent + ", metRipDate=" + metRipDate
				+ ", metComtNum=" + metComtNum + ", memNum=" + memNum + "]";
	}
	
	
}
