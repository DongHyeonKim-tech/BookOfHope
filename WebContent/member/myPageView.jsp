<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>내 정보 수정</title>
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
<body>
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>

	<style>
.container {
	width: 70%;
	height: 70%;
	margin: 10px auto;
}

.outer {
	display: table;
	width: 100%;
	height: 100%;
}

.inner {
	display: table-cell;
	vertical-align: middle;
	text-align: center;
}

.centered {
	position: relative;
	display: inline-block;
	width: 50%;
}
</style>

	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">회원정보</h1>
					<h6 class="subtitle">수정버튼을 눌러서 회원정보를 수정할 수 있습니다.</h6>
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

	<section class="service">

		<form name="frm" method="post"
			action="member?command=memberModify&memId=${memVo.memId}">
			<input type="hidden" name="memId" value="${LoginUser.memId}">
			<c:if
				test="${LoginUser.authority eq 1 or LoginUser.authority eq 2 or LoginUser.authority eq 3}">
				<div class="col-md-12"></div>

				<div class="container">
					<div class="row">
						<div class="col-sm-12 text-center mt-5 mb-4"></div>

						<div class="divider">
							<i class="ti-check"></i>
						</div>
						<h5 class="mb-2 mt-5"></h5>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">아이디</h3>


								<p class="feature-box-desc">${memVo.memId}</p>
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">이름</h3>


								<p class="feature-box-desc">${memVo.memName}</p>
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">생년월일</h3>


								<p class="feature-box-desc">${memVo.jumin}</p>
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">주소</h3>

								<input type="hidden" id="sample4_postcode" name="adr1" value="">
								<input type="text" class="form-control" id="sample4_roadAddress"
									onclick="sample4_execDaumPostcode()" name="adr"
									value="${memVo.adr}" readonly="readonly"> <input
									type="text" class="form-control" id="adr2" name="adr2"
									value="${memVo.adr2}">
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">연락처</h3>


								<input type="text" class="form-control" name="phone"
									value="${memVo.phone}">
							</div>

						</div>

						<div class="col-lg-4 mt-4">
							<div class="feature-box f-style-3 h-100 icon-grad">
								<div class="feature-box-icon">
									<i class="ti-book"></i>
								</div>

								<h3 class="feature-box-title">이메일</h3>


								<input type="text" class="form-control" name="email"
									value="${memVo.email}">
							</div>

						</div>

					</div>
				</div>
				<div class="outer">
					<div class="inner">
						<div class="centered">
							<button type="submit"
								class="btn btn-grad border-radius-left-0 mb-0"
								onclick="alert('수정되었습니다.')">수정하기</button>
							<button type="button"
								class="btn btn-grad border-radius-left-0 mb-0"
								onclick="goBack()">취소</button>
						</div>
					</div>
				</div>
			</c:if>
		</form>

	</section>


	<%@ include file="../include/footer.jsp"%>

	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">
		//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
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
		}
	</script>

	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>