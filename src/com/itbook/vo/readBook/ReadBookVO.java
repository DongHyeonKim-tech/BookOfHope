package com.itbook.vo.readBook;


public class ReadBookVO {
   
	 
	private String readBookNo;
	private String memNum;
	private String bookName;
	private String publishDate;
	private String writer;
	private String publisher;
	private String readBookContents;
	private String articleURL;
	private String videoURL;
	private String readBookFile;
	private int readBookCount;
	public String getReadBookNo() {
		return readBookNo;
	}
	public void setReadBookNo(String readBookNo) {
		this.readBookNo = readBookNo;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
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
	public String getReadBookContents() {
		return readBookContents;
	}
	public void setReadBookContents(String readBookContents) {
		this.readBookContents = readBookContents;
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
	public String getReadBookFile() {
		return readBookFile;
	}
	public void setReadBookFile(String readBookFile) {
		this.readBookFile = readBookFile;
	}
	public int getReadBookCount() {
		return readBookCount;
	}
	public void setReadBookCount(int readBookCount) {
		this.readBookCount = readBookCount;
	}
	@Override
	public String toString() {
		return "ReadBookVO [readBookNo=" + readBookNo + ", memNum=" + memNum + ", bookName=" + bookName
				+ ", publishDate=" + publishDate + ", writer=" + writer + ", publisher=" + publisher
				+ ", readBookContents=" + readBookContents + ", articleURL=" + articleURL + ", videoURL=" + videoURL
				+ ", readBookFile=" + readBookFile + ", readBookCount=" + readBookCount + "]";
	}
	
	
	
	
	

}
