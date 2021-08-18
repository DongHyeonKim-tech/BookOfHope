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
span {
	color: black;
	
}

h4 {
	font-weight: bold;
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

ul {
	list-style: none;
	padding-left: 0px;
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
					<h6 class="subtitle">대전의 작가들을 소개합니다.</h6>
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


			<form name="frm" method="post" role='form'
				action="writer?command=adminWriterRegister"
				enctype="multipart/form-data">
				<div class="row">
					<div class="col-lg-12">
						<!-- bookNum을 히든으로 처리를 하지 않으면 검색에서 값을 가져오지 못함. -->
						<input type="hidden" name="writerNo">
						<%-- <input type ="hidden" name = "memNum" value = "${LoginUser.memNum}">  --%>




						<h4 class="text-center mb-4">대전 작가 등록</h4>
						<br>
						<div class="row">
							<div class="form-group col-md-6">
								<span class="form-group">작가 이름<span style="color: red;">*</span></span><input
									type="text" name="writerName" placeholder="*작가 이름을 입력하세요"
									class="form-control">
							</div>
							<div class="form-group col-md-6">
								<span class="form-group">가입 협회 </span><input type="text"
									name="association" placeholder="가업 협회를 입력하세요"
									class="form-control">
							</div>
						</div>


						<div class="row">
							<div class="col-md-12" style="min-height: 480px;">
								<span class="form-group">작가 설명 </span>
								<div class="wrap">
									<textarea cols="40" rows="20" name="writerContents"
										id="writerContents" class="form-control"
										placeholder="내용을 입력하세요. 글자 수는 1500자로 제한됩니다."></textarea>
									<span id="counter">###</span>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="form-group col-md-12">
								<span class="form-group">대표작 <span style="color: red;">*</span>
								</span><input type="text" name="writerBook1"
									placeholder="저술한 도서 제목을 입력하세요" class="form-control">
							</div>
							<div class="form-group col-md-12">
								<span class="form-group">대표작 (선택) </span> <input type="text"
									name="writerBook2" placeholder="저술한 도서 제목을 입력하세요"
									class="form-control">
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<span class="form-group">대표작 (선택) </span> <input type="text"
									name="writerBook3" placeholder="저술한 도서 제목을 입력하세요"
									class="form-control">
							</div>
							<div class="form-group col-md-12">
								<span class="form-group">대표작 (선택)</span> <input type="text"
									name="writerBook4" placeholder="저술한 도서 제목을 입력하세요"
									class="form-control">
							</div>

							<div class="form-group col-md-12">
								<span class="form-group">대표작 (선택)</span> <input type="text"
									name="writerBook5" placeholder="저술한 도서 제목을 입력하세요"
									class="form-control">
							</div>

						</div>







						<!-- 
						<div class="form-group">
							<label>작가 이름</label> <input class="form-control" type="text"
								name="writerName" placeholder="*작가 이름을 입력하세요">

						</div>

						<div class="form-group">
							<label>가입 협회</label> <input class="form-control" type="text"
								name="association" placeholder="기업 협회를 입력하세요">

						</div>


						<div class="form-group">
							<label>도서 제목 </label> <input class="form-control" type="text"
								name="writerBook1" placeholder="저술한 도서 제목을 입력하세요"> <input
								class="form-control" type="text" name="writerBook2"
								placeholder="저술한 도서 제목을 입력하세요"> <input
								class="form-control" type="text" name="writerBook3"
								placeholder="저술한 도서 제목을 입력하세요"> <input
								class="form-control" type="text" name="writerBook4"
								placeholder="저술한 도서 제목을 입력하세요"> <input
								class="form-control" type="text" name="writerBook5"
								placeholder="저술한 도서 제목을 입력하세요">
						</div> -->



						<!-- 업로드 시작-->

						<div class="form-group">
							<input type="file" class="form-control-file" name="imgPath">

						</div>


						<div class="alert">
							<h3>첨부파일</h3>
							<div class="fileDrop">
								<span>이미지를 업로드하려면 여기에 </span><br> <span>이미지 파일을(jpg,
									png)을 끌어 넣거나</span><br> <label for="fileUpload"><b>여기</b></label>를
								클릭해주세요
							</div>
							<input type="file" id="fileUpload" style="display: none;">
							<input type="hidden" id="uploadCount"> <br>
						</div>
						<hr>
						<div>
							<ul class="mailbox-attachments clearfix uploadedList"></ul>
						</div>



						<!--업로드 끝  -->
						<div align="right">

							<input type="submit" class="btn btn-grad"
								onclick="return writerCheck()" value="등록">
							<button type="button" class="btn btn-grad"
								onclick="location.href='writer?command=writerList'">취소</button>
						</div>



					</div>

				</div>
			</form>

		</div>
	</section>










	<%@ include file="../include/footer.jsp"%>
</body>
<script type="text/javascript" src="/resources/js/fileinput.js"></script>
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template" type="text/x-handlebars-template">
<li class="dropzone-previews mt-3">
<div class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
<div class="p-2">
<div class="row align-items-center">
 <div class="col-auto">
    <img data-dz-thumbnail="" class="avatar-sm rounded bg-light" src="{{imgsrc}}" style="white: 200px; height:200px; ">
 </div>
 <div class="col pl-0">
   <a href="/displayFile?fileName={{fullName}}" text-muted font-weight-bold" data-dz-name="">{{fileName}} </a>
 </div>
 <div class="col-auto">
   <a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn"><i class="fas fa-trash-alt"></i>
</a>
 </div>
</div>
</div>
</div>
</li>                 
</script>


<script>

	$(document)
			.ready(
					function() {
						var formObj = $("form[role='form']");

						formObj.submit(function(event) {
									event.preventDefault();
									//유효성 검사
										var that = $(this);

										var str = "";

										$(".uploadedList .delbtn").each(
												
												/* function checkImageType(fileName){
													var pattern = /jpg&|gif$|png$|jpeg$/1;
													
													return fileName.match(pattern);
												} */
												
										function(index) {
															str += "<input type='hidden' name='files'"
																	+ " value='"
																	+ $(this).attr("href")
																	+ "'> ";
																	
															 /* if(checkImageType(data)){
															str = "<div>"
															+"<img src='displayFile?fileName="+data"'/>"
																	+data+"</div>"
														}  */
										});

										//that에다가 담아주는 부분 필요
										that.append(str);
										/* alert(str); */
										
										that.get(0).submit();

								});

						$(".btn-cancel")
								.on(
										"click",
										function() {
											self.location = "shop.do?action=list&page=${cri.page}&perPageNum=${cri.perPageNum}"
													+ "&searchType=${cri.searchType}&listType=${cri.listType}&keyword=${cri.keyword}";
										});

					});

	
	var template = Handlebars.compile($("#template").html());
	
	$('#mydropzone').click(function(event) {

		document.frm.fileUpload.click();

	});

	
/* function checkImageType(fileName){
		var pattern = /jpg&|gif$|png$|jpeg$/1;
		
		return fileName.match(pattern);
	}  */
	
	//dragenter dragover, drop 기본 동작 막기(기본적인 이벤트 처리 제한 preventDefault) 끌어다 놓으면 새로운 창이 열리는 동작
	 $(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
	}); 
	

	$(".fileDrop").on("drop", function(event) {
		event.preventDefault();

		var uploaded = $("#uploadCount").val();
		
	    //event.dataTransfer=이벤트와 같이 전달된 데이터   
	    //dataTransfer.files= 그안 에 포함된 전달된 파일 데이터를 찾아 가져오는 부분
	    //jQuery를 이용하는 경우 envent가 순수한 DOM 이벤트가 아니기때문에 
		var files = event.originalEvent.dataTransfer.files;
		console.log(files);
		var file = files[0];

	    //formData를 이용한 서버 호출 (기존 <form>태그로 만든 데이터 전송방식과 동일)
		var formData = new FormData();

	    //file 이름으로 파일 객체 추가
		formData.append("file", file);
	    
	    console.log(formData.get('file'));
		
	    //$.post()를 사용하지 않고 $.ajax() 사용하는 대신 processData,contentType: false로 지정
		$.ajax({
			url : '/uploadAjax',
			data : formData,
			dataType : 'text',
			processData : false, //데이터를 자동 변환 할 것인지(true:일반적인 query string / false:자동 변환 없이)
			contentType : false, //기본값(true) application/urlcod 타입으로 전송 / 파일의 경우(false) multipart/form_data 방식으로 전송
			type : 'POST',
			success : function(data) {

				var fileInfo = getFileInfo(data);
				var html = template(fileInfo);

				var str = "";
				
				/* if(checkImageType(data)){
					str = "<div>"
					+"<img src='displayFile?fileName="+data"'/>"
							+data+"</div>"
				} */

				
				
				$(".uploadedList").append(html);

				uploaded++;
				$("#uploadCount").attr("value", uploaded);

				$(".uploadedList").append(str);
			}
		});
	});

	//클릭으로 파일 업로드할 때 호출되는 함수
	$("#fileUpload").on("change", function(event) {
		event.preventDefault();
		
		var uploaded = $("#uploadCount").val();

		

		// 파일업로드 인풋에서 파일을 받음
		//document.getElementById 
		//주어진 문자열과 일치하는 id 속성을 가진 요소를 찾고, 이를 나타내는 Element 객체를 반환
		var file = document.getElementById("fileUpload").files[0];
		// 새로운 폼데이터를 생성
		var formData = new FormData();

		// 폼데이터에 파일을 붙임
		formData.append("file", file);

		// AJAX로 uploadAjax 메소드를 호출해서 파일을 업로드함
		$.ajax({
			url : '/uploadAjax',
			data : formData,
			dataType : 'text',
			processData : false,
			contentType : false,
			type : 'POST',
			success : function(data) {

				var fileInfo = getFileInfo(data);
				var html = template(fileInfo);

				var str = "";
				
				

				$(".uploadedList").append(html);

				uploaded++;
				$("#uploadCount").attr("value", uploaded);

				$(".uploadedList").append(str);
			}
		});
	});
	//첨부파일 삭제 처리
	$(".uploadedList").on("click", ".delbtn", function(event) {
		event.preventDefault();

		var that = $(this);
		var uploaded = $("#uploadCount").val();

		$.ajax({
			url : "/deleteFile",
			type : "post",
			data : {
				fileName : $(this).attr("href")
			},
			dataType : "text",
			success : function(result) {

				if (result == 'deleted') {

					that.closest("li").remove();
					uploaded--;
					$("#uploadCount").attr("value", uploaded);

				}
			}

		});

	});
	//파일링크 처리(길이를 줄여줌)
	function getOriginalName(fileName) {

		if (checkImageType(fileName)) {
			return;
		}

		var idx = fileName.indexOf("_") + 1;
		return fileName.substr(idx);

	}
	//이미지파일 원본 파일 찾기
	function getImageLink(fileName) {

		if (!checkImageType(fileName)) {
			return;
		}
		//fileName.substring(0,12)/년/월/일 경로 추출  
	    //fileName.substring(14) 파일 이름앞의 's_'제거
		var front = fileName.substr(0, 12);
		var end = fileName.substr(14);

		return front + end;

	}
	

</script>


</html>