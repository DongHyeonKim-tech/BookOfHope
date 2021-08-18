<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html>
<head>
   <title>대전책방</title>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="author" content="Webestica.com">
   <meta name="description" content="Creative Multipurpose Bootstrap Template">

   <!-- Favicon -->
   <link rel="shortcut icon" href="../assets/images/favicon.ico">

   <!-- Google Font -->
   <link
   href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700"
   rel="stylesheet">

   <!-- Plugins CSS -->
   <link rel="stylesheet" type="text/css"
   href="../assets/vendor/font-awesome/css/font-awesome.min.css" />
   <link rel="stylesheet" type="text/css"
   href="../assets/vendor/themify-icons/css/themify-icons.css" />
   <link rel="stylesheet" type="text/css"
   href="../assets/vendor/animate/animate.min.css" />

   <!-- Theme CSS -->
   <link rel="stylesheet" type="text/css" href="../assets/css/style.css" />
   </head>
      <body>
         <header>
            <%@ include file="../include/header.jsp"%>
         </header>
   <!-- =======================
   Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/main?command=loginForm"><i class="ti-home"></i>Home</a></li>
							<li class="breadcrumb-item">독서모임</li>
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
               <h5 class="text-center mb-4">박동준</h5> 
               <div class="table-responsive-sm">
                  <table class="table table-hover">
                  
                     <thead>
                     
                        <tr>
                           			<th scope="col">번호</th>
									<!-- <th scope="col">분류</th> -->
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">날짜</th>
                          
                        </tr>
                     </thead>
                     
                     <tbody>
                     <!-- varStatus를 통해서 책번호를 만든다. -->
                     <c:forEach var="metboardList" items="${metboardList}" varStatus="status">
                        <tr>
                           <!-- 전체 페이지 데이터 값 : numOfRow , 현재 페이지 수 : pageNum -->
                           <th scope = "row">${(paging.numOfRow - status.index) -  (paging.pageNum-1) * 10 }</th>
                           <th scope = "row"><a href="meeting?command=bookstoreUpdateForm&bookstoreNum=${metboardList.metBrdNum}">${metboardList.metBrdName}</a></th>
                           
                           <td><fmt:formatDate value="${metbrd.metBrdDate}"/></td>
                        </tr>
     				</c:forEach>
					
                     </tbody>
                    
                  </table>
             	 <div align="right">
             	 
                  <a class="btn btn-grad" href="meeting?command=metPostWriteFormAction&metNum=${meetingVo.metNum }">등록</a>

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
						<ul class="pagination justify-content-center">
						<c:if test="${paging.pageNum > 1}">
							<li class="page-item"><a class ="page-link" href="meeting?command=metBoardListFormAction&pageNum=${paging.pageNum - 1}&metNum=${meetingVo.metNum}">Prev</a></li>
						
							
						</c:if>	
							<c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="meeting?command=metBoardListFormAction&pageNum=${idx}&metNum=${meetingVo.metNum}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
						
							<c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="meeting?command=metBoardListFormActiont&pageNum=${paging.pageNum + 1}&metNum=${meetingVo.metNum}">Next</a></li>   
                                    </c:if>
							

						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section>

	
   <%@ include file="../include/footer.jsp"%>
</body>
</html>