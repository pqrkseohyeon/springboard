<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<div class="container-fluid">
<form action="join" method="post">
	<div class="form-group">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id">
		<button  type="button"  id="idcheckBtn"  class="btn btn-primary">중복확인</button>
	</div>
	<div class="form-group">
		<label for="id">비밀번호</label>
		<input type="password" name="pass" id="pass">
	</div>
	<div class="form-group">
		<label for="id">성명</label>
		<input type="text" name="name" id="name">
	</div>
	<div class="form-group">
		<label for="id">주소</label>
		<input type="text" name="addr" id="addr">
	</div>
	<div class="form-group">
		<label for="id">메모</label>
		<textarea rows="5" cols="25" name="memo" id="memo"></textarea>
	</div>
	<div class="form-group">
		<input type="button" id="joinBtn" name="joinBtn" value="가입" class="btn btn-primary">
		<input type="reset" value="취소" class="btn btn-secondary">
	</div>
</form>
</div>

<script>
$(function(){
	//아이디 중복확인 버튼
	$("#idcheckBtn").on("click", function(){
		$.ajax({
			type:"post",
			url:"/board/member/idCheck",
			data: {"id":$("#id").val()}
		
			})
			.done(function(resp){
				if(resp=="no"){
					alert("중복된 아이디가 있습니다.");
				}else{
					alert("사용가능한 아이디");
				}
			})
			.fail(function(error){
					alert("실패");
			})
		
	})//중복확인 버튼
	
	//가입버튼
	$("#joinBtn").on("click", function(){
		var data={
			id:$("#id").val(),
			pass:$("#pass").val(),
			name:$("#name").val(),
			addr:$("#addr").val(),
			memo:$("#memo").val()
		}
		$.ajax({
			type:"post",
			url: "/board/member/join",
			contentType: 'application/json;charser=utf-8',
			data: JSON.stringify(data)
			
			})
			.done(function(resp){
				alert(resp+"가입 성공");
				location.href="login";
			})
			.fail(function(error){
				alert("가입 실패");
			})
	})//가입 버튼
});//ready

</script>
</body>
</html>