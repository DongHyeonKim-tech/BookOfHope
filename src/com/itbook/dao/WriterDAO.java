package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.FileVO;
import com.itbook.vo.Paging;
import com.itbook.vo.WriterVO;

import util.DBManager;

public class WriterDAO {
	private WriterDAO() {

	}

	// �̱��� ����
	private static WriterDAO instance = new WriterDAO();

	public static WriterDAO getInstance() {
		return instance;
	}

	//회원 & 관리자 :: 작가 리스트
	public List<WriterVO> selectWriterList() {

		String sql = "select writerNo, writerName, imgPath" + "      from writer order by writerNo desc";

		List<WriterVO> list = new ArrayList<WriterVO>();
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				WriterVO wVo = new WriterVO();

				wVo.setWriterNo(rs.getString("writerNo"));
				wVo.setWriterName(rs.getString("writerName"));
				wVo.setImgPath(rs.getString("imgPath"));

				list.add(wVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs); 
												
		}
		return list;
	}



	// 작가 페이징
	public Paging selectWriterRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT" + "   FROM writer";

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
	
	//작가 리스트 페이징

		public ArrayList<WriterVO> selectWriterPage(Paging paging) {
			String sql = "select writerNo, writerName,  imgPath " + "   from writer order by writerNo desc limit ?,9";

			ArrayList<WriterVO> list = new ArrayList<WriterVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
				rs = pstmt.executeQuery();

				while (rs.next()) {
					WriterVO wVo = new WriterVO();

					wVo.setWriterNo(rs.getString("writerNo"));
					wVo.setWriterName(rs.getString("writerName"));
					wVo.setImgPath(rs.getString("imgPath"));

					list.add(wVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs); // �������� �� ������ ����
													// ���ų����� ���ؼ� ���ٷ� ��.
			}
			return list;
		}
		
		
		// 관리자 :: 작가리스트 (지금은 안씀)
		public List<WriterVO> selectAdminWriterList() {
			String sql = "select writerNo, writerName, writerBook1, writerBook2, writerBook3, writerBook4, writerBook5, association, imgPath from writer order by writerNo desc";

			List<WriterVO> list = new ArrayList<WriterVO>();
			Connection conn = null;
			Statement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.createStatement();
				rs = pstmt.executeQuery(sql);

				while (rs.next()) {
					WriterVO wVo = new WriterVO();

					wVo.setWriterNo(rs.getString("writerNo"));
					wVo.setWriterName(rs.getString("writerName"));
					wVo.setWriterBook1(rs.getString("writerBook1"));
					wVo.setWriterBook2(rs.getString("writerBook2"));
					wVo.setWriterBook3(rs.getString("writerBook3"));
					wVo.setWriterBook4(rs.getString("writerBook4"));
					wVo.setWriterBook5(rs.getString("writerBook5"));
					wVo.setAssociation(rs.getString("association"));
					wVo.setImgPath(rs.getString("imgPath"));

					list.add(wVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs); 
													
			}
			return list;
		}

	// 관리자 :: 작가페이징 (지금안씀)
	public ArrayList<WriterVO> selectAdminWriterListPaging(Paging paging) {
		String sql = "select writerNo,  writerName, writerBook1, writerBook2, writerBook3, writerBook4, writerBook5, association, imgPath" + "      from writer order by writerNo desc limit ?,10";

		ArrayList<WriterVO> list = new ArrayList<WriterVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			//
			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));

			rs = pstmt.executeQuery();

			while (rs.next()) {
				WriterVO wVo = new WriterVO();

				wVo.setWriterNo(rs.getString("writerNo"));
				wVo.setWriterName(rs.getString("writerName"));
				wVo.setWriterBook1(rs.getString("writerBook1"));
				wVo.setWriterBook2(rs.getString("writerBook2"));
				wVo.setWriterBook3(rs.getString("writerBook3"));
				wVo.setWriterBook4(rs.getString("writerBook4"));
				wVo.setWriterBook5(rs.getString("writerBook5"));
				wVo.setAssociation(rs.getString("association"));
				wVo.setImgPath(rs.getString("imgPath"));

				list.add(wVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	

	//관리자 :: 작가 등록
	public int insertAdminWriterRegister(WriterVO wVo) {

		String sql = "insert into writer( writerName, writerBook1, writerBook2, writerBook3, writerBook4, writerBook5, association, imgPath, writerContents, memNum)"
					+ "values (?,?,?,?,?,?,?,?,?,?)";
	
		int writerNo = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsKey = null;
		String generatedColumns[] = { "writerNo" };
		
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql, generatedColumns);
			pstmt.setString(1, wVo.getWriterName());
			pstmt.setString(2, wVo.getWriterBook1());
			pstmt.setString(3, wVo.getWriterBook2());
			pstmt.setString(4, wVo.getWriterBook3());
			pstmt.setString(5, wVo.getWriterBook4());
			pstmt.setString(6, wVo.getWriterBook5());
			pstmt.setString(7, wVo.getAssociation());
			pstmt.setString(8, wVo.getImgPath());
			pstmt.setString(9, wVo.getWriterContents());
			pstmt.setString(10, wVo.getMemNum());
			
			pstmt.executeUpdate();
			rsKey = pstmt.getGeneratedKeys();
			if (rsKey.next()) {
				writerNo = rsKey.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return writerNo;
	}
	
	
	

	// 관리자 :: 작가수정
	public boolean updateAdminWriter(WriterVO wVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false); // �ڵ� Ŀ���� false�� �Ѵ�.

			StringBuffer sql = new StringBuffer();
			sql.append("update writer set");
			sql.append(" writerName=?");
			sql.append(" ,writerBook1=?");
			sql.append(" ,writerBook2=?");
			sql.append(" ,writerBook3=?");
			sql.append(" ,writerBook4=?");
			sql.append(" ,writerBook5=?");
			sql.append(" ,association=?");
			sql.append(" ,imgPath=?");
			sql.append(" ,writerContents=?");
			sql.append("    where writerNo=?");

			System.out.println("����" + wVo);
			// update�Ҷ� ���ֱ�.
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, wVo.getWriterName());
			pstmt.setString(2, wVo.getWriterBook1());
			pstmt.setString(3, wVo.getWriterBook2());
			pstmt.setString(4, wVo.getWriterBook3());
			pstmt.setString(5, wVo.getWriterBook4());
			pstmt.setString(6, wVo.getWriterBook5());
			pstmt.setString(7, wVo.getAssociation());
			pstmt.setString(8, wVo.getImgPath());
			pstmt.setString(9, wVo.getWriterContents());
			pstmt.setString(10, wVo.getWriterNo());
			

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				result = true;
				conn.commit(); // �Ϸ�� Ŀ��
			}

		} catch (Exception e) {
			try {
				conn.rollback(); // ������ �ѹ�
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			e.getMessage();
		} finally {

			DBManager.close(conn, pstmt);
		}

		return result;
	}

	//회원, 관리자 :: 상세보기
	public WriterVO selectOneWriterNo(String writerNo) {

		String sql = "select writerNo, writerName, writerBook1, writerBook2, writerBook3, writerBook4, writerBook5, association, imgPath, writerContents, memNum from writer where writerNo = ?";

		WriterVO wVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, writerNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				wVo = new WriterVO();

				wVo.setWriterNo(rs.getString("writerNo"));
				wVo.setWriterName(rs.getString("writerName"));
				wVo.setWriterBook1(rs.getString("writerBook1"));
				wVo.setWriterBook2(rs.getString("writerBook2"));
				wVo.setWriterBook3(rs.getString("writerBook3"));
				wVo.setWriterBook4(rs.getString("writerBook4"));
				wVo.setWriterBook5(rs.getString("writerBook5"));
				wVo.setAssociation(rs.getString("association"));
				wVo.setImgPath(rs.getString("imgPath"));
				
				wVo.setWriterContents(rs.getString("writerContents"));
				wVo.setMemNum(rs.getString("memNum"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return wVo;
	}

	// 작가 삭제
	public void deleteWriter(String writerNo) {
		String sql = "delete from writer where writerNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writerNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 작가 삭제
	public void writerDelete(WriterVO wVO) {
		String sql = "delete from writer where writerNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, wVO.getWriterNo());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	

	public int insertFile(FileVO fVo, int writerNo){

		int res = 0;

		Connection conn = DBManager.getConnection();

		PreparedStatement st = null;
	
		System.out.println(writerNo);
		String sql = "INSERT INTO file (  FILENAME, writerNo )" + "  VALUES( ?, ?)";
		
		System.out.println(sql);

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, fVo.getFileName());
			st.setInt(2, writerNo);

			res = st.executeUpdate(); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = 0;
			e.printStackTrace();

		} finally {
			DBManager.close(conn, st);
		}

		return res;
	}
	
	
	public int deleteFile(String writerNo) {

		int res = 0;

		Connection conn = DBManager.getConnection();

		PreparedStatement st = null;

		String sql = "DELETE FROM file WHERE writerNo = ?";

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, writerNo);

			res = st.executeUpdate(); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = 0;
			e.printStackTrace();

		} finally {
			DBManager.close(conn, st);
		}

		return res;

	}
	
	public int deleteFileName(String fileName) {

		int res = 0;

		Connection conn = DBManager.getConnection();

		PreparedStatement st = null;

		String sql = "DELETE FROM FILE WHERE FILENAME = ?";

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, fileName);

			res = st.executeUpdate(); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = 0;
			e.printStackTrace();

		} finally {
			DBManager.close(conn, st);
		}

		return res;

	}
	
	
	
	  public List<FileVO> getFileList(String writerNo) {
	  
	  List<FileVO> fileList = new ArrayList<FileVO>();
	  
	  Connection conn = DBManager.getConnection();
	  
	  ResultSet rs = null; PreparedStatement st = null;
	  
	  String sql =
	  "SELECT FILENO, FILENAME, writerNo FROM file WHERE writerNo = ?";
	  
	  try {
	  
	  st = conn.prepareStatement(sql);
	  
	  st.setString(1, writerNo);
	  rs = st.executeQuery();
	  
	  while (rs.next()) {
	  
	  FileVO fVo = new FileVO(); 
	  fVo.setFileNo(rs.getInt("FILENO"));
	  fVo.setFileName(rs.getString("FILENAME"));
	  fVo.setWriterNo(rs.getInt("writerNo"));
	  
	  fileList.add(fVo);
	  
	  }
	  
	  } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } finally { DBManager.close(conn, st, rs); }
	  
	  return fileList; }
	  
