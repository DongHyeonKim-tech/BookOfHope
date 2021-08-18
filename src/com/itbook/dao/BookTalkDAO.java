package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itbook.vo.BookTalkVO;
import com.itbook.vo.Paging;

import util.DBManager;

public class BookTalkDAO {

	private static BookTalkDAO instance = new BookTalkDAO();

	public static BookTalkDAO getInstance() {

		return instance;
	}

	public int getSeq() {
		int result = 1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			// 떆 뒪 媛믪쓣 媛 졇 삩 떎. (DUAL : 떆 뒪 媛믪쓣 媛 졇 삤湲곗쐞 븳 엫 떆 뀒 씠釉 )
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT talkNo FROM bookTalk");

			pstmt = conn.prepareStatement(sql.toString());
			// 荑쇰━ 떎 뻾
			rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	} // end getSeq

	// 북토크 게시글 등록
	public boolean insertBookTalk(BookTalkVO bVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();

			sql.append(
					"insert into bookTalk(talkName, writer, talkDate, talkPlace, talkContents, articleURL, talkFile, talkPublisher, talkCount, videoURL)");
			sql.append("values( ?, ?, ?, ?, ?, ?,?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, bVo.getTalkName());
			pstmt.setString(2, bVo.getWriter());
			pstmt.setString(3, bVo.getTalkDate());
			pstmt.setString(4, bVo.getTalkPlace());
			pstmt.setString(5, bVo.getTalkContents());
			pstmt.setString(6, bVo.getArticleURL());
			pstmt.setString(7, bVo.getTalkFile());
			pstmt.setString(8, bVo.getTalkPublisher());
			pstmt.setInt(9, bVo.getTalkCount());
			pstmt.setString(10, bVo.getVideoURL());

			int flag = pstmt.executeUpdate();

			if (flag > 0) {
				result = true;
				conn.commit();
			}

		} catch (Exception e) {

			e.getMessage();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	//
	public ArrayList<BookTalkVO> getBookTalkList(HashMap<String, Object> listOpt) {

		ArrayList<BookTalkVO> list = new ArrayList<BookTalkVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String opt = (String) listOpt.get("opt"); // 寃 깋 샃 뀡( 젣紐 , 궡 슜, 湲 벖 씠
													// 벑...)
		String condition = (String) listOpt.get("condition"); // 寃 깋 궡 슜
		int start = (Integer) listOpt.get("start"); // 쁽 옱 럹 씠吏 踰덊샇

		try {
			conn = DBManager.getConnection();
			String sql = "";

			// 湲 紐⑸줉 쟾泥대 蹂댁뿬以 븣
			if (opt == null) {
				sql = "select talkNo, talkName, writer, talkPublisher, talkCount from bookTalk order by talkNo desc limit ?, 10";

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, start);

			}

			else {

				if (opt.equals("0")) {
					sql = "select talkNo, talkName, writer, talkPublisher, talkCount from bookTalk where talkName like ? "
							+ "order by talkNo desc limit ?, 10";
				} else if (opt.equals("1")) {
					sql = "select talkNo, talkName, writer, talkPublisher, talkCount from bookTalk where writer like ? "
							+ "order by talkNo desc limit ?, 10";
				}

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, start);

			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookTalkVO bVo = new BookTalkVO();

				bVo.setTalkNo(rs.getString("talkNo"));
				bVo.setTalkName(rs.getString("talkName"));
				bVo.setWriter(rs.getString("writer"));

				/*
				 * bVo.setTalkDate(rs.getString("talkDate"));
				 * bVo.setTalkPlace(rs.getString("talkPlace"));
				 * bVo.setTalkContents(rs.getString("talkContents"));
				 * bVo.setArticleURL(rs.getString("articleURL"));
				 * bVo.setTalkFile(rs.getString("talkFile"));
				 */

				bVo.setTalkPublisher(rs.getString("talkPublisher"));
				bVo.setTalkCount(rs.getInt("talkCount"));

				list.add(bVo);
			}

		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//
	public int getBookTalkListCount(HashMap<String, Object> listOpt) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;
		String opt = (String) listOpt.get("opt"); // 寃 깋 샃 뀡( 젣紐 , 궡 슜, 湲 벖 씠
													// 벑..)
		String condition = (String) listOpt.get("condition"); // 寃 깋 궡 슜

		try {
			conn = DBManager.getConnection();
			String sql = "";

			if (opt == null) // 쟾泥닿 쓽 媛쒖닔
			{
				sql = "select count(*) from bookTalk";
				pstmt = conn.prepareStatement(sql.toString());

			} else {

				if (opt.equals("0")) {

					sql = "select count(*) from bookTalk where talkName like ?";

				} else if (opt.equals("1")) {

					sql = "select count(*) from bookTalk where writer like ?";

				}

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%' + condition + '%');
			}

			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 조회수
	public void updateReadCount(String talkNo) {

		String sql = "update bookTalk set talkCount = talkCount+1 where talkNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, talkNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 상세보기
	public BookTalkVO selectOneBookTalkByNum(String talkNo) {
		String sql = "select * from bookTalk where talkNo=? order by talkNo asc";

		BookTalkVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, talkNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bVo = new BookTalkVO();

				bVo.setTalkNo(rs.getString("talkNo"));
				bVo.setTalkName(rs.getString("talkName"));
				bVo.setTalkDate(rs.getString("talkDate"));
				bVo.setTalkPlace(rs.getString("talkPlace"));
				bVo.setWriter(rs.getString("writer"));

				bVo.setTalkContents(rs.getString("talkContents"));
				bVo.setArticleURL(rs.getString("articleURL"));
				bVo.setTalkFile(rs.getString("talkFile"));
				bVo.setTalkPublisher(rs.getString("talkPublisher"));
				bVo.setTalkCount(rs.getInt("talkCount"));
				bVo.setVideoURL(rs.getString("videoURL"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	// 북토크 수정
	public boolean updateBookTalk(BookTalkVO bVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			sql.append("update bookTalk set");
			sql.append(" talkName=?");
			sql.append(" ,writer=?");
			sql.append(" ,talkDate=?");
			sql.append(" ,talkContents=?");
			sql.append(" ,talkPlace=?");
			sql.append(" ,articleURL=?");
			sql.append(" ,talkFile=?");
			sql.append(" ,talkPublisher=?");
			sql.append(" ,videoURL=?");
			sql.append("where talkNo=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, bVo.getTalkName());
			pstmt.setString(2, bVo.getWriter());
			pstmt.setString(3, bVo.getTalkDate());
			pstmt.setString(4, bVo.getTalkContents());
			pstmt.setString(5, bVo.getTalkPlace());
			pstmt.setString(6, bVo.getArticleURL());
			pstmt.setString(7, bVo.getTalkFile());
			pstmt.setString(8, bVo.getTalkPublisher());
			pstmt.setString(9, bVo.getVideoURL());
			pstmt.setString(10, bVo.getTalkNo());

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				result = true;
				conn.commit(); // 셿猷뚯떆 而ㅻ컠
			}

		} catch (Exception e) {
			try {
				conn.rollback(); // 삤瑜섏떆 濡ㅻ갚
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	// 북토크 삭제
	public void deleteBookTalk(String talkNo) {
		String sql = "delete from bookTalk where talkNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, talkNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 북토크 삭제
	public void bookTalkDelete(BookTalkVO bVO) {
		String sql = "delete from bookTalk where talkNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVO.getTalkNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public Paging selectBookTalkRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT" + "     FROM bookTalk";

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

	public ArrayList<BookTalkVO> selectBookTalkPage(Paging paging) {

		String sql = "select * from bookTalk order by talkNo desc limit ?, 10";

		ArrayList<BookTalkVO> list = new ArrayList<BookTalkVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookTalkVO bVo = new BookTalkVO();

				bVo.setTalkNo(rs.getString("talkNo"));
				bVo.setTalkName(rs.getString("talkName"));
				/*
				 * bVo.setWriter(rs.getString("talkContents"));
				 * bVo.setTalkDate(rs.getString("talkDate"));
				 * bVo.setTalkPlace(rs.getString("talkPlace"));
				 * bVo.setTalkContents(rs.getString("talkContents"));
				 * bVo.setArticleURL(rs.getString("articleURL"));
				 * bVo.setTalkFile(rs.getString("talkFile"));
				 */
				bVo.setTalkPublisher(rs.getString("talkPublisher"));
				bVo.setTalkCount(rs.getInt("talkCount"));

				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

}