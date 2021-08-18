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

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />
</head>
<body>
	<header class="header-static navbar-sticky navbar-light">
		<%@ include file="../include/header.jsp"%>
	</header>
	
				<!-- =======================
			Banner innerpage -->
			<div class="left bg-grad pattern-overlay-4">
				<div class="container">
					<div class="row all-text-white">
						<div class="col-md-12 align-self-center">
							<h1 class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n2 mt-9">인사말</h1>
						</div>
					</div>
				</div>
			</div>
			<!-- =======================
			Banner innerpage -->
		
			<!-- ======================= blog -->
			<section class="blog-page pb-0">
				<div class="container">
					<div class="row">
						<!-- sidebar start -->
						<aside class="col-md-3 sidebar order-last order-md-first">
							<!-- 인사말 -->
							<div class="widget">
								<h3 class="widget-title">인사말</h3>
							</div>
		
							<!-- 연혁 -->
							<div class="widget widget-newsletter">
								<h3 class="widget-title"><a href="/notice?command=timeLineAction">연혁</a></h3>
							</div>
		
							<!-- 조직도 -->
							<div class="widget widget-post">
								<h3 class="widget-title"><a href="/notice?command=teamAction">조직도</a></h3>
							</div>
		
							<!-- 찾아오시는 길 -->
							<div class="widget widget-post">
								<h3 class="widget-title"><a href="/notice?command=mapAction">찾아오시는 길</a></h3>
							</div>
							
							<c:if test="${LoginUser.authority ne null}">
							<div class="widget widget-post">
								<h3 class="widget-title"><a  href="/notice?command=noticeListFormAction">운영게시판</a></h3>
							</div>
							</c:if>

						</aside>
						<!-- sidebar end -->
		
						<!-- blog start -->
						<div class="col-md-9 mb-6 order-first order-md-first">
							<!-- Post item  with image-->
							<div class="post-item">
								<div class="post-item-wrap">
									<div class="post-image">
										<a href="#"> <img src="../resources/images/intro.jpg" alt="" style="width: 1000px; height: 550px;"> </a>
									</div>
								</div>
							</div>
							<!-- blog End -->
						</div>
					</div>
				</div>
			</section>
	
	<footer>
		<%@ include file="../include/footer.jsp"%>
	</footer>
</body>
</html>