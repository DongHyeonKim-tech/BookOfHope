<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!Doctype html>

<!-- 각 독서모임 별 메인홈 -->
<!-- portfolio-single.html Form -->
<html lang="en">
<head>
<title>독서모임 게시판</title>
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
	href="../assets/vendor/fancybox/css/jquery.fancybox.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />

<style type="text/css">
table {
	align: center;
}
</style>

<script type="text/javascript">
	function joinPopup() {

		var popUrl = "/meeting?command=joinMemberPopup&metNum=${meetingVo.metNum}";
		var popOption = "width=550px, height=500px, resizable=no, location=no, top=300px, left=300px;"

		window.open(popUrl, "모임 가입신청 ", popOption);
	}
</script>

<script type="text/javascript">
	function memberPopup() {
		var width = "500";
		var height = "600";
		var top = (window.screen.height - height) / 2;
		var left = (window.screen.width - width) / 2;
		var popUrl = "/meeting?command=memberPopup&metNum=${meetingVo.metNum}";
		var popOption = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width="
				+ width + ",height=" + height + ",top=" + top + ",left=" + left;

		window.open(popUrl, "모임 회원리스트 ", popOption);
	}
</script>



</head>

<body>
	<!-- header 삽입 -->
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	<div class="preloader">
		<img src="../assets/images/preloader.svg" alt="Pre-loader">
	</div>


	<!-- =======================
   Banner innerpage -->

	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a
								href="/main?command=loginForm"><i class="ti-home"></i>Home&nbsp;&nbsp;&nbsp;</a>
								<a
								href="/meeting?command=manageHomeAction&metNum=${meetingVo.metNum }">
									<c:if test="${LoginUser.memNum eq meetingVo.memNum or LoginUser.authority eq 3 }">
										<i class="ti-settings">모임관리</i>
									</c:if>
							</a></li>


							<c:if test="${LoginUser.authority ne null}">
							<c:set var="doneLoop" value="false" />
							<c:forEach items="${LoginUserList}" var="vo" varStatus="status">
								
								<c:if test="${not doneLoop}">
									<c:if test="${vo.metNum eq meetingVo.metNum}">
										<c:set var="doneLoop" value="true" />
									</c:if>
								</c:if>
								
							</c:forEach>

							<c:if test="${doneLoop}">
							
							<li> 
							</li>
								
							</c:if>
							
							<c:if test="${not doneLoop && LoginUser.memName ne meetingVo.represent}">

								<li><a class="btn btn-grad mt-4" onclick="joinPopup()">모임
										가입 
								</a></li>
							</c:if>
							</c:if>
							

							<%-- <c:if test="${LoginUser.memName eq meetingVo.represent}">
                    		 <a class="btn btn-grad mt-4" onclick="memberPopup()">
                       			 회원리스트
                     			<i class="fa fa-external-link ml-2 mr-0"></i></a>
                     		</c:if> --%>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
   Banner innerpage -->

	<!-- =======================
   portfolio -->
	<div class="container">
		<div class="row mb-4">


			<input type="hidden" name="metNum" value="${meetingVo.metNum}">
		
			<input type="hidden" name="metbrd" value="${metbrd.metBrdNum}">


			<div class="container" style="margin-top: 3%;">
				<div
					class="bg-white border-radius-3 py-5 all-text-dark pattern-overlay-2">
					<div class="row">
						<!-- item1 -->
						<div class="col-md-3 col-6">
							<div class="counter-item text-center">
								<i class="ti-face-smile"></i>
								<h3>${meetingVo.represent}</h3>
								<p class="counter-item-text">대표자</p>
							</div>
						</div>
						<!-- item2 -->
						<div class="col-md-3 col-6">
							<div class="counter-item text-center">
								<i class="ti-alarm-clock"></i>
								<h3>${meetingVo.metDate}</h3>
								<p class="counter-item-text">개설일자</p>
							</div>
						</div>
						<!-- item3 -->
						<div class="col-md-3 col-6">
							<div class="counter-item text-center">
								<i class="ti-user"></i>
								<h3 class="counter-item-digit" data-from="0"
									data-to="${meetingVo.headCount}" data-speed="3000"
									data-refresh-interval="10">${meetingVo.headCount}명</h3>
								<p class="counter-item-text">회원수</p>
							</div>
						</div>
						<!-- item4 -->
						<div class="col-md-3 col-6">
							<div class="counter-item text-center">
								<i class="ti-user"></i>
								<h3>${meetingVo.location}</h3>
								<p class="counter-item-text">${meetingVo.metPlace}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 활동사진 밑 코멘트 -->
		<div style="margin-top: 10%;">
			<span style="font-size: 25px;">독서모임 소개</span>
		</div>
		<section class="bg-light triangle-down py-5">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-8 text-center">
						<h5>${meetingVo.metIntro}</h5>
					</div>
				</div>
			</div>
		</section>

		<!-- 대표자 인사말 -->
		<div class="col-md-11 text-center" style="margin-top: 5%;">
			<blockquote class="blockquote">
				<h5 class="mb-2 text-light-gray">${meetingVo.metGreeting}</h5>
				<cite>- ${meetingVo.represent}</cite>
			</blockquote>
		</div>

		<div class="table-responsive-sm">
			<table class="table table-hover">
				<!-- 공지사항 링크연결 -->

				<div>
					<span style="font-size: 25px;">공지사항 </span>
					
					
				<c:if test="${LoginUser.memNum eq meetingVo.memNum }">
								<a href="/meeting?command=metBoardListFormAction&metNum=${meetingVo.metNum}">게시글
								더보기 
								</a>
					</c:if>  
					
					
					
						<c:if test="${LoginUser.authority ne null}">
							<c:set var="doneLoop" value="false" />
							
							
							<c:forEach items="${LoginUserList}" var="vo" varStatus="status">
							
								<c:if test="${not doneLoop}">
									<c:if test="${vo.metNum eq meetingVo.metNum}">
										<c:set var="doneLoop" value="true" />
									</c:if>
								</c:if>
								
							</c:forEach>

							<c:if test="${doneLoop}">
							
							<%-- <span style="font-size: 15px;">
							
							<a href="/meeting?command=metBoardListFormAction&metNum=${meetingVo.metNum}">게시글
								더보기 
							</a>
							</span> --%>
								
							</c:if>
							
						<%-- 	<c:if test="${not doneLoop}">

							</c:if> --%>
						</c:if>	
						
						
