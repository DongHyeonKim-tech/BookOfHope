package com.itbook.vo.Book;
/**이달의책 게시판테이블
 * 이달의책게시판번호
 * 이달의책제목
 * 이달의책내용
 * 작성일자
 * 조회수
 * 책번호
 * 회원번호 
 * @author 종욱
 *
 */

import java.sql.Date;

public class BookBoardVO {
	
	private String bookBrdNum;
	private String bookBrdTitle;
	private String bookBrdContent;
	private Date bookBrdDate;
	private int bookBrdCount;
	private String bookNum;
	private String bookTitle;
	private String memNum;
	private String writer; //책저자
	private String publisher; //출판사
	private String imgPath; //이미지 경로
	
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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
	public String getBookBrdNum() {
		return bookBrdNum;
	}      
	public void setBookBrdNum(String bookBrdNum) {
		this.bookBrdNum = bookBrdNum;
	}
	public String getBookBrdTitle() {
		return bookBrdTitle;
	}
	public void setBookBrdTitle(String bookBrdTitle) {
		this.bookBrdTitle = bookBrdTitle;
	}
	public String getBookBrdContent() {
		return bookBrdContent;
	}
	public void setBookBrdContent(String bookBrdContent) {
		this.bookBrdContent = bookBrdContent;
	}
	public Date getBookBrdDate() {
		return bookBrdDate;
	}
	public void setBookBrdDate(Date bookBrdDate) {
		this.bookBrdDate = bookBrdDate;
	}
	public int getBookBrdCount() {
		return bookBrdCount;
	}
	public void setBookBrdCount(int bookBrdCount) {
		this.bookBrdCount = bookBrdCount;
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
	@Override
	public String toString() {
		return "BookBoardVO [bookBrdNum=" + bookBrdNum + ", bookBrdTitle=" + bookBrdTitle + ", bookBrdContent="
				+ bookBrdContent + ", bookBrdDate=" + bookBrdDate + ", bookBrdCount=" + bookBrdCount + ", bookNum="
				+ bookNum + ", bookTitle=" + bookTitle + ", memNum=" + memNum + ", writer=" + writer + ", publisher="
				+ publisher + ", imgPath=" + imgPath + "]";
	}
	
	
}
