package com.itbook.vo;
/**
 * 梨낅쾲�샇
 * 梨낆젣紐�
 * ���옄
 * 異쒗뙋�궗
 * 異쒗뙋�씪
 * �궎�썙�뱶1
 * �궎�썙�뱶2
 * �궎�썙�뱶3
 * ISBN
 * �쉶�썝紐�
 * �쉶�썝踰덊샇
 * @author �젙�썝
 *
 */

import java.sql.Date;

public class BookVO {

	private String bookNum;
	private String bookTitle;
	private String writer;
	private String publisher;
	private Date publishDate;
	private String bookKeyword1;
	private String bookKeyword2;
	private String bookKeyword3;
	private String isbn;
	private String memName;
	private String memNum;

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
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

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getBookKeyword1() {
		return bookKeyword1;
	}

	public void setBookKeyword1(String bookKeyword1) {
		this.bookKeyword1 = bookKeyword1;
	}

	public String getBookKeyword2() {
		return bookKeyword2;
	}

	public void setBookKeyword2(String bookKeyword2) {
		this.bookKeyword2 = bookKeyword2;
	}

	public String getBookKeyword3() {
		return bookKeyword3;
	}

	public void setBookKeyword3(String bookKeyword3) {
		this.bookKeyword3 = bookKeyword3;
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

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return "BookVO [bookNum=" + bookNum + ", bookTitle=" + bookTitle + ", writer=" + writer + ", publisher="
				+ publisher + ", publishDate=" + publishDate + ", bookKeyword1=" + bookKeyword1 + ", bookKeyword2="
				+ bookKeyword2 + ", bookKeyword3=" + bookKeyword3 + ", isbn=" + isbn + ", memName=" + memName
				+ ", memNum=" + memNum + "]";
	}
	

}
