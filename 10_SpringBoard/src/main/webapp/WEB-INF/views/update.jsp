<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- script문 작성 시, 추가하는 거 잊지말기 -->
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<h2>${board.writer }님의 게시글 수정</h2>
<input type="hidden" name="num" value=${board.num }/>
<form action="bUpdate" method="post">
<table>		

<tr>
<th>제목 : </th>
<td><input type="text" name="title" value=${board.title }></td></tr>

<tr>
<th>작성자 : </th>
<td><input type="text" size="20" name="writer" value=${board.writer } readonly="readonly"></td></tr>

<tr>
<th>내용 : </th>
<td><textArea rows="5" cols="40" name="content">${board.content }</textArea></td></tr>

<tr>
<th>비밀번호 : </th>
<td><input type="password" size="20" name="password" value=${board.password }></td></tr>

<tr>
<td colspan="2">
<input type="submit" value="수정하기">
<input type="reset" value="취소"></td></tr>

</table>		
</form>
</body>
</html>