package com.itbook.vo;



public class BookTalkVO {
	/*
	 * CREATE TABLE `bookTalk` ( `talkNo` int(9) NOT NULL AUTO_INCREMENT COMMENT
	 * '게시글번호', `memNum` int(9) NOT NULL COMMENT '작성자', `bookTalkName` varchar(100)
	 * DEFAULT NULL COMMENT '선정도서', `writer` varchar(100) DEFAULT NULL COMMENT '저자',
	 * `talkDate` date DEFAULT NULL COMMENT '일시', `talkPlace` varchar(100) DEFAULT
	 * NULL COMMENT '장소', `talkBookContents` varchar(3000) DEFAULT NULL COMMENT
	 * '내용', `articleURL` varchar(100) DEFAULT NULL COMMENT '관련기사url', `talkFile`
	 * varchar(200) DEFAULT NULL COMMENT '첨부파일', `talkPublisher` varchar(100)
	 * DEFAULT NULL COMMENT '출판사', PRIMARY KEY (`talkNo`), KEY `bookTalk_FK`
	 * (`memNum`), CONSTRAINT `bookTalk_FK` FOREIGN KEY (`memNum`) REFERENCES
	 * `member` (`memNum`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 * 
	 * 
	 */
	
	
	private String talkNo;
	private String memNum;
	private String writer;
	private String talkName;
	private String talkDate;
	private String talkContents;
	private String talkPlace;
	private String  articleURL;
	private String videoURL;
	private String talkFile;
	private String talkPublisher;
	private int  talkCount;
	public String getTalkNo() {
		return talkNo;
	}
	public void setTalkNo(String talkNo) {
		this.talkNo = talkNo;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTalkName() {
		return talkName;
	}
	public void setTalkName(String talkName) {
		this.talkName = talkName;
	}
	public String getTalkDate() {
		return talkDate;
	}
	public void setTalkDate(String talkDate) {
		this.talkDate = talkDate;
	}
	public String getTalkContents() {
		return talkContents;
	}
	public void setTalkContents(String talkContents) {
		this.talkContents = talkContents;
	}
	public String getTalkPlace() {
		return talkPlace;
	}
	public void setTalkPlace(String talkPlace) {
		this.talkPlace = talkPlace;
	}
	public String getArticleURL() {
		return articleURL;
	}
	public void setArticleURL(String articleURL) {
		this.articleURL = articleURL;
	}
	public String getVideoURL() {
		return videoURL;
	}
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
	public String getTalkFile() {
		return talkFile;
	}
	public void setTalkFile(String talkFile) {
		this.talkFile = talkFile;
	}
	public String getTalkPublisher() {
		return talkPublisher;
	}
	public void setTalkPublisher(String talkPublisher) {
		this.talkPublisher = talkPublisher;
	}
	public int getTalkCount() {
		return talkCount;
	}
	public void setTalkCount(int talkCount) {
		this.talkCount = talkCount;
	}
	@Override
	public String toString() {
		return "BookTalkVO [talkNo=" + talkNo + ", memNum=" + memNum + ", writer=" + writer + ", talkName=" + talkName
				+ ", talkDate=" + talkDate + ", talkContents=" + talkContents + ", talkPlace=" + talkPlace
				+ ", articleURL=" + articleURL + ", videoURL=" + videoURL + ", talkFile=" + talkFile
				+ ", talkPublisher=" + talkPublisher + ", talkCount=" + talkCount + "]";
	}
	
	
	
	
	
	
	
}
