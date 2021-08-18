package com.itbook.controller.action.book;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.BookDAO;
import com.itbook.vo.MemberVO;
import com.itbook.vo.Book.BookBoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminTodayBookRegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//
        int fileSize= 5*1024*1024;
        // 
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        
        System.out.println("============ uploadFilePath = " + uploadPath);
        
        try {
            
            // 
            MultipartRequest multi = new MultipartRequest
                    (request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
 
            //
            String fileName = "";
            Enumeration<String> names = multi.getFileNames();
            
            
            if(names.hasMoreElements())
            {
                String name = names.nextElement();
                fileName = multi.getFilesystemName(name);
            }
            
            System.out.println("fileName : " + fileName);

            BookDAO bDao = BookDAO.getInstance();
            BookBoardVO bVo = new BookBoardVO();
            
            bVo.setBookBrdTitle(multi.getParameter("bookBrdTitle"));
    		bVo.setBookBrdContent(multi.getParameter("bookBrdContent"));
    		bVo.setBookTitle(multi.getParameter("bookTitle"));
    		bVo.setWriter(multi.getParameter("writer"));
    		bVo.setPublisher(multi.getParameter("publisher"));
    		bVo.setBookNum(multi.getParameter("bookNum"));
    		bVo.setImgPath(multi.getFilesystemName("imgPath"));
    		
    		//�꽮�뀡媛� 媛��졇�삤湲�.
    		MemberVO memVo = (MemberVO)request.getSession().getAttribute("LoginUser");
    	      bVo.setMemNum(memVo.getMemNum());
            
            boolean result = bDao.insertAdminTodayBookRegister(bVo);
            
            if(result) {
            	new AdminTodayBookListAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
            }
        	
        
        }  
}