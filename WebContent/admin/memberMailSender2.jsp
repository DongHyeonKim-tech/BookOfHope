<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/adminheader.jsp"%>

<!-- Main content -->
<style>
.container {
  width: 70%;
  height: 70%;
  margin: 10px auto;
}
.outer {
  display: table;
  width: 100%;
  height: 100%;
}
.inner {
  display: table-cell;
  vertical-align: middle;
  text-align: center;
}
.centered {
  position: relative;
  display: inline-block;
 
  width: 50%;
}

 </style>
<script type="text/javascript" src="js/mailPopup.js"></script>
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

				
			
			<div class="box" >
			
				<div class="box-header with-border">
					<h3 class="box-title">회원정보 관리</h3>
				</div>
				<form name = "frm" method = "post" action = "email?command=senderEmail&email=${MemberVO.email}">
 				<div class="box-body">

<div> 

 <table class="table table-bordered" id="user-table">
	<thead>
	<tr><th colspan="5" style = "text-align: center;">메일 전송</th></tr>
	<tr>
	    <th style="width: 10px; text-align:center;"><input type = "checkbox" name = "AllCheck" ></th>
		<th style="width: 100px; text-align: center;">아이디</th>
		<th style="width: 100px;text-align: center;">이름</th>
		<th style="width: 100px;text-align: center;">이메일</th>
		<th style="width: 50px;text-align: center;">회원등급</th>
	</tr>
	</thead>

<c:forEach items="${memberList}" var="MemberVO" varStatus="listStat">
	<tbody>
	<tr style ="text-align:center;">
		<td><input type ="checkbox" value="${MemberVO.email}" name="email" id="email" ></td>
		<td>${MemberVO.memId}</td>
		<td>${MemberVO.memName}</td>
		<td>${MemberVO.email}</td>
 		<c:if test = "${MemberVO.authority eq '1'}"><td>일반회원</td></c:if>	
		<c:if test = "${MemberVO.authority eq '2'}"><td>기부회원</td></c:if>
		<c:if test = "${MemberVO.authority eq '3'}"><td>관리자</td></c:if> 
		
	</tr>
	</tbody>
</c:forEach>
</table> 
</div>
		    <button type = "button" class="btn btn-danger" onclick="sendEmailForm()" style = "float : right">메일전송</button> 
</div>
			 </form>

			<section class="pt-0">
		<div class="container">
		<div class="outer">
    <div class="inner">
    <div class="centered">
						<ul class="pagination justify-content-center">
						<c:if test="${paging.pageNum > 1}">
							<li class="page-item"><a class ="page-link" href="admin?command=senderEmailListFormAction&pageNum=${paging.pageNum - 1}">Prev</a></li>
						
							
						</c:if>	
							<c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="admin?command=senderEmailListFormAction&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
						
							<c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="admin?command=senderEmailListFormAction&pageNum=${paging.pageNum + 1}">Next</a></li>   
                                    </c:if>
							

						</ul>
			</div>
			</div>
			</div>
		</div>
	</section>
			</div>

		
			</div>
			
			
		</div> 
		<!--/.col (left) -->

	
	<!-- /.row -->
</section>
<!-- /.content -->
<!-- </div> -->
<!-- /.content-wrapper -->

<script>
// 올체크
 $("input[name=AllCheck]").click(function(){
	var chk = $(this).is(":checked");
	
	if(chk){
		$("input[name='email']").prop("checked", true);
	} else{
		$("input[name='email']").prop("checked", false);
	}
});

function sendEmailForm(){

	 var total_cnt=0;
	 var email = new Array();
	 $('input:checkbox[name = "email"]').each(function(){
		 if(this.checked){
			 email[total_cnt] = this.value;
			 total_cnt++;
		 }
	 });
	 
	 
     var popUrl ="/admin?command=mailPopupForm&email="+email;
     var popOption = "width=650px, height=550px, resizable=no, location=no, top=300px, left=300px;"
        
        window.open(popUrl,"메일전송폼 ",popOption);    
 }

    </script>
<script type="text/javascript">
   $(document).ready(function(){
	   if($('.send').trigger('click'))
		$('.treevie ').addClass("active");
	    $('#m2').attr('style','gray;')
	}); 
</script>

<%@include file="../include/adminfooter.jsp"%>