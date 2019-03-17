<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/resources/admin/howtouse/js/showhowtouse.js"/>"></script>
</head>
<%@include file="../admin/footer.jsp" %>
   <br>
   <br>
   <br>
  <div id="writeForm" class="container">
    <form name="form" id="form" action="insertHowToUse.do" onsubmit="setVal()" method="POST" enctype="multipart/form-data">
    <input type="hidden" id="maxCnum" name="maxCnum" value=""/>
         <table class="table table-bordered">
         <thead>
         	 <tr>
               <th>제목:</th>
        		<td colspan="2"><input disabled="disabled" id="ttid" class="formtx" size="120" type="text" name="title" value="${htuctlist.get(0).getTitle()}"/><input type="hidden" id="size" value="${size}"/>
        		  <input type="hidden" name="num" value="${htuctlist.get(0).getNum()}"/>
        		</td>
        	</tr>
         </thead>
    
            <tbody>
              <c:forEach var="htuctlist" items="${htuctlist}">
              	 <tr class="form">
               		<th>내용:</th>
               		<td>
              		 <textarea disabled="disabled" name="content${htuctlist.cnum}" class="formtx" cols="110" rows="5">${htuctlist.content}</textarea>
             		</td>
             		<td rowspan="2" align="center">
             			<input type="button"  onclick="delWriteForm(${htuctlist.cnum},${htuctlist.num})" value="삭제"/></td>
              	 </tr>
              	 <tr class="form" id="file">
                  	<th>파일:</th>
                 	 <td id="fimg${htuctlist.cnum}"><img style="width:800px; height:auto;" src="<c:url value="/resources/howtouseImg/${htuctlist.num}/${htuctlist.cnum-1}/${htuctlist.fname}"/>">
                 	 <input hidden="true" type="file" id="file" name="file"  style="display: none;"/>
                 	 <input class="imgBtns" hidden="true" id="upim${htuctlist.cnum}" type="button" onclick="updateImg(${htuctlist.cnum},${htuctlist.num})" value="수정"/>
                 	  <input hidden="true" id="imgCcBtn${htuctlist.cnum}" type="button" onclick="cancleUpImg(${htuctlist.cnum})" value="수정취소"/>
                 	 </td>
               	</tr>
               </c:forEach>
            </tbody>
            <tfoot>
            	<tr>
               <td colspan="3">
              		 <input hidden="true" type="button" id="addForm"  onclick="addWriteForm()" value="글추가"/>
               		<input type="button" value="수정하기" id="upBtn" onclick="updating()"/>
               		 <input hidden="true" id="upcnBtn" type="button" value="수정취소" onclick="cancleUp()"/>
               		<a href="howtouseboard.do"  class="btn btn-primary pull-right">목록으로 가기</a>
               		<a href="deleteHowToUse.do?num=${htuctlist.get(0).getNum()}"  class="btn btn-primary pull-right">삭제하기</a>
               </td>
               </tr>
            </tfoot>
         </table>
      </form>
   </div>


   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
   
</body>
</html>