<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@include file="include/header.jsp" %>     
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>

</style>
<title>Insert title here</title>
</head>
<body>
<!--  <script src="/board/resources/Board.js">  -->
<!-- </script> -->
<form method="post" action="bInsert">

<table style="margin:20px">

	<tr>
	<td align="center">작성자</td>
	<td><input type="text" name="writer" id="writer" maxlength="50">
	</tr>
	
	<tr>
	<td align="center">제목</td>						
	<td><input type="text" name="title" id="title" maxlength="100"></td>
	</tr>
	
	<tr>
	<td align="center">내용</td>
	<td><textArea rows="5" cols="40" id="content" name="content"></textArea>
	</tr>
	
	<tr>
	<td align="center">비밀번호</td>
	<td><input type="password" name="password" id="password" maxlength="50" >
	
	</tr>
	

	<tr>
	<td colspan="2">
	<br>
		
	<input type="submit" value="입력" id="submit"></td>
	</tr>
	
</table>
</form>
 <br><br>


</body>
</html>