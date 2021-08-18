<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>희망의 책 공지사항</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Webestica.com">
	<meta name="description" content="Creative Multipurpose Bootstrap Template">

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
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 mb-5">
					<h5 class="text-center mb-4">공지사항 상세보기</h5>
					<form name="frm" method="post" action="/notice?command=noticeUpdateFormAction">
					<input type="hidden" name="noticeNum" value="${notice.noticeNum }">
					<div class="table-responsive-sm">
						<table class="table table-hover">
							
								<tr>
									<th scope="col">제목</th>
									<td>${notice.noticeTitle}</td>
									<th>작성일</th>
									<td>${notice.noticeDate }</td>
									
								</tr>
								<tr>
									<th scope="col">작성자</th>
									<td>관리자</td>
									<th>조회수</th>
									<td>${notice.noticeCount}</td>
									
								</tr>
								<tr>
									<th scope="col">첨부파일</th>
									<td><a href='/notice?command=fileDownloadAction&file_name=${notice.noticeFile}'>${notice.noticeFile}</a></td>
									<th></th>
									<td></td>
								</tr>
								 <%-- <tr>
								
									<th scope="col">내용</th>
									<td><textarea name="noticeContent" class="form-control" rows="10" style="width:100%;" disabled="disabled">${notice.noticeContent}</textarea></td> 
									<th></th>
									<td></td>
								</tr>  --%>
								
						</table> 
						<div class="col-md-12"><span class="form-group"><textarea cols="40" rows="10"  name="noticeContent" class="form-control" >${notice.noticeContent}</textarea></span></div>
							
						<div align="right">
							<input type="submit" value="수정" class="btn btn-primary" >
							<input type="button" value="삭제" class="btn btn-primary" onclick="location.href='/notice?command=noticeDeleteAction&noticeNum=${notice.noticeNum}'">
							<input type="button" value="돌아가기" class="btn btn-primary" onclick="location.href='/notice?command=noticeListFormAction'">
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</section>

<%@ include file="../include/footer.jsp"%>
</body>
</html>