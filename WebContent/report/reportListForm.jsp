<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>희망의책 도서관</title>
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
					<h1 class="innerpage-title">독후감</h1>
					<h6 class="subtitle">책은 마음의 양식입니다. 책에서 소중한 인연을 만나보세요.</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/main?command=loginForm"><i
									class="ti-home"></i> Home</a></li>

						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<section class="portfolio pb-0">
		<div class="container">
			<div class="row">

				<div class="col-sm-12 mb-5">
					<!-- <div class="nav justify-content-center">
						<ul
							class="nav-tabs nav-tabs-style-2 text-center px-2 p-md-0 m-0 mb-4">
							<li class="nav-filter active" data-filter="*">모두보기</li>
							<li class="nav-filter" data-filter=".문학">문학</li>
							<li class="nav-filter" data-filter=".경제">경제</li>
							<li class="nav-filter" data-filter=".자연과학">자연과학</li>
							<li class="nav-filter" data-filter=".인문사회">인문사회</li>
						</ul>
					</div> -->

					<!-- 검색 폼 스타트 -->
					
		 

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
								<c:forEach var="reportList" items="${reportList}" varStatus="status" >
									<tr>
										<th scope = "row">${(paging.numOfRow - status.index) -  (paging.pageNum-1) * 10 }</th>
										<th>${reportList.reportCategory}</th>
										<td><a
											href="/report?command=Report_Detail&reportNum=${reportList.reportNum}">${reportList.reportTitle }</a></td>
										<td>${reportList.memName}</td>
										<td><fmt:formatDate value="${reportList.reportDate}" /></td>
										<td>${reportList.reportCount}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<c:if
							test="${LoginUser.authority eq '1' or LoginUser.authority eq '2' or LoginUser.authority eq '3'}">
							<div align="right">
								<a class="btn btn-grad border-radius-left-0 mb-0"
									href="/report?command=Report_Reg_Form">글쓰기</a>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
	
		function openPopUp() {
			// window.name = "부모창 이름"; 
			window.name = "parentForm";
			// window.open("open할 window", "자식창 이름", "팝업창 옵션");
			var width = "650";
			var height = "300";
			var top = (window.screen.height - height) / 2;
			var left = (window.screen.width - width) / 2;
			var url = "../book/bookSearch.jsp";
			var title = "책";
			var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width="
					+ width
					+ ",height="
					+ height
					+ ",top="
					+ top
					+ ",left="
					+ left;

			window.open(url, title, status);
		}
	</script>

	<!-- 페이징 처리 -->
	<section class="pt-0">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<nav>
					<c:if test="${!empty reportList}">
						<ul class="pagination justify-content-center">
							<c:if test="${paging.pageNum > 1}">
								<li class="page-item"><a class="page-link"
									href="report?command=Report_List&pageNum=${paging.pageNum - 1}">Prev</a></li>


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
											href="report?command=Report_List&pageNum=${idx}">${idx}</a></li>
									</c:otherwise>

								</c:choose>
							</c:forEach>

							<c:if test="${paging.numOfPage != paging.pageNum}">
								<li class="page-item"><a class="page-link"
									href="report?command=Report_List&pageNum=${paging.pageNum + 1}">Next</a></li>
							</c:if>


						</ul>
						</c:if>
						<c:if test="${empty reportList}">
						</c:if>
					</nav>
				
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>