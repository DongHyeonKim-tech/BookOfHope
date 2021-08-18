package com.itbook.vo;

public class Paging {
		// 현재 페이지 번호
		private int pageNum;
		private int perPage;
		// 전체 데이터 개수
		private int numOfRow;

		public Paging()
		{
			this.pageNum = 1;
			this.perPage = 10;
		}
		public Paging(int perPage)
		{
			this.pageNum = 1;
			this.perPage = perPage;
		}
		/**
		    * 
		    * 매개변수가 있는 생성자
		    * 
		    * @param pageNum
		    */
		public Paging(int perPage, int pageNum)
		{
			this.perPage = perPage;
			this.pageNum = pageNum;
		}

		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getNumOfRow() {
			return numOfRow;
		}

		public void setNumOfRow(int numOfRow) {
			this.numOfRow = numOfRow;
		}
		
		public int getPerPage() {
			return this.perPage;
		}
		
		public void setPerPage(int perPage) {
			this.perPage = perPage;
		}
		
		/**
		 * 전체 페이지 개수를 뽑아내기 위해 사용하는 메소드
		 * 
		 * @return 전체 페이지 개수
		 */
		public int getNumOfPage() {
			// 전체 데이터를 10으로 나눠서 올림을 하면 전체 페이지 개수가 나옴
			return (int) Math.ceil(this.numOfRow / (double)this.perPage);
		}

		public int getFirstPage() {
			// 현재 페이지번호를 10으로 나눈 후 소수점 아래를 버림하고 10 + 1을 곱해주면 첫페이지 번호가 나옴(첫번째페이지로)
			return (this.pageNum - 1) / this.perPage * this.perPage + 1;
		}

		public int getLastPage() {
			// 첫페이지번호에 9를 더해준 값과 전체 페이지 개수 중 최솟값이 마지막 페이지 번호(마지막페이지로)
			return Math.min(getFirstPage() + this.perPage - 1, getNumOfPage());
		}

	}

