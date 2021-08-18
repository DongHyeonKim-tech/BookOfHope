<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>대전의 작가들</title>
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
<script type="text/javascript" src="/js/writer.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>


<style>
ul li {
	list-style-type: none;
	float: left;
}

#num {
	background-color: #4cbd89;
	color: white;
	font-size: 0.875rem;
	padding: 5px;
	margin-right: 10px;
	border-radius: 50%;
}

.row1 {
	margin-bottom: 2em;
	margin-top: 2em;
}

</style>


<body>

	<header>
		<%@ include file="../include/header.jsp"%>
	</header>


	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">대전의 작가들</h1>
					<h6 class="subtitle">${writer.writerName}작가님을소개합니다.</h6>

					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a
								href="/main?command=loginForm"><i class="ti-home"></i>Home</a></li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
   Banner innerpage -->




	<section>
		<div class="container h-100">
			<!-- admin의 WriterUpdateFormAction에 가도록 설정 -->
			<form name="frm" method="post"
				action="/writer?command=adminWriterUpdateFormAction">
				<div class="row">
					<input type="hidden" name="writerNo" value="${writer.writerNo}">
					<input type="hidden" name="memNum" value="${writer.memNum}">

					<div class="col-md-10 col-lg-6 mx-md-auto align-self-center "
						style="text-align: center;">

						<c:if test="${!empty writer.imgPath}">
							<img src="/displayFile?fileName=${writer.imgPath}" alt=""
								style="width: 300px; height: 400px; overflow: hidden;">
						</c:if>

						<c:if test="${empty writer.imgPath}">
							<img src="../resources/images/writer.png" alt=""
								style="width: 300px; height: 400px; overflow: hidden;">
						</c:if>



						<!-- <img class="rounded" src="https://i.ibb.co/2KCZwkB/Waysto-Give.jpg"  alt=""> -->
						<%-- <div class="position-absolute left-0 bottom-0 ml-4 ml-md-n2 mb-3">
						<a class="btn btn-dark" style="color: white;"> <i
							class="far fa-user"></i> ${writer.writerName}
						</a>
					</div> --%>
					</div>



					<div class="col-md-12 col-lg-6 align-self-center ">
						<div class="title text-left">

							<div class="col-11" style="margin-top: 8%">
								<h2>
									<span class="text-primary">${writer.writerName}</span>작가
								</h2>
							</div>


							<c:if test="${!empty writer.association}">

								<div class="col-11" style="margin-top: 8%">
									<h3 style="font-weight: bolder;">가입 협회</h3>${writer.association}
								</div>
							</c:if>


							<%-- <div class="col-11" style="margin-top: 8%">
							<h3 style="font-weight: bolder;">저서</h3>
						
						
						<div
							class="list-group-inline list-group-number list-unstyled mt-4" style="font-size: 20px;">
							<a class="list-group-item list-group-item-action"><span
								style="background-color: #4cbd89; color: white;">01</span>
								${writer.writerBook1}</a><br>
							<c:if test="${!empty writer.writerBook2}">
								<a class="list-group-item list-group-item-action"><span
									style="background-color: #4cbd89; color: white;">02</span>
									${writer.writerBook2}</a>
								<br>
							</c:if>
							
							 <c:if test="${!empty writer.writerBook3}">

								<a class="list-group-item list-group-item-action"><span
									style="background-color: #4cbd89; color: white;">03</span>
									${writer.writerBook3}</a>
								<br>
							</c:if>
							<c:if test="${!empty writer.writerBook4}">
								<a class="list-group-item list-group-item-action"><span
									style="background-color: #4cbd89; color: white;">04</span>
									${writer.writerBook4}</a>
								<br>
							</c:if>
							<c:if test="${!empty writer.writerBook5}">
								<a class="list-group-item list-group-item-action"><span
									style="background-color: #4cbd89; color: white;">05</span>
									${writer.writerBook5}</a>
								<br>
							</c:if> 
						</div> --%>
						</div>
					</div>
				</div>




				<c:if test="${!empty writer.writerContents}">
					<div class="row1">
						<div class="col-md-12 align-self-center ">
							<div class="card">
								<div class="card-body" style="padding: 0.5rem;">
									<textarea cols="40" rows="8" name="writerContents"
										class="form-control" readonly="readonly"
										style="font-weight: bolder; background: white; border: 1px;">${writer.writerContents}</textarea>


								</div>
							</div>

						</div>
					</div>
				</c:if>





				<div class="col-sm-12 mb-5">



					<h3 class="mb-4 text-primary" style="font-weight: bolder;">저서</h3>

					<div class="text-left " style="font-size: 20px; padding: 20 0 0 0;">
						<a class="list-group-item list-group-item-action"><span
							id="num">01</span> ${writer.writerBook1}</a><br>
						<c:if test="${!empty writer.writerBook2}">
							<a class="list-group-item list-group-item-action"><span
								id="num">02</span> ${writer.writerBook2}</a>
							<br>
						</c:if>

						<c:if test="${!empty writer.writerBook3}">

							<a class="list-group-item list-group-item-action"><span
								id="num">03</span> ${writer.writerBook3}</a>
							<br>
						</c:if>
						<c:if test="${!empty writer.writerBook4}">
							<a class="list-group-item list-group-item-action"><span
								id="num">04</span> ${writer.writerBook4}</a>
							<br>
						</c:if>
						<c:if test="${!empty writer.writerBook5}">
							<a class="list-group-item list-group-item-action"><span
								id="num">05</span> ${writer.writerBook5}</a>
							<br>
						</c:if>
					</div>








					<div style="text-align: center;">
						<div class="col-md-12 blog-grid blog-grid-4 portfolio-wrap"
							data-isotope='{ "itemSelector": ".post-item", "layoutMode": "fitRows" }'
							><!-- style="border:1px solid; padding-:10px;" -->
							<c:forEach items="${fileList}" var="fVo">
								<div class="post-item">
									<div class="post-item-wrap">
										<div class="post-image">
											<img src="/displayFile?fileName=${fVo.fileName}"
												style="width: 150px; height: 200px;">
										</div>
										 <span class="postt">&nbsp;</span>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<br>
					<br>













					<div align="right">
						<c:if
							test="${LoginUser.memNum eq writer.memNum or LoginUser.authority eq '3'}">
							<input type="submit" value="수정" class="btn btn-grad">
							<input type="button" value="삭제" id="delete" class="btn btn-grad">
						</c:if>
						<input type="button" value="목록" class="btn btn-grad" id="cancel">
					</div>

				</div>

			</form>
		</div>
		<!-- row end -->


	</section>


	<script>
		$(document)
				.ready(
						function() {
							$('#cancel').on("click", function(event) {
								self.location = "writer?command=writerList";
							});
							$('#delete')
									.on(
											"click",
											function(evt) {

												var confirmStat = confirm("삭제하시겠습니까?");

												if (confirmStat == true) {
													var writerNo = $(
															'#writerNo').val();
													alert("삭제되었습니다.");
													self.location = "writer?command=adminWriterDelete&writerNo=${writer.writerNo}";
												} else {
													return false;
												}

											});

							$('.Message').on("click", function(event) {

							});
						});
	</script>

	<%-- <section>
		<div class="container">
			<div class="row" >
			
			
				<div class="col-md-4" style="text-align: center;">

					<input type="hidden" name="writerNo" value="${writer.writerNo}">
					<input type ="hidden" name = "memNum" value = "${LoginUser.memNum}"> 
			
					<img src="/displayFile?fileName=${writer.imgPath}" alt=""
						style="width: 300px; height: 400px; overflow: hidden;">
				
				</div>
				<div class="col-md-6" style="color: #000000; text-align: center;">
				
				<div style="font-weight: bold; font-size: 2em;  color: #4cbd89; padding-bottom: 15px;">
				
		
					 ${writer.writerName}

				</div >
				<div style="font-weight: bold; font-size: 1.2em">

				<div style="padding-bottom: 15px;">
					<label>가입 단체</label> ${writer.association}
				</div>


				<div >
					<label>도서 제목 </label> 
					<ul  style="list-style-type:disc;">
					<li>${writer.writerBook1}
					</li>
					<li>${writer.writerBook2}
					</li>
					<li>${writer.writerBook3}
					</li>
					<li> ${writer.writerBook4}
					</li>
					<li> ${writer.writerBook5}
					</li>
					
</ul>


				</div>
				</div>
				</div>
				
				<div class="col-md-2" >
				</div>


			</div>

		</div>
	</section>
 --%>



	<%@ include file="../include/footer.jsp"%>
</body>
</html>