//	  
//	  public int deleteNoticeFile(String notiNo) {
//	  
//	  int res = 0;
//	  
//	  Connection conn = DBManager.getConnection();
//	  
//	  PreparedStatement st = null;
//	  
//	  String sql = "DELETE FROM NOTICE_FILE WHERE NOTI_NO = ?";
//	  
//	  try { st = conn.prepareStatement(sql); st.setString(1, notiNo);
//	  
//	  res = st.executeUpdate();
//	  
//	  } catch (SQLException e) { // TODO Auto-generated catch block res = 0;
//	  e.printStackTrace();
//	  
//	  } finally { DBManager.close(conn, st); }
//	  
//	  return res;
//	  
//	  }
		// 작가 등록
//		public boolean insertAdminWriterRegister(WriterVO wVo) {
	//
//			boolean result = false;
	//
//			Connection conn = null;
//			PreparedStatement pstmt = null;
	//
//			try {
	//
//				conn = DBManager.getConnection();
//				conn.setAutoCommit(false);
	//
//				StringBuffer sql = new StringBuffer();
	//
//				sql.append(
//						"insert into writer(writerName, writerBook1, writerBook2, writerBook3, writerBook4, writerBook5, association, imgPath, imgPath2, writerContents, memNum)");
//				sql.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
	//
