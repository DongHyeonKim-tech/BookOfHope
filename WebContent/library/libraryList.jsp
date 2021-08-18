<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>도서관 조회</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Webestica.com">
<meta name="description"
	content="Creative Multipurpose Bootstrap Template">

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

	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">대전 도서관</h1>
					<h6 class="subtitle">희망의 책 대전본부</h6>
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

	<section class="service">

		<!-- <div class="col-md-12"> -->

		<div class="container">
			<div class="row">
				
				
				<div class="divider">
					<i class="ti-book"></i>
				</div>
				<c:forEach var="libraryList" items="${libraryList}">

					<h5 class="mb-2 mt-5"></h5>

					<div class="col-lg-4 mt-4">
						<div class="feature-box f-style-3 h-100 icon-grad">
							<div class="feature-box-icon">
								<i class="ti-book"></i>
							</div>


							<h3 class="feature-box-title">${libraryList.libraryTitle}</h3>
							<a href="${libraryList.libraryUrl}" target="_blank">${libraryList.libraryUrl}</a>
							<p class="feature-box-desc">${libraryList.libraryContent}</p>
							
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</section>
	<!-- 페이징 처리 -->
<%-- 	<section class="pt-0">
      <div class="container">
         <div class="row justify-content-center">
            <div class="col-md-8">
               <nav>
                  <ul class="pagination justify-content-center">
                  <c:if test="${paging.pageNum > 1}">
                     <li class="page-item"><a class ="page-link" href="library?command=libraryList&pageNum=${paging.pageNum - 1}">Prev</a></li>
                  
                     
                  </c:if>   
                     <c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="library?command=libraryList&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
                  
                     <c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="library?command=libraryList&pageNum=${paging.pageNum + 1}">Next</a></li>   
                                    </c:if>
                     

                  </ul>
               </nav>
            </div>
         </div>
      </div>
   </section> 

 --%>



 <section class="pt-0">
      <div class="container">
         <div class="row justify-content-center">
            <div class="col-md-8">
               <nav>
               <c:if test="${!empty libraryList}">
                  <ul class="pagination justify-content-center">
                  <c:if test="${paging.pageNum > 1}">
                     <li class="page-item"><a class ="page-link" href="library?command=libraryList&pageNum=${paging.pageNum-1}">Prev</a></li>
                  
                     
                  </c:if>   
                     <c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="library?command=libraryList&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
                  
                     <c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="library?command=libraryList&pageNum=${paging.pageNum + 1}">Next</a></li>   
                                    </c:if>
                     

                  </ul>
                  </c:if>
						<c:if test="${empty libraryList}">
						</c:if>
               </nav>
            </div>
         </div>
      </div>
   </section>  



	<%@ include file="../include/footer.jsp"%>
</body>
</html>
</html>