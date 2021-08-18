package com.itbook.vo.library;

/**
 * 도서관번호
 * 도서관명
 * 도서관 위치
 * 도서관 URL
 * 회원번호
 * @author 정원
 *
 */

public class LibraryVO {

	private String libraryNum;
	private String libraryTitle;
	private String libraryContent;
	private String libraryUrl;
	private String memNum;

	public String getLibraryNum() {
		return libraryNum;
	}

	public void setLibraryNum(String libraryNum) {
		this.libraryNum = libraryNum;
	}

	public String getLibraryTitle() {
		return libraryTitle;
	}

	public void setLibraryTitle(String libraryTitle) {
		this.libraryTitle = libraryTitle;
	}

	public String getLibraryContent() {
		return libraryContent;
	}

	public void setLibraryContent(String libraryContent) {
		this.libraryContent = libraryContent;
	}

	public String getLibraryUrl() {
		return libraryUrl;
	}

	public void setLibraryUrl(String libraryUrl) {
		this.libraryUrl = libraryUrl;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	@Override
	public String toString() {
		return "LibraryVO [libraryNum=" + libraryNum + ", libraryTitle=" + libraryTitle + ", libraryContent="
				+ libraryContent + ", libraryUrl=" + libraryUrl + ", memNum=" + memNum + "]";
	}

}
