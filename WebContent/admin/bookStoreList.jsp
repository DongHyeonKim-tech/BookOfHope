<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/adminheader.jsp"%>
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
<!-- Main content -->


<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

				
			
			<div class="box">
			
				<div class="box-header with-border">
					<h3 class="box-title">회원정보 관리</h3>
				</div>
				<form name = "frm" id ="frm" method = "post" action = "admin?command=memberDelete">
				<div class="box-body">

<div>

 <table class="table table-bordered" id="user-table">
	<thead>
	<tr><th colspan="6" style = "text-align: center;">회원정보</th></tr>
	<tr>
	    <th style="width: 10px; text-align:center;"><input type = "checkbox" name = "AllCheck" ></th>
		<th style="width: 100px; text-align: center;">아이디</th>
		<th style="width: 100px;text-align: center;">이름</th>
		<th style="width: 100px;text-align: center;">이메일</th>
		<th style="width: 100px;text-align: center;">가입일</th>
		<th style="width: 50px;text-align: center;">회원등급</th>
	</tr>
	</thead>

<c:forEach items="${memberList}" var="MemberVO">
	<tbody >
	<tr style ="text-align:center;">
		<td><input type ="checkbox" value="${MemberVO.memNum}" name="memNum" ></td>
		<td>${MemberVO.memId}</td>
		<td>${MemberVO.memName}</td>
		<td>${MemberVO.email}</td>	
		<td>${MemberVO.signDate}</td>
 		<c:if test = "${MemberVO.authority eq '1'}"><td>일반회원</td></c:if>	
		<c:if test = "${MemberVO.authority eq '2'}"><td>기부회원</td></c:if>
		<c:if test = "${MemberVO.authority eq '3'}"><td>관리자</td></c:if> 
		
	</tr>
	</tbody>
</c:forEach>
</table> 
</div>
		    <button type = "submit" id = "btn" class="btn btn-danger" style = "float : right">삭제</button> 
</div>
			</form>
			<section class="pt-0">
		<div class="container">
		<div class="outer">
    <div class="inner">
    <div class="centered">
						<ul class="pagination justify-content-center">
						<c:if test="${paging.pageNum > 1}">
							<li class="page-item"><a class ="page-link" href="admin?command=memberListForm&pageNum=${paging.pageNum - 1}">Prev</a></li>
						
							
						</c:if>	
							<c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="admin?command=memberListForm&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
						
							<c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="admin?command=memberListForm&pageNum=${paging.pageNum + 1}">Next</a></li>   
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
		$("input[name='memNum']").prop("checked", true);
	} else{
		$("input[name='memNum']").prop("checked", false);
	}
}); 

 $("#btn").click(function(btn){
		btn.preventDefault();
		if(!confirm('정말로 삭제하시겠습니까?')) return;
		$('#frm')[0].submit();
	});   
     
 
    </script>
    
    <script type="text/javascript">
   $(document).ready(function(){
	   if($('.member').trigger('click'))
		$('.treevie ').addClass("active");
	    $('#m1').attr('style','gray;')
	}); 
</script>

<%@include file="../include/adminfooter.jsp"%>