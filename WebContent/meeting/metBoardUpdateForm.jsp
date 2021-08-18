<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>희망의 책 모임게시판</title>
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

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	/* 내용 칸 글자 수 제한 스크립트 */
	$(document).ready(function() {

		$('#metBrdContent').on('keyup', function() {

			if ($(this).val().length > 1000) {

				$(this).val($(this).val().substring(0, 1000));

			}

		});

	});
	/* 내용 칸 글자 수 출력 스크립트 */
	$(function() {
		$('#metBrdContent').keyup(function(e) {
			var content = $(this).val();

			$('#counter').html(content.length + '/3000');
		});
		$('#content').keyup();
	});
	$(document)
			.ready(
					function() {
						$('#cancel')
								.on(
										"click",
										function(event) {
											var confirmStat = confirm("취소하시겠습니까?");

											if (confirmStat == true) {
												var metNum = $('#metNum').val();
												self.location = "/meeting?command=metBoardListFormAction&metNum=${meetingVo.metNum }";
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
</script>
<script type="text/javascript" src="/js/metboard.js"></script>
</head>

<style>
h4 {
	font-weight: bold;
}

span {
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
	<!-- =======================
	Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a
								href="/main?command=loginForm"><i class="ti-home"></i>Home</a></li>
							<li class="breadcrumb-item">독서모임</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->

	<!-- =======================
	Banner innerpage -->
	<section>
		<div class="container">
			<div class="row" style="justify-content: center;">
				<div class="col-lg-12">
					<h4 class="text-center mb-4">모임게시판 수정</h4>
					<form name="frm" method="post"
						action="/meeting?command=metBoardUpdateAction&metNum=${meetingVo.metNum}<%-- &page=${pageNum} For input string: "" 오류원인--%>"
						enctype="multipart/form-data">
						<input type="hidden" name="metBrdNum" value="${metbrd.metBrdNum}">
						<input type="hidden" name="existing_file"
							value="${metbrd.metBrdFile}" />
							
							
							
							<div class="row">
							<div class="form-group col-md-12">
								<span>제목<span style="color: red;">*</span></span> <input type="text" class="form-control"
									 name="metBrdName" value="${metbrd.metBrdName}">
							</div>
						</div>
							
							<div class="row">
							<div class="col-md-12" style="min-height: 480px;">

								<div class="wrap">
									<textarea cols="40" rows="20" name="metBrdContent"
										id="metBrdContent" class="form-control"
										>${metbrd.metBrdContent}</textarea>
									<span id="counter">###</span>
								</div>
							</div>
						</div>
						
						<c:if test="${!empty metbrd.metBrdFile}">
							<span class="form-group">기존 파일</span>
							<input name="metBrdFile" class="form-control"
								value="${metbrd.metBrdFile}" readonly="readonly">
						</c:if>
						<span class="form-group">첨부 파일</span> <input type="file"
							name="metBrdFile" class="form-control-file">
						<div align="right">
								<input type="submit" class="btn btn-grad" value="수정"
									onclick="return metboardCheck()"> <input type="button"
									value="취소" id="cancel" class="btn btn-grad">
							</div>
						
						
						
						
						

						<%-- <div class="table-responsive-sm">
							<table class="table table-hover">

								<tr>
									<th scope="col">작성자</th>
									<td>${metbrd.memName }</td>
									<th>작성일</th>
									<td>${metbrd.regDate }</td>

								</tr>
								<tr>
									<th scope="col">제목</th>
									<td><input name="metBrdName" type="text" size="70"
										maxlength="100" value="${metbrd.metBrdName}" /></td>
									<th>조회수</th>
									<td>${metbrd.metBrdCount}</td>

								</tr>
								<tr>
									<th scope="col">기존파일</th>
									<td>&nbsp;&nbsp; ${metbrd.metBrdFile}</td>
									<th scope="col">첨부파일</th>
									<td><input type="file" name="metBrdFile" /></td>
								</tr>

							</table>
							<div class="col-md-12">
								<span class="form-group"> <textarea cols="40" rows="15"
										name="metBrdContent" class="form-control">${metbrd.metBrdContent}</textarea>
								</span>
							</div>


							<div align="right">
								<input type="submit" class="btn btn-grad" value="수정"
									onclick="return metboardCheck()"> <input type="button"
									value="취소" id="cancel" class="btn btn-grad">
							</div>
						</div> --%>
					</form>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>