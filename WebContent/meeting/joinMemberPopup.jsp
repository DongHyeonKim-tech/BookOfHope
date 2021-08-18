<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title> 모임가입 </title>

	<!-- Favicon -->
	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700" rel="stylesheet">

	<!-- Plugins CSS -->
	<link rel="stylesheet" type="text/css" href="assets/vendor/font-awesome/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/vendor/themify-icons/css/themify-icons.css" />
	<link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.min.css" />
 
	<!-- Theme CSS -->
	<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
</head>
<body>
<!-- =======================
   Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							
						</ol>
					</nav>
				</div>	
			</div>
		</div>
	</div>
   <!-- =======================
   Banner innerpage -->
		<div class="container">
		<div class="col-md-5 align-self-center" style="margin-top:7%;">
		<input type = "hidden" id="memNum" name = "memNum" value = "${LoginUser.memNum}">
		<input type = "hidden" id="memName" name = "memName" value = "${LoginUser.memName}">
		<input type = "hidden" id="memId" name = "memId" value = "${LoginUser.memId}">
		<input type = "hidden" id="metNum" name = "metNum" value = "${meetingVo.metNum}">
		<table class="table table-hover">
								<tr>
									<th scope="col">이름</th>
									<td>${LoginUser.memName}</td>
								</tr>

								<tr>
									<th>아이디</th>
									<td>${LoginUser.memId}</td>
								</tr>
								
								
		</table>
			<div class="text-center text-md-center mt-md-0 align-self-center" style="margin-top:7%;">
					<button type="button" name="ajax" id="send" onclick="sendMessage()" class="btn btn-grad" >가입</button>
					<button type="button" onclick="goBack()" class="btn btn-grad" >취소</button>
			</div>
		</div>
		</div>
		<!-- container -->
	<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	

</body>

<script>
	function sendMessage(){
		var memNum = $("#memNum").val();
		var metNum = $("#metNum").val();
		var memName = $("#memName").val();
		var memId = $("#memId").val();
	
		$.ajax({
			url : '/meeting?command=joinMeetingAction',
			type : 'post',
			data : {memNum : memNum,
					metNum : metNum,
					memName : memName,
					memId : memId},
			success : function(data){
				alert("신청되었습니다.");
				 self.close();
				opener.parent.location.reload();
				
			}
		});
	}
	function goBack(){
		self.close();
	}
	
	</script>
</html>