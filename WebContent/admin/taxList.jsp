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

<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<div class="box" >
			
				<div class="box-header with-border">
					<h3 class="box-title">영수증 신청 내역</h3>
				</div>
				<form name = "frm" id="frm" method = "post" action = "">
				<div class="box-body">

<div>

 <table class="table table-bordered" id="user-table">
	<thead>
	<tr>
		<th style="width: 10px; text-align: center;"></th>
		<th style="width: 10px; text-align: center;">이름</th>
		<th style="width: 20px;text-align: center;">전화번호</th>
		<th style="width: 30px;text-align: center;">이메일</th>
		<th style="width: 30px;text-align: center;">우편번호</th>
		<th style="width: 50px;text-align: center;">주소</th>
		<th style="width: 50px;text-align: center;">상세주소</th>
		<th style="width: 80px;text-align: center;">메세지</th>
		
	</tr>
	</thead>

<c:forEach var="taxList" items="${taxList}">
                        <tr style ="text-align:center;">
                           <td>${taxList.taxNum}</td>
                           <td>${taxList.taxName}</td>
                           <td>${taxList.taxPhone}</td>
                           <td>${taxList.taxEmail}</td>
                           <td>${taxList.taxAdr1}</td>
                           <td>${taxList.taxAdr2}</td>
                           <td>${taxList.taxAdr3}</td>
                           <td>${taxList.taxMsg}</td>
                        </tr>
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
							<li class="page-item"><a class ="page-link" href="admin?command=taxList&pageNum=${paging.pageNum - 1}">Prev</a></li>
						
							
						</c:if>	
							<c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="admin?command=tax
                                                List&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
						
							<c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="admin?command=taxList&pageNum=${paging.pageNum + 1}">Next</a></li>   
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

<script type="text/javascript">
        $(document).ready(function(){
     	   if($('.fee').trigger('click'))
     		$('.treev ').addClass("active");
     	    $('#m9').attr('style','gray;')
     	}); 
</script>

<%@include file="../include/adminfooter.jsp"%>