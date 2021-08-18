package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;

import util.DBManager;

import com.itbook.vo.Paging;
import com.itbook.vo.Notice.NoticeVO;

/**
 * 
 * 怨듭��궗�빆 �벑濡�, �닔�젙, �궘�젣, 議고쉶瑜� �븷 �닔 �엳�뒗 �겢�옒�뒪(�떛湲��넠)
 * 
 * @author 源��젙誘�
 *
 */

public class NoticeDAO {

	private static NoticeDAO instance = new NoticeDAO();

	public static NoticeDAO getInstance() {

		return instance;
	}

	// �떆���뒪瑜� 媛��졇�삩�떎.
	public int getSeq() {
		int result = 1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			// �떆���뒪 媛믪쓣 媛��졇�삩�떎. (DUAL : �떆���뒪 媛믪쓣 媛��졇�삤湲곗쐞�븳 �엫�떆 �뀒�씠釉�)
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT noticeNum FROM notice");

			pstmt = conn.prepareStatement(sql.toString());
			// 荑쇰━ �떎�뻾
			rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBManager.close(conn, pstmt);

		}

		return result;
	} // end getSeq

	// 怨듭��궗�빆 寃뚯떆臾� �벑濡�
	public boolean insertNotice(NoticeVO nVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();

			sql.append(
					"insert into notice(noticeTitle, noticeContent, noticeFile, noticeCount, noticeDate, noticeCategory, memNum)");
			sql.append("values( ?, ?, ?, ?, sysdate(), ?, ?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, nVo.getNoticeTitle());
			pstmt.setString(2, nVo.getNoticeContent());
			pstmt.setString(3, nVo.getNoticeFile());
			pstmt.setInt(4, nVo.getNoticeCount());
			pstmt.setString(5, nVo.getNoticeCategory());
			pstmt.setString(6, nVo.getMemNum());

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

	} // end insertNotice();

	// 寃뚯떆湲� 由ъ뒪�듃(�럹�씠吏� 泥섎━)
	public ArrayList<NoticeVO> getNoticeList(HashMap<String, Object> listOpt) {

		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String opt = (String) listOpt.get("opt"); // 검색 옵션
		String condition = (String) listOpt.get("condition"); // 검색 내용
		int start = (Integer) listOpt.get("start"); // 시작 페이지
		
		System.out.println(opt + condition);

		try {
			conn = DBManager.getConnection();
			String sql = "";

			// 湲�紐⑸줉 �쟾泥대�� 蹂댁뿬以� �븣
			if (opt == null) {
				sql = "select * from notice order by noticeNum desc limit ?, 10";

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, start);

			}

			else // �젣紐⑹쑝濡� 寃��깋
			{
				if (opt.equals("0")) {
					sql = "select * from notice where noticeTitle like ? " + "order by noticeNum desc limit ?, 10";
				} else if (opt.equals("1")) {
					sql = "select * from notice where noticeCategory like ? " + "order by noticeNum desc limit ?, 10";
				} else if (opt.equals("2")) {
					sql = "select * from notice where noticeContent like ? " + "order by noticeNum desc limit ?, 10";
				}

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, start);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeVO nVo = new NoticeVO();

				nVo.setNoticeNum(rs.getString("noticeNum"));
				nVo.setNoticeTitle(rs.getString("noticeTitle"));
				nVo.setNoticeContent(rs.getString("noticeContent"));
				nVo.setNoticeDate(rs.getDate("noticeDate"));
				nVo.setNoticeCount(rs.getInt("noticeCount"));
				nVo.setNoticeFile(rs.getString("noticeFile"));
				nVo.setNoticeCategory(rs.getString("noticeCategory"));

				list.add(nVo);
			}

		} catch (Exception e) {
			e.getMessage();
		} finally {

			DBManager.close(conn, pstmt, rs);
		}

		return list;
	} // end getNoticeList

	// 湲��쓽 媛쒖닔瑜� 媛��졇�삤�뒗 硫붿꽌�뱶
	public int getNoticeListCount(HashMap<String, Object> listOpt) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;
		String opt = (String) listOpt.get("opt"); // 寃��깋�샃�뀡(�젣紐�, �궡�슜, 湲��벖�씠
													// �벑..)
		String condition = (String) listOpt.get("condition"); // 寃��깋�궡�슜

		try {
			conn = DBManager.getConnection();
			String sql = "";

			if (opt == null) // �쟾泥닿��쓽 媛쒖닔
			{
				sql = "select count(*) from notice";
				pstmt = conn.prepareStatement(sql);

			} else {
				if (opt.equals("0")) {
					sql = "select count(*) from notice where noticeTitle like ?";
				} else if (opt.equals("1")) {
					sql = "select count(*) from notice where noticeCategory like ?";
				} else if (opt.equals("2")) {
					sql = "select count(*) from notice where noticeContent like ?";
				}
				
				System.out.println(opt + " " + condition);
				
				pstmt = conn.prepareStatement(sql);
				
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
	} // end getBoardListCount

	// 議고쉶�닔 利앷�
	public void updateReadCount(String noticeNum) {

		String sql = "update notice set noticeCount = noticeCount+1 where noticeNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, noticeNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 寃뚯떆湲� �긽�꽭蹂닿린
	public NoticeVO selectOneNoticeByNum(String noticeNum) {
		String sql = "select * from notice where noticeNum=? order by noticeNum asc";

		NoticeVO nVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				nVo = new NoticeVO();
				nVo.setNoticeNum(rs.getString("noticeNum"));
				nVo.setNoticeTitle(rs.getString("noticeTitle"));
				nVo.setNoticeDate(rs.getDate("noticeDate"));
				nVo.setNoticeContent(rs.getString("noticeContent"));
				nVo.setNoticeCount(rs.getInt("noticeCount"));
				nVo.setNoticeFile(rs.getString("noticeFile"));
				nVo.setNoticeCategory(rs.getString("noticeCategory"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nVo;
	}

	// 怨듭��궗�빆 寃뚯떆臾� �닔�젙
	public boolean updateNotice(NoticeVO nVo) {

		boolean result = false;
		String sql = "update notice set noticeTitle=?, noticeContent=?, noticeFile=?, noticeCategory=? where noticeNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nVo.getNoticeTitle());
			pstmt.setString(2, nVo.getNoticeContent());
			pstmt.setString(3, nVo.getNoticeFile());
			pstmt.setString(4, nVo.getNoticeCategory());
			pstmt.setString(5, nVo.getNoticeNum());

			int flag = pstmt.executeUpdate();

			System.out.println(flag);

			if (flag > 0) {
				result = true;
				conn.commit(); // �셿猷뚯떆 而ㅻ컠
			}

		} catch (Exception e) {
			try {
				conn.rollback(); // �삤瑜섏떆 濡ㅻ갚
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			e.getMessage();
		} finally {
			DBManager.close(conn, pstmt);

		}

		return result;
	} // end updateNotice

	// 怨듭��궗�빆 �궘�젣

	public void deleteNotice(String noticeNum) {
		String sql = "delete from notice where noticeNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, noticeNum);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 愿�由ъ옄 怨듭��궗�빆 湲� �궘�젣
	public void noticeDelete(NoticeVO nVO) {
		String sql = "delete from notice where noticeNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nVO.getNoticeNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 愿�由ъ옄�솕硫� 由ъ뒪�듃 �솕硫�
	public Paging selectNoticeRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT" + "     FROM notice";

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

	// 愿�由ъ옄 怨듭��궗�빆 �럹�씠吏� 泥섎━
	public ArrayList<NoticeVO> selectNoticePage(Paging paging) {

		String sql = "select * from notice order by noticeNum desc limit ?, 10";

		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));

			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeVO nVo = new NoticeVO();

				nVo.setNoticeNum(rs.getString("noticeNum"));
				nVo.setNoticeTitle(rs.getString("noticeTitle"));
				nVo.setNoticeDate(rs.getDate("noticeDate"));
				nVo.setNoticeContent(rs.getString("noticeContent"));
				nVo.setNoticeCount(rs.getInt("noticeCount"));

				list.add(nVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

}
