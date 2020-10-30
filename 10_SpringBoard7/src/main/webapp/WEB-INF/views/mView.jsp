<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h2>회원정보 변경</h2>
<div class="container-fluid">
<form action="join" method="post">
	<div class="form-group">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id" disabled="disabled" value="${member.id}">
	</div>
	<div class="form-group">
		<label for="id">비밀번호</label>
		<input type="password" name="pass" id="pass" value="${member.pass}">
	</div>
	<div class="form-group">
		<label for="id">성명</label>
		<input type="text" name="name" id="name" value="${member.name}">
	</div>
	<div class="form-group">
		<label for="id">주소</label>
		<input type="text" name="addr" id="addr" value="${member.addr}">
	</div>
	<div class="form-group">
		<label for="id">메모</label>
		<textarea rows="5" cols="25" name="memo" id="memo" >${member.memo}</textarea>
	</div>
	<div class="form-group">
		<input type="button" id="updateBtn" name="updateBtn" value="수정" class="btn btn-primary">
		<input type="reset" value="취소" class="btn btn-secondary">
	</div>
</form>
</div>
</body>
</html>