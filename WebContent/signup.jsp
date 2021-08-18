<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!doctype>
<html lang="en">
<head>
<script type="text/javascript" src="js/member.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>희망의 책 대전본부 회원가입</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Webestica.com">
<meta name="description"
	content="Creative Multipurpose Bootstrap Template">

<!-- Favicon -->
<link rel="shortcut icon" href="assets/images/favicon.ico">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700"
	rel="stylesheet">

<!-- Plugins CSS -->
<link rel="stylesheet" type="text/css"
	href="assets/vendor/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="assets/vendor/themify-icons/css/themify-icons.css" />
<link rel="stylesheet" type="text/css"
	href="assets/vendor/animate/animate.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />

</head>

<body>
	<div class="preloader">
		<img src="assets/images/preloader.svg" alt="Pre-loader">
	</div>

	<!-- =======================
		Sign up -->
	<section class="p-0 d-flex align-items-center">
		<div class="container-fluid">
			<div class="row">
				<!-- left -->
				<div
					class="col-12 col-md-5 col-lg-4 d-md-flex align-items-center bg-grad h-sm-100-vh"
					style="background-image: url(https://i.ibb.co/SRQ7ync/book3.jpg); background-position: center center; background-size: cover;">
					<div class="w-100 p-3 p-lg-5 all-text-white">
						<div class="justify-content-center align-self-center">
							<!-- SVG Logo Start -->
							<!-- <svg class="logo-auth mb-4" xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink"
								preserveAspectRatio="xMinYMid" width="325.656" height="100"
								viewBox="0 0 325.656 100">
							  <g>
								<path
									d="M320.187,75.278 C316.545,78.817 312.335,80.585 307.558,80.585 C302.721,80.585 298.497,78.830 294.885,75.322 C291.271,71.813 289.466,67.749 289.466,63.129 L289.466,55.058 C289.466,50.440 291.243,46.404 294.797,42.953 C298.351,39.503 302.605,37.778 307.558,37.778 C312.393,37.778 316.617,39.488 320.231,42.909 C323.843,46.330 325.650,50.381 325.650,55.058 L325.650,63.129 C325.650,67.690 323.828,71.740 320.187,75.278 ZM316.473,55.086 C316.473,52.763 315.583,50.671 313.807,48.813 C312.029,46.954 309.946,46.023 307.558,46.023 C305.111,46.023 303.013,46.954 301.265,48.813 C299.517,50.671 298.643,52.763 298.643,55.086 L298.643,63.103 C298.643,65.485 299.517,67.620 301.265,69.507 C303.013,71.396 305.111,72.339 307.558,72.339 C309.946,72.339 312.029,71.396 313.807,69.507 C315.583,67.620 316.473,65.485 316.473,63.103 L316.473,55.086 ZM285.184,76.023 C285.184,77.018 284.513,78.027 283.173,79.050 C281.832,80.072 280.551,80.585 279.328,80.585 C278.220,80.585 277.434,80.234 276.968,79.532 L267.529,65.058 L258.090,79.532 C257.565,80.234 256.749,80.585 255.642,80.585 C254.535,80.585 253.296,80.087 251.928,79.094 C250.558,78.100 249.874,77.076 249.874,76.023 C249.874,75.440 250.078,74.883 250.486,74.357 L261.323,58.743 L251.010,44.006 C250.602,43.480 250.398,42.953 250.398,42.427 C250.398,41.374 251.083,40.337 252.452,39.313 C253.821,38.290 255.147,37.778 256.429,37.778 C257.478,37.778 258.206,38.129 258.614,38.830 L267.529,52.865 L276.444,38.918 C276.909,38.159 277.667,37.778 278.716,37.778 C279.881,37.778 281.163,38.290 282.562,39.313 C283.960,40.337 284.659,41.374 284.659,42.427 C284.659,42.896 284.454,43.422 284.047,44.006 L273.647,58.830 L284.572,74.357 C284.979,74.883 285.184,75.440 285.184,76.023 ZM238.687,27.865 C237.230,27.865 235.978,27.383 234.929,26.418 C233.880,25.453 233.356,24.328 233.356,23.041 C233.356,21.696 233.880,20.556 234.929,19.620 C235.978,18.685 237.230,18.216 238.687,18.216 C240.143,18.216 241.397,18.685 242.445,19.620 C243.494,20.556 244.019,21.696 244.019,23.041 C244.019,24.328 243.494,25.453 242.445,26.418 C241.397,27.383 240.143,27.865 238.687,27.865 ZM224.617,79.883 L197.435,79.883 C196.387,79.883 195.585,79.560 195.032,78.910 C194.477,78.260 194.202,77.512 194.202,76.665 C194.202,75.659 194.726,74.416 195.775,72.935 L214.478,45.673 L197.872,45.673 C197.115,45.673 196.444,45.307 195.862,44.572 C195.279,43.837 194.988,42.963 194.988,41.946 C194.988,40.930 195.250,40.069 195.775,39.364 C196.299,38.658 196.998,38.304 197.872,38.304 L223.131,38.304 C224.005,38.304 224.748,38.573 225.360,39.109 C225.972,39.646 226.277,40.422 226.277,41.437 C226.277,42.680 225.810,43.954 224.879,45.256 L206.088,72.515 L224.617,72.515 C225.432,72.515 226.131,72.868 226.714,73.574 C227.296,74.280 227.588,75.169 227.588,76.241 C227.588,77.258 227.311,78.119 226.758,78.825 C226.204,79.531 225.491,79.883 224.617,79.883 ZM182.753,27.865 C181.295,27.865 180.043,27.383 178.994,26.418 C177.946,25.453 177.421,24.328 177.421,23.041 C177.421,21.696 177.946,20.556 178.994,19.620 C180.043,18.685 181.295,18.216 182.753,18.216 C184.208,18.216 185.462,18.685 186.511,19.620 C187.560,20.556 188.084,21.696 188.084,23.041 C188.084,24.328 187.560,25.453 186.511,26.418 C185.462,27.383 184.208,27.865 182.753,27.865 ZM158.544,78.918 C158.077,80.146 156.853,80.760 154.873,80.760 C152.891,80.760 151.639,80.175 151.115,79.006 L143.511,56.374 L135.994,78.743 C135.470,80.087 134.159,80.760 132.061,80.760 C130.139,80.760 128.915,80.087 128.391,78.743 L114.844,43.304 C114.610,42.602 114.494,42.106 114.494,41.813 C114.494,40.760 115.134,39.854 116.417,39.094 C117.698,38.334 119.009,37.953 120.350,37.953 C121.806,37.953 122.738,38.510 123.147,39.620 L132.848,66.901 L140.277,42.690 C140.684,41.345 141.763,40.673 143.511,40.673 C145.259,40.673 146.336,41.345 146.745,42.690 L154.086,67.076 L163.875,39.620 C164.225,38.510 165.127,37.953 166.584,37.953 C167.865,37.953 169.163,38.334 170.474,39.094 C171.785,39.854 172.440,40.790 172.440,41.901 C172.440,42.369 172.323,42.837 172.091,43.304 L158.544,78.918 ZM182.753,38.304 C184.092,38.304 185.200,38.582 186.074,39.137 C186.948,39.694 187.385,40.409 187.385,41.287 L187.385,76.813 C187.385,77.574 186.933,78.275 186.030,78.918 C185.126,79.562 184.034,79.883 182.753,79.883 C181.470,79.883 180.393,79.562 179.519,78.918 C178.645,78.275 178.208,77.574 178.208,76.813 L178.208,41.287 C178.208,40.409 178.630,39.694 179.475,39.137 C180.319,38.582 181.412,38.304 182.753,38.304 ZM238.687,38.304 C240.027,38.304 241.134,38.582 242.008,39.137 C242.882,39.694 243.319,40.409 243.319,41.287 L243.319,76.813 C243.319,77.574 242.867,78.275 241.965,78.918 C241.061,79.562 239.968,79.883 238.687,79.883 C237.405,79.883 236.327,79.562 235.453,78.918 C234.579,78.275 234.142,77.574 234.142,76.813 L234.142,41.287 C234.142,40.409 234.564,39.694 235.410,39.137 C236.254,38.582 237.346,38.304 238.687,38.304 Z"
									class="fill-white" />
							    <circle cx="50.047" cy="50" r="50.047" class="fill-white" />
							    <path
									d="M86.607,38.585 L55.868,69.317 C53.678,71.508 50.126,71.508 47.936,69.317 C45.745,67.127 45.745,63.577 47.936,61.387 L78.674,30.654 C80.865,28.464 84.416,28.464 86.607,30.654 C88.797,32.844 88.797,36.395 86.607,38.585 ZM26.806,69.317 C25.679,70.444 24.193,70.981 22.716,70.948 C22.636,70.953 22.560,70.972 22.478,70.972 L20.552,70.972 C18.108,70.972 16.128,68.992 16.128,66.548 L16.128,33.452 C16.128,31.008 18.108,29.028 20.552,29.028 L22.478,29.028 C24.922,29.028 26.902,31.008 26.902,33.452 L26.902,53.359 L49.612,30.654 C51.802,28.464 55.354,28.464 57.544,30.654 C59.735,32.844 59.735,36.395 57.544,38.585 L26.806,69.317 Z"
									class="fill-dark" />
							  </g>
							</svg> -->

							<!-- SVG Logo End -->
						</div>
						<!-- <h3 class="font-weight-light"><strong>희망의 책 대전 본부</strong>를 찾아주신 여러분께 <br>깊은 감사를
							드립니다. </h3> 
						<ul class="list-group list-group-borderless mt-4">
							<li class="list-group-item text-white"><i
								class="fa fa-check"></i>희망의 책은 <strong>만남과 소통의 장소</strong>입니다.</li>
							<li class="list-group-item text-white"><i
								class="fa fa-check"></i>희망의 책에서 <strong>소중한 인연</strong>을 만나보세요. </li>
							<li class="list-group-item text-white"><i
								class="fa fa-check"></i>독서의 <strong>즐거움</strong>과 <strong>새로운 경험</strong>을 만들어 보세요.</li>
						</ul> -->
					</div>
				</div>
				<!-- Right -->

				<div class="col-12 col-md-7 col-xl-8 mx-auto my-5">
					<div class="row h-100">
						<div
							class="col-12 col-md-10 col-lg-5 text-left mx-auto d-flex align-items-center">
							<div class="w-100">

								<form name="frm" method="post" onsubmit="return validate();"
									action="member?command=insertMember">
									<div class="form mt-4">
										<div>
											<p class="text-left mb-2">아이디</p>
											<span class="form-group"><input type="text"
												name="memId" id="memId" readonly="readonly"
												class="form-control" onclick="popupOpen()" maxlength="12"></span>
										</div>
										<div>
											<div class="align-items-center">
												<p class="text-left mb-2">비밀번호</p>
											</div>
											<span class="form-group"><input type="password"
												name="memPw" id="memPw" class="form-control"
												placeholder="*********" maxlength="12"></span>
										</div>
										<div>
											<div class="align-items-center">
												<p class="text-left mb-2">비밀번호 확인</p>
											</div>
											<span class="form-group"><input type="password"
												name="checkPw" id="checkPw" class="form-control"
												placeholder="*********" maxlength="12"></span>
										</div>
										<div>
											<p class="text-left mb-2">이름</p>
											<span class="form-group"><input type="text"
												name="memName" id="memName" class="form-control"
												placeholder="김OO" maxlength="6"></span>
										</div>
										<div>
											<p class="text-left mb-2">생년월일</p>
											<span class="form-group"> <input type="text"
												name="jumin" id="jumin" class="form-control" maxlength="8"
												placeholder="ex)19960116"
												onkeydown='return onlyNumber(event)'
												onkeyup='removeChar(event)' style='ime-mode: disabled;'></span>
										</div>
										<div>
											<p class="text-left mb-2">주소</p>
											<input type="text" id="sample4_postcode" name="adr1"
												placeholder="우편번호" class="form-control"
												style="width: 50%; float: left" readonly="readonly">
											<input type="button" onclick="sample4_execDaumPostcode()"
												class="btn btn-dark" value="우편번호 찾기"
												style="width: 45%; float: right">
										</div>
										<br> <input type="text" id="sample4_roadAddress"
											name="adr" placeholder="도로명주소" class="form-control"
											readonly="readonly"> <span id="guide"
											style="color: #999"></span>
										<div>
											<p class="text-left mb-2">상세주소</p>
											<input type="text" id="adr2" name="adr2" placeholder="상세주소"
												class="form-control">
										</div>
										<div>
											<p class="text-left mb-2">핸드폰번호</p>
											<span class="form-group"><input type="tel"
												name="phone" id="phone" class="form-control"
												placeholder="숫자만 입력해주세요." maxlength="11"
												style="width: 250px" onkeydown='return onlyNumber(event)'
												onkeyup='removeChar(event)' style='ime-mode:disabled;'></span>
										</div>
										<div>
											<p class="text-left mb-2">이메일 주소</p>
											<span class="form-group"><input type="email"
												name="email" id="email" class="form-control"></span>
											<!-- email 타입 @ 유효성 체크기능있음 -->
										</div>
										<div>
											<!-- id 값이 중복되서 이를 활용하면 에러날 수 있음 -->
											<input type="radio" name="authority" id="authority" value="1" style='padding-right:50px;'>일반회원
											<input type="radio" name="authority" id="authority" value="2">기부회원
										</div>
										<div class="col-12 mbtext-right">
											<button type="submit" class="btn btn-dark ">회원가입</button>
											<button type="button" class="btn btn-dark "
												onclick="location.href='main?command=loginForm'">돌아가기</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- =======================
	Sign up -->

	<!--Global JS-->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/popper.js/umd/popper.min.js"></script>
	<script src="assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!--Template Functions-->
	<script src="assets/js/functions.js"></script>


	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

	<script type="text/javascript">
		var filter = "win16|win32|win64|mac|macintel";

		if (navigator.platform) {

			if (filter.indexOf(navigator.platform.toLowerCase()) < 0) {
				//mobile 
				//alert('mobile 접속'); 
			} else {
				//pc 
				//alert('pc 접속'); } }
	</script>

	<script>
		function onlyNumber(event) {
					event = event || window.event;
					var keyID = (event.which) ? event.which : event.keyCode;
					if ((keyID >= 48 && keyID <= 57)
							|| (keyID >= 96 && keyID <= 105) || keyID == 8
							|| keyID == 46 || keyID == 37 || keyID == 39)
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
						event.target.value = event.target.value.replace(
								/[^0-9]/g, "");
		}
		
	</script>

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
												+ data.buildingName
												: data.buildingName);
									}
									// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
									if (extraRoadAddr !== '') {
										extraRoadAddr = ' (' + extraRoadAddr
												+ ')';
									}
									// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
									if (fullRoadAddr !== '') {
										fullRoadAddr += extraRoadAddr;
									}

									// 우편번호와 주소 정보를 해당 필드에 넣는다.
									document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
									document
											.getElementById('sample4_roadAddress').value = fullRoadAddr;

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

				function validate() {

					var memId = document.frm.memId;
					var memPw = document.frm.memPw;
					var checkPw = document.frm.checkPw;
					var memName = document.frm.memName;
					var jumin = document.frm.jumin;
					var adr = document.frm.sample4_roadAddress;
					var adr2 = document.frm.adr2;
					var phone = document.frm.phone;
					var email = document.frm.email;
					var authority = document.frm.authority;

					//아이디 입력 유무
					if (memId.value == ''
							|| !(memId.value.length >= 4 && memId.value.length <= 12)) {
						window.alert("아이디를 최소 4 ~ 12 글자 사이로 입력해주세요.");
						document.frm.memId.focus();
						document.getElementById('memId').select();
						return false;
					}
					//비밀번호 입력 유무
					if (memPw.value == '') {
						window.alert("비밀번호를 입력해주세요.");
						document.frm.memPw.focus();
						document.getElementById('memPw').select();
						return false;
					}

					if (memPw.value != checkPw.value) {
						window.alert("비밀번호가 일치하지 않습니다.")
						document.frm.memPw.focus();
						document.getElementById('memPw').select();
						document.frm.checkPw.focus();
						document.getElementById('checkPw').select();
						return false;
					}
					if (memName.value == '') {
						window.alert("이름을 입력해주세요.");
						document.frm.memName.focus();
						document.getElementById('memName').select();
						return false;
					}
					if (jumin.value == '' || jumin.value.length != 8) {
						jumin.value != 8 ? window.alert("입력양식에 맞게 작성주세요.") : window.alert("생년월일을 입력해주세요.");
						document.frm.jumin.focus();
						document.getElementById('jumin').select();
						return false;
					}
					
					if (adr.value == '') {
						window.alert("주소를 입력해주세요.");
						document.frm.adr.focus();
						document.getElementById('sample4_roadAddress').select();
						return false;
					}
					if (adr2.value == '') {
						window.alert("상세주소를 입력해주세요.");
						document.frm.adr2.focus();
						document.getElementById('adr2').select();
						return false;
					}
					if (phone.value == '') {
						window.alert("핸드폰 번호를 입력해주세요.");
						document.frm.phone.focus();
						document.getElementById('phone').select();
						return false;
					}
					if (email.value == '') {
						window.alert("이메일을 입력해주세요.");
						document.frm.email.focus();
						document.getElementById('email').select();
						return false;
					}
					if (authority.value == '') {
						window.alert("일반회원인지 기부회원인지 선택해주세요.");
						return false;
					}
					$(document).ready(function() {
						alert('회원가입이 완료되었습니다.')
					});
					return ture;
				}
		
	</script>
</body>
</html>