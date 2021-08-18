package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itbook.vo.FeePaymentVO;
import com.itbook.vo.Paging;

import util.DBManager;

public class feePaymentDAO {

		private feePaymentDAO() {
			
		}
		
		private static feePaymentDAO instance = new feePaymentDAO();
		
		//�떛湲��넠 �뙣�꽩
		public static feePaymentDAO getInstance() {
			
			return instance;
		}
		
		//�썑�썝 �벑濡앺븯湲�
		public void insertfeePayment(FeePaymentVO fVo) {
			String sql = "insert into fee_payment(payName,payEmail,payMobileNumber,payZipcode,"
					+ "payAttach,payPosition,payMessage,payBank,payFee,bankName,paySponsor,payBankNum,memNum) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, fVo.getPayName());//�썑�썝�씠由�
				pstmt.setString(2, fVo.getPayEmail());//�썑�썝�씠硫붿씪
				pstmt.setString(3, fVo.getPayMobileNumber());//�썑�썝�옄 �쟾�솕踰덊샇
				pstmt.setString(4, fVo.getPayZipcode());//�슦�렪踰덊샇
				pstmt.setString(5, fVo.getPayAttach());//�냼�냽
				pstmt.setString(6, fVo.getPayPosition());//吏곴툒
				pstmt.setString(7, fVo.getPayMessage());//硫붿꽭吏�
				pstmt.setString(8, fVo.getPayBank());//���뻾
				pstmt.setString(9, fVo.getPayFee());//�썑�썝湲덉븸
				pstmt.setString(10, fVo.getBankName());//�삁湲덉＜
				pstmt.setString(11, fVo.getPaySponsor());//�썑�썝諛⑹떇
				pstmt.setString(12, fVo.getPayBankNum());//怨꾩쥖踰덊샇
				pstmt.setString(13, fVo.getMemNum());//怨꾩쥖踰덊샇
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		public Paging selectfeePayRowCount(Paging paging) {
			int cnt = 0;
			String sql = "SELECT COUNT(*) CNT"
		            + "     FROM fee_payment";
		      
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
		//�썑�썝 由ъ뒪�듃 蹂닿린(愿�由ъ옄)
		public ArrayList<FeePaymentVO> adminSelectfeePayment(Paging paging) {
			String sql = "select * from fee_payment order by payNum desc limit ?,10";
			ArrayList<FeePaymentVO> list = new ArrayList<FeePaymentVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					FeePaymentVO fVo = new FeePaymentVO();
					
					fVo.setPayNum(rs.getString("payNum"));
					fVo.setPayName(rs.getString("payName"));
					fVo.setPayEmail(rs.getString("payEmail"));
					fVo.setPayMobileNumber(rs.getString("payMobileNumber"));
					fVo.setPayZipcode(rs.getString("payZipcode"));
					fVo.setPayAttach(rs.getString("payAttach"));
					fVo.setPayPosition(rs.getString("payPosition"));
					fVo.setPayMessage(rs.getString("payMessage"));
					fVo.setPayBank(rs.getString("payBank"));
					fVo.setBankName(rs.getString("bankName"));
					fVo.setPayFee(rs.getString("payFee"));
					fVo.setPaySponsor(rs.getString("paySponsor"));
					fVo.setPayBankNum(rs.getString("payBankNum"));
					
					list.add(fVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs); // �삁�쟾�뿉�뒗 �떎 �띁吏�留� �씠�젣 �뵒鍮꾨ℓ�꼫吏�瑜� �넻�빐�꽌 �븳以꾨줈 ��.
			}
			return list;
		}
	}
