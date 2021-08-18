package com.itbook.vo;


/*
CREATE TABLE `program` (
		  `proNo` int(9) NOT NULL AUTO_INCREMENT COMMENT '프로그램번호',
		  `name` varchar(30) DEFAULT NULL COMMENT '발표자',
		  `company` varchar(30) DEFAULT NULL COMMENT '소속',
		  `startTime` date NOT NULL COMMENT '시작 시간',
		  `endTime` date DEFAULT NULL COMMENT '종료 시간',
		  `title` varchar(200) DEFAULT NULL COMMENT '소개글',
		  `liveLink` varchar(200) DEFAULT NULL COMMENT '라이브링크(라이브질의응답/팀즈링크)',
		  `videoLink` varchar(200) DEFAULT NULL COMMENT '비디오링크',
		  `intro1` varchar(200) DEFAULT NULL COMMENT '연사소개',
		  `intro2` varchar(200) DEFAULT NULL COMMENT '발표소개',
		  `contact` varchar(200) DEFAULT NULL COMMENT '연락하기',
		  `proFile` varchar(200) DEFAULT NULL COMMENT '이미지 첨부파일',
		  PRIMARY KEY (`proNo`)
		) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;


*/
public class ProgramVO {
	
	private String proNo; //프로그램번호
	private String title; // 제목
	private String name; //발표자
	private String company; //소속
	private String startTime; //시작 시간
	private String endTime; // 종료 시간
	private String liveLink; //라이브링크(라이브질의응답/팀즈링크)

	private String videoLink; //유튜브 영상 링크
	private String intro1; //연사소개
	private String intro2; //발표소개
	private String contact; //연락하기
	private String proFile; //첨부파일
	
	
	public String getProNo() {
		return proNo;
	}
	public void setProNo(String proNo) {
		this.proNo = proNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLiveLink() {
		return liveLink;
	}
	public void setLiveLink(String liveLink) {
		this.liveLink = liveLink;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public String getIntro1() {
		return intro1;
	}
	public void setIntro1(String intro1) {
		this.intro1 = intro1;
	}
	public String getIntro2() {
		return intro2;
	}
	public void setIntro2(String intro2) {
		this.intro2 = intro2;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getProFile() {
		return proFile;
	}
	public void setProFile(String proFile) {
		this.proFile = proFile;
	}
	@Override
	public String toString() {
		return "ProgramVO [proNo=" + proNo + ", title=" + title + ", name=" + name + ", company=" + company
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", liveLink=" + liveLink + ", videoLink="
				+ videoLink + ", intro1=" + intro1 + ", intro2=" + intro2 + ", contact=" + contact + ", proFile="
				+ proFile + "]";
	}
	
	
	
		

}
