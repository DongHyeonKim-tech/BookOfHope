<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title> 메일전송 </title>

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
	<h3>메일 전송</h3>
		<div class="container">
		<input type = "hidden" id="email" name = "email" value = "${email}">
		
		<div class="form mt-4">
					<div>
					<p class="text-left mb-2">제목</p>
					<span class="form-group"><input type ="text" name = "subject" id = "subject" class="form-control"/></span>
							</div>
							<p></p>
							<div class ="wrap">
					내용 <span> <textarea name = "body" id = "body" class="form-control"></textarea></span>
					</div>
					<div>
					<button type="button" name="ajax" id="send" onclick="sendMessage();" class="btn btn-black">발송</button>
					<button type="button" onclick="goBack()" class="btn btn-black" >취소</button>
					</div>
		</div>
		
		</div>
		<!-- container -->
	<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<script>
	function sendMessage(){
		var email = $("#email").val();
		var subject = $("#subject").val();
		var body = $("#body").val();
	
		$.ajax({
			url : '/email?command=senderEmail',
			type : 'post',
			data : {subject : subject,
					body : body,
					email : email},
			success : function(data){
				alert("메일 전송을 성공했습니다.");
				 self.close();
			}
		});
	}
	
	function goBack() {
	    self.close();
	}


	</script>

</body>
</html>