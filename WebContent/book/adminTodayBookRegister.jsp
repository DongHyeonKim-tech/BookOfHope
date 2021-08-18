<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>이달의 책</title>
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
<script type="text/javascript" src="/js/todayBook.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<style>
h4 {
	font-weight: bold;
}

label {
	color: black;
}

.wrap {
	position: relative;
}

.wrap span {
	position: absolute;
	bottom: 5px;
	right: 5px;
	color: black;
}

#counter {
	background: rgba(255, 0, 0, 0.5);
	border-radius: 0.5em;
	padding: 0 .5em 0 .5em;
	font-size: 0.75em;
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
					<h1 class="innerpage-title">이달의 책</h1>
					<h6 class="subtitle">희망의 책에서 추천하는 이달의 책입니다.</h6>
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
				<div class="col-md-12">
					<h4 class="text-center mb-4">이달의 책 등록</h4>

					<form name="frm" method="post"
						action="book?command=adminTodayBookRegister"
						enctype="multipart/form-data">

						<!-- bookNum을 히든으로 처리를 하지 않으면 검색에서 값을 가져오지 못함. -->
						<input type="hidden" name="bookNum" id="bookNum">
						<input type ="hidden" name = "memNum" value="${LoginUser.memNum}">

						<div class="form-group">
							<!-- <label>책 제목 찾기</label> -->
							<div class="row">
								<div class="col-md-4 col-xs-4">
									<!-- id="keyword" -->
									<button type="button" class="form-control col-md-6"
										name="selectBook" id="selectBook" onclick="openPopUp()">책
										선택</button>
								</div>

							</div>
						</div>

						<div class="form-group">
							<label>책제목<span style="color: red;">*</span></label> <input
								class="form-control" type="text" name="bookTitle" id="bookTitle"
								placeholder="책제목">
						</div>

						<div class="form-group">
							<label>저자<span style="color: red;">*</span></label> <input
								class="form-control" type="text" name="writer" id="writer"
								placeholder="저자">
						</div>
						<div class="form-group">
							<label>출판사<span style="color: red;">*</span></label> <input
								class="form-control" type="text" name="publisher" id="publisher"
								placeholder="출판사">
						</div>
						<div class="form-group">
							<label>이달의 책 제목<span style="color: red;">*</span></label> <input
								class="form-control" type="text" name="bookBrdTitle"
								id="bookBrdTitle" placeholder="이달의 책 제목을 입력하세요.">
						</div>


						<div class="form-group">
							<label>내용<span style="color: red;">*</span></label>
							<div class="wrap">
								<textarea class="form-control" rows="10" name="bookBrdContent"
									id="bookBrdContent" placeholder="내용을 입력하세요. 글자수는 3000자로 제한됩니다."></textarea>
								<span id="counter">###</span>
							</div>
						</div>

						<!-- 업로드 시작-->

						<div class="form-group">
							<input type="file" class="form-control-file" name="imgPath">

						</div>
						<!--업로드 끝  -->
						<div align="right">

							<input type="submit" class="btn btn-grad"
								onclick="return todayBookCheck()" value="등록">
							<button type="button" class="btn btn-grad"
								onclick="location.href='book?command=adminTodayBookList'">
								취소</button>
						</div>


					</form>

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
			var height = "600";
			var top = (window.screen.height - height) / 2;
			var left = (window.screen.width - width) / 2;
			var url = "book?command=bookPopup";
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
		$(document).ready(function() {
			$('form').submit(function() {
				var result = alert("등록되었습니다.");

				return result;
			})
		})

		$(document).ready(function() {

			$('#bookBrdContent').on('keyup', function() {

				if ($(this).val().length > 3000) {

					$(this).val($(this).val().substring(0, 3000));

				}

			});

		});

		$(function() {
			$('#bookBrdContent').keyup(function(e) {
				var content = $(this).val();

				$('#counter').html(content.length + '/3000');
			});
			$('#content').keyup();
		});
	</script>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>