package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itbook.vo.Meeting.MetBoardVO;

import util.DBManager;

/**
 * 
 * 독서모임게시판 등록, 수정, 삭제, 조회를 할 수 있는 클래스(싱글톤)
 * 
 * @author 김정민
 *
 */

public class MetBoardDAO {

	private static MetBoardDAO instance = new MetBoardDAO();

	public static MetBoardDAO getInstance() {

		return instance;
	}

	// 모임게시판 게시물 등록
	   public boolean insertMetBoard(MetBoardVO mVo) {
	      
	      boolean result = false;
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         
	         conn = DBManager.getConnection();
	         conn.setAutoCommit( false );
	         
	         StringBuffer sql = new StringBuffer();
	         
	         sql.append("insert into met_board(metBrdName, metBrdContent, regDate, metBrdCategory, metNum, memNum, metBrdCount, metBrdFile)");
	         sql.append("values( ?, ?, sysdate(), ?, ?, ?, ?, ?)");
	         
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setString(1, mVo.getMetBrdName());
	         pstmt.setString(2, mVo.getMetBrdContent());
	         pstmt.setString(3, mVo.getMetBrdCategory());
	         pstmt.setString(4, mVo.getMetNum());
	         pstmt.setString(5, mVo.getMemNum());
	         pstmt.setInt(6, mVo.getMetBrdCount());
	         pstmt.setString(7,  mVo.getMetBrdFile());
	         
	         int flag = pstmt.executeUpdate();
	         
	            if(flag > 0){
	               result = true;
	               conn.commit();
	            }
	      
	      } catch (Exception e) {
	            
	           throw new RuntimeException(e.getMessage());
	        }
	         
