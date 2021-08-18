package com.itbook.vo.Meeting;
/**
 * 모임게시글번호
 * 제목
 * 내용
 * 작성일자
 * 조회수
 * 모임게시판번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class MetPostVO {
	
	private String metPostNum;
	private String metPostTitle;
	private String metPostContent;
	private Date metPostDate;
	private int metPostCount;
	private String metBrdNum;
	private String metPostFile;
	private String metPostCategory;
	
	public String getMetPostFile() {
		return metPostFile;
	}
	public void setMetPostFile(String metPostFile) {
		this.metPostFile = metPostFile;
	}
	public String getMetPostCategory() {
		return metPostCategory;
	}
	public void setMetPostCategory(String metPostCategory) {
		this.metPostCategory = metPostCategory;
	}
	public String getMetPostNum() {
		return metPostNum;
	}
	public void setMetPostNum(String metPostNum) {
		this.metPostNum = metPostNum;
	}
	public String getMetPostTitle() {
		return metPostTitle;
	}
	public void setMetPostTitle(String metPostTitle) {
		this.metPostTitle = metPostTitle;
	}
	public String getMetPostContent() {
		return metPostContent;
	}
	public void setMetPostContent(String metPostContent) {
		this.metPostContent = metPostContent;
	}
	public Date getMetPostDate() {
		return metPostDate;
	}
	public void setMetPostDate(Date metPostDate) {
		this.metPostDate = metPostDate;
	}
	public int getMetPostCount() {
		return metPostCount;
	}
	public void setMetPostCount(int metPostCount) {
		this.metPostCount = metPostCount;
	}
	public String getMetBrdNum() {
		return metBrdNum;
	}
	public void setMetBrdNum(String metBrdNum) {
		this.metBrdNum = metBrdNum;
	}
	@Override
	public String toString() {
		return "MetPostVO [metPostNum=" + metPostNum + ", metPostTitle=" + metPostTitle + ", metPostContent="
				+ metPostContent + ", metPostDate=" + metPostDate + ", metPostCount=" + metPostCount + ", metBrdNum="
				+ metBrdNum + ", metPostFile=" + metPostFile + ", metPostCategory=" + metPostCategory + "]";
	}
	
	
	
	
}
