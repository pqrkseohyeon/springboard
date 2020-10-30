<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <div class="row">
    <div class="col">
    <label for="userid">ID : </label>
    <input type="text" class="form-control" placeholder="Enter userid" id="id" name="id">
    
 	</div> 
 	<div class="col align-self-end">
  	<button id="checkBtn" class="btn btn-primary" name="checkBtn">사용여부</button>
  	</div>
  	</div>

 <script>

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
		if(resp=="yes"){
			alert("사용가능");
			$(opener.document).find("#id").val($("#id").val());
			self.close();
		}else{
			alert("사용 불가능")
			$("#id").val("");
		}
	})
	.fail(function(error){
		alert("실패 "+error);
	})
})

</script>
 