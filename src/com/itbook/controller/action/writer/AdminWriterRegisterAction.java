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
import com.itbook.vo.MemberVO;
import com.itbook.vo.WriterVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminWriterRegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fileSize= 5*1024*1024;
		 String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder/");
		 //path가 실제 저장되는 경로
		 
		   System.out.println("============ uploadFilePath = " + uploadPath);
		     
	        try {
	        	
	        	MultipartRequest multi = new MultipartRequest
	                    (request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
	 
	        	//MultipartRequest 를 사용하게 되면 톰캣의 request 객케의 getParameter 메서드를 이용하는 값 전달 못함.
	        	//MultipartRequest를 사용하고 값을 전달받기 위해 getParameter 메서드 이용하여 값 전달 받아야한다.
	        	  String fileName1 = "";
	        	  Enumeration<String> names = multi.getFileNames();
	              
	              //Eumeration으로 multi객체로 부터 전달받은 폼의 이름을 구해온다. 
	        	
	              
	              //hanMoreElement()는 커서 바로 앞에 데이타가 들어있는지를 체크
	              if(names.hasMoreElements())
	              {
	                  String name = names.nextElement();
	                  fileName1 = multi.getFilesystemName(name);
	                  //getFilesystemName 파일이 저장되는 이름을 String 으로 저장한다
	              }
	              
	              System.out.println("fileName1 : " + fileName1);
	              
	              WriterDAO wDao = WriterDAO.getInstance();
	              WriterVO wVo = new WriterVO();
	              
	              
	              
	              wVo.setWriterName(multi.getParameter("writerName"));
	              wVo.setWriterBook1(multi.getParameter("writerBook1"));
	              wVo.setWriterBook2(multi.getParameter("writerBook2"));
	              wVo.setWriterBook3(multi.getParameter("writerBook3"));
	              wVo.setWriterBook4(multi.getParameter("writerBook4"));
	              wVo.setWriterBook5(multi.getParameter("writerBook5"));
	              wVo.setAssociation(multi.getParameter("association"));
	              wVo.setWriterContents(multi.getParameter("writerContents"));
	              wVo.setImgPath(multi.getFilesystemName("imgPath"));
	             
	              
	              
	              
	              MemberVO memVo = (MemberVO)request.getSession().getAttribute("LoginUser");
	              wVo.setMemNum(memVo.getMemNum());
	            
	            int writerNo = wDao.insertAdminWriterRegister(wVo);
				System.out.println(writerNo);

	    		String[] filesArray = multi.getParameterValues("files");
	    		
	    		System.out.println("filesArray----------------------"+filesArray);
	    		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
	    		
	    		// 첨부파일 [] -> List add 하는 작업
	    		if (filesArray != null) {

	    			for (String fileName : filesArray) {

	    				FileVO iVo = new FileVO();
	    				iVo.setFileName(fileName);
	    				fileList.add(iVo);
	    				
	    			}
	    		}
           
				if (writerNo != 0) {
					
					for (FileVO fVo : fileList) {
						// 첨부파일 DB 저장
						

						WriterDAO.getInstance().insertFile(fVo, writerNo);
					}

					new WriterListAction().execute(request, response);
				}
	            	
	            } catch (Exception e) {
	                
	            	e.printStackTrace();
	            }
	        	
	        
	        }  
	}