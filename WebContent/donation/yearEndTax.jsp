<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후원금 영수증 신청</title>
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

<script type="text/javascript" src="/js/tax.js"></script>

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
               <h5
                  class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n2 mt-9">영수증
                  신청</h5>
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
               <form name="checkform">
                  <h4 class="mb-4">
                     - 모든 기부금은 매년 연말에 자동으로 국세청 연말정산간소화서비스에 <br>&nbsp;&nbsp;등록이되어
                     발급해드립니다.
                  </h4>

                  <h4 class="mb-4">
                     - 모든 기부금은 별도의 요청이 없으실 경우 회계연도 기준으로 당해 <br>&nbsp;&nbsp;연도분으로
                     발급해 드립니다.
                  </h4>

               </form>
               <!-- Apply form -->
               <form name="frm" method="post"
                  action="/notice?command=yearEndTaxInsertAction">
                  <input type="hidden" name="memNum" value="${LoginUser.memNum}">
                  <input type="hidden" name="command" value="feePaymentRegister">
                  <div class="row mt-5">
                     <div class="col-md-12">
                        <h2 class="mb-3">영수증 신청자 정보</h2>
                     </div>
                     <div class="col-md-6">
                        <span class="form-group"><input type="text"
                           class="form-control" placeholder="* 신청자 이름" name="taxName"></span>
                     </div>
                     <div class="col-md-6">
                        <span class="form-group"><input type="email"
                           class="form-control" placeholder="* 이메일" name="taxEmail"></span>
                     </div>
                     <div class="col-md-6">
                        <span class="form-group"><input type="text"
                           class="form-control" placeholder="* 연락처" name="taxPhone"
                           onkeydown='return onlyNumber(event)'
                           onkeyup='removeChar(event)'></span>
                     </div>
                     <div class="col-md-3">
                        <input type="text" id="sample4_postcode" name="taxAdr1"
                           placeholder="우편번호" class="form-control" style="width: 150px"
                           readonly="readonly">
                     </div>
                     <div class="col-md-3">
                        <input class="btn btn-success" type="button"
                           onclick="sample4_execDaumPostcode()" class="btn btn-dark"
                           value="우편번호 찾기"><br>
                     </div>
                     <div class="col-md-6">
                        <input type="text" id="sample4_roadAddress" name="taxAdr2"
                           id="adr" placeholder="도로명주소" class="form-control"
                           readonly="readonly"> <span id="guide"
                           style="color: #999"></span>
                     </div>
                     <div class="col-md-6">
                        <span class="form-group"><input type="text"
                           class="form-control" placeholder="상세주소" name="taxAdr3"></span>
                     </div>
                     <div class="col-md-12">
                        <span class="form-group"><textarea cols="40" rows="6"
                              class="form-control" placeholder="메세지" name="taxMsg"></textarea></span>
                     </div>

                  </div>

                  <div class="col-md-12 text-center">
                     <input type="submit" class="btn-block btn btn-success"
                        value="신청하기" onclick="return taxCheck()">
                  </div>
               </form>

            </div>


            <!-- Sidebar -->
            <div class="col-md-4 sidebar">
               <div class="sticky-element">
                  <h3 class="mt-3 mt-md-0 mb-3">문의하기</h3>
                  <ul class="list-unstyled p-0">
                     <li class="mb-3"><strong>담당자:</strong> 강신철</li>
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
   <script type="text/javascript" src="/js/donation.js"></script>
   <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

   <script type="text/javascript">
      function onlyNumber(event) {
         event = event || window.event;
         var keyID = (event.which) ? event.which : event.keyCode;
         if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
               || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
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
            event.target.value = event.target.value.replace(/[^0-9]/g, "");
      }
   </script>
   <script type="text/javascript" >
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


</body>
</html>