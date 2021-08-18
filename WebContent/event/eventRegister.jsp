<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>북 포럼</title>
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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

<script type="text/javascript" src="/js/event.js"></script>

</head>
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
		style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">북 포럼</h1>
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

	<!-- =======================
	공지사항 글쓰기 폼 시작 -->
	<section>
		<div class="container">
			<form name="frm" action="/event?command=eventInsert" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="memNum" value="${LoginUser.memNum}">

				<div class="row" style="justify-content: center;">
					<div class="col-lg-12">
						<h4 class="text-center mb-4">북 포럼 등록</h4>
						<br>
						<div class="row">
							<div class="form-group col-md-12">
								<span>제목<span style="color: red;">*</span></span> <input type="text" name="eventName"
									class="form-control">
							</div>

						</div>

						<div class="row">
							<div class="form-group col-md-6">
								<span>장소<span style="color: red;">*</span></span> <input type="text" name="eventPlace"
									class="form-control">
							</div>
							<div class="form-group col-md-6">
								<span>일자<span style="color: red;">*</span></span> <input type="text" name="eventDate"
									placeholder="날짜를 선택하세요." class="selector form-control"
									style="background: white;">

								<!-- <input type="text" class="selector" placeholder="날짜를 선택하세요." /> -->

								<a class="input-button" title="toggle" data-toggle><i
									class="icon-calendar"></i></a> ​
							</div>

							<script type="text/javascript">
								$(".selector").flatpickr({

									dateFormat : "Y-m-d",
								});
							</script>


						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<span>내용<span style="color: red;">*</span></span>
								<div class="wrap">
									<textarea cols="40" rows="20" name="eventContents"
										id="eventContents" class="form-control"
										placeholder="내용을 입력하세요.글자수는 3000자로 제한됩니다. "></textarea>
									<span id="counter">###</span>
								</div>
									<input type="file" name="eventFile" class="form-control-file">
									
							</div>
						</div>
					</div>
				</div>
				<div align="right">
					<input type="submit" value="등록" class="btn btn-grad"
						onclick="return eventCheck()" /> <input type="button" value="취소"
						id="cancel" class="btn btn-grad">
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

		$('#eventContents').on('keyup', function() {

			if ($(this).val().length > 3000) {

				$(this).val($(this).val().substring(0, 3000));

			}

		});

	});

	$(function() {
		$('#eventContents').keyup(function(e) {
			var content = $(this).val();

			$('#counter').html(content.length + '/3000');
		});
		$('#content').keyup();
	});
	$(document).ready(function() {
		$('#cancel').on("click", function(event) {
			var confirmStat = confirm("취소하시겠습니까?");

			if (confirmStat == true) {
				self.location = "/event?command=eventList";
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
</script>



</html>