package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.ProgramVO;

import util.DBManager;

public class ProgramDAO {

	private static ProgramDAO instance = new ProgramDAO();

	public static ProgramDAO getInstance() {

		return instance;
	}

	// 프로그램 리스트. (일반회원)
	public List<ProgramVO> selectProgramList() {

		String sql = "select proNo, name, company, startDate, endDate, title, liveLink "
				+ "		from program order by proNo desc";

		List<ProgramVO> list = new ArrayList<ProgramVO>();
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				ProgramVO pVo = new ProgramVO();

				pVo.setProNo(rs.getString("proNo"));
				pVo.setName(rs.getString("name"));
				pVo.setCompany(rs.getString("company"));
				pVo.setStartTime(rs.getString("startTime"));
				pVo.setEndTime(rs.getString("endTime"));
				pVo.setTitle(rs.getString("title"));
				pVo.setLiveLink(rs.getString("liveLink"));

				list.add(pVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
		}
		return list;
	}

	// 관리자 :: 프로그램 등록
	public boolean insertProgram(ProgramVO pVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();

			sql.append(
					"insert into program( name, company, startTime, endTime, title, liveLink, videoLink, intro1, intro2, contact, proFile)");
			sql.append("values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, pVo.getName());
			pstmt.setString(2, pVo.getCompany());
			pstmt.setString(3, pVo.getStartTime());
			pstmt.setString(4, pVo.getEndTime());
			pstmt.setString(5, pVo.getTitle());
			pstmt.setString(6, pVo.getLiveLink());
			pstmt.setString(7, pVo.getVideoLink());
			pstmt.setString(8, pVo.getIntro1());
			pstmt.setString(9, pVo.getIntro2());
			pstmt.setString(10, pVo.getContact());
			pstmt.setString(11, pVo.getProFile());

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

	// 프로그램 상세보기 - 서브페이지
	public ProgramVO selectOneProgramByNum(String proNo) {
		String sql = "select * from program where proNo=? order by proNo asc";

		ProgramVO pVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pVo = new ProgramVO();

				pVo.setProNo(rs.getString("proNo"));
				pVo.setTitle(rs.getString("title"));
				pVo.setName(rs.getString("name"));
				pVo.setCompany(rs.getString("company"));
				pVo.setStartTime(rs.getString("startTime"));
				pVo.setEndTime(rs.getString("endTime"));
				pVo.setLiveLink(rs.getString("liveLink"));

				pVo.setVideoLink(rs.getString("videoLink"));
				pVo.setIntro1(rs.getString("intro1"));
				pVo.setIntro2(rs.getString("intro2"));
				pVo.setContact(rs.getString("contact"));
				pVo.setProFile(rs.getString("proFile"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pVo;

	}

	// 프로그램 수정
	public boolean updateProgram(ProgramVO pVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			sql.append("update program set");
			sql.append(" title=?");
			sql.append(" ,name=?");
			sql.append(" ,company=?");
			sql.append(" ,startTime=?");
			sql.append(" ,endTime=?");
			sql.append(" ,liveLink=?");

			sql.append(" ,videoLink=?");
			sql.append(" ,intro1=?");
			sql.append(" ,intro2=?");
			sql.append(" ,contact=?");
			sql.append(" ,proFile=?");
			sql.append("where proNo=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, pVo.getTitle());
			pstmt.setString(2, pVo.getName());
			pstmt.setString(3, pVo.getCompany());
			pstmt.setString(4, pVo.getStartTime());
			pstmt.setString(5, pVo.getEndTime());
			pstmt.setString(6, pVo.getLiveLink());
			pstmt.setString(7, pVo.getVideoLink());
			pstmt.setString(8, pVo.getIntro1());
			pstmt.setString(9, pVo.getIntro2());
			pstmt.setString(10, pVo.getContact());
			pstmt.setString(11, pVo.getProFile());
			pstmt.setString(12, pVo.getProNo());

			int flag = pstmt.executeUpdate();
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
		}finally {
			
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	// 프로그램 삭제
	public void deleteProgram(String proNo) {
		String sql = "delete from program where proNo = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, proNo);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

}
