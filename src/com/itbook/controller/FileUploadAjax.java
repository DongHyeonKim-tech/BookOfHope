package com.itbook.controller;

import java.io.FileInputStream;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import util.EmpUploadFileUtils;
import util.MediaUtils;

/**
 * Servlet implementation class FileUploadAjax
 */
@WebServlet("/uploadAjax")
public class FileUploadAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String uploadFilePath;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("uploadAjax");
			process(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			process(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//   private ResponseEntity<String> process(HttpServletRequest request, HttpServletResponse response) throws Exception {

	private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int uploadFileSizeLimit = 5 * 1024 * 1024;
		

		String encType = "UTF-8";
		uploadFilePath = request.getServletContext().getRealPath("/META-INF/UploadFolder/");

		System.out.println("============ uploadFilePath = " + uploadFilePath);

		MultipartRequest multi = new MultipartRequest(
				
				request, 
				
				uploadFilePath,
				
				uploadFileSizeLimit, 
				
				encType,
				new DefaultFileRenamePolicy());
		//DefaultFileRenamePolicy 는 cos.jar 안에 존재하는 클래스 : 같은 파일명이 있는지 검사하고 있을 경우 뒤에 숫자를 붙혀준다.
		//(파일명을 어떻게 바꾼다라는 규칙이 정해져있는 클래스를 파라미터로 넘겨주고 파일을 업로드 할때 그 규칙에 따라 파일명이 바뀌어서 올라간다) 
		//MultipartRequest 를 통해 업로드 하면 생성자에 FileRenamePolicy 인스턴스를 피라미터로 전달
		
		//파일 업로드를 하려면 기본적인 POSt방식으로는 안되고 파일 업로드를 처리할 수 있는 무언가가 있어야한다
		//Jsp 부분에서 form 에서 entype이 multipart/form-data로 보내야함.  받는 역할은 cos.jar가 함. 기존의 폼을 받던 request.getParameter()로는 받을 수 없으므로
		//cos.jar의 MultipartRequest를 받는다

		String name = "file";
		
		System.out.println("file :  " + name);
		String res = EmpUploadFileUtils.uploadFile(uploadFilePath, multi.getOriginalFileName(name),
				multi.getFilesystemName(name).getBytes());
		//실제 파일이 업로드 되는 이름과  파일명이 중복 되면 시스템에서 자동으로 바꾸어주는 이름

		System.out.println("process :  " + res);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = response.getWriter();
		pw.print(res);
		pw.flush();
	}

	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadFilePath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

}