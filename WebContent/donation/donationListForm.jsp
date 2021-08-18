<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후원하기</title>
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
	<div class="left bg-grad pattern-overlay-4">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1
						class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n2 mt-9">후원안내</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->

	<!-- =======================
	About us -->
	<section>
		<div class="container h-100">
			<div class="row">
				<div class="col-md-12 col-lg-6 align-self-center ">
					<div class="title text-left">
						<h2>
							희망의 책은 <span class="text-primary">법인세법</span>에 의거한 <span
								class="text-primary"><br>지정기부금단체</span>입니다.
						</h2>
						<div class="col-11" style="font-size: 14pt; margin-top: 8%">
							후원해주신 기부금은 <strong>법인은 소득 금액의 10%, 개인은 30% 범위 </strong> 내에서 <strong>손비인정
								또는 소득공제</strong>를 받을 수 있는 기부금 영수증을 발급해드립니다.
						</div>
						<div
							class="list-group-inline list-group-number list-unstyled mt-4">
							<a class="list-group-item list-group-item-action"><span>01</span>
								독서문화 사업 연구 지원</a> <a class="list-group-item list-group-item-action"><span>02</span>
								사람 네트워크의 형성 기회</a> <a class="list-group-item list-group-item-action"><span>03</span>
								전국 도서문화 확산과 생각 나눔</a> <a
								class="list-group-item list-group-item-action"><span>04</span>
								문화예술교육 프로그램 지원</a>
						</div>
					</div>
				</div>
				<div class="col-md-10 col-lg-6 mx-md-auto align-self-center ">
					<img class="rounded" src="https://i.ibb.co/2KCZwkB/Waysto-Give.jpg"
						alt="">
				</div>

			</div>
			<!-- row end -->

			<div class="col-md-12" align="center" style="margin-top: 50px">
				<a class="btn btn-dark"
					href="/notice?command=donationWriteFormAction"> <i
					class="fa fa-play text-white"></i>후원하기
				</a>
			</div>

		</div>
	</section>
	<!-- =======================
	About us -->

	<%@ include file="../include/footer.jsp"%>

</body>
</html>