<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/adminheader.jsp"%>
<style>
.container {
  width: 70%;
  height: 70%;
  margin: 10p
  x auto;
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
					<h3 class="box-title">모임 승인·거절</h3>
				</div>
				<form name = "frm" method = "post" action = "admin?command=meetingUpdate&metNum=${MeetingVO.metNum}">
				<div class="box-body">

<div>

 <table class="table table-bordered" id="user-table">
	<thead>
	<tr><th colspan="6" style = "text-align: center;">모임신청 명단</th></tr>
	<tr>
		<th style="width: 100px; text-align: center;">모임명</th>
		<th style="width: 100px;text-align: center;">대표자</th>
		<th style="width: 100px;text-align: center;">활동지역</th>
		<th style="width: 100px;text-align: center;">모임소개</th>
		<th style="width: 50px;text-align: center;">승인여부</th>
		
	</tr>
	</thead>

<c:forEach items="${metList}" var="MeetingVO">
<c:if test = "${MeetingVO.approval eq 'F'}">
	<tbody >
	<tr style ="text-align:center;">
		<td>${MeetingVO.metName}</td>
		<td>${MeetingVO.represent}</td>
		<td>${MeetingVO.metPlace}
		<td>${MeetingVO.metIntro}</td>
		<td style ="align:center;"><a href="/admin?command=meetingRefuseAction&metNum=${MeetingVO.metNum}"><button type = "button" class="btn btn-danger" style = "float : right" onclick="return confirm('거절하시겠습니까?');">거절</button></a>&nbsp;&nbsp;
		    <a href="/admin?command=meetingUpdate&metNum=${MeetingVO.metNum}&memNum=${MeetingVO.memNum}"><button type = "button" class="btn btn-primary" style = "float : right" onclick="return confirm('승인하시겠습니까?');">승인</button></a></td>
	</tr>
	</tbody>
	</c:if>
</c:forEach>
</table> 
</div>

</div>
			</form>
			<section class="pt-0">
		<div class="container">
		<div class="outer">
    <div class="inner">
    <div class="centered">
						<ul class="pagination justify-content-center">
						<c:if test="${paging.pageNum > 1}">
							<li class="page-item"><a class ="page-link" href="admin?command=meetingListForm&pageNum=${paging.pageNum - 1}">Prev</a></li>
						
							
						</c:if>	
							<c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="admin?command=meetingListForm&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
						
							<c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="admin?command=meetingListForm&pageNum=${paging.pageNum + 1}">Next</a></li>   
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
		$("input[name='metNum']").prop("checked", true);
	} else{
		$("input[name='metNum']").prop("checked", false);
	}
}); 

$(document).ready(function(){
$('form').submit(function(){
	var result = alert("승인되었습니다.");
	
	return result;
})
})
    
    </script>
    <script type="text/javascript">
   $(document).ready(function(){
	   if($('.meetingAc').trigger('click'))
		$('.treevi ').addClass("active");
	    $('#m4').attr('style','gray;')
	}); 
</script>

<%@include file="../include/adminfooter.jsp"%>