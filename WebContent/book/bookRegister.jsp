<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	   
<!DOCTYPE html>
<html lang="en">
<head>
<title>책 등록</title>
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
<script type="text/javascript" src ="/js/book.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
  
   <header>
      <%@ include file="../include/header.jsp"%>
   </header>

   

   <div class="innerpage-banner center bg-overlay-dark-7 py-7"
      style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
      <div class="container">
         <div class="row all-text-white">
            <div class="col-md-12 align-self-center">
              <h1 class="innerpage-title">책 등록</h1>
					<h6 class="subtitle">회원들이 원하는 책이 없으면 책을 등록하세요.</h6>
               <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                     <li class="breadcrumb-item active"><a href="/main?command=loginForm"><i
                           class="ti-home"></i>Home</a></li>
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
            <div class="col-md-4">
	<form name ="frm" method ="post" action="book">
	<input type = "hidden" name = "command" value="bookRegister">
    <input type ="hidden" name = "memNum" value = "${LoginUser.memNum}">
               <div class="form-group">
                  <label>제목</label> <input class="form-control" type="text" name = "bookTitle"
                     placeholder="* 제목을 입력하세요.">
               </div>
               
               <div class="form-group">
                  <label>ISBN</label> <input class="form-control" type="text" name = "isbn"
                     placeholder="* ISBN번호를 입력하세요.">
               </div>
               
               
               <div class="form-group">
                  <label>저자</label> <input class="form-control" type="text" name = "writer"
                     placeholder="* 저자를 입력하세요.">
               </div>
               
               <div class="form-group">
                  <label>키워드</label> <input class="form-control" type="text" name = "bookKeyword1"
                     placeholder="* 키워드를 입력하세요.">
                     <input class="form-control" type="text" name = "bookKeyword2"
                     placeholder=" 키워드를 입력하세요.">
                     <input class="form-control" type="text" name = "bookKeyword3"
                     placeholder=" 키워드를 입력하세요.">
               </div>
               
               <div class="form-group">
                  <label>출판사</label> <input class="form-control" type="text" name = "publisher"
                     placeholder="* 출판사를 입력하세요.">
               </div>
               
               <input type ="submit" class ="btn btn-grad" onclick="return bookCheck()" value="등록">
               <button type = "button" class="btn btn-grad" onclick="location.href='book?command=bookList'">취소</button>
         </form>
            </div>
         
         </div>
         
      </div>
   </section>
<script>
$(document).ready(function(){
	$('form').submit(function(){
 	  var result = alert("등록되었습니다.");
   
	   return result;
	})
	})
</script>

   <%@ include file="../include/footer.jsp"%>
</body>
</html>