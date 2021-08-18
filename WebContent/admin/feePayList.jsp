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
			<!-- general form elements -->

				
			
			<div class="box" >
			
				<div class="box-header with-border">
					<h3 class="box-title">후원 관리</h3>
				</div>
				<form name = "frm" id="frm" method = "post" action = "">
				<div class="box-body">

<div>

 <table class="table table-bordered" id="user-table">
	<thead>
	<!-- <tr><th colspan="6" style = "text-align: center;">후원 관리</th></tr> -->
	<tr>
		<th style="width: 10px; text-align: center;"></th>
		<th style="width: 20px; text-align: center;">이름</th>
		<th style="width: 20px;text-align: center;">이메일</th>
		<th style="width: 100px;text-align: center;">전화번호</th>
		<!-- <th style="width: 100px;text-align: center;">우편번호</th> -->
		<th style="width: 50px;text-align: center;">소속</th>
		<th style="width: 50px;text-align: center;">직급</th>
		<!-- <th style="width: 50px;text-align: center;">메세지</th> -->
		<th style="width: 20px;text-align: center;">은행</th>
		<th style="width: 50px;text-align: center;">계좌번호</th>
		<th style="width: 50px;text-align: center;">금액</th>
		<th style="width: 50px;text-align: center;">후원방식</th>
		<th style="width: 50px;text-align: center;">예금주</th>
		
	</tr>
	</thead>

<c:forEach var="feePayList" items="${feePayList}" varStatus="status">
                        <tr style ="text-align:center;">
                           <td>${status.count}</td>
                           <td>${feePayList.payName}</td>
                           <td>${feePayList.payEmail}</td>
                           <td>${feePayList.payMobileNumber}</td>
                           <%-- <td>${feePayList.payZipcode}</td> --%>
                           <td>${feePayList.payAttach}</td>
                           <td>${feePayList.payPosition}</td>
                           <%-- <td>${feePayList.payMessage}</td> --%>
                           <td>${feePayList.payBank}</td>
                           <td>${feePayList.payBankNum}</td>
                           <td>${feePayList.payFee}</td>
                           <td>${feePayList.paySponsor}</td>
                           <td>${feePayList.bankName}</td>
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
							<li class="page-item"><a class ="page-link" href="admin?command=feePaymentList&pageNum=${paging.pageNum - 1}">Prev</a></li>
						
							
						</c:if>	
							<c:forEach begin="${paging.firstPage}"
                                       end="${paging.lastPage}" var="idx">
                                       
                                       <c:choose>
                                          <c:when test="${idx == paging.pageNum}">
                                             <li class="page-item active"> <span class="page-link bg-grad">${idx}</span></li>
                                          </c:when>
                       
                                          <c:otherwise>
                                             <li class="page-item"><a class ="page-link"
                                                href="admin?command=feePaymentList&pageNum=${idx}">${idx}</a></li>
                                          </c:otherwise>
                                          
                                       </c:choose>
                                    </c:forEach>
						
							<c:if test="${paging.numOfPage != paging.pageNum}">
                                    <li class="page-item"><a class = "page-link" href="admin?command=feePaymentList&pageNum=${paging.pageNum + 1}">Next</a></li>   
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
     	    $('#m8').attr('style','gray;')
     	}); 
</script>

<%@include file="../include/adminfooter.jsp"%>