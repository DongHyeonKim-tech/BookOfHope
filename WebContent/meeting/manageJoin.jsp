<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>희망의 책 : 독서모임</title>
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
		
				<!-- ======================= Banner innerpage -->
				<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
					<div class="container">
						<div class="row all-text-white">
							<div class="col-md-12 align-self-center">
								<h1 class="innerpage-title"> ${meetingVo.metName} 독서모임 신청자 </h1>
								<h6 class="subtitle">다같이 만들어가는 독서모임</h6>
								<nav aria-label="breadcrumb">
									<ol class="breadcrumb">
										<li class="breadcrumb-item active"><a href="/main?command=loginForm"><i class="ti-home"></i> Home</a></li>
										<li class="breadcrumb-item"><a href="/meeting?command=manageHomeAction&metNum=${ meetingVo.metNum}">관리 홈</a></li>
									</ol>
								</nav>
							</div>
						</div>
					</div>
				</div>
				<!-- ======================= Banner innerpage -->
				
				
				<!-- ======================= portfolio -->
			<section class="portfolio pb-0">
				<div class="container">
					<div class="row">
						<div class="col-sm-12  p-0">
						
						
						<div class="table-responsive-sm">	
						<table class="table table-hover">
							<thead>
							
								<tr>
									<th style="width: 50px; text-align: center;">신청자 ID</th>
									<th style="width: 50px; text-align: center;">이름</th>
									<th style="width: 50px; text-align: center;">승인여부</th>
								</tr>
							</thead>
							<c:if test="${empty memList}">
								<tr>
									<th colspan="3" style="text-align: center; color: gray;">가입신청한 멤버가 없습니다.</th>
								</tr>
							</c:if>
							<c:forEach var="memList" items="${memList}">
								<c:if test="${memList.approval eq 'F'}">
									<input type="hidden" name="memNum" value="${memList.memNum}">
									<tr style="text-align: center;">
									<c:if test="${memList.metNum eq meetingVo.metNum}">
										<td>${memList.memId}</td>
										<td>${memList.memName}</td>
										<td>
											<a href="/member?command=approvalMeeting&memNum=${memList.memNum}&metNum=${meetingVo.metNum}">
											<button type="button" class="btn btn-primary btn-sm" onclick="alert('승인되었습니다.')">승인</button></a>&nbsp;&nbsp;
											<a href="/member?command=refuseMemberShip&memNum=${memList.memNum}&metNum=${meetingVo.metNum}">
											<button type="button" class="btn btn-danger btn-sm" onclick="alert('거절되었습니다.')">거절</button></a></td>
										</c:if>
									</tr>
								</c:if>
							</c:forEach>
						</table>
						</div>
					</div>
				</div>
			</div>
		</section>
			
		
		<footer>
			<%@ include file="../include/footer.jsp"%>
		</footer>

</body>
</html>