<%-- 						<span style="font-size: 15px;"><a
							href="/meeting?command=metBoardListFormAction&metNum=${meetingVo.metNum}">게시글
								더보기 <i class="fa fa-external-link ml-2 mr-0"></i>
						</a></span> --%>

				</div>

				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">분류</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">날짜</th>
					</tr>
				</thead>

				<tbody>
					<c:if test="${empty metboardList}">
						<tr>
							<th colspan="5" style="text-align: center; color: gray;">게시글이
								없습니다.</th>
						</tr>
					</c:if>
					<c:forEach var="metbrd" items="${metboardList}" varStatus="var">

						<c:if test="${not empty metboardList}">

							<tr>
								<th scope="row">${var.count}</th>
								<th>${metbrd.metBrdCategory}</th>
								<th>${metbrd.metBrdName}</th>
								<th>${metbrd.memName}</th>
								<td><fmt:formatDate value="${metbrd.regDate}" /></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>

			</table>
		</div>

	</div>


	<%-- <div class="row mt-4">
			<!-- portfolio Greeting -->
			<div class="col-md-6">
				<h4 class="mb-4"><b>${meetingVo.metName}의 인사말</b></h4>
				<blockquote class="blockquote" cite="#">
					<h5 class="mb-2 text-light-gray">${meetingVo.metGreeting}</h5>
					<cite>- ${meetingVo.represent}</cite>
				</blockquote>
			</div>
		<!-- 독서모임 소개 -->
			<div class="col-md-6">
				<h4 class="mb-4"><b>우리 독서모임은</b></h4>
				<h5 class="mb-2 text-light-gray">${meetingVo.metIntro}</h5>
			</div>
		</div> --%>
	</div>

	<div class="row" style="margin-top: 10%;">
		<div class="col-md-12">
			<!-- tag and share -->
			<div class="divider mb-4"></div>

			<%-- <!-- tag check-box 불러오기 -->
				<div class="row">
					<div class="tags col-12 col-sm-8 text-center text-sm-left">
					<a class="mb-2 mb-sm-0">${meetingVo.keyword}</a>
					</div>
				</div> --%>

			<!-- <div class="divider mt-12"></div> -->
			<!-- navigation -->
			<div class="row post-navigation mt-5"></div>
		</div>
	</div>

	<!-- <script type="text/javascript">
			function joinPopup() {

			var popUrl = "/meeting?command=joinMemberPopup&metNum=${meetingVo.metNum}";
			var popOption = "width=650px, height=550px, resizable=no, location=no, top=300px, left=300px;"

			window.open(popUrl, "모임 가입신청 ", popOption);
			}
		</script> -->



	<%@ include file="../include/footer.jsp"%>

</body>
</html>