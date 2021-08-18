<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>얼토당토 북토크</title>
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


<script type="text/javascript" src="/js/bookTalk.js"></script>
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
		style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">얼토당토 북토크</h1>
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
			<form name="frm" action="/bookTalk?command=bookTalkInsertAction"
				method="post" onsubmit="return validateGalBoard()"
				enctype="multipart/form-data">
				<input type="hidden" name="memNum" value="${LoginUser.memNum}">

				<div class="row" style="justify-content: center;">
					<div class="col-lg-12">
						<h4 class="text-center mb-4">얼토당토 북토크 등록</h4>


						<div class="row">
							<div class="form-group col-md-12">
								<span>도서명<span style="color: red;">*</span> <input
									type="text" class="form-control" placeholder="도서명을 입력하세요."
									name="talkName"></span>
							</div>
						</div>

						<div class="row">
						
							<div class="col-md-6">
								<span class="form-group">저자<span style="color: red;">*</span><input
									type="text" class="form-control" placeholder="저자를 입력하세요."
									name="writer"></span>
							</div>
							
							<div class="col-md-6">
								<span class="form-group">출판사<span style="color: red;">*</span><input
									type="text" class="form-control" placeholder="출판사를 입력하세요."
									name="talkPublisher"></span>
							</div>

						</div>

						<div class="row">
							<div class="col-md-6">
								<span class="form-group">모임 일자<span style="color: red;">*</span>
									<input type="text" class="selector form-control"
									placeholder="날짜를 선택하세요." name="talkDate"
									style="background: white;"> <a class="input-button"
									title="toggle" data-toggle><i class="icon-calendar"></i></a>
								</span>​
							</div>

							<script type="text/javascript">
								$(".selector").flatpickr({

									dateFormat : "Y-m-d ",
								});
							</script>

							<div class="col-md-6">
								<span class="form-group">장소</span><br> <input type="text"
									class="form-control" placeholder="장소를 입력하세요." name="talkPlace">

							</div>
						</div>

						<div class="row">
							<div class="col-md-12" style="min-height: 480px;">

								<div class="wrap">
									<textarea cols="40" rows="20" name="talkContents"
										id="talkContents" class="form-control"
										placeholder="내용을 입력하세요. 글자 수는 3000자로 제한됩니다."></textarea>
									<span id="counter">###</span>
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md-12">
								<span class="form-group">관련 기사<input type="text"
									class="form-control" placeholder="관련 기사 URL" name="articleURL"></span>
							</div>
						</div>


						<div class="row">
							<div class="col-md-12">
								<span class="form-group">관련 영상<input type="text"
									class="form-control" placeholder="동영상 URL" name="videoURL"></span>
							</div>
						</div>


						<input type="file" name="talkFile" class="form-control-file"
							id="exampleFormControlFile1">

					</div>
				</div>
				<div align="right">
					<input type="submit" class="btn btn-grad"
						onclick="return bookTalkCheck()" value="등록"> <input
						type="button" value="취소" id="cancel" class="btn btn-grad">
				</div>
			</form>
		</div>
	</section>
	<!-- =======================
	공지사항 글쓰기 폼 끝 -->



	<%@ include file="../include/footer.jsp"%>
</body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	/* function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 도로명 조합형 주소 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== ''
								&& /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== ''
								&& data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}
						// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
						if (fullRoadAddr !== '') {
							fullRoadAddr += extraRoadAddr;
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('sample4_roadAddress').value = fullRoadAddr;

						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							//예상되는 도로명 주소에 조합형 주소를 추가한다.
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';

						} else {
							document.getElementById('guide').innerHTML = '';
						}
					}
				}).open();
	} */
	$(document).ready(function() {

		$('#talkContents').on('keyup', function() {

			if ($(this).val().length > 3000) {

				$(this).val($(this).val().substring(0, 3000));

			}

		});

	});

	$(function() {
		$('#talkContents').keyup(function(e) {
			var content = $(this).val();

			$('#counter').html(content.length + '/3000');
		});
		$('#content').keyup();
	});

	$(document).ready(function() {
		$('form').submit(function() {
			var result = alert("등록되었습니다.");

			return result;
		})
	});
	$(document).ready(function() {
		$('#cancel').on("click", function(event) {
			var confirmStat = confirm("취소하시겠습니까?");

			if (confirmStat == true) {
				self.location = "/bookTalk?command=bookTalkListFormAction";
			} else {
				return false;
			}
		});

		$('.Message').on("click", function(event) {

		});
	});
</script>
</html>