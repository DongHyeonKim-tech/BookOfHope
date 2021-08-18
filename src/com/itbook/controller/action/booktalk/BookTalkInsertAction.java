package com.itbook.controller.action.booktalk;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookTalkDAO;
import com.itbook.vo.BookTalkVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BookTalkInsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int fileSize= 5*1024*1024;
	     
	        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
	        
	        System.out.println("============ uploadFilePath = " + uploadPath);
	        
	        try {
	            
	           
	            MultipartRequest multi = new MultipartRequest
	                    (request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
	 
	           
	            String fileName = "";
	            Enumeration<String> names = multi.getFileNames();
	            if(names.hasMoreElements())
	            {
	                String name = names.nextElement();
	                fileName = multi.getFilesystemName(name);
	            }
	            
	            System.out.println("fileName : " + fileName);

	            BookTalkDAO bDao = BookTalkDAO.getInstance();
	            BookTalkVO bVo = new BookTalkVO();
	            
	            bVo.setTalkName(multi.getParameter("talkName"));
	            bVo.setWriter(multi.getParameter("writer"));
	            bVo.setTalkDate(multi.getParameter("talkDate"));
	            bVo.setTalkPlace(multi.getParameter("talkPlace"));
	            bVo.setTalkContents(multi.getParameter("talkContents"));
	            bVo.setArticleURL(multi.getParameter("articleURL"));
	            bVo.setTalkFile(multi.getFilesystemName("talkFile"));
	            bVo.setTalkPublisher(multi.getParameter("talkPublisher"));
	            bVo.setVideoURL(multi.getParameter("videoURL"));
	           
	            
	            
	            boolean result = bDao.insertBookTalk(bVo);
	            
	            if(result) {
	            	
	            	new BookTalkListFormAction().execute(request, response);
	            }
	            	
	            } catch (Exception e) {
	                
	            	e.printStackTrace();
	                System.out.println("湲� �옉�꽦 �삤瑜� : " + e.getMessage());
	            }
	        	
	        
	        }  

}
