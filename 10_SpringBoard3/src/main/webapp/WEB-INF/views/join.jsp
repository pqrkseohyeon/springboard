<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp" %>
  

<div class="container">
<form action="/board/member/join" method="post">

  <div class="row">
    <div class="col">
    <label for="userid">ID : </label>
    <!-- id꼭 적을것@!!! -->
    <input type="text" class="form-control" placeholder="Enter userid" id="id" name="id">
 	</div> 
 	<div class="col align-self-end">
  	<button type="button" id="id_checkBtn" class="btn btn-primary" name="id_checkBtn">중복확인</button>
  	</div>
  </div>
   <div class="form-group">
    <label for="name">NAME : </label>
    <input type="text" class="form-control" placeholder="Enter name" id="name" name="name">
  </div>

  <div class="form-group">
    <label for="pwd">Password : </label>
    <input type="password" class="form-control" placeholder="Enter password" id="pass" name="pass">
  </div>
  
    <div class="form-group">
    <label for="pwd_check">Password Confirm : </label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd_check" name="pwd_check">
  </div>
  
   <div class="form-group">
    <label for="email">ADDR :  </label>
    <input type="text" class="form-control" placeholder="Enter address" id="addr" name="addr">
  </div>
  
  <div class="form-group">
    <label for="phone">MEMO : </label>
    <textarea class="form-control" placeholder="Enter phone" rows="5" cols="40" id="memo" name="memo"></textarea>
  </div>
<!--   
 <div class="form-check-inline">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="admin" value="1">관리자
  </label>
</div>

<div class="form-check-inline">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="admin" value="0" checked>일반회원
  </label>
</div> -->

<Br>
<Br>

  <button id="submit" class="btn btn-primary">회원가입</button>
  <Br>
</form>
  </div>
  
<script>
$("#id_checkBtn").on("click", function(){
	alert("켜저라고ㅡㅡ");
	window.open("/board/member/idcheckform","","width=700 height=250");
})

$("#checkBtn").click(function(){
	if($("#id").val()==""){
		alert("아이디를 입력하세요");
		$("#id").focus();
		return false;
	}
	$.ajax({
		type:"post",
		url:"/board/member/idcheck",
		data : {"id":$("#id").val()}
	})
	.done(function(resp){
		alert("성공!"+resp);
	})
	.fail(function(error){
		alert("실패 "+error);
	})
})

</script>

