package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itbook.vo.Paging;
import com.itbook.vo.donation.TaxVO;

import util.DBManager;

/**
 * 
 * �뿰留먯젙�궛 �쁺�닔利� �떊泥� �븷 �닔 �엳�뒗 �겢�옒�뒪(�떛湲��넠)
 * 
 * @author 源��젙誘�
 *
 */

public class TaxDAO {

	private static TaxDAO instance = new TaxDAO();

	public static TaxDAO getInstance() {

		return instance;

	}

	// �뿰留먯젙�궛 �쁺�닔利� �떊泥�
		public void insertTax(TaxVO tVo) {
		String sql = "insert into tax (taxName, taxEmail, taxPhone, taxAdr1, taxAdr2, taxAdr3, taxMsg, memNum)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tVo.getTaxName());
			pstmt.setString(2, tVo.getTaxEmail());
			pstmt.setString(3, tVo.getTaxPhone());
			pstmt.setString(4, tVo.getTaxAdr1());
			pstmt.setString(5, tVo.getTaxAdr2());
			pstmt.setString(6, tVo.getTaxAdr3());
			pstmt.setString(7, tVo.getTaxMsg());
			pstmt.setString(8, tVo.getMemNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
		
	// �뿰留먯젙�궛 �쁺�닔利� �궡�뿭蹂닿린
		public ArrayList<TaxVO> adminSelectTax(Paging paging) {
			String sql = "select * from tax order by taxNum desc limit ?,10";
			ArrayList<TaxVO> list = new ArrayList<TaxVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					TaxVO tVo = new TaxVO();
					
					tVo.setTaxNum(rs.getString("taxNum"));
					tVo.setTaxName(rs.getString("taxName"));
					tVo.setTaxPhone(rs.getString("taxPhone"));
					tVo.setTaxAdr1(rs.getString("taxAdr1"));
					tVo.setTaxAdr2(rs.getString("taxAdr2"));
					tVo.setTaxAdr3(rs.getString("taxAdr3"));
					tVo.setTaxEmail(rs.getString("taxEmail"));
					tVo.setTaxMsg(rs.getString("taxMsg"));
					list.add(tVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs); // �삁�쟾�뿉�뒗 �떎 �띁吏�留� �씠�젣 �뵒鍮꾨ℓ�꼫吏�瑜� �넻�빐�꽌 �븳以꾨줈 ��.
			}
			return list;
		}
		
		public Paging selectTaxRowCount(Paging paging) {
			int cnt = 0;
			String sql = "SELECT COUNT(*) CNT"
		            + "     FROM tax";
		      
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
	}
