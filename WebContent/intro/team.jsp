<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>희망의 책 소개</title>
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
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />
</head>
<body>

	<header>
		<%@ include file="../include/header.jsp"%>
	</header>

	<!-- ======================	Banner innerpage -->
	<div class="left bg-grad pattern-overlay-4">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1
						class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n2 mt-9">조직도</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- ======================= Banner innerpage -->

	<!-- ======================= blog -->
	<section class="team social-hover team-overlay">
		<div class="container">
			<div class="row">
				<!-- sidebar start -->
				<aside class="col-md-3 sidebar order-last order-md-first">
					<!-- 인사말 -->
					<div class="widget">
						<h3 class="widget-title">
							<a href="/notice?command=introAction">인사말</a>
						</h3>
					</div>

					<!-- 연혁 -->
					<div class="widget widget-newsletter">
						<h3 class="widget-title">
							<a href="/notice?command=timeLineAction">연혁</a>
						</h3>
					</div>

					<!-- 조직도 -->
					<div class="widget widget-post">
						<h3 class="widget-title">조직도</h3>
					</div>

					<!-- 찾아오시는 길 -->
					<div class="widget widget-post">
						<h3 class="widget-title">
							<a href="/notice?command=mapAction">찾아오시는 길</a>
						</h3>
					</div>

					<c:if test="${LoginUser.authority ne null}">
						<div class="widget widget-post">
							<h3 class="widget-title">
								<a href="/notice?command=noticeListFormAction">운영게시판</a>
							</h3>
						</div>
					</c:if>

				</aside>
				<!-- sidebar end -->



				<!-- blog start -->
				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/강신철교수님.jpg" alt="">
						</div>
						<div class="team-desc">
							<h5 class="team-name">강신철</h5>
							<span class="team-position">이사장</span>
							<p>한남대학교 글로벌IT경영학과 교수</p>
							<!-- <ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class=" fa fa-facebook-square "></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul>  -->
						</div>
					</div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/최은경대표님.jpg" alt="채은경">
						</div>
						<div class="team-desc">
							<h5 class="team-name">채은경</h5>
							<span class="team-position">감사</span>
							<p>(주)유클리드 대표</p>
							<!-- <ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul> -->
						</div>
					</div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/김기수.jpg" alt="">
						</div>
						<div class="team-desc">
							<h5 class="team-name">김기수</h5>
							<span class="team-position">이사</span>
							<p>독서클럽 대표</p>
							<!-- <ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul> -->
						</div>
					</div>
				</div>





				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<!-- <div class="team-avatar">
										<img src="https://i.ibb.co/TPPVQVW/image.png" alt="">
									</div>
									<div class="team-desc">
										<h5 class="team-name">Allen Smith</h5>
										<span class="team-position">Founder</span>
										<p>I am temporibus voluptatem odio odit ratione perferendis explicabo!</p>
										<ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul>
									</div> -->
					</div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/박주한.jpg" alt="">
						</div>
						<div class="team-desc">
							<h5 class="team-name">박주한</h5>
							<span class="team-position">이사</span>
							<p>(주)유클리드 임원</p>
							<!-- <ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul> -->
						</div>
					</div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/우현종.jpg" alt="우현종">
						</div>
						<div class="team-desc">
							<h5 class="team-name">우현종</h5>
							<span class="team-position">이사</span>
							<p>(주)유클리드 임원</p>
							<!-- <ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul> -->
						</div>
					</div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/한빛찬.jpg" alt="한빛찬">
						</div>
						<div class="team-desc">
							<h5 class="team-name">한빛찬</h5>
							<span class="team-position">이사</span>
							<p>수학의 시선 (대표)</p>
							<!-- <ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul> -->
						</div>
					</div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<!-- <div class="team-avatar">
										<img src="https://i.ibb.co/TPPVQVW/image.png" alt="">
									</div>
									<div class="team-desc">
										<h5 class="team-name">Allen Smith</h5>
										<span class="team-position">Founder</span>
										<p>I am temporibus voluptatem odio odit ratione perferendis explicabo!</p>
										<ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul>
									</div> -->
					</div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/진창희.png" alt="진창희">
						</div>
						<div class="team-desc">
							<h5 class="team-name">진창희</h5>
							<span class="team-position">이사</span>
							<p>전 동화읽는어른모임 대전지회장</p>
							<p>전 노은인문학모임 대표</p>
							<!-- <ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul> -->
						</div>
					</div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/임효인.jpg" alt="임효인">
						</div>
						<div class="team-desc">
							<h5 class="team-name">임효인</h5>
							<span class="team-position">이사</span>
							<p>중도일보 기자</p>
							<!-- <ul class="social-icons si-colored-on-hover">
											<li class="social-icons-item social-facebook"><a class="social-icons-link" href="#"><i class="fa fa-facebook"></i></a></li>
											<li class="social-icons-item social-instagram"><a class="social-icons-link" href="#"><i class="fa fa-instagram"></i></a></li>
											<li class="social-icons-item social-twitter"><a class="social-icons-link" href="#"><i class="fa fa-twitter"></i></a></li>
										</ul> -->
						</div>
					</div>
				</div>

				<!-- 							<div class="col-9 col-sm-3 col-md-3">
								<div class="team-item text-center">
									<div class="team-avatar">
										<img src="../resources/images/introduce/진창희.png" alt="진창희">
									</div>
									<div class="team-desc">
										<h5 class="team-name">진창희</h5>
										<span class="team-position">이사</span>
										<p>전 동화읽는어른모임 대전지회장</p>
										<p>전 노은인문학모임 대표</p>

										
									</div>
								</div>
							</div> -->

				<!-- Post item  with image-->


				<!-- Post item  with image-->
				<!-- 							<div class="col-9 col-sm-3 col-md-3">
								<div class="team-item text-center">
									<div class="team-avatar">
										<img src="../resources/images/introduce/임효인.jpg" alt="임효인">
									</div>
									<div class="team-desc">
										<h5 class="team-name">임효인</h5>
										<span class="team-position">이사</span>
										<p>중도일보 기자</p>
										
									</div>
								</div>
							</div>
							 -->

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/박순필.png" alt="박순필">
						</div>
						<div class="team-desc">
							<h5 class="team-name">박순필</h5>
							<span class="team-position">이사</span>
							<p>우리대전같은책읽기 도서선정위원장</p>

						</div>
					</div>
				</div>
				<!-- blog End -->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center"></div>
				</div>

				<!-- Post item  with image-->
				<div class="col-9 col-sm-3 col-md-3">
					<div class="team-item text-center">
						<div class="team-avatar">
							<img src="../resources/images/introduce/이선배.jpg" alt="이선배 ">
						</div>
						<div class="team-desc">
							<h5 class="team-name">이선배</h5>
							<span class="team-position">이사</span>
							<p>
								koresa(독서교육연구회) 운영자 <br> [재명아! 기본소득이 뭐야? / 여우고개] 저자
							</p>

						</div>
					</div>
				</div>
				<!-- blog End -->


			</div>
		</div>
	</section>

	<footer>
		<%@ include file="../include/footer.jsp"%>
	</footer>

</body>
</html>