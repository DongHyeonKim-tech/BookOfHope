<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>우리대전 같은 책읽기</title>
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
					<h1 class="innerpage-title">우리대전 같은 책읽기</h1>
					<h6 class="subtitle">희망의 책 대전본부</h6>
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
	<section>

		<div class="container">
			<div class="row">
				<div class="col-sm-12 mb-5">
					<!-- <h5 class="text-center mb-4">우리대전 같은 책읽기</h5> -->


					<!-- 검색 폼 스타트 -->
					<div class="row" id="searchForm">
						<form name="frm" action="/readBook?command=readBookList"
							method="post" onsubmit="return validateGalBoard()">
							<div class="md-4" style="margin-left: 60px">
								<div class="row">
									<div class="md-1">
										<select class="btn btn-light btn-sm dropdown-toggle"
											name="opt" style="margin: 5px">
											<option value="0" <c:if test="${opt==0}">selected</c:if>>선정도서</option>
											<option value="1" <c:if test="${opt==1}">selected</c:if>>저자</option>
										</select>
									</div>
									<div class="md-2">
										<input class="form-control btn-sm" type="text"
											name="condition" style="margin: 5px" value="${condition}"/>&nbsp;&nbsp;
									</div>
									<div class="md-1" style="margin-left: 10px" align="center">
										<input class="btn btn-light btn-sm" type="submit" value="검색"
											style="margin: 5px" />
									</div>
								</div>
							</div>
						</form>
					</div>
					<!-- 검색 폼 마지막 -->

					<!-- 검색 폼 스타트
					<div id="searchForm">
						<form name="frm" action="/readBook?command=readBookList"
							method="post" onsubmit="return validateGalBoard()">
							<select name="opt">
								<option value="0">선정도서</option>
								<option value="1">저자</option>
							</select> <input type="text" size="20" name="condition" />&nbsp; <input
								type="submit" value="검색" />
						</form>
					</div>
					검색 폼 마지막 -->
					<div class="table-responsive-sm">
						<table class="table table-hover">

							<thead>

								<tr>
									<th scope="col">번호</th>
									<th scope="col">선정도서</th>
									<th scope="col">저자</th>
									<th scope="col">출판사</th>
									<th scope="col">출판연도</th>
									<th scope="col">조회수</th>


								</tr>
							</thead>

							<tbody>
								<c:forEach var="readBookList" items="${readBookList}"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<th><a
											href="readBook?command=readBookView&readBookNo=${readBookList.readBookNo}">${readBookList.bookName}</a></th>
										<td>${readBookList.writer}</td>
										<td>${readBookList.publisher}</td>
										<td>${readBookList.publishDate}</td>
										<td>${readBookList.readBookCount}</td>
								</c:forEach>

							</tbody>

						</table>
						<c:if test="${LoginUser.authority eq 3}">
							<div align="right">

								<a class="btn btn-grad border-radius-left-0 mb-0"
									href="readBook?command=readBookInsertForm">등록</a>

							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- 페이징 처리 -->
	<section class="pt-0">
		<div class="container">
			<div class="row justify-content-center">

				<div id="pageForm" class="col-md-8">
					<nav>
						<ul class="pagination justify-content-center">

							<c:if test="${startPage != 1}">
								<li class="page-item"><a class="page-link"
									href="/readBook?command=readBookList&page=${startPage-1}">Prev</a></li>
							</c:if>

							<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
								<c:if test="${pageNum == spage}">
									<li class="page-item active"><span
										class="page-link bg-grad">${pageNum}&nbsp;</span></li>
								</c:if>
								<c:if test="${pageNum != spage}">
									<a class="page-link"
										href='/readBook?command=readBookList&page=${pageNum}'>${pageNum}&nbsp;</a>
								</c:if>
							</c:forEach>

							<c:if test="${endPage != maxPage }">
								<li class="page-item"><a class="page-link"
									href="/readBook?command=readBookList&page=${endPage+1 }">Next</a></li>
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