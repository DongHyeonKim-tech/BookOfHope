<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>${bookTalk.talkName}</title>
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
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#cancel')
								.on(
										"click",
										function(event) {
											self.location = "bookTalk?command=adminBookTalkList";
										});
						$('#delete')
								.on(
										"click",
										function(evt) {

											var confirmStat = confirm("정말로 삭제하시겠습니까?");

											if (confirmStat == true) {
												var talkNo = $('#talkNo').val();
												alert("삭제되었습니다.");
												self.location = "/bookTalk?command=bookTalkDeleteAction&talkNo=${bookTalk.talkNo}";
											} else {
												return false;
											}

										});

						$('.Message').on("click", function(event) {

						});
					});
</script>
<style>

h4 {
	font-weight: bold;
}

</style>

<body>
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	
	<!-- =======================
	Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">얼토당토 북토크</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a
								href="/main?command=loginForm"><i class="ti-home"></i> Home</a></li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
	Banner innerpage -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 mb-5">
					<h4 class="text-center mb-4">얼토당토 북토크</h4>
					<div class="col-md-12" align="right">
					<c:if test="${LoginUser.authority eq 3}">
					<a href="#" id="btn_share01" onclick="snsSubmit('facebook', '');">
					<img src="https://res.heraldm.com/nbiz_2016/images/h_biz_icon_sns_1.jpg" alt = "페이스북" width="20px" height="20px">
					</a>
					</c:if>
					</div>
					<form name="frm" method="post"
						action="/bookTalk?command=bookTalkUpdateFormAction">
						<input type="hidden" name="talkNo" value="${bookTalk.talkNo }">
						<div class="table-responsive-sm">
							<table class="table table-hover">

								<tr>
									<th scope="col">제목</th>
									<td>${bookTalk.talkName}</td>
									<th></th>
									<td></td>

									<th></th>
									<td></td>

								</tr>
								<tr>
									<th scope="col">저자</th>
									<td>${bookTalk.writer}</td>

									<th></th>
									<td></td>

									<th>출판사</th>
									<td>${bookTalk.talkPublisher}</td>

								</tr>
								<tr>
									<th scope="col">모임 일자</th>
									<td>${bookTalk.talkDate}</td>
									<th></th>
									<td></td>
									<th>장소</th>
									<td>${bookTalk.talkPlace}</td>


								</tr>

								<tr>
									<th scope="col">관련기사</th>
									<td><a href='${bookTalk.articleURL}'target="_blank">${bookTalk.articleURL}</a></td>
									<th></th>
									<td></td>
									<th></th>
									<td></td>
								</tr>


					
								<tr>
									<th scope="col">첨부파일</th>
									<td><a
										href='/bookTalk?command=fileDownloadAction&file_name=${bookTalk.talkFile}'>${bookTalk.talkFile}</a></td>
									<th></th>
									<td></td>
									<th></th>
									<td></td>
								</tr>
								<tr>
							</table>




							<div class="col-md-12">
								<span class="form-group"> <textarea cols="40" rows="12"
										name="talkContents" class="form-control" readonly="readonly"
										style="background: white; border: 1px;">${bookTalk.talkContents}</textarea>
								</span>
							</div>

							<div class="form-group col-md-12"
								style="width: 100%; ">
								<c:if test="${!empty bookTalk.videoURL}">
									<iframe id="vid_prv" width=100% height="500px"
									src="https://www.youtube.com/embed/${bookTalk.videoURL}"
									frameborder="0" gesture="media" allow="encrypted-media"
									allowfullscreen>
									</iframe>
									
								</c:if>
								
									
									
							</div>

							<div align="center">
								<%--파일 업로드 사진일 경우 사진이 보이도록 설정 --%>
								<c:if test="${!empty bookTalk.talkFile}">
									<c:forTokens var="token" items="${bookTalk.talkFile}"
										delims="." varStatus="status">
										<c:choose>
											<c:when
												test="${token eq 'jpg' || token eq 'JPG' || token eq 'gif' || token eq 'GIF' || token eq 'png' || token eq 'PNG' || token eq 'bmp' || token eq 'BMP' }">
												<div class="form-group">
													<label for="exampleInputEmail1" class="col-form-label">첨부파일<span
														class="must-mark">*</span></label>
												</div>
												<img data-dz-thumbnail="" class="avatar-sm rounded bg-light"
													src="/displayFile?fileName=${bookTalk.talkFile}"
													width="500" height="500">
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
									</c:forTokens>
								</c:if>
								<c:if test="${empty bookTalk.talkFile }">
								</c:if>
							</div>




						</div>	
						
						
				<c:if test="${LoginUser.authority eq 3}">
					<div align="right">
						<input type="submit" value="수정" class="btn btn-grad"> <input
							type="button" value="삭제" id="delete" class="btn btn-grad">
						<input type="button" value="목록" class="btn btn-grad"
							onclick="location.href='/bookTalk?command=bookTalkListFormAction'">
					</div>
				</c:if>

				<c:if test="${LoginUser.authority ne 3}">
					<div align="right">
						<input type="button" value="목록" class="btn btn-grad"
							onclick="location.href='/bookTalk?command=bookTalkListFormAction'">
					</div>
				</c:if>
						
						
						
						</form>
				</div>














			
			</div>

		</div>
	

	</section>
	<script type="text/javascript">
		var currentUrl = jQuery(location).attr('href');

		function snsSubmit(type, title) {

			if (type == "facebook") {
				sns.facebook(currentUrl, title);

			}
		}

		var sns = {

			facebook : function(link, title) {

				link = encodeURIComponent(link);
				title = encodeURIComponent(document.title);

				var url = 'http://www.facebook.com/sharer.php?u=' + link + '&t'
						+ title;
				window.open(url, '', 'width=360, height=400, lefit=600');

			}

		}
	</script>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>