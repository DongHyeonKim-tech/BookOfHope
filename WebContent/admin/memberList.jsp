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

ul.tabs {
    margin: 0;
    padding: 0;
    float: left;
    list-style: none;
    height: 32px;
    border-bottom: 1px solid #eee;
    border-left: 1px solid #eee;
    width: 100%;
    font-family:"dotum";
    font-size:12px;
}
ul.tabs li {
    float: left;
    text-align:center;
    cursor: pointer;
    width:82px;
    height: 31px;
    line-height: 31px;
    border: 1px solid #eee;
    border-left: none;
    font-weight: bold;
    background: #fafafa;
    overflow: hidden;
    position: relative;
}
ul.tabs li.active {
    background: #FFFFFF;
    border-bottom: 1px solid #FFFFFF;
}
.tab_container {
    border: 1px solid #eee;
    border-top: none;
    clear: both;
    float: left;
    width: 1250px; 
    background: #FFFFFF;
}
.tab_content {
    padding: 5px;
    font-size: 12px;
    display: none;
}
.tab_container .tab_content ul {
    width:100%;
    margin:0px;
    padding:0px;
}
.tab_container .tab_content ul li {
    padding:5px;
    list-style:none
}
;
 #container {
    width: 249px;
    margin: 0 auto;
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

<div id="container">
    <ul class="tabs">
        <li class="active" rel="tab1">기부회원</li>
        <li rel="tab2">일반회원</li>
    </ul>
    <div class="tab_container">
        <div id="tab1" class="tab_content">
        
        <table class="table table-bordered" id="user-table">
			<thead>
			<tr><th colspan="6" style = "text-align: center;">회원정보</th></tr>
			
			<tr>
			    <th style="width: 10px; text-align:center;"><input type = "checkbox" name = "donationCheck"></th>
				<th style="width: 100px; text-align: center;">아이디</th>
				<th style="width: 100px;text-align: center;">이름</th>
				<th style="width: 100px;text-align: center;">이메일</th>
				<th style="width: 100px;text-align: center;">가입일</th>
				<th style="width: 50px;text-align: center;">회원등급</th>
			</tr>
			</thead>
		
		<c:forEach items="${donation}" var="MemberVO" varStatus="status">
			<tbody >
			<tr style ="text-align:center;">
				<td><input type ="checkbox" value="${MemberVO.memNum}" name="memNum" id="donationMemberCheck${status.count}"></td>
				<td>${MemberVO.memId}</td>
				<td>${MemberVO.memName}</td>
				<td>${MemberVO.email}</td>	
				<td>${MemberVO.signDate}</td>
				<c:if test = "${MemberVO.authority eq '2'}"><td id="donation">기부회원</td></c:if>
				
			</tr>
			</tbody>
		</c:forEach>
	</table> 
        
        
        
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
        
        
        
        
        <!-- #tab2 -->
        <div id="tab2" class="tab_content">
         <table class="table table-bordered" id="user-table">
			<thead>
			<tr><th colspan="6" style = "text-align: center;">회원정보</th></tr>
			<tr>
			    <th style="width: 10px; text-align:center;"><input type = "checkbox" name = "Check"></th>
				<th style="width: 100px; text-align: center;">아이디</th>
				<th style="width: 100px;text-align: center;">이름</th>
				<th style="width: 100px;text-align: center;">이메일</th>
				<th style="width: 100px;text-align: center;">가입일</th>
				<th style="width: 50px;text-align: center;">회원등급</th>
			</tr>
			</thead>
		
		<c:forEach items="${memberList}" var="Member" varStatus="status">
			<tbody >
			<tr style ="text-align:center;">
				<td><input type ="checkbox" value="${Member.memNum}" name="memNum" id="memberCheck${status.count}"></td>
				<td>${Member.memId}</td>
				<td>${Member.memName}</td>
				<td>${Member.email}</td>	
				<td>${Member.signDate}</td>
		 		<c:if test = "${Member.authority eq '1'}"><td id="member">일반회원</td></c:if>	
				
			</tr>
			</tbody>
		</c:forEach>
		</table> 
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
        <!-- #tab2 -->
    </div>
    <!-- .tab_container -->
</div>
<!-- #container -->

</div>
		    <button type = "submit" id = "btn" class="btn btn-danger" style = "float : right">삭제</button> 
</div>
			</form>
			<section class="pt-0">
		<div class="container">
		<div class="outer">
    <div class="inner">
    <%-- <div class="centered">
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
			</div> --%>
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

$(function () {

    $(".tab_content").hide();
    $(".tab_content:first").show();

    $("ul.tabs li").click(function () {
        $("ul.tabs li").removeClass("active").css("color", "#333");
        //$(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
        $(this).addClass("active").css("color", "darkred");
        $(".tab_content").hide()
        var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn()
    });
});

</script>

<script>

$("input[name=Check]").click(function(){
	
 	var checkCount = $("input[name='memNum']").length
 	
 	for (var count = 0; count < $("input[name='memNum']").length; count++) {
		
 	$("#donationMemberCheck"+count).prop("disabled", true);
 	
	}
 
 	
	var chk = $(this).is(":checked");
	
	if(chk){
		$("input[name='memNum']").prop("checked", true);
	} else{
		$("input[name='memNum']").prop("checked", false);
	}
}); 

// 올체크

 $("input[name=donationCheck]").click(function(){
		
	 	var checkCount = $("input[name='memNum']").length
	 	
	 	for (var count = 0; count < $("input[name='memNum']").length; count++) {
			
	 	$("#memberCheck"+count).prop("disabled", true);
	 	
		}
	 
	 	
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
		alert('삭제되었습니다.')
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