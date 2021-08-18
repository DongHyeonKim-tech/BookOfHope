<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>희망의 책 공지사항</title>
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
	<!-- =======================
	Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">운영 게시판</h1>
					<h6 class="subtitle">사람과의 만남이 중요하듯 또 다른 소중한 만남이 있습니다.</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a
								href="/main?command=loginForm"><i class="ti-home"></i> Home</a></li>

						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->
	<section class="portfolio pb-0">
		<div class="container">
			<div class="row">

				<div class="col-sm-12  p-0">

					<!-- 검색 폼 스타트 -->
					<div class="row" id="searchForm">
						<form name="frm" action="/notice?command=noticeListFormAction"
							method="post" onsubmit="return validateGalBoard()">
							<div class="md-4" style="margin-left: 60px">
								<div class="row">
									<div class="md-1">
										<select class="btn btn-light btn-sm dropdown-toggle"
											name="opt" style="margin: 5px">
											<option value="0">제목</option>
											<option value="1">분류</option>
											<option value="2">내용</option>
										</select>
									</div>
									<div class="md-2">
										<input class="form-control btn-sm" type="text" name="condition" style="margin: 5px"/>&nbsp;&nbsp;
									</div>
									<div class="md-1" style="margin-left: 10px" align="center">
										<input class="btn btn-light btn-sm" type="submit" value="검색" style="margin: 5px"/>
									</div>
								</div>
							</div>
						</form>
					</div>
					<!-- 검색 폼 마지막 -->

					<div class="table-responsive-sm">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">분류</th>
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">작성일</th>
									<th scope="col">조회수</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="notice" items="${noticeList}" varStatus="status">
									<tr>
										<td scope="row">${status.count}</td>
										<td>${notice.noticeCategory}</td>
										<td><a
											href="/notice?command=noticeViewAction&noticeNum=${notice.noticeNum}">${notice.noticeTitle }</a></td>
										<td>관리자</td>
										<td><fmt:formatDate value="${notice.noticeDate }" /></td>
										<td>${notice.noticeCount }</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						<c:if test="${LoginUser.authority eq 3}">
							<div align="right">
								<a class="btn btn-grad"
									href="/notice?command=noticeInsertFormAction">글쓰기</a>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- 페이징 처리 스타트-->
	<section class="pt-0">
		<div class="container">
			<div class="row justify-content-center">
				<div id="pageForm" class="col-md-8">
					<nav>
						<c:if test="${!empty noticeList}">
							<ul class="pagination justify-content-center">

								<c:if test="${startPage != 1}">
									<li class="page-item"><a class="page-link"
										href="/notice?command=noticeListFormAction&page=${startPage-1}">Prev</a></li>
								</c:if>

								<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
									<c:if test="${pageNum == spage}">
										<li class="page-item active"><span
											class="page-link bg-grad">${pageNum}&nbsp;</span></li>
									</c:if>
									<c:if test="${pageNum != spage}">
										<a class="page-link"
											href='/notice?command=noticeListFormAction&page=${pageNum}'>${pageNum}&nbsp;</a>
									</c:if>
								</c:forEach>

								<c:if test="${endPage != maxPage }">
									<li class="page-item"><a class="page-link"
										href="/notice?command=noticeListFormAction&page=${endPage+1 }">Next</a></li>
								</c:if>

							</ul>
						</c:if>
						<c:if test="${empty noticeList}">
						</c:if>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- 페이징 처리 마지막 -->



	<%@ include file="../include/footer.jsp"%>
</body>
</html>