package com.itbook.vo.Meeting;
/**
 * @author 정원
 * 독서모임번호
 * 독서모임명
 * 독서모임인사말
 * 독서모임소개
 * 대표자명
 * 활동지역
 * 활동주제
 * 개설일자
 * 회원수
 *
 */

import java.sql.Date;

public class MeetingVO {
	private String metNum;
	private String metName;
	private String metGreeting;
	private String metIntro;
	private String represent;
	private String location;
	private String metPlace;
	private String keyword;
	private Date metDate;
	private int headCount;
	private String approval;
	private String metImg;
	private String memNum;
	public String getMetNum() {
		return metNum;
	}
	public void setMetNum(String metNum) {
		this.metNum = metNum;
	}
	public String getMetName() {
		return metName;
	}
	public void setMetName(String metName) {
		this.metName = metName;
	}
	public String getMetGreeting() {
		return metGreeting;
	}
	public void setMetGreeting(String metGreeting) {
		this.metGreeting = metGreeting;
	}
	public String getMetIntro() {
		return metIntro;
	}
	public void setMetIntro(String metIntro) {
		this.metIntro = metIntro;
	}
	public String getRepresent() {
		return represent;
	}
	public void setRepresent(String represent) {
		this.represent = represent;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMetPlace() {
		return metPlace;
	}
	public void setMetPlace(String metPlace) {
		this.metPlace = metPlace;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getMetDate() {
		return metDate;
	}
	public void setMetDate(Date metDate) {
		this.metDate = metDate;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getMetImg() {
		return metImg;
	}
	public void setMetImg(String metImg) {
		this.metImg = metImg;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	@Override
	public String toString() {
		return "MeetingVO [metNum=" + metNum + ", metName=" + metName + ", metGreeting=" + metGreeting + ", metIntro="
				+ metIntro + ", represent=" + represent + ", location=" + location + ", metPlace=" + metPlace
				+ ", keyword=" + keyword + ", metDate=" + metDate + ", headCount=" + headCount + ", approval="
				+ approval + ", metImg=" + metImg + ", memNum=" + memNum + "]";
	}



}