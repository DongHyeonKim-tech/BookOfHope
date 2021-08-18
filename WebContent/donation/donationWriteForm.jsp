<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청서 작성</title>
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
	
	<!-- =======================
	Banner innerpage -->
	<div class="left bg-grad pattern-overlay-4">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n2 mt-9">후원하기</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->
	
	<!-- =======================
	careers -->
	<section>
		<div class="container">
			<div class="row">
				<!-- Job positions -->
				<div class="col-md-8">
	<form name = "checkform">
					<h2 class="mb-4">만 14세 이상 후원 신청 동의</h2>
					<p>신청인이 만 14세 이상인 경우만 신청할 수 있습니다. 만 14세 이상입니까?  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="checkbox" value ="checkbox1"></p>
					
					<h2 class="mb-4">개인정보처리방침</h2>
					<div class="col-md-12">
					<textarea rows="5" class="form-control" disabled >[개인정보 수집 및 이용 동의]
					 
- 수집 및 이용목적 : CMS 출금이체를 통한 요금수납
- 수집항목 : 성명, 전화번호, 휴대폰번호, 금융기관명, 계좌번호
- 보유 및 이용기간 : 수집, 이용 동의일로부터 CMS 출금이체 종료일(해지일) 후 5년까지
- 신청자는 개인정보 수집 및 이용을 거부할 권리가 있으며, 권리행사시 출금이체 신청이 거부될 수 있습니다.

[개인정보 제3자 제공 동의]

- 개인정보를 제공받는 자 : 사단법인 금융결제원, 나이스페이먼츠, 금융기관
- 개인정보를 제공받는 자의 개인정보 이용 목적 
  : CMS 출금이체 서비스 제공 및 출금동의 확인, 출금이체 신규등록 및 해지 사실 통지 
- 제공하는 개인정보의 항목
  : 성명, 금융기관명, 계좌번호, 생년월일, 전화번호, (은행 등 금융회사 및 이용기관 보유)휴대폰번호
- 개인정보를 제공받는 자의 개인정보 보유 및 이용기간
  : CMS 출금이체 서비스 제공 및 출금동의 확인 목적을 달성할 때까지
- 신청자는 개인정보에 대해 금융결제원에 제공하는 것을 거부할 권리가 있으며, 거부시 출금이체 신청이
  거부될 수 있습니다.					
					
					
					</textarea></div>
					<p><span style="float:right;margin-right:20px;font-weight:normal;">개인정보 수집 및 이용 동의 &nbsp;&nbsp;&nbsp;<input type="checkbox" name="checkbox" value="checkbox2"><br>
					개인정보 제3자 제공 동의 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="checkbox" value="checkbox3"></span></p>
					
					<br><br><br>

</form>
					<!-- Apply form -->
					<form name="frm" method="post" action="feePayment">
					<input type="hidden" name="memNum" value="${LoginUser.memNum}">
					<input type="hidden" name = "command" value="feePaymentRegister">
					<div class="row mt-5">
						<div class="col-md-12">
							<h2 class="mb-3">후원 신청자 정보</h2></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="* 후원자 이름" name="payName" ></span></div>
						<div class="col-md-6"><span class="form-group"><input type="email" class="form-control" placeholder="* E-mail" name = "payEmail"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="* Mobile number" name = "payMobileNumber"></span></div>
						<div class="col-md-3">
						<input type="text" id="sample4_postcode" name = "payZipcode" placeholder="우편번호" class="form-control" style ="width:150px" readonly="readonly">
						</div>			
						<div class="col-md-3">
									<input class="btn btn-success" type="button" onclick="sample4_execDaumPostcode()" class ="btn btn-dark" value="우편번호 찾기" ><br>
						</div>		
						<div class="col-md-12">	
									<input type="text" id="sample4_roadAddress" name = "adr1" id = "adr" placeholder="도로명주소" class="form-control" readonly="readonly">
									<span id="guide" style="color:#999"></span>
						</div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="소속" name="payAttach"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="직급" name="payPosition"></span></div>
						<div class="col-md-12"><span class="form-group"><textarea cols="40" rows="6" class="form-control" placeholder="Message" name="payMessage"></textarea></span></div>
						
					</div>
					
						<!-- Apply form -->
					<div class="row mt-5">
						<div class="col-md-12">
							<h2 class="mb-3">후원 계좌 및 금액 정보</h2></div>
						<div class="col-md-6"><span class="form-group"><select class = "custom-select select-big mb-3" name="payBank">
						<option value='' selected>--은행선택 --</option>
						<option value='농협'>농협</option>
						<option value='기업'>기업</option>
						<option value='신한'>신한</option>
						<option value='우리'>우리</option>
						<option value='외환'>외환</option>
						<option value='하나'>하나</option>
						<option value='우리'>우리</option>
						<option value='국민'>국민</option>
						<option value='신협'>신협</option>
						
						
						</select></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="* 예금주" name="bankName"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="* 계좌번호" name="payBankNum"></span></div>
						<div class="col-md-6"><span class="form-group"><input type="text" class="form-control" placeholder="* 금액(원)" name="payFee"></span></div>
						<div class="col-md-6"><span class="form-group"><select class = "custom-select select-big mb-3" name="paySponsor">
						<option value='' selected>-- 후원방식 --</option>
						<option value='일시후원'>일시후원</option>
						<option value='정기후원'>정기후원</option>
						
						</select></span></div>
						<div class="col-md-12 text-center">
						<input type="submit" class="btn-block btn btn-success" value="후원 완료" onclick="return donationCheck()"></div>
					</div>
						</form>

				</div>
				
				
				<!-- Sidebar -->
				<div class="col-md-4 sidebar">
					<div class="sticky-element">
						<h3 class="mt-3 mt-md-0 mb-3">문의하기</h3>
						<ul class="list-unstyled p-0">
							<li class="mb-3"><strong>담당자:</strong> 강신철 </li>
							<li class="mb-3"><strong>전화번호:</strong> (042) 488-6589</li>
							<li class="mb-3"><strong>이메일:</strong> djbook111@gmail.com</li>
						</ul>
					</div>
				</div>
				<!-- Sidebar end-->

			</div>
		</div>
	</section>
	<!-- =======================
	careers -->
	<%@ include file="../include/footer.jsp"%>
	<script type="text/javascript" src ="/js/donation.js"></script>
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
		
$(document).ready(function(){
	$('form').submit(function(){
 	  var result = alert("등록되었습니다.");
   
	   return result;
	})
	})
	

</script>
</body>
</html>