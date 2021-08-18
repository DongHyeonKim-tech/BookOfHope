package com.itbook.controller.action.notice;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.NoticeDAO;
import com.itbook.vo.Notice.NoticeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * 怨듭��궗�빆 �벑濡앺빐二쇰뒗 �븸�뀡 �겢�옒�뒪 
 * 
 * @author 源��젙誘�
 *
 */

public class NoticeInsertAction implements Action {
	
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

            NoticeDAO nDao = NoticeDAO.getInstance();
            NoticeVO nVo = new NoticeVO();
            
            nVo.setNoticeTitle(multi.getParameter("noticeTitle"));
            nVo.setNoticeContent(multi.getParameter("noticeContent"));
            nVo.setNoticeCategory(multi.getParameter("noticeCategory"));
            nVo.setNoticeFile(multi.getFilesystemName("noticeFile"));
            nVo.setMemNum(multi.getParameter("memNum"));
            
            boolean result = nDao.insertNotice(nVo);
            
            if(result) {
            	
            	new NoticeListFormAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("등록 : " + e.getMessage());
            }
        	
        
        }  
        
}

		
		
		
		
	

