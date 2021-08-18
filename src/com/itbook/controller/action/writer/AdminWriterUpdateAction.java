package com.itbook.controller.action.writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.WriterDAO;
import com.itbook.vo.FileVO;
import com.itbook.vo.WriterVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminWriterUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fileSize = 5 * 1024 * 1024;
		// 업로드될 폴더 경로
				String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");

				try {
					MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",
							new DefaultFileRenamePolicy());

					// 파라미터 값을 가져온다.
					String writerNo = multi.getParameter("writerNo");
					String writerName = multi.getParameter("writerName");
					String writerBook1 = multi.getParameter("writerBook1");
					String writerBook2 = multi.getParameter("writerBook2");
					String writerBook3 = multi.getParameter("writerBook3");
					String writerBook4 = multi.getParameter("writerBook4");
					String writerBook5 = multi.getParameter("writerBook5");
					String association = multi.getParameter("association");
					String writerContents = multi.getParameter("writerContents");
					String existFile = multi.getParameter("existing_file"); // 기존첨부파일

					// 파라미터 값을 자바빈에 세팅한다.
					WriterVO wVo = new WriterVO();
					wVo.setWriterNo(writerNo);
					wVo.setWriterName(writerName);
					wVo.setWriterBook1(writerBook1);
					wVo.setWriterBook2(writerBook2);
					wVo.setWriterBook3(writerBook3);
					wVo.setWriterBook4(writerBook4);
					wVo.setWriterBook5(writerBook5);
					wVo.setAssociation(association);
					wVo.setWriterContents(writerContents);
		
					// 글 수정 시 업로드된 파일 가져오기
					Enumeration<String> fileNames = multi.getFileNames();
					if (fileNames.hasMoreElements()) {
						String fileName1 = fileNames.nextElement();
						String updateFile = multi.getFilesystemName(fileName1);
						if (updateFile == null) // 수정시 새로운 파일을 첨부 안했다면 기존파일명 세팅
							wVo.setImgPath(existFile);
						else
							wVo.setImgPath(updateFile);
					}

					WriterDAO wDao = WriterDAO.getInstance();
					boolean result = wDao.updateAdminWriter(wVo);
					
					
					String[] filesArray = multi.getParameterValues("files");
					System.out.println("filesArray----------------------"+filesArray);
					ArrayList<FileVO> fileList = new ArrayList<FileVO>();

					if (filesArray != null) {

						for (String fileName : filesArray) {

							FileVO iVo = new FileVO();
							iVo.setFileName(fileName);
							fileList.add(iVo);

							System.out.println("filesArray: " + fileName);

						}
					}
			//  //파일 삭제했다 다시 생성
					String writerNo1 = wVo.getWriterNo();
					WriterDAO.getInstance().deleteFile(writerNo1);
					System.out.println("writerNo1: " + writerNo1);
					
					int writerNo2 = Integer.valueOf(wVo.getWriterNo());
					
					System.out.println("writerNo2: " + writerNo2);
					
					if (writerNo2 != 0) {
						for (FileVO fVo : fileList) {
						  WriterDAO.getInstance().insertFile(fVo, writerNo2);
						}
					}

					if (result) {
						new WriterListAction().execute(request, response);
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("대전의 작가들 글 수정 오류 : " + e.getMessage());
				}
			}
		}