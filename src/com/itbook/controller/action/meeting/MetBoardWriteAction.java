package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MetBoardDAO;
import com.itbook.dao.MetPostDAO;
import com.itbook.vo.Meeting.MetBoardVO;
import com.itbook.vo.Meeting.MetPostVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * 독서모임게시판 게시글 등록 액션 클래스 
 * 
 * @author 김정민
 *
 */

public class MetBoardWriteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드 파일 사이즈
        int fileSize= 5*1024*1024;
        // 업로드될 폴더 경로
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        String metNum = request.getParameter("metNum");
        String memNum = request.getParameter("memNum");
        
        
        System.out.println("metNum: " + metNum);
        System.out.println("memNum: " + memNum);
        
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
            
            MetBoardDAO mDao = MetBoardDAO.getInstance();
            MetBoardVO mVo = new MetBoardVO();
            
            mVo.setMetNum(multi.getParameter("metNum"));
            mVo.setMetBrdName(multi.getParameter("metBrdName"));
            mVo.setMetBrdContent(multi.getParameter("metBrdContent"));
            mVo.setMetBrdCategory(multi.getParameter("metBrdCategory"));
            mVo.setMemNum(multi.getParameter("memNum"));
            mVo.setMetBrdFile(multi.getFilesystemName("metBrdFile"));
            
            boolean result = mDao.insertMetBoard(mVo);
            
            
            if(result) {
            	
            	new metBoardListFormAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("글 작성 오류 : " + e.getMessage());
            }
        	
        
        }  
		
	}
