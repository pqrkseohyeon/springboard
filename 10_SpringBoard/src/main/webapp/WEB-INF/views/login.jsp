<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="include/header.jsp" %> <!-- header의 연장선~~ -->
<div class="container">

<form action="/board/member/logincheck" method="post">
  <div class="form-group">
    <label for="userid">ID : </label>
    <input type="text" class="form-control" placeholder="Enter id" id="id" name="id">
  </div>
  <div class="form-group">
    <label for="pwd">Password : </label>
    <input type="password" class="form-control" placeholder="Enter password" id="pass" name="pass">
  </div>
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button type="button" class="btn btn-primary" id="loginBtn" name="loginBtn">Submit</button>
</form>

</div>
	
<script>
$("#loginBtn").click(function(){
	if($("#id").val()==""){
		alert("ID입력");
		$("#id").focus();
		return false;
	}
	if($("#pass").val()==""){
		alert("패스워드 입력");
		$("#pass").focus();
		return false;
	}
 	$.ajax({
		type:"post",
		url:"/board/member/logincheck",
		data : {"id":$("#id").val(), "pass":$("#pass").val()}		
	})
	
	.done(function(resp){
		if(resp=="no"){
			alert("회원이 아닙니다. 회원가입하세요.");
			location.href="/board/member/joinform";
		}else if(resp=="success"){
			alert("로그인 되었습니다.");
			location.href="/board/member/list";
		//	$(location).attr("href", "/board/member/mlist");
			
		}else{
			alert("비밀번호를 확인하세요");
			$("#pass").focus();
		}
	})
	
	.fail(function(error){
		alert("실패 " +error);
	})
})	
</script>