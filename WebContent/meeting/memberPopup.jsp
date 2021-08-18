<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8">

<title> 모임가입 </title>

	<!-- Favicon -->
	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700" rel="stylesheet">

	<!-- Plugins CSS -->
	<link rel="stylesheet" type="text/css" href="assets/vendor/font-awesome/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/vendor/themify-icons/css/themify-icons.css" />
	<link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.min.css" />
 
	<!-- Theme CSS -->
	<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
</head>
<body>
<!-- =======================
   Banner innerpage -->
	<div class="innerpage-banner center bg-overlay-dark-7 py-7" style="background:url(../assets/images/bg/04.jpg) no-repeat; background-size:cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">${meetingVo.metName}</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href=""><i class="ti-home"></i>회원 리스트</a></li>
						</ol>
					</nav>
				</div>	
			</div>
		</div>
	</div>
   <!-- =======================
   Banner innerpage -->

		<div class="container">
         <div class="row">
            <div class="col-sm-12 mb-5">
               <h5 class="text-center mb-4"></h5> 
               <div class="table-responsive-sm">
                  <table class="table table-hover">
                  
                     <thead>
                        <tr>
                        	<th scope="col">번호</th>
                           <th scope="col">아이디</th>
                           <th scope="col">이름</th>
                           <th scope="col">가입일</th>
                          <th scope="col">추방여부</th>
                        </tr>
                     </thead>
                     
                     <tbody>
                     <!-- varStatus를 통해서 책번호를 만든다. -->
                     <c:forEach var="memList" items="${memList}" varStatus="var">
                        <tr>
                           <th scope="row">${var.count}</th>
                           <td>${memList.memId}</td>
                           <td>${memList.memName}</td>
                           <td>${memList.joinDate}</td>
                           <td><a href="/meeting?command=meetingMemberDelete&memNum=${memList.memNum}&metNum=${meetingVo.metNum}">
                           <button type = "button" class="btn btn-danger">추방</button></a>
                        </tr>
     				</c:forEach>
					
                     </tbody>
                    
                  </table>
                 
             	 <div align="right">

              <%-- <button type="button" onclick="javascript:opener.location.href='/meeting?command=meetingHome&memNum=${memList.memNum}&metNum=${meetingVo.metNum}';self.close();" class="btn btn-grad" >취소</button> --%>
			<!-- <input type="button" value="Refresh Page" onClick="window.location.reload()"> -->
			<button type="button" onclick="goBack()" class="btn btn-grad" >취소</button>
                  </div>
               </div>
            </div>
         </div>
      </div>
		<!-- container -->
	<script src='{% static "js/jquery-1.11.3.min.js" %}'></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	
<script>

function goBack(){
	window.opener.location.reload();
	window.close();
}

</script>


</body>
</html>