<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>비밀번호 변경</title>
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
<script type="text/javascript" src ="/js/pwModify.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>


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
					<h1 class="innerpage-title">비밀번호 변경</h1>
					
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

	<section class="service">

		<form name="frm" method="post" action="member?command=memberPwModify&memNum=${LoginUser.memNum}">
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

							<div class="feature-box f-style-3 h-100 icon-grad"
								style="align: center">

								<h5>변경할 비밀번호</h5>
								<input type="password" name="memPw" value="${memPw}">
								
								<h5>비밀번호 재확인</h5>
								<input type="password" name="memPwCheck">
								<button type="submit" class="btn btn-grad border-radius-left-0 mb-0" onclick="return pwModify();">비밀번호 변경</button>

							</div>
						</div>
					</div>
				</div>
			</c:if>
		</form>
	</section>
	<script>
	$(document).ready(function(){
		$('form').submit(function(){
	 	  var result = alert("비밀번호 변경이 완료됐습니다.");
	   
		   return result;
		})
		})
	</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>