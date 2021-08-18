package com.itbook.dao;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.itbook.vo.Paging;
import com.itbook.vo.Report.ReportBoardVO;

import util.DBManager;

/**
 * @author 수아
 */

public class ReportDAO {
	private static ReportDAO instance;

	public static ReportDAO getInstance() {
		if (instance == null) {
			instance = new ReportDAO();
		}
		return instance;
	}

	// 독후감 조회
	public List<ReportBoardVO> selectAllReports() {

		String sql = "select r.reportNum,r.reportTitle,r.reportContent,r.reportDate,r.reportCount,r.bookNum,r.memNum,m.memName from report_board r , member m where r.memNum = m.memNum order by ReportNum desc";

		List<ReportBoardVO> list = new ArrayList<ReportBoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				ReportBoardVO rVo = new ReportBoardVO();

				rVo.setReportNum(rs.getString("reportNum"));
				rVo.setReportTitle(rs.getString("reportTitle"));
				rVo.setReportContent(rs.getString("reportContent"));
				rVo.setReportDate(rs.getDate("reportDate"));
				rVo.setReportCount(rs.getInt("reportCount"));
				rVo.setBookNum(rs.getString("bookNum"));
				rVo.setMemNum(rs.getString("memNum"));
				rVo.setMemName(rs.getString("memName"));

				list.add(rVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 독후감 등록하기
	public void insertReport(ReportBoardVO rVo) {
		String sql = "insert into report_board (reportTitle,reportContent,reportCount,reportDate,memNum,bookNum,writer,publisher,reportCategory, bookTitle) value (?,?,?,sysdate(),?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rVo.getReportTitle());
			pstmt.setString(2, rVo.getReportContent());
			pstmt.setInt(3, 0);
			pstmt.setString(4, rVo.getMemNum());
			pstmt.setString(5, rVo.getBookNum());
			pstmt.setString(6, rVo.getWriter());
			pstmt.setString(7, rVo.getPublisher());
			pstmt.setString(8, rVo.getReportCategory());
			pstmt.setString(9, rVo.getBookTitle());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 독후감 상세보기
	public ReportBoardVO selectOneReportByNum(String reportNum) {
		String sql = "select r.reportNum,r.reportTitle,r.reportContent,r.reportDate,r.reportCount,r.bookNum,r.writer,r.publisher,r.reportCategory,r.bookTitle, r.memNum,m.memName  from report_board r , member m where r.memNum = m.memNum and reportNum = ?";

		ReportBoardVO rVo = new ReportBoardVO();
		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reportNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				rVo.setReportNum(rs.getString("reportNum"));
				rVo.setReportTitle(rs.getString("reportTitle"));
				rVo.setReportContent(rs.getString("reportContent"));
				rVo.setReportDate(rs.getDate("reportDate"));
				rVo.setReportCount(rs.getInt("reportCount"));
				rVo.setBookNum(rs.getString("bookNum"));
				rVo.setMemNum(rs.getString("memNum"));
				rVo.setWriter(rs.getString("writer"));
				rVo.setPublisher(rs.getString("publisher"));
				rVo.setReportCategory(rs.getString("reportCategory"));
				rVo.setBookTitle(rs.getString("bookTitle"));
				rVo.setMemName(rs.getString("memName"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return rVo;
	}

	// 독후감 조회수 올리기
	public void updateReportCount(String ReportNum) {
		String sql = "update report_board set reportCount = reportCount+1 where reportNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ReportNum);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 독후감 게시글 수정하기
	public void updateReport(ReportBoardVO rVo) {
		String sql = "UPDATE report_board SET ReportTitle=?, ReportContent=?, ReportCategory=?, bookTitle = ? WHERE ReportNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rVo.getReportTitle());
			pstmt.setString(2, rVo.getReportContent());
			pstmt.setString(3, rVo.getReportCategory());

			pstmt.setString(4, rVo.getBookTitle());
			pstmt.setString(5, rVo.getReportNum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 독후감 게시글 삭제하기
	public void deleteReport(String reportNum) {

		String sql = "DELETE FROM report_board WHERE ReportNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reportNum);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// admin delete
	public void ReportDelete(ReportBoardVO rVO) {
		String sql = "DELETE FROM report_board WHERE ReportNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rVO.getReportNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 독후감 리스트 총 게시글 수 보기
	public Paging selectReportRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT FROM report_board";

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
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, stmt);
		}
		return paging;
	}

	// 독후감 리스트 페이징 처리
	public ArrayList<ReportBoardVO> selectReportPage(Paging paging) {

		String sql = "select r.reportNum, r.reportTitle, r.reportCategory,r.reportDate,r.reportCount, m.memName from report_board r, member m where r.memNum=m.memNum order by ReportNum desc limit ?, 10";

		ArrayList<ReportBoardVO> list = new ArrayList<ReportBoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReportBoardVO rVo = new ReportBoardVO();

				rVo.setReportNum(rs.getString("reportNum"));
				rVo.setReportTitle(rs.getString("reportTitle"));
				rVo.setReportCategory(rs.getString("reportCategory"));
				rVo.setReportDate(rs.getDate("reportDate"));
				rVo.setReportCount(rs.getInt("reportCount"));
				rVo.setMemName(rs.getString("memName"));

				list.add(rVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 독후감 검색 기능
	public ArrayList<ReportDAO> getReportList(HashMap<String, Object> listOpt) {

		ArrayList<ReportDAO> list = new ArrayList<ReportDAO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String opt = (String) listOpt.get("opt");
		String condition = (String) listOpt.get("condition");
		int start = (Integer) listOpt.get("start");

		try {
			conn = DBManager.getConnection();
			StringBuffer sql = new StringBuffer();

			if (opt == null) { // 글목록 전체를 보여줄 때

				sql.append("select * from report_board order by reportNum desc;");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");

				// StringBuffer를 비운다.
				sql.delete(0, sql.toString().length());

			} else if (opt.equals("0")) { // 제목으로 검색

				sql.append("select * from report_Board where reportTitle like ? ");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");

				sql.delete(0, sql.toString().length());
			}

		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	public ArrayList<ReportBoardVO> selectTop4Reports() {

		String sql = " select r.reportNum, r.reportTitle as reportTitle ,m.memName from report_board r , member m where r.memNum = m.memNum ORDER BY ReportNum desc limit ? , 4 ";
		System.out.println(sql);
		ArrayList<ReportBoardVO> list = new ArrayList<ReportBoardVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {

				ReportBoardVO rVo = new ReportBoardVO();
				rVo.setReportNum(rs.getString("reportNum"));
				rVo.setReportTitle(rs.getString("reportTitle"));
				rVo.setMemName(rs.getString("memName"));

				list.add(rVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

}
