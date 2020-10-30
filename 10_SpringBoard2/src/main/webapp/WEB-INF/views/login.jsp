<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>


  <div class="container mt-3">
    <div class="form">
      <label for="id">id:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
    </div>

    <button type="button" class="btn btn-primary" id="loginBtn">Submit</button>
</div>
<script>
$("#loginBtn").click(function(){
	if($("#id").val()==""){
		alert("아이디를 입력하세요");
		$("#id").focus();
		return false;
	}
	if($("#pass").val()==""){
		alert("비밀번호를입력하세요");
		$("#pass").focus();
		return false;
	}
	$.ajax({
		type:"post",
		url : "login",
		data : {"id" : $("#id").val(), "pass" : $("#pass").val()},
		
	})  //ajax
	.done(function(resp){
		if(resp=="no"){
			alert("회원이 아닙니다. 회원가입하세요")
		}else if(resp=="success"){
			alert("성공");
		//	 location.href="/board/list";
			 $(location).attr("href","/board/list");
		}else{
			alert("비번 오류");

		}
	})
	.fail(function(error){

	})
		
})  //loginBtn

</script>

<%@ include file="../include/footer.jsp" %>




