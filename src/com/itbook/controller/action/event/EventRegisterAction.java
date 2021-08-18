package com.itbook.controller.action.event;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;

import com.itbook.dao.EventDAO;

import com.itbook.vo.Event.EventVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EventRegisterAction implements Action {
	
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

            EventDAO eDao = EventDAO.getInstance();
            EventVO eVo = new EventVO();
			/* DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */
            
            eVo.setEventName(multi.getParameter("eventName"));
            eVo.setEventPlace(multi.getParameter("eventPlace"));
            eVo.setEventDate(multi.getParameter("eventDate"));
            eVo.setEventContents(multi.getParameter("eventContents"));
            eVo.setEventFile(multi.getFilesystemName("eventFile"));
            eVo.setMemNum(multi.getParameter("memNum"));
            
         
            boolean result = eDao.insertEvent(eVo);
            
            if(result) {
            	
            	new EventListAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("행사를 작성하였습니다. : " + e.getMessage());
            }
        	
        
        }  

}
