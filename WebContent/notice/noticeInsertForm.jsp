<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>희망의 책 운영 게시판</title>
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

<script type="text/javascript" src="/js/notice.js"></script>

</head>
<style>
span {
	color: black;
}

label {
	color: black;
}

h4 {
	font-weight: bold;
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
	padding: 0.5em 0.5em;
	font-size: 0.75em;
}
</style>

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
					<h1 class="innerpage-title">운영 게시판</h1>
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
	<!-- =======================
	Banner innerpage -->

	<!-- =======================
	공지사항 글쓰기 폼 시작 -->
	<section>
		<div class="container">
			<form name="frm" action="/notice?command=noticeInsertAction"
				method="post" onsubmit="return validateGalBoard()"
				enctype="multipart/form-data">
				<input type="hidden" name="memNum" value="${LoginUser.memNum}">

				<div class="row" style="justify-content: center;">
					<div class="col-lg-12">
						<h4 class="text-center mb-4">운영 게시판 등록</h4>
						<br>
						<div class="row">
							<div class="form-group col-md-3">
								<select class="custom-select select-big mb-3"
									name="noticeCategory">
									<option value="공지">공지</option>
									<option value="일반">일반</option>
									<option value="행사 및 세미나">행사 및 세미나</option>
									<option value="자료">자료</option>
								</select>
							</div>
							<div class="form-group col-md-9">
								<span class="form-group"><input type="text"
									class="form-control" placeholder="제목을 입력하세요."
									name="noticeTitle"></span>
							</div>
						</div>

						<div class="row">

							<div class="form-group col-md-12">
								<span class="form-group"></span>
								<div class="wrap">
									<textarea cols="40" rows="20" name="noticeContent"
										id="noticeContent" class="form-control"
										placeholder="내용을 입력하세요. 글자수는 3000자로 제한됩니다."></textarea>
									<span id="counter">###</span>
								</div>
							</div>

							<input type="file" name="noticeFile" class="form-control-file"
								id="exampleFormControlFile1">
						</div>
					</div>

				</div>
				<div align="right">
					<input type="submit" class="btn btn-grad"
						onclick="return noticeCheck()" value="등록">
					<button type="button" value="취소 " class="btn btn-grad"
						onclick="location.href='/notice?command=noticeListFormAction'">
						취소</button>
				</div>
			</form>
		</div>
	</section>
	<!-- =======================
	공지사항 글쓰기 폼 끝 -->



	<%@ include file="../include/footer.jsp"%>
</body>
<script>
	$(document).ready(function() {
		$('form').submit(function() {
			var result = alert("등록되었습니다.");

			return result;
		})
	});

	$(document).ready(function() {

		$('#noticeContent').on('keyup', function() {

			if ($(this).val().length > 3000) {

				$(this).val($(this).val().substring(0, 3000));

			}

		});

	});

	$(function() {
		$('#noticeContent').keyup(function(e) {
			var content = $(this).val();

			$('#counter').html(content.length + '/3000');
		});
		$('#content').keyup();
	});
</script>
</html>