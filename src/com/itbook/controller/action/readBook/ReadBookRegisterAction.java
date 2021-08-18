package com.itbook.controller.action.readBook;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ReadBookDAO;
import com.itbook.vo.readBook.ReadBookVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReadBookRegisterAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 파일
        int fileSize= 5*1024*1024;
        // 파일 경로
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        
        System.out.println("============ uploadFilePath = " + uploadPath);
        
        try {
            
        	// 파일업로드
            MultipartRequest multi = new MultipartRequest
                    (request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
 
         // 파일이름 가져오기
            String fileName = "";
            Enumeration<String> names = multi.getFileNames();
            
            if(names.hasMoreElements())
            {
                String name = names.nextElement();
                fileName = multi.getFilesystemName(name);
            }
            
            System.out.println("fileName : " + fileName);

            ReadBookDAO rbDao = ReadBookDAO.getInstance();
            ReadBookVO rbVo = new ReadBookVO();
			/* DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */
            
            rbVo.setBookName(multi.getParameter("bookName"));
			/* rbVo.setPublishDate(multi.getParameter("publishDate")); */
            rbVo.setWriter(multi.getParameter("writer"));
            rbVo.setPublisher(multi.getParameter("publisher"));
            rbVo.setPublishDate(multi.getParameter("publishDate"));
            rbVo.setReadBookContents(multi.getParameter("readBookContents"));
            rbVo.setArticleURL(multi.getParameter("articleURL"));
            rbVo.setVideoURL(multi.getParameter("videoURL"));
            rbVo.setReadBookFile(multi.getFilesystemName("readBookFile"));
            rbVo.setMemNum(multi.getParameter("memNum"));
            
         
            boolean result = rbDao.insertReadBook(rbVo);
            
            if(result) {
            	
            	new ReadBookListAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("책일기 게시물을 작성하였습니다. : " + e.getMessage());
            }
        	
        
        }  

}
