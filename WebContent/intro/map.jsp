<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>희망의 책 소개</title>
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

<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
 <script>
 function initialize() {

 /*
 http://openapi.map.naver.com/api/geocode.php?key=f32441ebcd3cc9de474f8081df1e54e3&encoding=euc-kr&coord=LatLng&query=서울특별시 노원구 섬밭로 258
 위의 링크에서 뒤에 주소를 적으면 x,y 값을 구할수 있습니다.
 */
 var Y_point = 36.323379; // Y 좌표
 var X_point = 127.424276; // X 좌표
 var zoomLevel = 17; // 첫 로딩시 보일 지도의 확대 레벨
 var markerTitle = "희망의 책 대전본부"; // 현재 위치 마커에 마우스를 올렸을때 나타나는 이름
 var markerMaxWidth = 300; // 마커를 클릭했을때 나타나는 말풍선의 최대 크기

 // 말풍선 내용
 var contentString = '<div id="content">' +
 '<div id="siteNotice">' +
 '</div>' +
 '<h4 id="firstHeading" class="firstHeading">대전 중구 대흥로 109</h4>' +
 '<div id="bodyContent">' +
 '<p>종합문화복지관 내<br />' +
 'Tel. 042) 488-6589</p>' +
 '</div>' +
 '</div>';

 var myLatlng = new google.maps.LatLng(Y_point, X_point);
 var mapOptions = {
 zoom: zoomLevel,
 center: myLatlng,
 mapTypeId: google.maps.MapTypeId.ROADMAP
 }
 var map = new google.maps.Map(document.getElementById('map_view'), mapOptions);

 var marker = new google.maps.Marker({
 position: myLatlng,
 map: map,
 title: markerTitle
 });

 var infowindow = new google.maps.InfoWindow(
 {
 content: contentString,
 maxWidth: markerMaxWidth
 }
 );

 google.maps.event.addListener(marker, 'click', function() {
 infowindow.open(map, marker);
 });
 }
 </script>
</head>
<body onload="initialize()">
	
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	
		<!-- ======================	Banner innerpage -->
			<div class="left bg-grad pattern-overlay-4">
				<div class="container">
					<div class="row all-text-white">
						<div class="col-md-12 align-self-center">
							<h1 class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n2 mt-9">찾아오시는 길</h1>
						</div>
					</div>
				</div>
			</div>
		<!-- ======================= Banner innerpage -->
		
		<!-- ======================= blog -->
			<section class="team social-hover team-overlay">
				<div class="container">
					<div class="row">
						<!-- sidebar start -->
						<aside class="col-md-3 sidebar order-last order-md-first">
							<!-- 인사말 -->
							<div class="widget">
								<h3 class="widget-title"><a href="/notice?command=introAction">인사말</a></h3>
							</div>
		
							<!-- 연혁 -->
							<div class="widget widget-newsletter">
								<h3 class="widget-title"><a href="/notice?command=timeLineAction">연혁</a></h3>
							</div>
		
							<!-- 조직도 -->
							<div class="widget widget-post">
								<h3 class="widget-title"><a href="/notice?command=teamAction">조직도</a></h3>
							</div>
		
							<!-- 찾아오시는 길 -->
							<div class="widget widget-post">
								<h3 class="widget-title">찾아오시는 길</h3>
							</div>
							
							<c:if test="${LoginUser.authority ne null}">
							<div class="widget widget-post">
								<h3 class="widget-title"><a  href="/notice?command=noticeListFormAction">운영게시판</a></h3>
							</div>
							</c:if>
							
						</aside>
						<!-- sidebar end -->
		
				<!-- ======================= Maps -->
		
						
						<!-- Google default iframe Map -->
						<div class="col-md-6">
							<h5>희망의 책 대전본부<br><br></h5>
							<div class="mapouter"><div class="gmap_canvas"><iframe width="550" height="450" id="gmap_canvas" src="https://maps.google.com/maps?q=%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C%EC%86%8C%ED%94%84%ED%8A%B8&t=&z=15&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://yt2.org"></a><br><style>.mapouter{position:relative;text-align:right;height:450px;width:550px;}</style><style>.gmap_canvas {overflow:hidden;background:none!important;height:450px;width:550px;}</style></div></div>
				</div>
			</section>
				
	<footer>
		<%@ include file="../include/footer.jsp"%>
	</footer>
	
	
	<!--Global JS-->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/popper.js/umd/popper.min.js"></script>
	<script src="assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Google Map -->
	<script src="assets/vendor/map/map.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCtF5lHSU7Y7c2BYl_c4-G9bSi44h1X9Ls"></script>

	<!--Template Functions-->
	<script src="assets/js/functions.js"></script>
</body>
</html>