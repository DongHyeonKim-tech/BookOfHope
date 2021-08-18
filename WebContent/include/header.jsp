<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap"
	rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>

<script type="text/javascript" src="js/logout.js"></script>
<body>
	<!-- =======================
   header Start-->
	<header class="header-static navbar-sticky navbar-light">
		<!-- Search -->
		<div class="top-search collapse bg-light" id="search-open"
			data-parent="#search">
			<div class="container">
				<div class="row position-relative">
					<div class="col-md-8 mx-auto py-5">
						<form>
							<div class="input-group">
								<input class="form-control border-radius-right-0 border-right-0"
									type="text" name="search" autofocus
									placeholder="What are you looking for?">
								<button type="button"
									class="btn btn-grad border-radius-left-0 mb-0">Search</button>
							</div>
						</form>
						<p class="small mt-2 mb-0">
							<strong>e.g.</strong>희망의 책 대전본부 홈페이지
						</p>
					</div>
					<a class="position-absolute top-0 right-0 mt-3 mr-3"
						data-toggle="collapse" href="#search-open"><i
						class="fa fa-window-close"></i></a>
				</div>
			</div>
		</div>
		<!-- End Search -->

		<!-- Navbar top start-->
		<div class="navbar-top d-none d-lg-block">
			<div class="container">
				<div class="d-flex justify-content-between align-items-center">
					<!-- navbar top Left-->
					<div class="d-flex align-items-center">

						<!-- Top info -->
						<ul class="nav list-unstyled ml-3">
							<li class="nav-item mr-3"><a class="navbar-link" href="#"><strong>전화:</strong>
									(042) 488-6589</a></li>
							<li class="nav-item mr-3"><a class="navbar-link" href="#"><strong>이메일:</strong>
									djbook111@gmail.com</a></li>
						</ul>
					</div>

					<!-- navbar top Right-->
					<div class="d-flex align-items-center" id="navbar">
						<c:if
							test="${LoginUser.authority eq 1 or LoginUser.authority eq 2 or LoginUser.authority eq 3}">
							<span class="loginfo"> <span class="dept_of_top"></span> <b>${LoginUser.memName}</b>님
								반갑습니다.&emsp;&emsp;
							</span>
						</c:if>
						<!-- Top Account -->
						<div class="dropdown">
							<c:if
								test="${LoginUser.authority eq 1 or LoginUser.authority eq 2}">
								<a class="dropdown-toggle" href="" role="button"
									id="dropdownAccount" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"><i
									class="ti-user mr-2"></i>내정보 </a>
								<div class="dropdown-menu mt-2 shadow"
									aria-labelledby="dropdownAccount">
									<a class="dropdown-item"
										href="/member?command=mypageAction&memId=${LoginUser.memId }">내
										정보</a>
										
									<a class="dropdown-item" href="#" onclick="logout();">로그아웃</a>
								</div>
							</c:if>

							<c:if test="${LoginUser.authority eq 3}">
								<a class="dropdown-toggle" href="#" role="button"
									id="dropdownAccount" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"><i
									class="ti-user mr-2"></i>내정보 </a>
								<div class="dropdown-menu mt-2 shadow"
									aria-labelledby="dropdownAccount">
									<a class="dropdown-item"
										href="/member?command=mypageAction&memId=${LoginUser.memId }">내
										정보</a> 
										
									<a class="dropdown-item" href="#" onclick="logout();">로그아웃</a>
								</div>
							</c:if>
						</div>

						<div class="dropdown">
							<c:if test="${LoginUser.authority eq null}">
								<a class="nav-link" href="login.jsp">로그인</a>
							</c:if>
						</div>

						<!-- top link -->
						<ul class="nav">
							<li class="nav-item">
								<%-- <c:if test="${LoginUser.authority eq '1' or LoginUser.authority eq '2'}">
									<a class="nav-link" href="#" onclick="logout();">로그아웃</a>
								</c:if>  --%>
								<c:if test="${LoginUser.authority eq 3}">
									<a class="nav-link" href="admin?command=adminMemberListAction">관리자 화면</a>
								</c:if></li>
						</ul>
						<!-- top social -->
						<ul class="social-icons">
							<li class="social-icons-item social-facebook m-0"><a
								class="social-icons-link w-auto px-2"
								href="https://facebook.com/groups/433359417472308?group_view_referrer=profile_browser">
									<i class="fab fa-facebook-square"></i>
							</a></li>

						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- Navbar top End-->

		<!-- Logo Nav Start -->
		<nav class="navbar navbar-expand-lg">
			<div class="container">
				<!-- Logo -->
				<a class="navbar-brand" href="main?command=loginForm"> <!-- SVG Logo Start -->
					<img src="https://i.ibb.co/9473b6T/image.jpg" width="170"
					height="150" alt="희망의 책 로고" />
				</a>
				<!-- Menu opener button -->
				<button class="navbar-toggler ml-auto" type="button"
					data-toggle="collapse" data-target="#navbarCollapse"
					aria-controls="navbarCollapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"> </span>
				</button>
				<!-- Main Menu Start -->
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav ml-auto">

						<!-- Menu item 1 Pages-->
						<c:if test="${LoginUser.authority eq null}">
							<li class="nav-item dropdown"><a class="nav-link"
								href="/login.jsp" id="pagesMenu" aria-haspopup="true"
								aria-expanded="false">로그인</a> <!-- <ul class="dropdown-menu" aria-labelledby="pagesMenu"> -->
							</li>
						</c:if>

						<c:if test="${LoginUser.authority ne null}">
							<li class="nav-item dropdown"><a class="nav-link"
								href="/member?command=logout" id="pagesMenu"
								aria-haspopup="true" aria-expanded="false" onclick="logout();">로그아웃</a>
								<!-- <ul class="dropdown-menu" aria-labelledby="pagesMenu"> -->
							</li>

						</c:if>
						<!-- Menu item 1 Pages-->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="blogMenu"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">희망의
								책 알아보기</a>

							<ul class="dropdown-menu" aria-labelledby="blogMenu">

								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=introAction">인사말</a></li>

								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=timeLineAction">연혁</a></li>

								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=teamAction">조직도</a></li>


								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=mapAction">찾아오시는 길</a></li>


								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=noticeListFormAction">운영게시판</a></li>

							</ul> <!-- 조직도 -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="blogMenu"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">독서진흥사업</a>
							<ul class="dropdown-menu" aria-labelledby="blogMenu">


								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/readBook?command=readBookList">우리대전 같은 책읽기</a></li>

								<!-- 								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/program?command=programListFormAction">책잔치 한마당</a></li> -->

								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/bookTalk?command=bookTalkListFormAction">얼토당토 북토크</a></li>

								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/event?command=eventList">북 포럼</a></li>

								<!--관리자로 로그인을 했을 시 이달의 책 등록-->
								<c:if test="${LoginUser.authority eq 3}">
									<li class="dropdown-submenu"><a class="dropdown-item"
										href="/book?command=adminTodayBookList" id="portfolioMenu"
										aria-haspopup="true" aria-expanded="false">이달의 책</a></li>
								</c:if>
								<!-- 사용자로 로그인을 했을 시 이달의 책 등록-->
								<c:if test="${LoginUser.authority ne 3}">
									<li class="dropdown-submenu"><a class="dropdown-item"
										href="/book?command=todayBookList" id="portfolioMenu"
										aria-haspopup="true" aria-expanded="false">이달의 책</a></li>
								</c:if>
							</ul></li>


						<!-- Menu item 2 Blog-->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="blogMenu"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">독서
								생태계</a>
							<ul class="dropdown-menu" aria-labelledby="blogMenu">


								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/report?command=Report_List">독후감 나누기</a>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/writer?command=writerList" aria-expanded="false">대전의
										작가들</a></li>


								<!-- 관리자로 로그인을 했을 시 동네책방-->
								<c:if test="${LoginUser.authority eq 3}">
									<li class="dropdown-submenu"><a class="dropdown-item"
										href="/bookstore?command=adminBookstoreList">동네책방</a></li>
								</c:if>

								<!-- 사용자로 로그인을 했을 시 동네책방-->
								<c:if test="${LoginUser.authority ne 3}">
									<li class="dropdown-submenu"><a class="dropdown-item"
										href="/bookstore?command=bookstoreList">동네책방</a></li>
								</c:if>


								<c:if test="${LoginUser.authority eq 3}">
									<li class="dropdown-submenu"><a class="dropdown-item"
										href="/library?command=adminLibraryList">도서관</a></li>
								</c:if>
								<c:if test="${LoginUser.authority ne 3}">
									<li class="dropdown-submenu"><a class="dropdown-item"
										href="/library?command=libraryList">도서관</a></li>
								</c:if>

								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/meeting?command=meetingList">독서모임</a></li>

								<c:if test="${LoginUser.authority ne null}">
									<li class="dropdown-submenu"><a class="dropdown-item"
										href="/book?command=bookList">책 등록 </a></li>
								</c:if>





							</ul></li>
						<!-- Menu item 5 Blog-->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="blogMenu"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">후원하기</a>
							<ul class="dropdown-menu" aria-labelledby="blogMenu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=introBusinessFormAction">사업소개</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=donationListFormAction">개인후원</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="/notice?command=yearEndTaxFormAction">연말정산 영수증 신청</a></li>
							</ul></li>


					</ul>
				</div>
				<!-- Main Menu End -->
				<!-- Header Extras Start-->
				<!-- Header Extras End-->
			</div>
		</nav>
		<!-- Logo Nav End -->
	</header>
	<!-- =======================
   header End-->
</body>
</html>