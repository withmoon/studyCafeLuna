<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link href="<c:url value="/resources/admin/board/css/board.css"/>" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="<c:url value="/resources/admin/board/js/board.js"/>"></script>
<script src="<c:url value="/resources/util/js/paging.js"/>"></script>
<title>게시판 목록</title>


</head>



  <%@include file="../admin/footer.jsp" %>
   <div align="center">
      <h3>Q N A</h3>
   </div>
   <br></br>
   <div class="container">
      <div class="row">
      <form action="board.ado" method="post">
         <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
            <thead>
               <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성일</th>
               </tr>
            </thead>
            <tbody  id="inform_table"></tbody>
         </table>
         <ul id="informPaging"></ul>
         <a href="write.ado" class="btn btn-primary pull-right">글쓰기</a>
         </form>
      </div>
   </div>





   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
  
</body>
</html>