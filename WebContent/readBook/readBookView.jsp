<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>${readBook.bookName}</title>
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
<style>

video {
width:70%
}
h4 {
	font-weight: bold;
}

</style>
<script type="text/javascript"
   src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   $(document)
         .ready(
               function() {

                  $('#delete')
                        .on(
                              "click",
                              function(evt) {

                                 var confirmStat = confirm("정말로 삭제하시겠습니까?");

                                 if (confirmStat == true) {
                                    var readBookNo = $(
                                          '#readBookNo').val();
                                    alert("삭제되었습니다.");
                                    self.location = "/readBook?command=readBookDelete&readBookNo=${readBook.readBookNo}";
                                 } else {
                                    return false;
                                 }

                              });

                  $('.Message').on("click", function(readBook) {

                  });
               });
</script>

<script type="text/javascript">
   $(window).resize(function() {
      resizeYoutube();
   });
   $(function() {
      resizeYoutube();
   });
   function resizeYoutube() {
      $("iframe").each(
            function() {
               if (/^https?:\/\/www.youtube.com\/embed\//g.test($(this)
                     .attr("src"))) {
                  $(this).css("width", "100%");
                  $(this)
                        .css(
                              "height",
                              Math
                                    .ceil(parseInt($(this).css(
                                          "width")) * 480 / 854)
                                    + "px");
               }
            });
   }
</script>



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
					<h1 class="innerpage-title">우리대전 같은 책읽기</h1>
					<h6 class="subtitle">희망의 책 대전본부</h6>
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
      <div class="container">
         <div class="row">
            <div class="col-sm-12 mb-5">
              
               <h4 class="text-center mb-4">우리대전 같은 책읽기 </h4><br>
               
               <div class="col-md-12" align="right">
                  <c:if test="${LoginUser.authority eq 3}">
                     <a href="#" id="btn_share01" onclick="snsSubmit('facebook', '');">
                        <img
                        src="https://res.heraldm.com/nbiz_2016/images/h_biz_icon_sns_1.jpg"
                        alt="페이스북" height="20" width="20">
                     </a>
                  </c:if>
               </div>
               <form name="frm" method="post"
                  action="/readBook?command=readBookUpdateForm">
                  <input type="hidden" name="readBookNo"
                     value="${readBook.readBookNo}">
                  <div class="table-responsive-sm">
                     <table class="table table-hover">

                        <tr>
                           <th scope="col">선정도서</th>
                           <td>${readBook.bookName}</td>
                           
                           <th>출판연도</th>
                           <td>${readBook.publishDate}</td>

                        </tr>
                        <tr>
                           <th scope="col">출판사</th>
                           <td>${readBook.publisher}</td>
                           
                           <th >작가</th>
                           <td>${readBook.writer}</td>
                        </tr>

                        <tr>
                           <th scope="col">첨부파일</th>
                           <td><a
                              href='/readBook?command=fileDownloadAction&file_name=${readBook.readBookFile}'>${readBook.readBookFile}</a></td>
                           <th></th>
                           <td></td>
                        </tr>
                        <tr>
                           <th scope="col">관련기사</th>
                           <td><a href='${readBook.articleURL}' target="_blank">${readBook.articleURL}</a></td>
                           <th></th>
                           <td></td>
                        </tr>
                        
                     </table>
                     
                     <div class="col-md-12">
                        <div align="center">
                           <%--파일 업로드 사진일 경우 사진이 보이도록 설정 --%>
                           <c:if test="${!empty readBook.readBookFile}">
                              <c:forTokens var="token" items="${readBook.readBookFile}"
                                 delims="." varStatus="status">
                                 <c:choose>
                                    <c:when
                                       test="${token eq 'jpg' || token eq 'JPG' || token eq 'gif' || token eq 'GIF' || token eq 'png' || token eq 'PNG' || token eq 'bmp' || token eq 'BMP' }">
                                    
                                       <img data-dz-thumbnail=""
                                          class="avatar-sm rounded bg-light"
                                          src="/displayFile?fileName=${readBook.readBookFile}"
                                          width="500" height="500">
                                    </c:when>

                                    <c:when
                                       test="${token eq 'mp4' || token eq 'avi' || token eq 'flv' || token eq 'wmv' || token eq 'mov' }">
                                    
                                       <video oncontextmenu="return false;" id="readBookFile"
                                           controls >
                                          <source src="/displayFile?fileName=${readBook.readBookFile}" type="video/mp4">
                                       </video>
                                    </c:when>
                                    <c:otherwise>
                                    </c:otherwise>
                                 </c:choose>
                              </c:forTokens>
                           </c:if>
                           <c:if test="${empty readBook.readBookFile}">
                           </c:if>
                        </div>
                     </div>

                     <br>
                     <div class="col-md-12" align="center">


                        <%-- <iframe width="1150" height="800" src="${readBook.articleURL}" frameborder="0"></iframe> --%>
                        <%-- <iframe  src="${readBook.articleURL}" width="500" height="500"></iframe> --%>

                        <%-- <video src="${readBook.articleURL}" poster="${readBook.articleURL}"></video> --%>
                        <%-- <c:if test="${!empty readBook.articleURL}">
                           <h6>
                              관련 보도 자료 패이지로 이동하기: <a href="${readBook.articleURL}"
                                 target="_blank">${readBook.articleURL}</a>
                           </h6>
                        </c:if> --%>

                        <c:if test="${!empty readBook.videoURL}">
                           <embed src="https://www.youtube.com/embed/${readBook.videoURL}" style="width: 100%"
                              height="400px"></embed>
                           <h6>
                              동영상 페이지로 이동하기: <a href="https://www.youtube.com/embed/${readBook.videoURL}" target="_blank">https://www.youtube.com/embed/${readBook.videoURL}</a>
                           </h6>
                        </c:if>
                     </div>
<div class="col-md-12">
                        <span class="form-group"> <textarea cols="40" rows="15"
                              name="readBookContents" class="form-control"
                              readonly="readonly" style="background: white; border: 1px;">${readBook.readBookContents}</textarea>
                        </span>

                     </div>
                     <div class="col-md-12">
                        <br>
                        <c:if test="${LoginUser.authority eq 3}">
                           <div align="right">
                              <input type="submit" value="수정" class="btn btn-grad">
                              <input type="button" value="삭제" id="delete"
                                 class="btn btn-grad"> <input type="button" value="목록"
                                 class="btn btn-grad"
                                 onclick="location.href='/readBook?command=readBookList'">
                           </div>
                        </c:if>

                        <c:if test="${LoginUser.authority ne 3}">
                           <div align="right">
                              <input type="button" value="목록" class="btn btn-grad"
                                 onclick="location.href='/readBook?command=readBookList'">
                           </div>
                        </c:if>
                     </div>
                  </div>
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