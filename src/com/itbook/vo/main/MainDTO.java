package com.itbook.vo.main;

public class MainDTO {

	private String metNum;
	private String metName;
	private String metImg;
	private String metIntro;
	private String metPlace;
	private String imgPath;
	private String bookBrdTitle;
	private String bookBrdNum;
	
	
	public String getBookBrdTitle() {
		return bookBrdTitle;
	}
	public void setBookBrdTitle(String bookBrdTitle) {
		this.bookBrdTitle = bookBrdTitle;
	}
	public String getBookBrdNum() {
		return bookBrdNum;
	}
	public void setBookBrdNum(String bookBrdNum) {
		this.bookBrdNum = bookBrdNum;
	}
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
	public String getMetImg() {
		return metImg;
	}
	public void setMetImg(String metImg) {
		this.metImg = metImg;
	}
	public String getMetIntro() {
		return metIntro;
	}
	public void setMetIntro(String metIntro) {
		this.metIntro = metIntro;
	}
	public String getMetPlace() {
		return metPlace;
	}
	public void setMetPlace(String metPlace) {
		this.metPlace = metPlace;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "MainDTO [metNum=" + metNum + ", metName=" + metName + ", metImg=" + metImg + ", metIntro=" + metIntro
				+ ", metPlace=" + metPlace + ", imgPath=" + imgPath + ", bookBrdTitle=" + bookBrdTitle + ", bookBrdNum="
				+ bookBrdNum + "]";
	}
	
}
