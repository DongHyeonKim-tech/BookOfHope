<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>희망의책 대전본부 내정보</title>
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
.container {
	width: 70%;
	height: 70%;
	margin: 10px auto;
}

.outer {
	display: table;
	width: 100%;
	height: 100%;
}

.inner {
	display: table-cell;
	vertical-align: middle;
	text-align: center;
}

.centered {
	position: relative;
	display: inline-block;
	width: 50%;
}
</style>
<body>
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>


	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">회원정보</h1>
					<h6 class="subtitle">수정버튼을 눌러서 회원정보를 수정할 수 있습니다.</h6>
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

	<section class="service">

		<form name="frm" method="post"
			action="/member?command=memberModifyForm">
			<input type="hidden" name="memId" value="${LoginUser.memId}">
			<input type="hidden" name="memNum" value="${LoginUser.memNum}">
			<c:if
				test="${LoginUser.authority eq 1 or LoginUser.authority eq 2 or LoginUser.authority eq 3}">
				<div class="col-md-12"></div>

				<div class="container">
					<div class="row">
						<div class="col-sm-12 text-center mt-5 mb-4"></div>

						<div class="divider">
							<i class="ti-check"></i>
						</div>
						<h5 class="mb-2 mt-5"></h5>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">아이디</h3>


								<p class="feature-box-desc">${memVo.memId}</p>
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">이름</h3>


								<p class="feature-box-desc">${memVo.memName}</p>
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">생년월일</h3>


								<p class="feature-box-desc">${memVo.jumin}</p>
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">주소</h3>


								<p class="feature-box-desc">${memVo.adr}<br>${mVo.adr2}</p>
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">연락처</h3>


								<p class="feature-box-desc">${memVo.phone}</p>
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">이메일</h3>


								<p class="feature-box-desc">${memVo.email}</p>
							</div>

						</div>

					</div>
				</div>
				<div class="outer">
					<div class="inner">
						<div class="centered">
							<button type="submit"
								class="btn btn-grad border-radius-left-0 mb-0">수정하기</button>
							<a
								href="member?command=memberPwModifyForm&memNum=${memVo.memNum}"><button
									type="button" class="btn btn-grad border-radius-left-0 mb-0">비밀번호
									변경</button></a>
						</div>
					</div>
				</div>
			</c:if>
		</form>

	</section>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>