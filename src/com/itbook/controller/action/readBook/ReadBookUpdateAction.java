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

public class ReadBookUpdateAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // 업로드 파일 사이즈
      int fileSize = 5 * 1024 * 1024;
      // 업로드될 폴더 절대경로
      String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");

      try {
         MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",
               new DefaultFileRenamePolicy());

         // 파리미터 값을 가져온다.
         String readBookNo = multi.getParameter("readBookNo"); // 책 읽기  번호
         String bookName = multi.getParameter("bookName"); // 책 제목 제목
         String publishDate = multi.getParameter("publishDate"); // 출판 연도
         String writer = multi.getParameter("writer"); // 저자
         String publisher = multi.getParameter("publisher"); // 출판사
         String readBookContents = multi.getParameter("readBookContents"); // 내용
         String articleURL = multi.getParameter("articleURL"); // 관련 기사 url
         String videoURL = multi.getParameter("videoURL"); // 관련 뎡상  url
         String existFile = multi.getParameter("existing_file");
         


         // 파라미터 값을 자바빈에 세팅한다.
         ReadBookVO rbVo = new ReadBookVO();
         rbVo.setReadBookNo(readBookNo);
         rbVo.setBookName(bookName);
         rbVo.setPublishDate(publishDate);
         rbVo.setWriter(writer);
         rbVo.setPublisher(publisher);
         rbVo.setReadBookContents(readBookContents);
         rbVo.setArticleURL(articleURL);
         rbVo.setVideoURL(videoURL);
         

         // 글 수정 시 업로드된 파일 가져오기
         Enumeration<String> fileNames = multi.getFileNames();
         if (fileNames.hasMoreElements()) {
            String fileName = fileNames.nextElement();
            String updateFile = multi.getFilesystemName(fileName);

            if (updateFile == null) // 수정시 새로운 파일을 첨부 안했다면 기존 파일명을 세팅
               rbVo.setReadBookFile(existFile);
            else // 새로운 파일을 첨부했을 경우
               rbVo.setReadBookFile(updateFile);
         }

         ReadBookDAO rbDao = ReadBookDAO.getInstance();
         boolean result = rbDao.updateReadBook(rbVo);

         if (result) {

            // 원래있던 페이지로 돌아가기 위해 페이지번호를 전달한다.
            // forward.setNextPath("BoardListAction.bo?page="+pageNum);

            new ReadBookListAction().execute(request, response);
         }

      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("글 수정 오류 : " + e.getMessage());
      }

   }

}