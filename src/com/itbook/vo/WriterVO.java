package com.itbook.vo;

import java.util.ArrayList;
import java.util.Arrays;

/*CREATE TABLE `writer` (
        `writerNo` int(9) NOT NULL AUTO_INCREMENT,
        `memNum` int(9) NOT NULL DEFAULT '1',
        `writerName` varchar(100) DEFAULT NULL COMMENT '작가명',
        `writerBook1` varchar(100) DEFAULT NULL COMMENT '대표작품1',
        `writerBook2` varchar(100) DEFAULT NULL COMMENT '대표작품2',
        `writerBook3` varchar(100) DEFAULT NULL COMMENT '대표작품3',
        `writerBook4` varchar(100) DEFAULT NULL COMMENT '대표작품4',
        `writerBook5` varchar(100) DEFAULT NULL COMMENT '대표작품5',
        `association`  varchar(100) DEFAULT NULL COMMENT '가입단체',
        'writerContents' varchar(3000) DEFAULT NULL COMMENT '작가설명',
        `imgPath` varchar(100) DEFAULT '0',
        PRIMARY KEY (`writerNo`),
        KEY `WRITER_FK` (`memNum`),
        CONSTRAINT `WRITER_FK` FOREIGN KEY (`memNum`) REFERENCES `member` (`memNum`)
      ) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
*/

public class WriterVO {

	private String writerNo; // 작가번호
	private String writerName; // 작가이름
	private String writerBook1; // 대표작품1
	private String writerBook2; // 대표작품2
	private String writerBook3; // 대표작품3
	private String writerBook4; // 대표작품4
	private String writerBook5; // 대표작품5
	private String association; // 가입 단체
	private String imgPath; // 이미지경로
	private String writerContents; // 작가 설명
	private String memNum;
	private String[] files;

	// 상세보기 file 여러개 가져오기
	private ArrayList<FileVO> fileList;

	public String getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getWriterBook1() {
		return writerBook1;
	}

	public void setWriterBook1(String writerBook1) {
		this.writerBook1 = writerBook1;
	}

	public String getWriterBook2() {
		return writerBook2;
	}

	public void setWriterBook2(String writerBook2) {
		this.writerBook2 = writerBook2;
	}

	public String getWriterBook3() {
		return writerBook3;
	}

	public void setWriterBook3(String writerBook3) {
		this.writerBook3 = writerBook3;
	}

	public String getWriterBook4() {
		return writerBook4;
	}

	public void setWriterBook4(String writerBook4) {
		this.writerBook4 = writerBook4;
	}

	public String getWriterBook5() {
		return writerBook5;
	}

	public void setWriterBook5(String writerBook5) {
		this.writerBook5 = writerBook5;
	}

	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getWriterContents() {
		return writerContents;
	}

	public void setWriterContents(String writerContents) {
		this.writerContents = writerContents;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public ArrayList<FileVO> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<FileVO> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "WriterVO [writerNo=" + writerNo + ", writerName=" + writerName + ", writerBook1=" + writerBook1
				+ ", writerBook2=" + writerBook2 + ", writerBook3=" + writerBook3 + ", writerBook4=" + writerBook4
				+ ", writerBook5=" + writerBook5 + ", association=" + association + ", imgPath=" + imgPath
				+ ", writerContents=" + writerContents + ", memNum=" + memNum + ", files=" + Arrays.toString(files)
				+ ", fileList=" + fileList + "]";
	}

	
	
}