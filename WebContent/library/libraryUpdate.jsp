<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>도서관 조회</title>
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
label {
	color: black;
}

h4 {
	font-weight: bold;
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
					<h1 class="innerpage-title">대전 도서관</h1>
					<h6 class="subtitle"></h6>
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
	<section>
		<div class="container">
			<div class="row" style="justify-content: center;">
				<div class="col-lg-12">
					<!-- 책 수정 폼 -->
					<form name="frm" method="post"
						action="library?command=libraryUpdate&libraryNum=${libraryList.libraryNum}">
						<input type="hidden" name="libraryNum"
							value="${libraryList.libraryNum}">
						<h4 class="text-center mb-4">도서관 등록</h4>

						<div class="col-md-9 text-left mx-auto align-items-center">
							<div class="form-group">
								<label><span style="color: red;">*</span>도서관 명</label> <input
									class="form-control" type="text" name="libraryTitle"
									value="${libraryList.libraryTitle}" placeholder="제목을 입력하세요.">
							</div>

							<div class="form-group">
								<label><span style="color: red;">*</span>URL</label> <input
									class="form-control" type="text" name="libraryUrl"
									value="${libraryList.libraryUrl}" placeholder="URL을 입력하세요.">
							</div>

							<div class="form-group">
								<label><span style="color: red;">*</span>기존 주소
									:${libraryList.libraryContent}</label> <input type="button"
									onclick="sample4_execDaumPostcode()" class="btn btn-dark"
									value="주소 찾기"><br> <input type="hidden"
									id="sample4_postcode" name="adr1" placeholder="우편번호"
									class="form-control" style="width: 150px" readonly="readonly">
								<input type="text" id="sample4_roadAddress"
									value="${libraryList.libraryContent}" name="libraryContent"
									id="adr" placeholder="도로명주소" class="form-control"
									readonly="readonly"> <span id="guide"
									style="color: #999"></span>

							</div>


							<div align="right">
								<button type="submit" class="btn btn-grad"
									onclick="return libraryCheck()">수정</button>
								<button type="button" class="btn btn-grad" id="delete"
									onclick="location.href= 'library?command=libraryDelete&libraryNum=${libraryList.libraryNum}'">
									삭제</button>
								<button type="button" class="btn btn-grad" id="cancel">취소</button>
							</div>
						</div>
					</form>

					<!-- 
						<input type="submit"
							class="btn btn-grad  onclick="return libraryCheck()" value="수정">

						<button type="button" id="delete"
							class="btn btn-grad border-radius-left-0 mb-0">삭제</button>

						<button type="button" id="cancle"
							class="btn btn-grad border-radius-left-0 mb-0">취소</button>
					</form> -->
				</div>



			</div>

		</div>

	</section>


	<%@ include file="../include/footer.jsp"%>

</body>


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	function sample4_execDaumPostcode() {
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
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
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
	}
	$(document)
			.ready(
					function() {
						$('#cancel').on("click", function(event) {
							self.location = "library?command=adminLibraryList";
						});
						$('#delete')
								.on(
										"click",
										function(evt) {

											var confirmStat = confirm("삭제하시겠습니까?");

											if (confirmStat == true) {
												var libraryNum = $(
														'#libraryNum').val();
												alert("삭제되었습니다.");
												self.location = "library?command=libraryDelete&libraryNum=${libraryList.libraryNum}";
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
<script type="text/javascript" src="/js/library.js">
	
</script>


</html>