package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.MemListVO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Paging;
import com.itbook.vo.Meeting.MeetingVO;
import com.itbook.vo.Meeting.MetBoardVO;
import com.itbook.vo.main.MainDTO;

import util.DBManager;

/**
 * @author �젙�썝
 */
public class MeetingDAO {

	private static MeetingDAO instance;

	public static MeetingDAO getInstance() {
		if (instance == null) {
			instance = new MeetingDAO();
		}
		return instance;
	}

	// MeetingVO�뿉�꽌 媛믪쓣 媛��졇�샂(DB�벑濡앸맂 紐⑤뱺 �뜲�씠�꽣 媛��졇�삤湲�)
	/*
	 * private int metNum; private String metName; private String metIntro;
	 * private String represent; private Date metDate; private int headCount;
	 */
	public List<MeetingVO> selectAllMeetings() {

		String sql = "SELECT metNum" + "         ,metName" + "         ,metIntro" + "         ,represent"
				+ "         ,metDate"
				+ "         ,(SELECT count(*) FROM mem_list WHERE approval = 'T' and  metNum = meeting.metNum) as headCount"
				+ "			,location" + "			,metPlace" + "			,keyword" + "         ,metImg"
				+ "     FROM meeting" + "     WHERE approval = 'T'" + "   ORDER BY metDate DESC";

		List<MeetingVO> list = new ArrayList<MeetingVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MeetingVO mVo = new MeetingVO();

				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setRepresent(rs.getString("represent"));
				mVo.setMetDate(rs.getDate("metDate"));
				mVo.setHeadCount(rs.getInt("headCount"));
				mVo.setLocation(rs.getString("location"));
				mVo.setMetPlace(rs.getString("metPlace"));
				mVo.setKeyword(rs.getString("keyword"));
				mVo.setMetImg(rs.getString("metImg"));

				list.add(mVo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<MainDTO> selectMainMeetings() {

		String sql = "SELECT metNum" + "         ,metName" + "         ,metImg" + "         ,metIntro"
				+ "         ,metPlace" + "     FROM meeting" + "     WHERE approval = 'T'" + "   ORDER BY metDate DESC";

		List<MainDTO> list = new ArrayList<MainDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MainDTO mVo = new MainDTO();

				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetImg(rs.getString("metImg"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setMetPlace(rs.getString("metPlace"));
				list.add(mVo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시물 등록
	public boolean insertMeeting(MeetingVO mVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();

			sql.append(
					"INSERT INTO meeting(metName,metGreeting,metIntro,represent,location,metPlace,keyword,metImg,memNum)");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, mVo.getMetName());
			pstmt.setString(2, mVo.getMetGreeting());
			pstmt.setString(3, mVo.getMetIntro());
			pstmt.setString(4, mVo.getRepresent());
			pstmt.setString(5, mVo.getLocation());
			pstmt.setString(6, mVo.getMetPlace());
			pstmt.setString(7, mVo.getKeyword());
			pstmt.setString(8, mVo.getMetImg());
			pstmt.setString(9, mVo.getMemNum());

			int flag = pstmt.executeUpdate();

			if (flag > 0) {
				result = true;
				conn.commit();
			}

		} catch (Exception e) {

			throw new RuntimeException(e.getMessage());
		}

		DBManager.close(conn, pstmt);
		return result;

	}

	// 전체 데이터 행을 카운트함.
	public Paging adminMeetingRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT" + " FROM meeting";

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

	// 게시글 리스트(검색, 페이징 기능)
	public List<MetBoardVO> selectFiveMetBoard(String metNum) {

		List<MetBoardVO> list = new ArrayList<MetBoardVO>();

		String sql = "SELECT m.metBrdNum" + ", m.metBrdCategory" + ", m.metBrdName" + ", m.metNum" + ", m.memNum"
				+ ", m.regDate" + ", b.memName" + ", b.memNum" + "	FROM met_board m, member b "
				+ "	WHERE m.memNum = b.memNum and m.metNum=?" + "	ORDER BY m.regDate desc limit 5";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				MetBoardVO mbVo = new MetBoardVO();

				mbVo.setMetBrdNum(rs.getString("metBrdNum"));
				mbVo.setMetBrdName(rs.getString("metBrdName"));
				mbVo.setMetNum(rs.getString("metNum"));
				mbVo.setMetBrdCategory(rs.getString("metBrdCategory"));
				mbVo.setMemNum(rs.getString("memNum"));
				mbVo.setMemName(rs.getString("memName"));
				mbVo.setRegDate(rs.getDate("regDate"));

				System.out.println("mbVo : " + mbVo);

				list.add(mbVo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 페이징 처리를 하고 리스트를 보여줌
	public ArrayList<MetBoardVO> selectAllMetBoard(String metNum, Paging paging) {

		ArrayList<MetBoardVO> list = new ArrayList<MetBoardVO>();

		String sql = "SELECT m.metBrdNum" + "		,m.metBrdName" + "		,m.regDate" + "		,m.metBrdCategory"
				+ "		,m.metBrdCount" + "		,m.metBrdContent" + "		,m.memNum" + "		,m.metNum"
				+ "		,b.memName" + " FROM met_board m, member b" + " WHERE m.memNum = b.memNum and m.metNum = ?"
				+ " ORDER BY m.metBrdNum desc limit ?, 10";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);
			pstmt.setInt(2, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MetBoardVO mbVo = new MetBoardVO();

				mbVo.setMetBrdNum(rs.getString("metBrdNum"));
				mbVo.setMetBrdName(rs.getString("metBrdName"));
				mbVo.setMetBrdContent(rs.getString("metBrdContent"));
				mbVo.setMetNum(rs.getString("metNum"));
				mbVo.setRegDate(rs.getDate("regDate"));
				mbVo.setMetBrdCategory(rs.getString("metBrdCategory"));
				mbVo.setMemNum(rs.getString("memNum"));
				mbVo.setMetBrdCount(rs.getInt("metBrdCount"));
				mbVo.setMemName(rs.getString("memName"));

				list.add(mbVo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 게시글 상세보기
	public MeetingVO selectOneMeetingByNum(String metNum) {

		String sql = "SELECT metNum" + "			, metName" + "			, metIntro" + "			, metGreeting"
				+ "			, represent" + "			, location" + "			, metPlace" + "			, keyword"
				+ "			, metDate" + "			, metImg" + "			, memNum"
				+ "			, (SELECT count(*) FROM mem_list WHERE approval = 'T' and  metNum = meeting.metNum) as headCount"
				+ " FROM meeting" + " WHERE metNum = ?";

		MeetingVO mVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				mVo = new MeetingVO();

				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setMetGreeting(rs.getString("metGreeting"));
				mVo.setRepresent(rs.getString("represent"));
				mVo.setLocation(rs.getString("location"));
				mVo.setMetPlace(rs.getString("metPlace"));
				mVo.setKeyword(rs.getString("keyword"));
				mVo.setMetDate(rs.getDate("metDate"));
				mVo.setMetImg(rs.getString("metImg"));
				mVo.setHeadCount(rs.getInt("headCount"));
				mVo.setMemNum(rs.getString("memNum"));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVo;
	}

	// 게시글 수정
	public boolean updateMeeting(MeetingVO mVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false); // 占쏙옙占쏙옙 �뚣끇占쏙옙占� false嚥∽옙 占쏙옙占쏙옙.

			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE meeting SET ");
			sql.append(" metName=? ");
			sql.append(" ,metIntro=? ");
			sql.append(" ,metGreeting=? ");
			sql.append(" ,metPlace=? ");
			sql.append(" ,keyword=? ");
			sql.append(" ,metImg=? ");
			sql.append(" ,represent=? ");
			sql.append(" ,location=? ");
			sql.append("	WHERE metNum=? ");

			System.out.println(sql.toString());

			System.out.println("占쏙옙占쏙옙 : " + mVo);
			// update占쏙옙占쏙옙 占썩뫁竊쒏묾占�.
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, mVo.getMetName());
			pstmt.setString(2, mVo.getMetIntro());
			pstmt.setString(3, mVo.getMetGreeting());
			pstmt.setString(4, mVo.getMetPlace());
			pstmt.setString(5, mVo.getKeyword());
			pstmt.setString(6, mVo.getMetImg());
			pstmt.setString(7, mVo.getRepresent());
			pstmt.setString(8, mVo.getLocation());
			pstmt.setString(9, mVo.getMetNum());

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				result = true;
				conn.commit(); // 占쏙옙�뙴占쏙옙占� �뚣끇占�
			}

		} catch (Exception e) {
			try {
				conn.rollback(); // 占썬끇占쏙옙占� 嚥▲끇媛�
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}

		DBManager.close(conn, pstmt);
		return result;
	}

	// 사용자 :: 게시물 삭제
	public void deleteMeeting2(MeetingVO mVO) {
		String sql = "DELETE FROM meeting WHERE metNum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVO.getMetNum());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// �룆�꽌紐⑥엫 硫ㅻ쾭�돺 �쉶�썝 寃뚯떆�뙋 �럹�씠吏� 泥섎━
	public ArrayList<MeetingVO> meetingList(Paging paging) {
		String sql = "SELECT * FROM meeting ORDER BY metNum desc limit ?, 10";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MeetingVO> list = new ArrayList<MeetingVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MeetingVO mVo = new MeetingVO();
				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setMetPlace(rs.getString("metPlace"));
				mVo.setMetDate(rs.getDate("metDate"));
				mVo.setRepresent(rs.getString("represent"));
				mVo.setMetGreeting(rs.getString("metGreeting"));
				mVo.setKeyword(rs.getString("keyword"));
				mVo.setHeadCount(rs.getInt("headCount"));
				mVo.setApproval(rs.getString("approval"));
				mVo.setMemNum(rs.getString("memNum"));

				list.add(mVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// �룆�꽌紐⑥엫 �솃�뿉 怨듭��궗�빆 寃뚯떆�뙋 �럹�씠吏� 泥섎━
	public Paging meetingRowCount(Paging paging, String metNum) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT FROM met_board WHERE metNum=? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt("CNT");
				paging.setNumOfRow(cnt);
				;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return paging;
	}

	// 愿�由ъ옄 �럹�씠吏��뿉�꽌 �룆�꽌紐⑥엫 �듅�씤�븯湲�
	public void acceptMeeting(MeetingVO mVO) {
		String sql = "UPDATE meeting SET metDate = sysdate(), approval = 'T'  WHERE metNum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVO.getMetNum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void meetingManagerInsert(MemListVO mVo) {
		String sql = "INSERT INTO mem_list(memNum, metNum, memName, memId)"
				+ "SELECT m.memNum, t.metNum, m.memName, m.memId" + " FROM member m join meeting t"
				+ " ON m.memNum = t.memNum" + " WHERE m.memNum = ? and t.metNum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMemNum());
			pstmt.setString(2, mVo.getMetNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void meetingManagerUpdate(MemListVO mVo) {
		String sql = "UPDATE mem_list SET approval = 'T' WHERE memNum = ? and metNum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMemNum());
			pstmt.setString(2, mVo.getMetNum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시물 삭제
	public void deleteMeeting(MeetingVO mVO) {
		String sql = "DELETE FROM meeting WHERE metNum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVO.getMetNum());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// �룆�꽌紐⑥엫 �듅�씤 �썑 紐⑥엫 �쉶�썝 �닔 �삱由ш린
	public void countHeadCount(int headCount) {

		String sql = "UPDATE meeting" + " SET headCount = headCount + 1" + " WHERE metNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public MemListVO checkMeetingMember(String memNum, String metNum) {

		String sql = "SELECT * FROM mem_list WHERE memNum = ? AND metNum = ? AND approval = 'T'";

		MemListVO mlVo = new MemListVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memNum);
			pstmt.setString(2, metNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mlVo.setMemNum(rs.getString("memNum"));
				mlVo.setMetNum(rs.getString("metNum"));
				mlVo.setJoinDate(rs.getTimestamp("joinDate"));
				mlVo.setApproval(rs.getString("approval"));
				mlVo.setMemId(rs.getString("memId"));
				mlVo.setMemName(rs.getString("memName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return mlVo;
	}

}