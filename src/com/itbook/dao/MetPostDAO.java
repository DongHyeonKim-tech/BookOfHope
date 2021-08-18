package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itbook.vo.Meeting.MetBoardVO;
import com.itbook.vo.Meeting.MetPostVO;

import util.DBManager;

public class MetPostDAO {
	
	private static MetPostDAO instance = new MetPostDAO();
	
	public static MetPostDAO getInstance() {
		
		return instance;
	}
	
	// 모임게시판 게시물 등록
		public boolean insertMetPost(MetPostVO mVo) {
			
			boolean result = false;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				conn = DBManager.getConnection();
				conn.setAutoCommit( false );
				
				StringBuffer sql = new StringBuffer();
				
				sql.append("insert into met_post(metPostTitle, metPostContent, metPostFile, metPostCount, metPostDate, metPostCategory)");
				sql.append("values( ?, ?, ?, ?, sysdate(), ?)");
				
				pstmt = conn.prepareStatement(sql.toString());
				
				pstmt.setString(1, mVo.getMetPostTitle());
				pstmt.setString(2, mVo.getMetPostContent());
				pstmt.setString(3, mVo.getMetPostFile());
				pstmt.setInt(4, mVo.getMetPostCount());
				pstmt.setString(5, mVo.getMetPostCategory());
				
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
		public ArrayList<MetPostVO> getMetPostList(HashMap<String, Object> listOpt) {
			
			ArrayList<MetPostVO> list = new ArrayList<MetPostVO>();
			
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
					sql.append("select * from met_post order by metPostNum desc limit ?, 10");
					
					
					
					pstmt = conn.prepareStatement(sql.toString());
					pstmt.setInt(1, start);
					
					
					// StringBuffer를 비운다.
					sql.delete(0, sql.toString().length());
				}
				
				 else if(opt.equals("0")) // 제목으로 검색
		            {
		                sql.append("select * from met_post where metPostTitle like ? "
		                		+ "order by metPostNum desc limit ?, 10");
		                
		                
		                pstmt = conn.prepareStatement(sql.toString());
		                pstmt.setString(1, "%"+condition+"%");
		                pstmt.setInt(2, start);
		               
		                
		                sql.delete(0, sql.toString().length());
		            }
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					MetPostVO mVo = new MetPostVO();
					
					mVo.setMetPostNum(rs.getString("metPostNum"));
					mVo.setMetPostTitle(rs.getString("metPostTitle"));
					mVo.setMetPostContent(rs.getString("metPostContent"));
					mVo.setMetPostDate(rs.getDate("metPostDate"));
					mVo.setMetPostFile(rs.getString("metPostFile"));
					mVo.setMetPostCount(rs.getInt("metPostCount"));
					mVo.setMetPostCategory(rs.getString("metPostCategory"));
					
					list.add(mVo);
				}
					
				} catch (Exception e) {
		            throw new RuntimeException(e.getMessage());
		        }
		        
				DBManager.close(conn, pstmt, rs);
				return list;
		    } // end getBoardList
			
		
		//글의 개수를 가져오는 메서드
		public int getMetPostListCount(HashMap<String, Object> listOpt) {
			
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
	                sql.append("select count(*) from met_post");
	                pstmt = conn.prepareStatement(sql.toString());
	                
	                // StringBuffer를 비운다.
	                sql.delete(0, sql.toString().length());
	            }
	            else if(opt.equals("0")) // 제목으로 검색한 글의 개수
	            {
	                sql.append("select count(*) from met_post where metPostTitle like ?");
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
			public void updateReadCount(String metPostNum) {
				
				String sql = "update met_post set metPostCount = metPostCount+1 where metPostNum=?";
				
				Connection conn = null;
				PreparedStatement  pstmt = null;
				
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, metPostNum);
					pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt);
				}
				
			}
			
			//모임게시판 게시글 상세보기
			public MetPostVO selectOneMetPostByNum(String metPostNum) {
				String sql = "select * from met_post where metPostNum=? order by metPostNum asc";
				
				MetPostVO mVo = null;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, metPostNum);
					
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						
						mVo = new MetPostVO();
						mVo.setMetPostNum(rs.getString("metPostNum"));
						mVo.setMetPostTitle(rs.getString("metPostTitle"));
						mVo.setMetPostContent(rs.getString("metPostContent"));
						mVo.setMetPostDate(rs.getDate("metPostDate"));
						mVo.setMetPostCount(rs.getInt("metPostCount"));
						mVo.setMetPostFile(rs.getString("metPostFile"));
						mVo.setMetPostCategory(rs.getString("metPostCategory"));
						
					}
					
				} catch (Exception e) {
						e.printStackTrace();
				} finally {
						DBManager.close(conn, pstmt, rs);
				}
				
				return mVo;
			}
			
			//모임게시판 게시물 수정
			public boolean updateMetPost(MetPostVO mVo) {
				
				boolean result = false;
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					
					conn = DBManager.getConnection();
					conn.setAutoCommit( false ); // 자동 커밋을 false로 한다.
					
					StringBuffer sql = new StringBuffer();
					sql.append("update met_post set");
					sql.append(" metPostTitle=?");
					sql.append(" ,metPostContent=?");
					sql.append(" ,metPostFile=?");
					sql.append("where metPostNum=?");
					
					pstmt = conn.prepareStatement(sql.toString());
					pstmt.setString(1, mVo.getMetPostTitle());
					pstmt.setString(2, mVo.getMetPostContent());
					pstmt.setString(3, mVo.getMetPostFile());
					pstmt.setString(4, mVo.getMetPostNum());
					
					
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
			
			public void deleteMetPost(String metPostNum) {
				String sql = "delete from met_post where metPostNum=?";
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					conn = DBManager.getConnection();
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, metPostNum);
					
					pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt);
				}

			}

}
