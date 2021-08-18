<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!-- 독서모임 신청폼 -->
<!-- portfolio-grid-column-4.html Form -->
<html>
<head>
<title>독서모임 신청</title>
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
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/fancybox/css/jquery.fancybox.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />

<!-- Form CSS -->
<!-- 스타일 시트 추가 -->
<style type="text/css">
form {
	margin: 0 auto;
}

.hd1 {
	font-weight: bold;
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

<!-- Form JavaScript -->
<script type="text/javascript" src="/js/meetingCheck.js"></script>

<script type="text/javascript">
   
   function meetingList() {
      
   location.href='meeting?command=meetingList';
   }
   
   </script>

<!-- textarea 글자수 제한 -->
<script type="text/javascript">
   $(document).ready(function(){
      
         $('#metIntro').on('keyup', function(){
            if($(this).val().length > 3000){
               $(this).val($(this).val().substring(0, 3000));
            }
         
         $('#metGreeting').on('keyup', function(){
            if($(this).val().length > 333){
               $(this).val($(this).val().substring(0, 333));
            }
         });
      });
   </script>

<!-- check-box 선택값 1개로 제한하기 -->
<script type="text/javascript">
   function check_only(chk) {
      var cnt = document.getElementsByName("keyword"); //checkbox keyword의 배열값을 불러옴
      
      for(var i=0; i<cnt.length; i++){ //checked한 배열의 차와 cnt가 같지 않으면 unchecked 상태로 돌려줌
         if(cnt[i] != chk){
            cnt[i].checked = false;
         }
      }
   }
   </script>

</head>
<body>
	<!-- header 삽입 -->
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	<div class="preloader">
		<img src="../assets/images/preloader.svg" alt="Pre-loader">
	</div>

	<!-- =======================
   Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">독서모임 신청</h1>
					<h6 class="subtitle">나만의 독서모임 신청하기</h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a
								href="/main?command=loginForm"><i class="ti-home"></i> Home</a></li>
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
   Form -->
	<section>
		<div class="container">
			<div class="row">
				<form name="frm" method="post"
					action="/meeting?command=meetingApply&memNum=${LoginUser.memNum}"
					class="col-md-7" enctype="multipart/form-data">
					<input type="hidden" name="memNum" value="${LoginUser.memNum}">
					<!-- 독서모임명 -->
					<div class="form-group">
						<label class="hd1">독서모임명<span style="color: red;">*</span></label>
						<input type="text" name="metName" class="form-control"
							placeholder="독서모임명을 입력하세요." maxlength=33>
					</div>

					<!-- 독서모임소개 -->
					<div class="form-group">
						<label class="hd1">독서모임소개</label>
						<div class="wrap">
							<textarea id="metIntro" name="metIntro" class="form-control"
								rows="7" placeholder="독서모임 소개글을 입력하세요. 글자 수는 3000자로 제한됩니다."></textarea>
							<span id="counter">###</span>
						</div>
					</div>

					<!-- 독서모임 인사말 -->
					<div class="form-group">
						<label class="hd1">인사말<span style="color: red;">*</span></label>
						<textarea id="metGreeting" name="metGreeting" class="form-control"
							rows="2" placeholder="대표 인사말을 입력하세요."></textarea>
					</div>

					<!-- 대표자명 -->
					<div class="form-group">
						<label class="hd1">대표자<span style="color: red;">*</span></label> <input
							type="text" name="represent" value="${LoginUser.memName}"
							class="form-control" style="width: 250px" readonly>
					</div>

					<!-- Select -->
					<div class="form-group">
						<label class="hd1">주 활동지역<span style="color: red;">*</span></label><br />
						<select name="location" class="custom-select select-big mb-3"
							style="float: left; width: 25%;">
							<option value="서울특별시">서울특별시</option>
							<option value="인천광역시">인천광역시</option>
							<option value="대전광역시" selected>대전광역시</option>
							<option value="세종특별자치시">세종특별자치시</option>
							<option value="대구광역시">대구광역시</option>
							<option value="부산광역시">부산광역시</option>
							<option value="울산광역시">울산광역시</option>
							<option value="광주광역시">광주광역시</option>
							<option value="경기도">경기도</option>
							<option value="충청북도">충청북도</option>
							<option value="충청남도">충청남도</option>
							<option value="전라북도">전라북도</option>
							<option value="경상북도">경상북도</option>
							<option value="경상남도">경상남도</option>
							<option value="제주도특별자치시">제주도특별자치시</option>
						</select> <input type="text" name="metPlace" class="form-control"
							placeholder="상세활동장소를 입력하세요"
							style="float: left; width: 75%; height: 45.52px;">
					</div>

					<!-- <div class="col-md-6"> -->
					<!-- custom checkbox -->
					<label class="mt-3 hd1">활동주제 <span style="color: red;">*</span>
						(※가장 적합한 1개의 주제를 선택하세요)
					</label>
					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="home"
							class="custom-control-input" id="home" onclick="check_only(this)" />
						<label class="custom-control-label" for="home">가정/육아</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="health"
							class="custom-control-input" id="health"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="health">건강/뷰티</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="business"
							class="custom-control-input" id="business"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="business">경제/경영</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="education"
							class="custom-control-input" id="education"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="education">교육</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="literature"
							class="custom-control-input" id="literature"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="literature">문학</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="social"
							class="custom-control-input" id="social"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="social">사회과학</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="IT"
							class="custom-control-input" id="IT" onclick="check_only(this)" />
						<label class="custom-control-label" for="IT">IT/개발</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="leisure"
							class="custom-control-input" id="leisure"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="leisure">여가생활</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="history"
							class="custom-control-input" id="history"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="history">역사</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="art"
							class="custom-control-input" id="art" onclick="check_only(this)" />
						<label class="custom-control-label" for="art">예술/대중문화</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="foreign"
							class="custom-control-input" id="foreign"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="foreign">외국어/외국문학</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="child"
							class="custom-control-input" id="child"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="child">아동/청소년</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="humanity"
							class="custom-control-input" id="humanity"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="humanity">인문학</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="selfimprove"
							class="custom-control-input" id="selfimprove"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="selfimprove">자기계발</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="natural"
							class="custom-control-input" id="natural"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="natural">자연/과학</label>
					</div>

					<div class="custom-control custom-checkbox mr-sm-2">
						<input type="radio" name="keyword" value="computer"
							class="custom-control-input" id="computer"
							onclick="check_only(this)" /> <label
							class="custom-control-label" for="computer">컴퓨터/인터넷</label>
					</div>
					<br /> <label class="mt-3 hd1">대표이미지</label>

					<div class="form-group">
						<input type="file" class="form-control-file" name="metImg">

					</div>

					<br> <br>
					<!-- post way -->
					<div class="text-center text-md-left align-self-center">
						<h5 class="m-0">
							<b>※독서모임은 관리자의 승인 후 활동 가능합니다.</b>
						</h5>
					</div>
					<br>
					<section>
						<div class="text-center text-md-center mt-md-0 align-self-center ">
							<input type="submit" value="등록" class="btn btn-grad"
								onclick="return meetingCheck()" style="margin: 0;">
							<button class="btn btn-grad mb-0" type="reset">다시작성</button>

							<input type="button" value="취소" id="cancel" class="btn btn-grad"
								style="margin: 0;" />

							<!-- <input type ="button" class="btn btn-outline-light mb-0" value="취소" onclick="location.href='meeting?command=meetingList'"> -->
						</div>
					</section>
				</form>
			</div>
		</div>
	</section>

	<!-- =======================
   Form -->

	<!-- =======================r
   footer  -->
	<%@ include file="../include/footer.jsp"%>
	<!-- =======================
   footer  -->

	<div>
		<a href="#" class="back-top btn btn-grad"><i class="ti-angle-up"></i></a>
	</div>

</body>

<script>
/* 내용 칸 글자 수 제한 스크립트 */
$(document).ready(function() {

	$('#metIntro').on('keyup', function() {

		if ($(this).val().length > 3000) {

			$(this).val($(this).val().substring(0, 3000));

		}

	});

});
/* 내용 칸 글자 수 보이기 */
$(function() {
	$('#metIntro').keyup(function(e) {
		var content = $(this).val();

		$('#counter').html(content.length + '/3000');
	});
	$('#content').keyup();
});

   $(document).ready(function() {
      $('#cancel').on("click", function(event) {
         var confirmStat = confirm("취소하시겠습니까?");

         if (confirmStat == true) {
            self.location = "/meeting?command=meetingList";
         } else {
            return false;
         }
      });

      $('.Message').on("click", function(event) {

      });
   });

   $(document).ready(function() {
      $('form').submit(function() {
         var result = alert("신청 되었습니다. 관리자 승인을 기다려주세요.");
         return result;
      })
   });
</script>
</html>