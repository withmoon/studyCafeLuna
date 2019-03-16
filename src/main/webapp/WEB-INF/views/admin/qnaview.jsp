<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
</head>
<%@include file="../admin/footer.jsp" %>
   <br>
   <br>
   <br>
   <div class="container">
   <h4>글상세</h4>
      <form name="form2" action="qnaupdate.ado" method="POST">
         <table class="table table-bordered">
            <tbody>
               <tr>
                  <th>제목:</th>
                  <td><input type="text" name="subject" placeholder="subject" id="subject"
                     value="${num.subject}" class="form-control" />
                     <input type="hidden" name="num" value="${num.num}" />
                  </td>
               </tr>

               <tr>
               
                  <th>내용:</th>
                  <td><textarea cols="5" placeholder="content " id="content"
                        name="content" class="form-control" rows="20">${num.content}</textarea></td>
               </tr>

               <tr>
               <td colspan="2"><input type="submit" id="update" value="수정" class="btn btn-primary pull-right" /> 
                <input type="button" value="삭제"
                     class="btn btn-primary pull-right" onclick="javascript:location.href='qnadelete.ado?num=${num.num}'" /></td>
               </tr>
            </tbody>
         </table>
      </form>
   </div>


   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
 
</body>
</html>