//				pstmt = conn.prepareStatement(sql.toString());
	//
//				pstmt.setString(1, wVo.getWriterName());
//				pstmt.setString(2, wVo.getWriterBook1());
//				pstmt.setString(3, wVo.getWriterBook2());
//				pstmt.setString(4, wVo.getWriterBook3());
//				pstmt.setString(5, wVo.getWriterBook4());
//				pstmt.setString(6, wVo.getWriterBook5());
//				pstmt.setString(7, wVo.getAssociation());
//				pstmt.setString(8, wVo.getImgPath());
//				pstmt.setString(9, wVo.getImgPath2());
//				pstmt.setString(10, wVo.getWriterContents());
//				pstmt.setString(11, wVo.getMemNum());
	//
//				int flag = pstmt.executeUpdate();
	//
//				if (flag > 0) {
//					result = true;
//					conn.commit();
//				}
	//
//			} catch (Exception e) {
	//
//				e.getMessage();
//			} finally {
	//
//				DBManager.close(conn, pstmt);
//			}
	//
//			return result;
	//
//		}
		
		/*
		 * public int insertNotice(NoticeVO nVo) {
		 * 
		 * String sql = "insert into notice(" +
		 * " noti_no, noti_title, noti_contents, mem_id ,noti_date)" +
		 * " values(notice_seq.nextval,?, ?, ?, sysdate)";
		 * 
		 * int notiNo = 0;
		 * 
		 * Connection conn = null; PreparedStatement pstmt = null; ResultSet rsKey =
		 * null; String generatedColumns[] = { "noti_no" };
		 * 
		 * try { conn = DBManager.getConnection();
		 * 
		 * pstmt = conn.prepareStatement(sql, generatedColumns); pstmt.setString(1,
		 * nVo.getNotiTitle()); pstmt.setString(2, nVo.getNotiContents());
		 * pstmt.setString(3, nVo.getMemId());
		 * 
		 * pstmt.executeUpdate(); rsKey = pstmt.getGeneratedKeys();
		 * 
		 * if (rsKey.next()) { notiNo = rsKey.getInt(1); }
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); } finally {
		 * DBManager.close(conn, pstmt); }
		 * 
		 * return notiNo; }
		 */

}