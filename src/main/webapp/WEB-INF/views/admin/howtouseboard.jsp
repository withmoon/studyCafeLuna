<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/admin/css/footer.css"/>"> <!-- 메뉴 -->
<script src="<c:url value="/resources/admin/howtouse/js/howtouse.js"/>"></script>
<title>게시판 목록</title>

</head>
<%@include file="../admin/footer.jsp" %>
   <div align="center">
      <h3>이용가이드</h3>
   </div>
   <br></br>
   <div  id="listForm" class="container">
      <div class="row">
         <table class="table table-striped"
            style="text-align: center; border: 1px solid #dddddd">
            <tbody>
            <c:if test="${fn:length(htulist) eq 0}">
           	 	<tr><td>아직 올린글이 없습니다.</td></tr>
            </c:if>
             <c:if test="${fn:length(htulist) ne 0}">
            <c:forEach var="htulist" items="${htulist}">
            	 <tr>
              		<td><a href="showHowToUse.do?num=${htulist.num}">${htulist.title}</a></td>
              		<td><a href="deleteHowToUse.do?num=${htulist.num}" >삭제</a></td>
             	</tr>
   			</c:forEach>
   			</c:if>
            </tbody>
            <tfoot>
           	<tr><td align="right"><button onclick="showWriteForm()">글쓰기</button></td></tr>
            </tfoot>
         </table>
      </div>
   </div>


   <div hidden="true" id="writeForm" class="container">
    <form name="form" action="insertHowToUse.do" onsubmit="return setVal()" method="POST" enctype="multipart/form-data">
    <input type="hidden" id="maxCnum" name="maxCnum" value=""/>
         <table class="table table-bordered">
         <thead>
         	 <tr>
               <th>제목:</th>
        		<td colspan="2"><input class="formtx" size="120" type="text" name="title" placeholder="제목"/></td>
        	</tr>
         </thead>
            <tbody>
               <tr class="form0">
               <th>내용:</th>
               <td>
               <textarea id="content0" name="content0" class="formtx" cols="110" rows="5"></textarea>
             	</td>
             	<td align="center" rowspan="2"><input type="button"  onclick="addWriteForm()" value="추가"/></td>
               </tr>
               <tr class="form0">
                  <th>파일:</th>
                  <td><input class="formtx" type="file" name="file" placeholder="file" id="file" class="form-control" ></td>
               </tr>
            </tbody>
            <tfoot>
            	<tr><td>
               <td colspan="3"><a href="javascript:cancleWrite()"  class="btn btn-primary pull-right">취소</a>&emsp;<input type="submit" id="update" value="글올리기" class="btn btn-primary pull-right" /> </td>
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