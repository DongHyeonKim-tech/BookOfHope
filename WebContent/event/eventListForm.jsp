<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>북포럼</title>
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
<style>
h4 {
	font-weight: bold;
}

.selectbox {
	position: relative;
	width: 100px; /* 너비설정 */
	border: 1px solid #999; /* 테두리 설정 */
	z-index: 1;
}

.selectbox:before { /* 화살표 대체 */
	content: "";
	position: absolute;
	top: 50%;
	right: 15px;
	width: 0;
	height: 0;
	margin-top: -1px;
	border-left: 5px solid transparent;
	border-right: 5px solid transparent;
	border-top: 5px solid #333;
}

.selectbox label {
	position: absolute;
	top: 1px; /* 위치정렬 */
	left: 5px; /* 위치정렬 */
	padding: .8em .5em; /* select의 여백 크기 만큼 */
	color: #999;
	z-index: -1; /* IE8에서 label이 위치한 곳이 클릭되지 않는 것 해결 */
}

.selectbox select {
	width: 100%;
	height: auto; /* 높이 초기화 */
	line-height: normal; /* line-height 초기화 */
	font-family: inherit; /* 폰트 상속 */
	padding: .8em .5em; /* 여백과 높이 결정 */
	border: 0;
	opacity: 0; /* 숨기기 */
	filter: alpha(opacity = 0); /* IE8 숨기기 */
	-webkit-appearance: none; /* 네이티브 외형 감추기 */
	-moz-appearance: none;
	appearance: none;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		var selectTarget = $('.selectbox select');
		selectTarget.change(function() {
			var select_name = $(this).children('option:selected').text();
			$(this).siblings('label').text(select_name);
		});
	});
</script>

<!-- <style>
.style select {
 
width: 100px;
	height: 34px;
	padding-left: 5px;
	border: 1px solid 4cbd89;
	border-radius: 3px;
}
.green_window {
	display: inline-block;
	width: 200px;
	height: 34px;
	border: 3px solid #4cbd89;
	background: white;
}

.input_text {
	width: 180px;
	height: 24px;
	margin: 0;
	border: 0;
	line-height: 21px;
	outline: none;
}

.sch_smit {
	width: 54px;
	height: 35px;
	margin: 0;
	border: 0;
	vertical-align: top;
	background: #4cbd89;
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
}

.sch_smit:hover {
	background: #56C82C;
}

div#select_box {
	position: relative;
	width: 100px;
	height: 40px;
	background: url(select_arrow.png) 180px center no-repeat; /* 화살표 이미지 */
	border: 1px solid #E9DDDD;
}

div#select_box label {
	position: absolute;
	font-size: 14px;
	color: #a97228;
	top: 13px;
	left: 12px;
	letter-spacing: 1px;
}

div#select_box select#color {
	width: 100%;
	height: 40px;
	min-height: 40px;
	line-height: 40px;
	padding: 0 10px;
	opacity: 0;
	filter: alpha(opacity = 0); /* IE 8 */
}
</style>

 -->

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
					<h1 class="innerpage-title">북 포럼</h1>
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
					<!-- <h4 class="text-center mb-4">북 포럼 </h4> -->

					<!-- 검색 폼 스타트 -->
					<div class="row" id="searchForm">
						<form name="frm" action="/event?command=eventList" method="post"
							onsubmit="return validateGalBoard()">
							<div class="md-4" style="margin-left: 60px">
								<div class="row">
									<div class="md-1">
										<select class="btn btn-light btn-sm dropdown-toggle"
											name="opt" style="margin: 5px">
											<option value="0">행사 이름</option>
										</select>
									</div>
									<div class="md-2">
										<input class="form-control btn-sm" type="text"
											name="condition" style="margin: 5px" />&nbsp;&nbsp;
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
						<form name="frm" action="/event?command=eventList" method="post"
							onsubmit="return validateGalBoard()">
							<select name="opt">
								<option value="0">행사 이름</option>
							</select> <span class='green_window'> <input type="text"
								class='input_text' name="condition" /></span>
							<button type='submit' class='sch_smit'>검색</button>
						</form>
					</div>
					<!-- 검색 폼 마지막 -->

					<div class="table-responsive-sm">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">행사 이름</th>
									<th scope="col">행사 일자</th>
									<th scope="col">작성자</th>
									<th scope="col">조회수</th>


								</tr>
							</thead>

							<tbody>
								<!-- varStatus를 통해서 책번호를 만든다. -->
								<c:forEach var="eventList" items="${eventList}"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<th><a
											href="event?command=eventView&eventNo=${eventList.eventNo}">${eventList.eventName}</a></th>
										<td>${eventList.eventDate}</td>
										<td>관리자</td>
										<td>${eventList.eventCount}</td>

									</tr>
								</c:forEach>

							</tbody>

						</table>
						<c:if test="${LoginUser.authority eq 3}">
							<div align="right">

								<a class="btn btn-grad border-radius-left-0 mb-0"
									href="event?command=eventInsertForm">등록</a>

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
									href="/event?command=eventList&page=${startPage-1}">Prev</a></li>
							</c:if>

							<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
								<c:if test="${pageNum == spage}">
									<li class="page-item active"><span
										class="page-link bg-grad">${pageNum}&nbsp;</span></li>
								</c:if>
								<c:if test="${pageNum != spage}">
									<a class="page-link"
										href='/event?command=eventList&page=${pageNum}'>${pageNum}&nbsp;</a>
								</c:if>
							</c:forEach>

							<c:if test="${endPage != maxPage }">
								<li class="page-item"><a class="page-link"
									href="/event?command=eventList&page=${endPage+1 }">Next</a></li>
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