<!-- 	DJ PARK
		이달의 책 리스트
		(보류)책 제목을 누르면 상세보기 페이지로 넘어감.	-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<title></title>
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
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/owlcarousel/css/owl.carousel.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />

</head>
<style>
.postt {
	text-align: center;
	margin: 10px;
	font-size: 0.875rem;
	color: black;
	font-weight: bold;
}

/* style="font-weight: bold; text-align: center; margin-right: 20px;" */
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
					<h1 class="innerpage-title">대전의 작가들</h1>
					<h6 class="subtitle">대전의 작가들을 소개합니다.</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a
								href="/main?command=loginForm"><i class="ti-home"></i>Home</a></li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->


	<!-- =======================
	blog -->
	<section class="blog-page pb-0">
		<div class="container">
			<div class="row" style="text-align: center;">
				<div class="col-md-12 blog-grid blog-grid-3 portfolio-wrap"
					data-isotope='{ "itemSelector": ".post-item", "layoutMode": "fitRows" }'>



					<!-- 이달의 책 게시판 글 / 첨부파일 -->
					<c:forEach var="writerList" items="${writerList}"
						varStatus="status">
						<div class="post-item">
							<div class="post-item-wrap">
								<div class="post-image">
									<span class="post-meta-category bg-grad">${status.count}</span>
								</div>
								<div class="post-image">

									<c:if test="${empty writerList.imgPath}">
										<a
											href="writer?command=writerView&writerNo=${writerList.writerNo}">
											<img src="../resources/images/writer.png" alt=""
											style="width: 300px; height: 400px; overflow: hidden;">
										</a>
									</c:if>

									<c:if test="${!empty writerList.imgPath}">
										<a
											href="writer?command=writerView&writerNo=${writerList.writerNo}">
											<img src="/displayFile?fileName=${writerList.imgPath}" alt=""
											style="width: 300px; height: 400px; overflow: hidden;">
										</a>
									</c:if>
								</div>
								<br>

								<div >
									<span class="postt"> 작가 이름 :
										${writerList.writerName} </span>
								</div>
								<div class="postt">
									<a class="btn btn-success"
										style="padding: 2px; margin-bottom: 0; font-size: 0.7rem; "
										href="writer?command=writerView&writerNo=${writerList.writerNo}">상세보기</a>

								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<c:if test="${empty writerList}">
				<div style="text-align: center; padding-bottom: 50px;">
					<h4 style="text-align: center">내역이 없습니다.</h4>
				</div>
			</c:if>

			<c:if test="${LoginUser.authority ne null}">
				<div align="right">
					<a class="btn btn-success"
						href="writer?command=adminWriterRegisterFormAction">등록</a>
				</div>
			</c:if>

		</div>
	</section>


	<%-- <!-- 페이징 처리 -->
	<section class="pt-0">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<nav>
						<ul class="pagination justify-content-center">
							<c:if test="${paging.pageNum > 1}">
								<li class="page-item"><a class="page-link"
									href="writer?command=writerList&pageNum=${paging.pageNum - 1}">Prev</a></li>


							</c:if>
							<c:forEach begin="${paging.firstPage}" end="${paging.lastPage}"
								var="idx">

								<c:choose>
									<c:when test="${idx == paging.pageNum}">
										<li class="page-item active"><span
											class="page-link bg-grad">${idx}</span></li>
									</c:when>

									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="writer?command=writerList&pageNum=${idx}">${idx}</a></li>
									</c:otherwise>

								</c:choose>
							</c:forEach>

							<c:if test="${paging.numOfPage != paging.pageNum}">
								<li class="page-item"><a class="page-link"
									href="writer?command=writerList&pageNum=${paging.pageNum + 1}">Next</a></li>
							</c:if>


						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section> --%>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>