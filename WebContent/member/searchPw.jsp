<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title> 비밀번호 찾기 </title>

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
	<h3>비밀번호 찾기</h3>
		<div class="container">
		<input type="hidden" name="memPw" id="memPw" value="${memberList.memPw}">
		<div class="form mt-4">
					<div>
					<p class="text-left mb-2">아이디</p>
					<span class="form-group"><input type ="text" name = "memId" id = "memId" class="form-control"/></span>
							</div>
					<div>
					<p class="text-left mb-2">이름</p>
					<span class="form-group"><input type ="text" name = "memName" id = "memName" class="form-control"/></span>
					</div>
					<div>
					<p class="text-left mb-2">이메일</p>
					<span class="form-group"><input type ="text" name = "email" id = "email" class="form-control"/></span>
					</div>
					
					<div>
					<button type="button" name="ajax" id="send" onclick="searchPw()" class="btn btn-black" >찾기</button>
					<button type="button" onclick="goBack()" class="btn btn-black" >취소</button>
					</div>
		</div>
		
		</div>
		<!-- container -->
	<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<script>
	function searchPw(){
		var memPw = $("#memPw").val();
		var memName = $("#memName").val();
		var memId = $("#memId").val();
		var email = $("#email").val();
	
		$.ajax({
			url : '/member?command=searchPwAction',
			type : 'post',
			data : {memName : memName,
					memId : memId,
					email : email},
			success : function(data){
				alert("비밀번호는"+memPw+"입니다.");
			}
		});
	}
	
	function goBack() {
	    self.close();
	}
	</script>

</body>
</html>