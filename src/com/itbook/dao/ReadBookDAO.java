package com.itbook.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.itbook.vo.Paging;
import com.itbook.vo.WriterVO;
import com.itbook.vo.readBook.ReadBookVO;

import util.DBManager;

public class ReadBookDAO {

	private static ReadBookDAO instance = new ReadBookDAO();

	public static ReadBookDAO getInstance() {
		return instance;
	}

	public int getSeq() {
		int result = 1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT readBookNo FROM readBook");

			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	} // end getSeq

	// 글 목록 가져오기
	public ArrayList<ReadBookVO> getReadBookList(HashMap<String, Object> listOpt) {

		ArrayList<ReadBookVO> list = new ArrayList<ReadBookVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String opt = (String) listOpt.get("opt"); // 검색 옵션(제목, 내용, 글쓴이 등 ..)
		String condition = (String) listOpt.get("condition"); // 검색 내용
		int start = (Integer) listOpt.get("start"); // 현재 페이지번호

		try {
			conn = DBManager.getConnection();
			String sql = "";

			// 글 목록 전체를 보여줄 때
			if (opt == null) {
				sql = "select readBookNo, bookName,publishDate,writer,publisher, readBookCount from readBook order by readBookNo desc limit ?, 10";
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, start);

			}

			else {

				if (opt.equals("0")) {
					sql = "select readBookNo, bookName,publishDate,writer,publisher, readBookCount from readBook where bookName like ? "
								+ "order by readBookNo desc limit ?, 10";
				} else if (opt.equals("1")) {
					sql = "select readBookNo, bookName,publishDate,writer,publisher, readBookCount from readBook where writer like ? "
							+ "order by readBookNo desc limit ?, 10";
				}


				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, start);

			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReadBookVO rbVo = new ReadBookVO();

				rbVo.setReadBookNo(rs.getString("readBookNo"));
				rbVo.setBookName(rs.getString("bookName"));
				rbVo.setPublishDate(rs.getString("publishDate"));
				rbVo.setWriter(rs.getString("writer"));
				rbVo.setPublisher(rs.getString("publisher"));
				rbVo.setReadBookCount(rs.getInt("readBookCount"));

				list.add(rbVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	//
	public int getReadBookListCount(HashMap<String, Object> listOpt) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;
		String opt = (String) listOpt.get("opt");
		String condition = (String) listOpt.get("condition");

		try {
			conn = DBManager.getConnection();
			String sql = "";

			if (opt == null) {
				sql = "select count(*) from readBook";
				pstmt = conn.prepareStatement(sql.toString());

			} else {

				if (opt.equals("0")) {
					sql = "select count(*) from readBook where bookName like ?";
				} else if (opt.equals("1")) {
					sql = "select count(*) from readBook where writer like ?";
				}

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%' + condition + '%');

			}

			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	// 조회수
	public void updateReadCount(String readBookNo) {

		String sql = "update readBook set readBookCount = readBookCount+1 where readBookNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, readBookNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 책읽기 게시물 등록
	public boolean insertReadBook(ReadBookVO rbVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();

			sql.append(
					"insert into readBook(memNum,bookName,publishDate,writer,publisher,readBookContents,articleURL,videoURL,readBookFile,readBookCount)");
			sql.append("values (?,?,?,?,?,?,?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, rbVo.getMemNum());
			pstmt.setString(2, rbVo.getBookName());
			pstmt.setString(3, rbVo.getPublishDate());
			pstmt.setString(4, rbVo.getWriter());
			pstmt.setString(5, rbVo.getPublisher());
			pstmt.setString(6, rbVo.getReadBookContents());
			pstmt.setString(7, rbVo.getArticleURL());
			pstmt.setString(8, rbVo.getVideoURL());
			pstmt.setString(9, rbVo.getReadBookFile());
			pstmt.setInt(10, rbVo.getReadBookCount());

			int flag = pstmt.executeUpdate();

			if (flag > 0) {
				result = true;
				conn.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;

	}

	// 책 읽기 게시물 수정

	public boolean updateReadBook(ReadBookVO rbVo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false); // 자동 커밋을 false로 한다.

			StringBuffer sql = new StringBuffer();
			sql.append("update readBook set");
			sql.append(" bookName=?");
			sql.append(" ,publishDate=?");
			sql.append(" ,writer=?");
			sql.append(" ,publisher=?");
			sql.append(" ,readBookContents=?");
			sql.append(" ,articleURL=?");
			sql.append(" ,videoURL=?");
			sql.append(" ,readBookFile=?");
			sql.append(" where readBookNo=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, rbVo.getBookName());
			pstmt.setString(2, rbVo.getPublishDate());
			pstmt.setString(3, rbVo.getWriter());
			pstmt.setString(4, rbVo.getPublisher());
			pstmt.setString(5, rbVo.getReadBookContents());
			pstmt.setString(6, rbVo.getArticleURL());
			pstmt.setString(7, rbVo.getVideoURL());
			pstmt.setString(8, rbVo.getReadBookFile());
			pstmt.setString(9, rbVo.getReadBookNo());

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				result = true;
				conn.commit(); // 완료시 커밋
			}

		} catch (Exception e) {
			try {
				conn.rollback(); // 오류시 롤백
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;

	}

	// 책 읽기 게시물 삭제
	public void deleteReadBook(String readBookNo) {
		String sql = "delete from readBook where readBookNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, readBookNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 책 읽기 게시물 상세보기
	// 기타 행사 상세보기
	public ReadBookVO selectOneReadBookByNo(String readBookNo) {
		String sql = "select * from  readBook where readBookNo=? order by readBookNo asc";

		ReadBookVO rbVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, readBookNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				rbVo = new ReadBookVO();
				rbVo.setReadBookNo(rs.getString("readBookNO"));
				rbVo.setBookName(rs.getString("bookName"));
				rbVo.setPublishDate(rs.getString("publishDate"));
				rbVo.setWriter(rs.getString("writer"));
				rbVo.setPublisher(rs.getString("publisher"));
				rbVo.setReadBookContents(rs.getString("readBookContents"));
				rbVo.setArticleURL(rs.getString("articleURL"));
				rbVo.setVideoURL(rs.getString("videoURL"));
				rbVo.setReadBookFile(rs.getString("readBookFile"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rbVo;
	}

	// 페이징
	public Paging selectReadBookRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT" + "     FROM readBook";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt("CNT");
				paging.setNumOfRow(cnt);
				;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
		return paging;
	}

	// 리스트
	public ArrayList<ReadBookVO> SelectReadBookList(Paging paging) {
		String sql = "select * from readBook order by readBookNo desc limit ?,10";
		ArrayList<ReadBookVO> list = new ArrayList<ReadBookVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReadBookVO rbVo = new ReadBookVO();

				rbVo.setReadBookNo(rs.getString("readBookNo"));
				rbVo.setBookName(rs.getString("bookName"));
				rbVo.setPublishDate(rs.getString("publishDate"));
				rbVo.setWriter(rs.getString("writer"));
				rbVo.setPublisher(rs.getString("publisher"));
				rbVo.setReadBookContents(rs.getString("readBookContents"));
				rbVo.setArticleURL(rs.getString("articleURL"));
				rbVo.setVideoURL(rs.getString("videoURL"));
				rbVo.setReadBookFile(rs.getString("readBookFile"));

				list.add(rbVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
		}
		return list;
	}

}
