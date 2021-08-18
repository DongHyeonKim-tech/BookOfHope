package com.itbook.vo.Meeting;
/**
 * 모임파일번호
 * 파일명
 * 등록일
 * 모임게시판번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class MetFileVO {
	
	private String metFileNum;
	private String metFileName;
	private Date metFileDate;
	private String metBrdNum;
	public String getMetFileNum() {
		return metFileNum;
	}
	public void setMetFileNum(String metFileNum) {
		this.metFileNum = metFileNum;
	}
	public String getMetFileName() {
		return metFileName;
	}
	public void setMetFileName(String metFileName) {
		this.metFileName = metFileName;
	}
	public Date getMetFileDate() {
		return metFileDate;
	}
	public void setMetFileDate(Date metFileDate) {
		this.metFileDate = metFileDate;
	}
	public String getMetBrdNum() {
		return metBrdNum;
	}
	public void setMetBrdNum(String metBrdNum) {
		this.metBrdNum = metBrdNum;
	}
	
	@Override
	public String toString() {
		return "MetFile [metFileNum=" + metFileNum + ", metFileName=" + metFileName + ", metFileDate=" + metFileDate
				+ ", metBrdNum=" + metBrdNum + "]";
	}
	
	
}
