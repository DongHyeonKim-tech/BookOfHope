<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>희망의 책 모임게시판</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Webestica.com">
	<meta name="description" content="Creative Multipurpose Bootstrap Template">

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
	
	<script type="text/javascript" src ="/js/metboard.js"></script>
</head>
<style>
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
	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/main?command=loginForm"><i class="ti-home"></i>Home</a></li>
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
		 <form name="frm" action="/meeting?command=metBoardWriteAction&metNum=${meetingVo.metNum}" method="post" onsubmit="return validateGalBoard()" enctype="multipart/form-data">
		<input type="hidden" name="memNum" value="${LoginUser.memNum}">
		<input type="hidden" name="metNum" value="${meetingVo.metNum}">
		<!-- Comment-respond -->
							<div class="row mt-5">
								<div class="col-md-12">
									<h2 class="mb-2">게시판 글쓰기</h2><br>
								</div>
								<div class="col-md-2">
								<select class="custom-select select-big mb-3" name="metBrdCategory">
									<option value="공지">공지</option>
									<option value="일반">일반</option>
									<option value="행사 및 세미나">행사 및 세미나</option>
									<option value="자료">자료</option>
								</select>
								</div>
								<div class="col-md-7"><span class="form-group"><input type="text" class="form-control" placeholder="제목을 입력하세요." name="metBrdName"></span></div>
								
								<div class="col-md-3">
									<div class="form-group">
										<input type="file" name="metBrdFile" class="form-control-file" id="exampleFormControlFile1">
									</div>
								</div>
								
								<div class="col-md-12" style="min-height:480px;">
									<div class="form-group">
									<div class="wrap">
										<textarea cols="40" rows="20"  name="metBrdContent" id="metBrdContent" class="form-control"  placeholder="내용을 입력하세요. 글자 수는 1000으로 제한합니다."></textarea>
										 <span id="counter">###</span>
									</div>
									</div>
								</div>
							</div>
								<div align="right">
								<input type="submit" value="등록" class="btn btn-grad" onclick="return metboardCheck()"/> 
								<input type="button" value="취소 " class="btn btn-grad" onclick="location.href='/meeting?command=metBoardListFormAction&metNum=${meetingVo.metNum}'"/></div>
			   </form>
		</div>
		
	</section>
	<!-- =======================
	공지사항 글쓰기 폼 끝 -->
	<%@ include file="../include/footer.jsp"%>
	</body>
	
	
	<script>
	/* 내용 칸 글자 수 제한 스크립트 */
	$(document).ready(function() {

		$('#metBrdContent').on('keyup', function() {

			if ($(this).val().length > 1000) {

				$(this).val($(this).val().substring(0, 1000));

			}

		});

	});
	/* 내용 칸 글자 수 출력하는 스크립트 */
	$(function() {
		$('#metBrdContent').keyup(function(e) {
			var content = $(this).val();

			$('#counter').html(content.length + '/1000');
		});
		$('#content').keyup();
	});
		$(document).ready(function() {
			$('form').submit(function() {
				var result = alert("등록되었습니다.");

				return result;
			})
		});
	</script>
	
</html>