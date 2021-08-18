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
					<h3 class="box-title">이달의 책 관리</h3>
				</div>
				<form name="frm" id="frm" method="post"
					action="/admin?command=todayBookDelete">
					<div class="box-body">

						<div>

							<table class="table table-bordered" id="user-table">
								<thead>
									<tr>
										<th colspan="4" style="text-align: center;">이달의책 목록</th>
									</tr>
									<tr>
										<th style="width: 10px; text-align: center;"><input
											type="checkbox" name="AllCheck"></th>
										<th style="width: 100px; text-align: center;">제목</th>
										<th style="width: 100px; text-align: center;">저자</th>
										<th style="width: 100px; text-align: center;">출판사</th>
									</tr>
								</thead>

								<c:forEach items="${bookBrdList}" var="bookBrdList">
									<tbody>
										<tr style="text-align: center;">
											<td><input type="checkbox"
												value="${bookBrdList.bookBrdNum}" name="bookBrdNum"></td>
											<td><a
												href="book?command=adminTodayBookUpdateFormAction&bookBrdNum=${bookBrdList.bookBrdNum}"
												target="_blank">${bookBrdList.bookBrdTitle}</a></td>
											<td>${bookBrdList.writer}</td>
											<td>${bookBrdList.publisher}</td>

										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
						<button type="submit" id="btn" class="btn btn-danger"
							style="float: right">삭제</button>
						<a class="btn btn-success" id="btn" style="float: right"
							type="button" href="/book?command=adminTodayBookRegFormAction">글쓰기</a>

					</div>
				</form>
				<section class="pt-0">
					<div class="container">
						<div class="outer">
							<div class="inner">
								<div class="centered">
									<ul class="pagination justify-content-center">
										<c:if test="${paging.pageNum > 1}">
											<li class="page-item"><a class="page-link"
												href="admin?command=todayBookList&pageNum=${paging.pageNum - 1}">Prev</a></li>


										</c:if>
										<c:forEach begin="${paging.firstPage}"
											end="${paging.lastPage}" var="idx">

											<c:choose>
												<c:when test="${idx == paging.pageNum}">
													<li class="page-item active"><span
														class="page-link bg-grad">${idx}</span></li>
												</c:when>

												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="admin?command=todayBookList&pageNum=${idx}">${idx}</a></li>
												</c:otherwise>

											</c:choose>
										</c:forEach>

										<c:if test="${paging.numOfPage != paging.pageNum}">
											<li class="page-item"><a class="page-link"
												href="admin?command=todayBookList&pageNum=${paging.pageNum + 1}">Next</a></li>
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
	$("input[name=AllCheck]").click(function() {
		var chk = $(this).is(":checked");

		if (chk) {
			$("input[name='bookBrdNum']").prop("checked", true);
		} else {
			$("input[name='bookBrdNum']").prop("checked", false);
		}
	});

	$("#btn").click(function(btn) {
		btn.preventDefault();
		if (!confirm('정말로 삭제하시겠습니까?'))
			return;
		$('#frm')[0].submit();
		alert('삭제되었습니다.')
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if ($('.book').trigger('click'))
			$('.tree ').addClass("active");
		$('#m5').attr('style', 'gray;')
		$('#m7').attr('style', 'gray;')
		$('#m10').attr('style', 'gray;')
	});
</script>
<%@include file="../include/adminfooter.jsp"%>