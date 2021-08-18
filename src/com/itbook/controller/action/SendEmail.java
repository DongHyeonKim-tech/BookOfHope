package com.itbook.controller.action;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SendEmail {
	
	/**
	 * Action이 수행할 기능들을 정의
	 * 모든 기능이 수행된 후 
	 * RequestDispatcher의 forward() 메소드를 통해서 페이지 이동을 시켜줄 것을 권장
	 * 
	 * @see RequestDispatcher
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AddressException, MessagingException;
}
