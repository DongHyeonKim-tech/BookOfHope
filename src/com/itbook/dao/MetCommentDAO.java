package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itbook.vo.Meeting.MetCommentVO;

import util.DBManager;

/**
 * 
 * 독서모임게시판 댓글 등록, 삭제, 조회를 할 수 있는 클래스(싱글톤)
 * 
 * @author 김정민
 *
 */

public class MetCommentDAO {
	
	private static MetCommentDAO instance = new MetCommentDAO();

	public static MetCommentDAO getInstance() {

		return instance;
	}
	
	// 댓글 등록
    public boolean insertComment(MetCommentVO comment)
    {
        boolean result = false;
        
        Connection conn = null;
		PreparedStatement pstmt = null;
        
        try {
            conn = DBManager.getConnection();
 
            // 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);
            
            StringBuffer sql = new StringBuffer();
            sql.append("INSERT INTO met_comment");
            sql.append(" (metBrdNum, memNum, metComtContent");
            sql.append(" , metComtDate)");
            sql.append(" VALUES(?,?,?, sysdate())");
    
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, comment.getMetBrdNum());
            pstmt.setString(2, comment.getMemNum());
            pstmt.setString(3, comment.getMetComtContent());
            
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
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        DBManager.close(conn, pstmt);
        return result;    
    } // end boardInsert();    
    
 // 댓글 목록 가져오기
    public ArrayList<MetCommentVO> getCommentList(String metBrdNum)
    {
        ArrayList<MetCommentVO> list = new ArrayList<MetCommentVO>();
        Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        
        try {
            conn = DBManager.getConnection();
            
            StringBuffer sql = new StringBuffer();
            sql.append("    select m.metComtNum, m.metComtContent, m.metComtDate,");
            sql.append("           m.metBrdNum, m.memNum, b.memName ");
            sql.append("    from met_comment m, member b");
            sql.append("    where m.memNum = b.memNum and m.metBrdNum = ? order by m.metComtNum desc");
            
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, metBrdNum);
            
            rs = pstmt.executeQuery();
            while(rs.next())
            {
            	MetCommentVO comment = new MetCommentVO();
                comment.setMetComtNum(rs.getString("metComtNum"));
                comment.setMetComtContent(rs.getString("metComtContent"));
                comment.setMetBrdNum(rs.getString("metBrdNum"));
                comment.setMetComtDate(rs.getDate("metComtDate"));
                comment.setMemNum(rs.getString("memNum"));
                comment.setMemName(rs.getString("memName"));
                
                
                list.add(comment);
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        DBManager.close(conn, pstmt, rs);
        return list;
    } // end getCommentList
    
    //댓글 삭제
    public boolean deleteComment(String metComtNum) 
    {
        boolean result = false;
        
        Connection conn = null;
		PreparedStatement pstmt = null;
 
        try {
            conn = DBManager.getConnection();
            conn.setAutoCommit(false); // 자동 커밋을 false로 한다.
 
            StringBuffer sql = new StringBuffer();
            sql.append("DELETE FROM met_comment");
            sql.append(" WHERE metComtNum = ? ");
            
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, metComtNum);
            
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
    } // end deleteComment  




}
