package com.itbook.controller.action.program;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.ProgramDAO;
import com.itbook.vo.ProgramVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProgramInsertAction implements Action{

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

	            ProgramDAO pDao = ProgramDAO.getInstance();
	            ProgramVO pVo = new ProgramVO();
	            
	            pVo.setTitle(multi.getParameter("title"));
	            pVo.setName(multi.getParameter("name"));
	            pVo.setCompany(multi.getParameter("company"));
	            pVo.setStartTime(multi.getParameter("startTime"));
	            pVo.setEndTime(multi.getParameter("endTime"));
	            pVo.setLiveLink(multi.getParameter("liveLink"));
	            
	            pVo.setVideoLink(multi.getFilesystemName("videoLink"));
	            pVo.setIntro1(multi.getParameter("intro1"));
	            pVo.setIntro2(multi.getParameter("intro2"));
	            pVo.setContact(multi.getParameter("contact"));
	            pVo.setProFile(multi.getParameter("proFile"));
	           
	           
	            
	            
	            boolean result = pDao.insertProgram(pVo);
	            
	            if(result) {
	            	
	            	new ProgramListFormAction().execute(request, response);
	            }
	            	
	            } catch (Exception e) {
	                
	            	e.printStackTrace();
	                System.out.println("등록 : " + e.getMessage());
	            }
	        	
	        
	        }  
	}


