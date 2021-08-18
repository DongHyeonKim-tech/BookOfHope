package com.itbook.vo.Meeting;
/**
 * @author 정원
 * 모임활동사진 테이블
 * 사진파일번호
 * 사진파일명
 * 사진파일등록일
 * 모임게시판번호
 */
import java.sql.Date;

public class MeetingPicture {
	private String pictureNum;
	private String pictureName;
	private Date pictureDate;
	private String metNum;
	public String getPictureNum() {
		return pictureNum;
	}
	public void setPictureNum(String pictureNum) {
		this.pictureNum = pictureNum;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public Date getPictureDate() {
		return pictureDate;
	}
	public void setPictureDate(Date pictureDate) {
		this.pictureDate = pictureDate;
	}
	public String getMetNum() {
		return metNum;
	}
	public void setMetNum(String metNum) {
		this.metNum = metNum;
	}
	
	@Override
	public String toString() {
		return "MeetingPicture [pictureNum=" + pictureNum + ", pictureName=" + pictureName + ", pictureDate="
				+ pictureDate + ", metNum=" + metNum + "]";
	}
	
}
