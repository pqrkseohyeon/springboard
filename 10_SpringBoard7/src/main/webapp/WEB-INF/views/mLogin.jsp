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
<div class="container">
	<br/>
  <h2>로그인</h2>
  <form action="mLogin" method="post">
    <div class="form-group">
      <label for="id">id:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
    </div>
    <button type="button" class="btn btn-primary" id="loginBtn" name="loginBtn">로그인</button>
  </form>
</div>
<script>
$(function(){
	$("#loginBtn").on("click", function(){
		if($("#id").val()==""){
			alert("id입력");
			return false;
		}
		if($("#pass").val()==""){
			alert("password입력");
			return false;
		}
		
		$.ajax({
			type: "post",
			url: "/board/member/login",
			data: {"id": $("#id").val(), "pass":$("#pass").val()}
		})
		.done(function(resp){
			if(resp=="no"){
				alert("회원 아님");
			}else if(resp=="success"){
				alert("로그인 성공");
				//location.href="/board/list"; //javascript 형태
				$(location).attr("href","/board/list"); //jquery 형태
			}else if(resp=="passError"){
				alert("비번 오류");
			}
		})
		.fail(function(error){
			alert("error");
		})
	})//loginBtn
})//ready

</script>
</body>
</html>