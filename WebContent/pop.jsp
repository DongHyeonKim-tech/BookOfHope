<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="js/member.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title>지역서점과 함께 하는 2020 대전 책잔치 한마당</title>

<!-- css include -->
<link rel="stylesheet" type="text/css" href="css/materialize.css">
<link rel="stylesheet" type="text/css" href="css/icofont.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
<link rel="stylesheet" type="text/css"
	href="css/owl.theme.default.min.css">

<!-- my css include -->
<link rel="stylesheet" type="text/css" href="css/custom-menu.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />

</head>

<style>
body {
	padding: 0;
	margin: 0;
}

img {
	max-height: 100%;
}
</style>

<script>
	function goUrl(url) {
		opener.location.href = url;
		self.close();
	}
</script>


<body>
	<img src="../resources/images/2020book.jpg" alt="">

	<!-- container -->
	<div align="right" style="padding: 8px;">




		<a href="javascript:goUrl('/program?command=programListFormAction')"
			class="btn btn-success" type="btn" style="padding: 1px;"> 행사일정 상세보기</a>


		
		<a href='javascript:window.close();' type="btn" class="btn btn-dark" style="padding: 1px;">닫기</a>



	</div>




</body>
</html>