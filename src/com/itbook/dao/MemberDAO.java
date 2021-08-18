package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itbook.vo.MemListVO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Paging;
import util.DBManager;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {

		return instance;
	} // Singleton �뙣�꽩

	/**
	 * �쉶�썝 �벑濡� 硫붿냼�뱶 �쉶�썝�젙蹂대�� MemberVO 媛앹껜濡� 諛쏆븘���꽌 �엯�젰
	 * 
	 * @param MemVO
	 */
	public void insertMember(MemberVO MemVO) {
		String sql = "insert into member (" + "memId, memPw, jumin, memName, phone, email, authority, adr, adr2)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, MemVO.getMemId());
			pstmt.setString(2, MemVO.getMemPw());
			pstmt.setString(3, MemVO.getJumin());
			pstmt.setString(4, MemVO.getMemName());
			pstmt.setString(5, MemVO.getPhone());
			pstmt.setString(6, MemVO.getEmail());
			pstmt.setString(7, MemVO.getAuthority());
			pstmt.setString(8, MemVO.getAdr());
			pstmt.setString(9, MemVO.getAdr2());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/**
	 * �쉶�썝�젙蹂대�� �닔�젙�븯�뒗 硫붿냼�뱶
	 * 
	 * @param memVO
	 */

	public boolean memberUpdate(MemberVO memVO) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			sql.append("update member set");
			sql.append(" phone=?");
			sql.append(" ,email=?");
			sql.append(" ,adr=?");
			sql.append(" ,adr2=?");
			sql.append("	where memId=?");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, memVO.getPhone());
			pstmt.setString(2, memVO.getEmail());
			pstmt.setString(3, memVO.getAdr());
			pstmt.setString(4, memVO.getAdr2());
			pstmt.setString(5, memVO.getMemId());

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				result = true;
				conn.commit(); //
			}

		} catch (Exception e) {
			try {
				conn.rollback(); //
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	// 鍮꾨�踰덊샇 蹂�寃�
	public void memberPwUpdate(MemberVO memVO) {
		String sql = "update member" + "	set memPw = ?" + " where memNum = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memVO.getMemPw());
			pstmt.setString(2, memVO.getMemNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	/**
	 * �쉶�썝�젙蹂� �궘�젣
	 * 
	 * @param memNum
	 */
	public void memberDelete(MemberVO mVO) {
		String sql = "DELETE FROM member WHERE memNum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVO.getMemNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt);
		}
	}

	public void searchPw(String memId, String memName, String email) {
		String sql = "select memPw from member where memId = ? and memName = ? and email = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				rs.getString("memPw");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}

	/**
	 * 以묐났�솗�씤
	 * 
	 * @param memId
	 * @return
	 */
	public int idCheck(String memId) {
		int result = -1;
		String sql = "SELECT MEMID FROM member WHERE MEMID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public MemberVO getMemberInfo(MemberVO tempVO) {

		String sql = "SELECT * " + "  FROM member " + " WHERE memId = '" + tempVO.getMemId() + "'";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberVO memVO = new MemberVO();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				memVO.setMemNum(rs.getString("memNum"));
				memVO.setMemId(rs.getString("memId"));
				memVO.setMemPw(rs.getString("memPw"));
				memVO.setMemName(rs.getString("memName"));
				memVO.setEmail(rs.getString("email"));
				memVO.setAdr(rs.getString("adr"));
				memVO.setAdr2(rs.getString("adr2"));
				memVO.setAuthority(rs.getString("authority"));
				memVO.setPhone(rs.getString("phone"));
				memVO.setSignDate(rs.getTimestamp("signDate"));
				memVO.setJumin(rs.getString("jumin"));
				// memVO.setMetNum(rs.getString("metNum"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return memVO;
	}

	public ArrayList<MemListVO> getMemberListInfo(MemListVO tempVO) {

		String sql = "SELECT * " + "  FROM mem_list " + " WHERE memId = '" + tempVO.getMemId() + "'";

		ArrayList<MemListVO> list = new ArrayList<MemListVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemListVO mVO = new MemListVO();

				mVO.setMemNum(rs.getString("memNum"));
				mVO.setMemId(rs.getString("memId"));
				mVO.setMemName(rs.getString("memName"));
				mVO.setMetNum(rs.getString("metNum"));
				mVO.setApproval(rs.getString("approval"));

				list.add(mVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 濡쒓렇�씤 �젙蹂� 泥댄겕
	 * 
	 * @param memVO
	 * @return
	 */
	public int loginCheck(MemberVO memVO) {
		String sql = "SELECT memId, memPw" + "	FROM member" + "	WHERE memId ='" + memVO.getMemId() + "'";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString("memId"));
				System.out.println(rs.getString("memPw"));
				if (rs.getString("memPw") != null && rs.getString("memPw").equals(memVO.getMemPw())) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return -1;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		return -1;

	}

	public ArrayList<MemberVO> memberList() {
		String sql = "SELECT * FROM member";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVO mVO = new MemberVO(); // MemberVO mVO = null;

				mVO.setMemNum(rs.getString("memNum"));
				mVO.setMemId(rs.getString("memId"));
				mVO.setMemName(rs.getString("memName"));
				mVO.setMemPw(rs.getString("memPw"));
				mVO.setJumin(rs.getString("jumin"));
				mVO.setAdr(rs.getString("adr"));
				mVO.setAdr(rs.getString("adr2"));
				mVO.setAuthority(rs.getString("authority"));
				mVO.setEmail(rs.getString("email"));
				mVO.setPhone(rs.getString("phone"));
				mVO.setSignDate(rs.getTimestamp("signDate"));

				list.add(mVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		return list;

	}

	// 珥앷쾶�떆湲� �닔 蹂닿린
	public Paging memberRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT" + "     FROM member";

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

	// 일반회원
	public ArrayList<MemberVO> memberListP(Paging paging) {
		String sql = "SELECT * FROM member where authority = 1 order by memNum desc limit ?, 10";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO mVO = new MemberVO();

				mVO.setMemNum(rs.getString("memNum"));
				mVO.setMemId(rs.getString("memId"));
				mVO.setMemName(rs.getString("memName"));
				mVO.setMemPw(rs.getString("memPw"));
				mVO.setJumin(rs.getString("jumin"));
				mVO.setAdr(rs.getString("adr"));
				mVO.setAdr(rs.getString("adr2"));
				mVO.setAuthority(rs.getString("authority"));
				mVO.setEmail(rs.getString("email"));
				mVO.setPhone(rs.getString("phone"));
				mVO.setSignDate(rs.getTimestamp("signDate"));

				list.add(mVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		return list;

	}

	// 기부회원
	public ArrayList<MemberVO> memberListDonation(Paging paging) {
		String sql = "SELECT * FROM member where authority = 2 order by memNum desc limit ?, 10";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO mVO = new MemberVO();

				mVO.setMemNum(rs.getString("memNum"));
				mVO.setMemId(rs.getString("memId"));
				mVO.setMemName(rs.getString("memName"));
				mVO.setMemPw(rs.getString("memPw"));
				mVO.setJumin(rs.getString("jumin"));
				mVO.setAdr(rs.getString("adr"));
				mVO.setAdr(rs.getString("adr2"));
				mVO.setAuthority(rs.getString("authority"));
				mVO.setEmail(rs.getString("email"));
				mVO.setPhone(rs.getString("phone"));
				mVO.setSignDate(rs.getTimestamp("signDate"));

				list.add(mVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		return list;

	}

	// �룆�꽌紐⑥엫 �쉶�썝媛��엯! (�쉶�썝�벑濡�)
	public void joinMember(MemListVO mVo) {
		String sql = "insert into mem_list(memNum, metNum, memName, memId) values(?,?,?,?);";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMemNum());
			pstmt.setString(2, mVo.getMetNum());
			pstmt.setString(3, mVo.getMemName());
			pstmt.setString(4, mVo.getMemId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 硫ㅻ쾭�돺 �듅�씤
	public void approvalMeeting(MemListVO mVo) {
		String sql = "update mem_list set joinDate = sysdate(), approval = 'T' where memNum =? and metNum = ?";

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

	// 硫ㅻ쾭�돺 �듅�씤/嫄곗젅 由ъ뒪�듃
	public ArrayList<MemListVO> meetingMemList() {
		String sql = "SELECT * FROM mem_list";

		ArrayList<MemListVO> list = new ArrayList<MemListVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemListVO mVo = new MemListVO();

				mVo.setMemNum(rs.getString("memNum"));
				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMemId(rs.getString("memId"));
				mVo.setMemName(rs.getString("memName"));
				mVo.setJoinDate(rs.getTimestamp("joinDate"));
				mVo.setApproval(rs.getString("approval"));

				list.add(mVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}

	public MemListVO selectMemNum(String memNum) {

		String sql = "SELECT memNum, metNum, memId, memName, joinDate, approval from mem_list where memNum = ? and approval='T'";

		MemListVO mVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				mVo = new MemListVO();

				mVo.setMemNum(rs.getString("memNum"));
				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMemId(rs.getString("memId"));
				mVo.setMemName(rs.getString("memName"));
				mVo.setJoinDate(rs.getTimestamp("joinDate"));
				mVo.setApproval(rs.getString("approval"));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVo;
	}

	public void refuseMemberShip(MemListVO mVo) {
		String sql = "update mem_list set approval = 'R' where memNum = ? and metNum = ?";

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

	// 紐⑥엫 �쉶�썝 由ъ뒪�듃
	public ArrayList<MemListVO> meetingMemberList(String metNum) {
		String sql = "SELECT memNum, metNum, memId, memName, joinDate, approval from mem_list where metNum=? and approval ='T'";

		ArrayList<MemListVO> list = new ArrayList<MemListVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemListVO mVo = new MemListVO();

				mVo.setMemNum(rs.getString("memNum"));
				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMemId(rs.getString("memId"));
				mVo.setMemName(rs.getString("memName"));
				mVo.setJoinDate(rs.getTimestamp("joinDate"));
				mVo.setApproval(rs.getString("approval"));

				list.add(mVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}

	// 紐⑥엫 愿�由ъ옄媛� �쉶�썝 �궘�젣.
	public void memberDelete(MemListVO mVo) {
		String sql = "update mem_list set approval='R' where memNum=? and metNum=?";

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

	// 9.24일 새로추가(AdminMemberListAction,AdminMemberList.jsp)
	// 전체 사용자 리스트 (관리자 전용)

	public ArrayList<MemberVO> adminMemberList(HashMap<String, Object> listOpt) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String opt = (String) listOpt.get("opt");
		String sql = "";
		System.out.println("BLAHBLAH" + opt);
		if (opt != null && !opt.equals("0")) {
			sql = "SELECT memNum, memId,memName,memPw,authority,email,phone,signDate from member where authority like "
					+ opt + " order by authority desc";
		} else {
			sql = "SELECT memNum, memId,memName,memPw,authority,email,phone,signDate from member order by authority desc";
		}
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVO mVO = new MemberVO(); // MemberVO mVO = null;

				mVO.setMemNum(rs.getString("memNum"));
				mVO.setMemId(rs.getString("memId"));
				mVO.setMemName(rs.getString("memName"));
				mVO.setMemPw(rs.getString("memPw"));
				mVO.setAuthority(rs.getString("authority"));
				mVO.setEmail(rs.getString("email"));
				mVO.setPhone(rs.getString("phone"));
				mVO.setSignDate(rs.getTimestamp("signDate"));

				list.add(mVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		return list;

	}

	public int getAdminMemListCount(HashMap<String, Object> listOpt) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;
		String opt = (String) listOpt.get("opt"); // 寃��깋�샃�뀡(�젣紐�, �궡�슜, 湲��벖�씠 �벑..)
		String condition = (String) listOpt.get("condition"); // 寃��깋�궡�슜

		try {
			conn = DBManager.getConnection();
			StringBuffer sql = new StringBuffer();

			if (opt == null) // �쟾泥닿��쓽 媛쒖닔
			{
				sql.append("select count(*) from member");
				pstmt = conn.prepareStatement(sql.toString());

				// StringBuffer瑜� 鍮꾩슫�떎.
				sql.delete(0, sql.toString().length());
			} else if (opt.equals("0")) // �젣紐⑹쑝濡� 寃��깋�븳 湲��쓽 媛쒖닔
			{
				sql.append("select count(*) from member where authority like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%' + condition + '%');

				sql.delete(0, sql.toString().length());
			}

			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		DBManager.close(conn, pstmt, rs);
		return result;
	}

}
/*
 * //전체 사용자 리스트 검색(관리자 전용) public ArrayList<MemberVO>
 * getAdminMemList(HashMap<String, Object> listOpt) {
 * 
 * ArrayList<MemberVO> list = new ArrayList<MemberVO>();
 * 
 * Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * 
 * String opt = (String) listOpt.get("opt"); String condition = (String)
 * listOpt.get("condition"); int start = (Integer) listOpt.get("start");
 * 
 * try { conn = DBManager.getConnection(); StringBuffer sql = new
 * StringBuffer();
 * 
 * 
 * if (opt == null) { sql.
 * append("select memNum, memId,memName,memPw,authority,email,phone,signDate from member order by memNum desc limit ?, 10"
 * );
 * 
 * 
 * 
 * pstmt = conn.prepareStatement(sql.toString()); pstmt.setInt(1, start);
 * 
 * 
 * sql.delete(0, sql.toString().length()); }
 * 
 * else if (opt.equals("0")) { sql.
 * append("select memNum, memId,memName,memPw,authority,email,phone,signDate from member where authority like ? "
 * + "order by memNum desc" );
 * 
 * pstmt = conn.prepareStatement(sql.toString()); pstmt.setString(1, "%" +
 * condition + "%"); pstmt.setInt(2, start);
 * 
 * sql.delete(0, sql.toString().length()); }
 * 
 * rs = pstmt.executeQuery();
 * 
 * while (rs.next()) { MemberVO mVo = new MemberVO();
 * 
 * 
 * mVo.setMemNum(rs.getString("memNum")); mVo.setMemId(rs.getString("memId"));
 * mVo.setMemName(rs.getString("memName")); mVo.setMemPw(rs.getString("memPw"));
 * mVo.setAuthority(rs.getString("authority"));
 * mVo.setEmail(rs.getString("email")); mVo.setPhone(rs.getString("phone"));
 * mVo.setSignDate(rs.getTimestamp("signDate"));
 * 
 * 
 * list.add(mVo); }
 * 
 * } catch (Exception e) { throw new RuntimeException(e.getMessage()); }
 * 
 * DBManager.close(conn, pstmt, rs); return list; }
 */
