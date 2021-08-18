<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>

<!-- 독서모임 리스트 -->
<!-- portfolio-grid-column-4.html Form -->
<!-- 참고 index-6.html Form -->
<html>
<head>
	<title>독서모임리스트</title>
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
	
	<!-- List div CSS -->
	<style type="text/css">
	.portfolio-card-body {
	width: 295px;
	height: 313.59px;
	overflow: hidden;
	}
	
	body span {
	width: 270px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	display: inline-block;
	}
	</style>
	
	<!-- Form JavaScript -->
	<script type="text/javascript">
	function meetingApply() {
		
		var value = ${LoginUser.authority};
	
		if(value != null){
			location.href='meeting?command=meetingApplyFormAction';			
		}else{
			alert('로그인 후 이용가능합니다.');
		}	
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
	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">독서모임</h1>
					<h6 class="subtitle">함께 만드는 아름다운 소통과 교류의 장</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/main?command=loginForm"><i class="ti-home"></i>Home</a></li>
						<!-- 	<li class="breadcrumb-item">독서모임</li> -->
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->

	<!-- =======================
	Portfolio -->
	<section class="blog-page pb-0">
		<div class="container">
			<div class="row">
				<!-- =======================
	call to action-->
 	<section class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-9 text-center text-md-left align-self-center">
					<h4 class="m-0"><b>소통의 장, 독서모임 신청하기</b></h4>
				</div>
				<div class="col-md-3 text-center text-md-right mt-3 mt-md-0 align-self-center ">
					<button style=float:right class="btn btn-grad mb-0" type="submit" onclick="return meetingApply()" title="독서모임">독서모임 신청</button>
				</div>
			</div>
		</div>
	</section>
	<!-- =======================
	call to action-->
				<div class="col-md-12 blog-grid blog-grid-3 portfolio-wrap" data-isotope='{ "itemSelector": ".post-item", "layoutMode": "fitRows" }'>
<!-- 					<div class="nav justify-content-center">
						<ul class="nav-tabs nav-tabs-style-2 text-center px-2 p-md-0 m-0 mb-4">
							<li class="nav-filter active" data-filter="*">모든 모임</li>
							<li class="nav-filter" data-filter=".home">가정/육아</li>
							<li class="nav-filter" data-filter=".health">건강/뷰티</li>
							<li class="nav-filter" data-filter=".business">경제/경영</li>
							<li class="nav-filter" data-filter=".education">교육</li>
							<li class="nav-filter" data-filter=".literature">문학</li>
							<li class="nav-filter" data-filter=".social">사회과학</li>
							<li class="nav-filter" data-filter=".IT">IT/개발</li>
							<li class="nav-filter" data-filter=".leisure">여가생활</li>
							<li class="nav-filter" data-filter=".history">역사</li>
							<li class="nav-filter" data-filter=".art">예술/영화</li>
							<li class="nav-filter" data-filter=".foreign">외국어/외국문학</li>
							<li class="nav-filter" data-filter=".child">아동/청소년</li>
							<li class="nav-filter" data-filter=".humanity">인문학</li>
							<li class="nav-filter" data-filter=".selfimprove">자기계발</li>
							<li class="nav-filter" data-filter=".natural">자연/과학</li>
							<li class="nav-filter" data-filter=".computer">컴퓨터/인터넷</li>
						</ul>
					</div>
			 
					 
					<!-- portfolio-card -->
					<!-- <div class="portfolio-wrap grid items-3 items-padding"> -->
					
					
					<!-- 독서모임 신청하면 승인 후 자동생성 -->
					<input type="hidden" name="memNum" value="${LoginUser.memNum}">
					<c:forEach var="meetingList" items="${meetingList}" varStatus="status">
					
						<!-- portfolio-card -->
						<%--<div class="portfolio-card isotope-item ${meetingList.keyword}" style="position: absolute; left: 0px; top: 0px;">
							<div class="portfolio-card-body">
								<div class="portfolio-card-header">
								<!-- 이미지 -->
									 <a href="#"><img src="/displayFile?fileName=${meetingList.metImg}" alt=""></a>
									 
								</div>
 								<div class="portfolio-card-footer">
									<a class= "full screen" href="/displayFile?fileName=${meetingList.metImg}" data-fancybox="portfolio" data-caption="${meetingList.metName}"><i class="ti-fullscreen"></i></a>
									<div class="post-author">${meetingList.represent}, 
									<fmt:formatDate value="${meetingList.metDate}"/>, 
									회원수 : ${meetingList.headCount}
									</div>
									<div class="post-author">${meetingList.location}</div>
									<div><h6 class="info-title"><b><a href="/meeting?command=meetingHome&metNum=${meetingList.metNum}&memNum=${LoginUser.memNum}" title="독서모임">${meetingList.metName}</a></b></h6></div>
									<span>${meetingList.metIntro}</span>
								</div> --%>
								
						<div class="post-item ${meetingList.keyword}" style="position: absolute; left: 0px; top: 0px; ">
							<div class="post-item-wrap">
								<div class="post-image" style="">
								<!-- 이미지 -->
									 <a href="/meeting?command=meetingHome&metNum=${meetingList.metNum}&memNum=${LoginUser.memNum}"><img src="/displayFile?fileName=${meetingList.metImg}" alt=""></a>
									 
								</div>
 								<div class="post-item-desc">
 								<div><h4 class="info-title"><b><a href="/meeting?command=meetingHome&metNum=${meetingList.metNum}&memNum=${LoginUser.memNum}" title="독서모임">${meetingList.metName}</a></b></h4></div>
									<span class="post-meta">${meetingList.represent}</span> 
									<span class="post-meta"><fmt:formatDate value="${meetingList.metDate}"/></span>
									<span class="post-meta"> 회원수 : ${meetingList.headCount}</span>
									<span class="post-meta">${meetingList.location}</span>
									<p>${meetingList.metIntro}</p>
									</div>
								</div> 
								
							</div>
						</c:forEach>
						</div>
						
					</div>
				</div>
	</section>
	<!-- =======================
	Portfolio -->

	<!-- =======================
	call to action-->
<!--  	<section class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-9 text-center text-md-left align-self-center">
					<h4 class="m-0"><b>소통의 장, 독서모임 신청하기</b></h4>
				</div>
				<div class="col-md-3 text-center text-md-right mt-3 mt-md-0 align-self-center ">
					<button class="btn btn-grad mb-0" type="submit" onclick="return meetingApply()" title="독서모임">독서모임 신청</button>
				</div>
			</div>
		</div>
	</section> -->
	<!-- =======================
	call to action-->


	<!-- =======================
	footer  -->
	<%@ include file="../include/footer.jsp"%>
</body>
</html>