	         DBManager.close(conn, pstmt);
	         return result;
	   
	      } // end noticeInsert();
	
		
	//게시글 리스트(검색, 페이징 기능)
	public ArrayList<MetBoardVO> getMetBoardList(HashMap<String, Object> listOpt) {
		
		ArrayList<MetBoardVO> list = new ArrayList<MetBoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등...)
		String condition = (String)listOpt.get("condition"); //검색내용
		int start = (Integer)listOpt.get("start"); // 현재 페이지번호
		
		try {
			conn = DBManager.getConnection();
			StringBuffer sql = new StringBuffer();
			
			// 글목록 전체를 보여줄 때
			if(opt == null)
			{
				sql.append("select * from met_board order by metBrdNum desc limit ?, 10");
				
				
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				
				
				// StringBuffer를 비운다.
				sql.delete(0, sql.toString().length());
			}
			
			 else if(opt.equals("0")) // 제목으로 검색
	            {
	                sql.append("select * from met_board where metBrdName like ? "
	                		+ "order by metBrdNum desc limit ?, 10");
	                
	                
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, "%"+condition+"%");
	                pstmt.setInt(2, start);
	               
	                
	                sql.delete(0, sql.toString().length());
	            }
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				MetBoardVO mVo = new MetBoardVO();
				
				mVo.setMetBrdNum(rs.getString("metBrdNum"));
				mVo.setMetBrdName(rs.getString("metBrdName"));
				mVo.setMetBrdContent(rs.getString("metBrdContent"));
				mVo.setRegDate(rs.getDate("regDate"));
				mVo.setMetBrdFile(rs.getString("metBrdFile"));
				mVo.setMetBrdCount(rs.getInt("metBrdCount"));
				mVo.setMetBrdCategory(rs.getString("metBrdCategory"));
				
				list.add(mVo);
			}
				
			} catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	        }
	        
			DBManager.close(conn, pstmt, rs);
			return list;
	    } // end getBoardList
		
	
	//글의 개수를 가져오는 메서드
	public int getMetBoardListCount(HashMap<String, Object> listOpt) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
        int result = 0;
        String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
        String condition = (String)listOpt.get("condition"); // 검색내용
        
        try {
            conn = DBManager.getConnection();
            StringBuffer sql = new StringBuffer();
            
            if(opt == null)    // 전체글의 개수
            {
                sql.append("select count(*) from met_board");
                pstmt = conn.prepareStatement(sql.toString());
                
                // StringBuffer를 비운다.
                sql.delete(0, sql.toString().length());
            }
            else if(opt.equals("0")) // 제목으로 검색한 글의 개수
            {
                sql.append("select count(*) from met_board where metBrdName like ?");
                pstmt = conn.prepareStatement(sql.toString());
                pstmt.setString(1, '%'+condition+'%');
                
                sql.delete(0, sql.toString().length());
            }
            rs = pstmt.executeQuery();
            if(rs.next())    result = rs.getInt(1);
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        DBManager.close(conn, pstmt, rs);
        return result;
	}  // end getBoardListCount
	
	//조회수 증가
		public void updateReadCount(String metBrdNum) {
			
			String sql = "update met_board set metBrdCount = metBrdCount+1 where metBrdNum=?";
			
			Connection conn = null;
			PreparedStatement  pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, metBrdNum);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		
		//모임게시판 게시글 상세보기
	      public MetBoardVO selectOneMetBoardByNum(String metBrdNum) {
	         String sql = "select m.metBrdNum, m.metBrdName, m.metBrdContent, m.regDate, m.metBrdCount, m.metBrdCategory,"
	               + "m.memNum, m.metBrdFile, b.memName from met_board m, member b "
	               + "where m.memNum = b.memNum and metBrdNum = ? ";
	         
	         MetBoardVO mVo = null;
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         
	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, metBrdNum);
	            
	            rs = pstmt.executeQuery();
	            
	            if(rs.next()) {
	               
	               mVo = new MetBoardVO();
	               
	               mVo.setMetBrdNum(rs.getString("metBrdNum"));
	               mVo.setMetBrdName(rs.getString("metBrdName"));
	               mVo.setMetBrdContent(rs.getString("metBrdContent"));
	               mVo.setRegDate(rs.getDate("regDate"));
	               mVo.setMetBrdCount(rs.getInt("metBrdCount"));
	               mVo.setMetBrdFile(rs.getString("metBrdFile")); 
	               mVo.setMetBrdCategory(rs.getString("metBrdCategory"));
	               mVo.setMemName(rs.getString("memName"));
	               mVo.setMemNum(rs.getString("memNum"));
	               
	            }
	            
	         } catch (Exception e) {
	               e.printStackTrace();
	         } finally {
	               DBManager.close(conn, pstmt, rs);
	         }
	         
	         return mVo;
	      }
		
		//모임게시판 게시물 수정
		public boolean updateMetBoard(MetBoardVO mVo) {
			
			boolean result = false;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				conn = DBManager.getConnection();
				conn.setAutoCommit( false ); // 자동 커밋을 false로 한다.
				
				StringBuffer sql = new StringBuffer();
				sql.append("update met_board set");
				sql.append(" metBrdName=?");
				sql.append(" ,metBrdContent=?");
				sql.append(" ,metBrdFile=?");
				sql.append("where metBrdNum=?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, mVo.getMetBrdName());
				pstmt.setString(2, mVo.getMetBrdContent());
				pstmt.setString(3, mVo.getMetBrdFile());
				pstmt.setString(4, mVo.getMetBrdNum());
				
				
				int flag = pstmt.executeUpdate();
	            if(flag > 0){
	                result = true;
	                conn.commit(); // 완료시 커밋
	            }
				
			} catch (Exception e) {
				try {
	                conn.rollback(); // 오류시 롤백
	            } catch (SQLException sqle) {
	                sqle.printStackTrace();
	            }
	            throw new RuntimeException(e.getMessage());
	        }
			
			DBManager.close(conn, pstmt);
			return result;
		} // end updateNotice
		
		//모임게시판 게시물 삭제 
		
		public void deleteMetBoard(String metBrdNum) {
			String sql = "delete from met_board where metBrdNum=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, metBrdNum);
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}

		}
	
}
	


