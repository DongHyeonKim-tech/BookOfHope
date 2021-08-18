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
               <h3 class="box-title">운영게시판 관리</h3>
            </div>
            <form name="frm" id="frm" method="post"
               action="admin?command=noticeDelete">
               <div class="box-body">

                  <div>

                     <table class="table table-bordered" id="user-table">
                        <thead>
                           <tr>
                              <th colspan="5" style="text-align: center;">운영게시판 목록</th>
                           </tr>
                           <tr>
                              <th style="width: 10px; text-align: center;"><input
                                 type="checkbox" name="AllCheck"></th>
                              <th style="width: 100px; text-align: center;">제목</th>
                              <th style="width: 100px; text-align: center;">작성자</th>
                              <th style="width: 100px; text-align: center;">작성일자</th>
                              <!-- <th style="width: 50px;text-align: center;">회원등급</th> -->
                           </tr>
                        </thead>

                        <c:forEach items="${noticeList}" var="NoticeVO">
                           <tbody>
                              <tr style="text-align: center;">
                                 <td><input type="checkbox" value="${NoticeVO.noticeNum}"
                                    name="noticeNum"></td>
                                 <td><a
                                    href="/notice?command=noticeViewAction&noticeNum=${NoticeVO.noticeNum}"
                                    target="_blank">${NoticeVO.noticeTitle}</a></td>
                                 <td>
                                    <%-- ${NoticeVO.notice} --%>관리자
                                 </td>
                                 <td>${NoticeVO.noticeDate}</td>

                              </tr>
                           </tbody>
                        </c:forEach>
                     </table>
                  </div>
                  <button type="submit" id="btn" class="btn btn-danger"
                     style="float: right">삭제</button>
                  

                  <a class="btn btn-success" id="btn" style="float: right" type="button" 
                     href="/notice?command=noticeInsertFormAction">글쓰기</a>
               </div>
         
         </form>
         <!--/.col (left) -->


         <!-- /.row -->
         <section class="pt-0">
            <div class="container">
               <div class="outer">
                  <div class="inner">
                     <div class="centered">
                        <ul class="pagination justify-content-center">
                           <c:if test="${paging.pageNum > 1}">
                              <li class="page-item"><a class="page-link"
                                 href="/notice?command=noticeListForm&pageNum=${paging.pageNum - 1}">Prev</a></li>


                           </c:if>
                           <c:forEach begin="${paging.firstPage}" end="${paging.lastPage}"
                              var="idx">

                              <c:choose>
                                 <c:when test="${idx == paging.pageNum}">
                                    <li class="page-item active"><span
                                       class="page-link bg-grad">${idx}</span></li>
                                 </c:when>

                                 <c:otherwise>
                                    <li class="page-item"><a class="page-link"
                                       href="/notice?command=noticeListForm&pageNum=${idx}">${idx}</a></li>
                                 </c:otherwise>

                              </c:choose>
                           </c:forEach>

                           <c:if test="${paging.numOfPage != paging.pageNum}">
                              <li class="page-item"><a class="page-link"
                                 href="/notice?command=noticeListForm&pageNum=${paging.pageNum + 1}">Next</a></li>
                           </c:if>


                        </ul>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <!-- /.content -->
         <!-- </div> -->
         <!-- /.content-wrapper -->
      </div>
   </div>
   </div>
</section>
<script>
   // 올체크
   $("input[name=AllCheck]").click(function() {
      var chk = $(this).is(":checked");

      if (chk) {
         $("input[name='noticeNum']").prop("checked", true);
      } else {
         $("input[name='noticeNum']").prop("checked", false);
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
      if ($('.notice').trigger('click'))
         $('.tree ').addClass("active");
      $('#m6').attr('style', 'gray;')
      $('#m7').attr('style', 'gray;')
      $('#m10').attr('style', 'gray;')
   });
</script>

<%@include file="../include/adminfooter.jsp"%>