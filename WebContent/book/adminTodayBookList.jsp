<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
   <title>책 조회</title>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="author" content="Webestica.com">
   <meta name="description" content="Creative Multipurpose Bootstrap Template">
<!-- Favicon -->
	<link rel="shortcut icon" href="../assets/images/favicon.ico">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700" rel="stylesheet">

	<!-- Plugins CSS -->
	<link rel="stylesheet" type="text/css" href="../assets/vendor/font-awesome/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/themify-icons/css/themify-icons.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/animate/animate.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/vendor/fancybox/css/jquery.fancybox.min.css" />

	<!-- Theme CSS -->
	<link rel="stylesheet" type="text/css" href="../assets/css/style.css"/>
   
   </head>
   <style>

h4 {
	font-weight: bold;
}
</style>
      <body>
         <header>
            <%@ include file="../include/header.jsp"%>
         </header>
   <!-- =======================
   Banner innerpage -->
   <div class="innerpage-banner center bg-overlay-dark-7 py-7"
      style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
      <div class="container">
         <div class="row all-text-white">
            <div class="col-md-12 align-self-center">
              <h1 class="innerpage-title">이달의 책 </h1>
					<h6 class="subtitle">희망의 책에서 추천하는 이달의 책입니다.</h6>
               <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                     <li class="breadcrumb-item active"><a href="/main?command=loginForm"><i
                           class="ti-home"></i>Home</a></li>
                  </ol>
               </nav>
            </div>
         </div>
      </div>
   </div>
   <!-- =======================
   Banner innerpage -->
   <section>
      <div class="container">
         <div class="row">
            <div class="col-sm-12 mb-5">
             <h4 class="text-center mb-4">관리자 페이지</h4><br>
               <div class="table-responsive-sm">
                  <table class="table table-hover">
                     <thead>
                        <tr>
                           <th scope="col">번호</th>
                           <th scope="col">책제목</th>
                           <th scope="col">이달의 책 제목</th>
                           <th scope="col">첨부파일</th>
                         <th scope="col">저자</th>
                          <th scope="col">출판사</th>
                          <th scope="col">작성자</th>
                        </tr>
                     </thead>
                     
                     <tbody>
                     <c:forEach var="todayBookList" items="${todayBookList}" varStatus="status">
                        <tr>
                        
                        	<th scope = "row">${(paging.numOfRow - status.index) -  (paging.pageNum-1) * 10 }</th>
                           
                           <td><a href="book?command=adminTodayBookUpdateFormAction&bookBrdNum=${todayBookList.bookBrdNum}">${todayBookList.bookTitle}</a></td>
                           <td>${todayBookList.bookBrdTitle}</td>
                           <td>${todayBookList.imgPath}</td>
                           <td>${todayBookList.writer}</td>
                           <td>${todayBookList.publisher}</td>
                           
                           <!-- 관리자만 로그인이 가능하니까 LoginUser로 값을 줌. -->
                           <!-- todayBookList.memName은 3조인해야함. -->
                           <td>${LoginUser.memName}</td>
                        </tr>
                        </c:forEach>
                     </tbody>
                    
                  </table>
                  <div align="right">
                     <a class="btn btn-primary" href="book?command=adminTodayBookRegFormAction">등록</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
   
   
<!-- 페이징 처리 -->  
<section class="pt-0">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<nav>
					<c:if test="${!empty todayBookList}">
						<ul class="pagination justify-content-center">
						<c:if test="${paging.pageNum > 1}">
							<li class="page-item"><a class ="page-link" href="book?command=adminTodayBookList&pageNum=${paging.pageNum - 1}">Prev</a></li>
						
							
						</c:if>	
							<c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="book?command=adminTodayBookList&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
						
							<c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="book?command=adminTodayBookList&pageNum=${paging.pageNum + 1}">Next</a></li>   
                                    </c:if>
							

						</ul>
						</c:if>
						<c:if test="${empty todayBookList}">
						</c:if>
					</nav>
				</div>
			</div>
		</div>
	</section>
	
   <%@ include file="../include/footer.jsp"%>
   
   
   
</body>
</html>