package com.itbook.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itbook.vo.Paging;
import com.itbook.vo.Event.EventVO;

import util.DBManager;

public class EventDAO {
	private static EventDAO instance = new EventDAO();
	
	public static EventDAO getInstance() {
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
			sql.append("SELECT eventNo FROM event");

			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		DBManager.close(conn, pstmt);
		return result;
	} // end getSeq
	
	
	
	//
	public ArrayList<EventVO> getEventList(HashMap<String, Object> listOpt) {

		ArrayList<EventVO> list = new ArrayList<EventVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String opt = (String) listOpt.get("opt"); 
		String condition = (String) listOpt.get("condition");
		int start = (Integer) listOpt.get("start");

		try {
			conn = DBManager.getConnection();
			StringBuffer sql = new StringBuffer();

			
			if (opt == null) {
				sql.append("select eventNo, eventName,eventDate,eventPlace,eventCount from event order by eventNo desc limit ?, 10");
				

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, start);

				
				sql.delete(0, sql.toString().length());
			}

			else if (opt.equals("0")) 
			{
				sql.append("select eventNo, eventName,eventDate,eventPlace,eventCount from event where eventName like ? " + "order by eventNo desc limit ?, 10");

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + condition + "%");
				pstmt.setInt(2, start);

				sql.delete(0, sql.toString().length());
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EventVO eVo = new EventVO();

				eVo.setEventNo(rs.getString("eventNo"));
				eVo.setEventName(rs.getString("eventName"));
				eVo.setEventDate(rs.getString("eventDate"));
				eVo.setEventPlace(rs.getString("eventPlace"));
				eVo.setEventCount(rs.getInt("eventCount"));

				list.add(eVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
	
	
	//
	public int getEventListCount(HashMap<String, Object> listOpt) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;
		String opt = (String) listOpt.get("opt"); 
		String condition = (String) listOpt.get("condition"); 

		try {
			conn = DBManager.getConnection();
			StringBuffer sql = new StringBuffer();

			if (opt == null) 
			{
				sql.append("select count(*) from event");
				pstmt = conn.prepareStatement(sql.toString());

				
				sql.delete(0, sql.toString().length());
			} else if (opt.equals("0"))
			{
				sql.append("select count(*) from event where eventName like ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, '%' + condition + '%');

				sql.delete(0, sql.toString().length());
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
	
	
	
	//조회수
	public void updateReadCount(String eventNo) {

		String sql = "update event set eventCount = eventCount+1 where eventNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, eventNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	
	
	//기타 행사 게시물 등록
	public boolean insertEvent(EventVO eVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();

			sql.append(
					"insert into event(memNum,eventName,writer,regDate,eventDate,eventPlace,eventContents,eventFile,eventCount)");
			sql.append("values (?,?,?,sysdate(),?,?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, eVo.getMemNum());
			pstmt.setString(2, eVo.getEventName());
			pstmt.setString(3, eVo.getWriter());
			pstmt.setString(4, eVo.getEventDate());
			pstmt.setString(5, eVo.getEventPlace());
			pstmt.setString(6, eVo.getEventContents());
			pstmt.setString(7, eVo.getEventFile());
			pstmt.setInt(8,eVo.getEventCount());

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

	
	
	//기타 행사 수정
	public boolean updateEvent(EventVO eVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false); // 자동 커밋을 false로 한다.

			StringBuffer sql = new StringBuffer();
			sql.append("update event set");
			sql.append(" eventName=?");
			sql.append(" ,eventPlace=?");
			sql.append(" ,eventDate=?");
			sql.append(" ,eventContents=?");
			sql.append(" ,eventFile=?");
			sql.append(" where eventNo=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, eVo.getEventName());
			pstmt.setString(2, eVo.getEventPlace());
			pstmt.setString(3, eVo.getEventDate());
			pstmt.setString(4, eVo.getEventContents());
			pstmt.setString(5, eVo.getEventFile());
			pstmt.setString(6, eVo.getEventNo());

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
			
			//기타행사 게시물 삭제 
			
			public void deleteEvent(String eventNo) {
				String sql = "delete from event where eventNo=?";
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					conn = DBManager.getConnection();
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, eventNo);
					
					pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt);
				}

			}
			
			//기타 행사 상세보기
			public EventVO selectOneEvnetByNo(String eventNo) {
				String sql = "select * from  event where eventNo=? order by eventNo asc";

				EventVO eVo = null;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, eventNo);

					rs = pstmt.executeQuery();

					if (rs.next()) {
						eVo = new EventVO();
						eVo.setEventNo(rs.getString("eventNo"));
						eVo.setEventName(rs.getString("eventName"));
						eVo.setEventDate(rs.getString("eventDate"));
						eVo.setEventPlace(rs.getString("eventPlace"));
						eVo.setEventContents(rs.getString("eventContents"));
						eVo.setEventFile(rs.getString("eventFile"));
											}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
				return eVo;
			}
			
			//페이징
			public Paging selectEventRowCount(Paging paging) {
				int cnt = 0;
				String sql = "SELECT COUNT(*) CNT"
		            + "     FROM event";
		      
		          Connection conn = null;
		         PreparedStatement stmt = null;
		         ResultSet rs = null;
		         
		         try
		         {
		            conn = DBManager.getConnection();
		            stmt = conn.prepareStatement(sql);
		            
		            rs = stmt.executeQuery();
		            
		            while (rs.next())
		            {
		               cnt = rs.getInt("CNT");
		               paging.setNumOfRow(cnt);;
		            }
		            
		         }
		         catch (Exception e)
		         {
		            e.printStackTrace();
		         }finally {
		 			DBManager.close(conn, stmt);
		 		}
		         return paging;
		   }

			//리스트
			public ArrayList<EventVO> SelectEventList(Paging paging) {
				String sql = "select * from event order by eventNo desc limit ?,10";
				ArrayList<EventVO> list = new ArrayList<EventVO>();
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						EventVO eVo = new EventVO();
						
						eVo.setEventNo(rs.getString("eventNo"));
						eVo.setEventName(rs.getString("eventName"));
						eVo.setEventDate(rs.getString("eventDate"));
						eVo.setEventPlace(rs.getString("eventPlace"));
						eVo.setEventContents(rs.getString("eventContents"));
						eVo.setEventFile(rs.getString("eventFile"));

						
						list.add(eVo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
				}
				return list;
			}
}
