<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>희망의 책 공지사항</title>
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

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript" src="/js/notice.js"></script>

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
	>
	<section>

		<div class="container">

			<form name="frm" method="post"
				action="/notice?command=noticeUpdateAction"
				enctype="multipart/form-data" onsubmit="return validateGalBoard()">
				
				<input type="hidden" name="memNum" value="${LoginUser.memNum}">
				<input type="hidden" name="noticeNum" value="${notice.noticeNum }">
				<input type="hidden" name="existing_file"
					value="${notice.noticeFile}" />

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
									name="noticeTitle" value="${notice.noticeTitle}"></span>
							</div>
						</div>

						<div class="row">

							<div class="form-group col-md-12">
								<span class="form-group"></span>
								<div class="wrap">
									<textarea cols="40" rows="20" name="noticeContent"
										id="noticeContent" class="form-control"
										placeholder="내용을 입력하세요. 글자수는 3000자로 제한됩니다.">${notice.noticeContent}</textarea>
									<span id="counter">###</span>
								</div>
							</div>
							<c:if test="${!empty notice.noticeFile}">
								<label class="form-group">기존 파일</label>
								<input name="noticeFile" class="form-control"
									value="${notice.noticeFile}" readonly="readonly">
							</c:if>
							<input type="file" name="noticeFile" class="form-control-file"
								id="exampleFormControlFile1">
						</div>
					</div>

				</div>
				<div align="right">
					<input type="submit" class="btn btn-grad"
						onclick="return noticeCheck()" value="수정">
					<button type="button" name="cancel" id="cancle" value="취소 " class="btn btn-grad">
						취소</button>
				</div>
			</form>
		</div>
	</section>

	<%@ include file="../include/footer.jsp"%>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$('#cancel').on("click", function(event) {
			var confirmStat = confirm("취소하시겠습니까?");

			if (confirmStat == true) {
				self.location = "/notice?command=noticeListFormAction";
			} else {
				return false;
			}
		});

		$('.Message').on("click", function(event) {

		});
	});

	$(document).ready(function() {
		$('form').submit(function() {
			var result = alert("수정되었습니다.");

			return result;
		})
	})

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