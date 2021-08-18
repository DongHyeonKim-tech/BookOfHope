<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>우리대전 같은 책읽기 등록</title>
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
<script type="text/javascript" src="../js/readBook2.js"></script>
<style>
span {
	color: black;
}

h4 {
	font-weight: bold;
}

input {
	margin-bottom: 5px;
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
					<h1 class="innerpage-title">우리대전 같은 책읽기</h1>
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
	 글쓰기 폼 시작 -->
	<section>
		<div class="container">
			<form name="frm" role="form"
				action="/readBook?command=readBookInsert" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="memNum" value="${LoginUser.memNum}">


				<div class="row" style="justify-content: center;">
					<div class="col-lg-12">
						<h4 class="text-center mb-4">우리대전 같은 책읽기 등록</h4>
						<br>
						<div class="row">
							<div class="form-group col-md-6">
								<span class="form-group">선정도서<span style="color: red;">*</span></span><input type="text"
									name="bookName" class="form-control">
							</div>
							<div class="form-group col-md-6">
								<span class="form-group">작가<span style="color: red;">*</span></span><input type="text"
									name="writer" class="form-control">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-6">
								<span class="form-group">출판사<span style="color: red;">*</span></span><input type="text"
									name="publisher" class="form-control">
							</div>
							<div class="form-group col-md-6">
								<span class="form-group">출판 연도<span style="color: red;">*</span></span> <input type="text"
									name="publishDate" class="form-control" maxlength=4
									onkeydown='return onlyNumber(event)'
									onkeyup='removeChar(event)'>
							</div>
						</div>
						<div class="row">

							<div class="form-group col-md-12">
								<span class="form-group">내용<span style="color: red;">*</span></span>
								<div class="wrap">
									<textarea cols="40" rows="20" name="readBookContents"
										id="readBookContents" class="form-control"
										placeholder="내용을 입력하세요. 글자수는 6000자로 제한됩니다."></textarea>
									<span id="counter">###</span>
								</div>

								<input type="file" name="readBookFile" class="form-control-file">
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<span class="form-group">보도기사 URL</span> <input type="text"
									name="articleURL" class="form-control">
							</div>
							<div class="form-group col-md-12">
								<span class="form-group">관련 유튜브 URL</span> <input type="text"
									name="videoURL" class="form-control">
							</div>

						</div>
					</div>
				</div>
				<div align="right">
					<input type="submit" value="등록" class="btn btn-grad"
						onclick="return readBookCheck()" /> <input type="button"
						value="취소" id="cancel" class="btn btn-grad">
				</div>
			</form>
		</div>
	</section>






	<%@ include file="../include/footer.jsp"%>
</body>


<script>
	function onlyNumber(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
				|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
			return;
		else
			return false;
	}

	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
			return;
		else
			event.target.value = event.target.value.replace(/[^0-9]/g, "");
	}
</script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#cancel').on("click", function(event) {
			var confirmStat = confirm("취소하시겠습니까?");

			if (confirmStat == true) {
				self.location = "/readBook?command=readBookList";
			} else {
				return false;
			}
		});

		$('.Message').on("click", function(event) {

		});
	});

	$(document).ready(function() {
		$('form').submit(function() {
			var result = alert("등록되었습니다.");

			return result;
		})
	});

	$(document).ready(function() {

		$('#readBookContents').on('keyup', function() {

			if ($(this).val().length > 6000) {

				$(this).val($(this).val().substring(0, 6000));

			}

		});

	});

	$(function() {
		$('#readBookContents').keyup(function(e) {
			var content = $(this).val();

			$('#counter').html(content.length + '/6000');
		});
		$('#content').keyup();
	});
</script>

</html>