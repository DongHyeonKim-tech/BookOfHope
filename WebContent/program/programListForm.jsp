<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Webestica.com">
<meta name="description"
   content="Creative Multipurpose Bootstrap Template">

<script>
   document.getElementsByTagName("html")[0].className += " js";
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="../assets/css/style2.css">
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
<title>프로그램</title>
</head>
<body style="text-align: center;">


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
               <h1 class="innerpage-title">2020 책잔치 한마당</h1>
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
            <div class="col-sm-12 mb-5" >
     
     

   <div class="responsive-iframe-container">
      <iframe class="iframe_computer" src="https://calendar.google.com/calendar/embed?height=700&amp;wkst=1&amp;bgcolor=%23ffffff&amp;ctz=Asia%2FSeoul&amp;src=ZGpib29rMTExQGdtYWlsLmNvbQ&amp;color=%23039BE5&amp;showTabs=1&amp;showPrint=0&amp;showDate=1&amp;showNav=1&amp;showTitle=0" style="border-width:0" width="1300" height="800" frameborder="0" scrolling="no"></iframe>
      <iframe class="iframe_mobile" src="https://calendar.google.com/calendar/embed?height=500&amp;wkst=1&amp;bgcolor=%23ffffff&amp;ctz=Asia%2FSeoul&amp;src=ZGpib29rMTExQGdtYWlsLmNvbQ&amp;color=%23039BE5&amp;showTitle=0&amp;showNav=1&amp;showTabs=0&amp;mode=AGENDA&amp;showDate=1&amp;showPrint=0&amp;showCalendars=0&amp;showTz=1" style="border:solid 1px #777" width="500" height="500" frameborder="0" scrolling="no"></iframe>
   </div>

                  <!-- .cd-schedule -->
   <!--   ["이소영","Microsoft Korea","지속 성장과 성장 마인드셋","15:00","17:00", "<자기소개> 하루에 조금씩 딥러닝에 대해 알아가고, 제가 조금이나마 알고 있는 것들을 공유하는 것이 소소한 기쁨입니다.", "<연락처 & sns>", "https://i.ibb.co/yd4Jdy0/1.png", "<발표 소개>ex.협업 필터링 방법을 이용해서 간단한 추천시스템을 구축하는 방법을 소개하려고 합니다.",'월'], -->
         </div>
            </div>
         </div>
      </div>
   </section>
   

   <%@ include file="../include/footer.jsp"%>
</body>
<script>
   window.onload = function() { 
      if( screen.width <= 480 ) {
         // mobile
         document.getElementsByClassName('iframe_computer')[0].hidden = true;
         document.getElementsByClassName('iframe_mobile')[0].hidden = false;
      }
      else{
         // computer or pad
         document.getElementsByClassName('iframe_computer')[0].hidden = false;
         document.getElementsByClassName('iframe_mobile')[0].hidden = true;
      }
   };
</script>
</html>