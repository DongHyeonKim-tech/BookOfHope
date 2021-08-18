<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>희망의책 도서관</title>
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
<script type="text/javascript" src="/js/report.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<style>
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
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">독후감</h1>
					<h6 class="subtitle"></h6>
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

	<section>
		<div class="container">
			<form name="frm" method="post" action="/report?command=Report_Reg">
				<input type="hidden" name="bookNum"> <input type="hidden"
					name="memNum" value="${LoginUser.memNum}">
				<div class="form-group"></div>

				<!-- Comment-respond -->
				<div class="row mt-5">
					<div class="col-md-12">
						<h2 class="mb-2">글쓰기</h2>
					</div>
					<div class="col-md-12">
						책 등록을 하신 후에 독후감을 써주시길 바랍니다. <br> <br>
						<button type="button" class="form-control col-md-1"
							name="selectBook" id="selectBook" onclick="openPopUp()">책
							선택</button>

					</div>
					<div class="col-md-3">

						<div class="form-group ">
							<span>분류</span> <select class="custom-select select-big mb-3"
								name="reportCategory">
								<option value="인문학">인문학</option>
								<option value="사회과학">사회과학</option>
								<option value="역사">역사</option>
								<option value="과학">과학</option>
								<option value="예술/대중문화">예술/대중문화</option>
								<option value="자기계발">자기계발</option>
							</select>
						</div>
					</div>

					<div class="col-md-12">
						<div class="form-group">
							<span class="form-group"> 도서명
							<input type="text" class="form-control" placeholder="도서명"
								name="bookTitle" style="background: white;" disabled></span>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<span class="form-group"> 저자<input type="text"
								class="form-control" placeholder="저자" readonly="readonly"
								name="writer" style="background: white;" disabled></span>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<span class="form-group">출판사 <input type="text"
								class="form-control" placeholder="출판사" readonly="readonly"
								name="publisher" readonly="readonly" style="background: white;" disabled></span>
						</div>
					</div>

					<div class="col-md-12">
						<span class="form-group">제목<input type="text"
							class="form-control" placeholder="제목을 입력하세요." name="reportTitle" id="reportTitle"></span>
					</div>
					<div class="col-md-12" style="min-height: 480px;">
						<div class="wrap">
							<textarea cols="40" rows="20" name="reportContent"
								class="form-control" id="reportContent"
								placeholder="내용을 입력하세요. 글자 수는 3000자로 제한됩니다. "></textarea>
							<span id="counter">###</span>
						</div>
					</div>

					<div class="col-md-12 text-right">
						<button type="submit"
							class="btn btn-grad border-radius-left-0 mb-0 "
							onclick="return reportCheck()">등록</button>
						<a href="report?command=Report_List">
							<button type="button"
								class="btn btn-grad border-radius-left-0 mb-0">취소</button>
						</a>
					</div>
				</div>
			</form>
		</div>

	</section>
	<script>
		/* 내용 칸 글자 수 제한 스크립트 */
		$(document).ready(function() {

			$('#reportContent').on('keyup', function() {

				if ($(this).val().length > 3000) {

					$(this).val($(this).val().substring(0, 3000));

				}

			});

		});
		/* 내용 칸 글자 수 보이기 */
		$(function() {
			$('#reportContent').keyup(function(e) {
				var content = $(this).val();

				$('#counter').html(content.length + '/3000');
			});
			$('#content').keyup();
		});

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
	</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>