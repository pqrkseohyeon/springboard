<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/><br/><br/>
<form action="boardInsert" method="post">	
<div class="container">
    <div class="form-group">
      <label>번호<label>
      <input type="text" size="20" id="num" name="num" value="${board.num}" disabled="disabled">
    </div>

    <div class="form-group">
      <label>글쓴이</label>
      <input type="text" size="20" id="writer" name="writer" value="${board.writer}">
    </div>
    
    <div class="form-group">
      <label>제목</label>
      <input type="text" size="37" id="title" name="title" value="${board.title}">
    </div>

    <div class="form-group">
      <label>내용</label>
      <input type="text" size="37" id="content" name="content" value="${board.content}">
    </div>

    <div class="form-group">
      <label>비밀번호</label>
      <input type="password" size="20" id="password" name="password" value="${board.password}" >
    </div>
    <br/>
		<input type="submit" value="수정">
		<input type="button" value="삭제">	
		<input type="reset" value="취소">
</div>
</form>
<div align="center">
<!--댓글쓰기 영역 -->
<textarea rows="5" cols="50" id="msg"></textarea>
<input type="button" value="댓글쓰기" id="commentBtn">
</div>
<!-- 댓글 목록 -->
<div id="area"></div>
<script>
var init=function(){
	$.ajax({
		type:"get",
		url:"/board/reply/commentList",
		data:{"num":$("#num").val()}
		})
		.done(function(resp){
			var htmlCont=""; //테이블 내용
			//resp객체가 없으면 실행이 안된다. 
			$.each(resp,function(key,val){
				htmlCont+=val.content+"<br>";
				htmlCont+=val.regdate+"<br>";
				//htmlCont+="<a data-cnum="+val.cnum+">삭제</a><hr>";
				htmlCont+="<a href='javascript:fdel("+val.cnum+")'>삭제</a><hr>";
			})
			$("#area").html(htmlCont);//테이블 내용
			$("#area").on("click", "a", function(e){ //a태그가 클릭될때마다 cnum을 가져와라
					var cnum=$(this).data("cnum");
					alert(cnum);
					fdel(cnum);
			})
		})
		.fail(function(error){
			alert("실패");
		})
}

init();

//댓글 입력
$("#commentBtn").on("click",function(){
	var data={
		bnum:$("#num").val(),
		content:$("#msg").val()
		}
	
	$.ajax({
		type:"post",
		url:"/board/reply/commentInsert",
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify(data)
		
		})
		.done(function(){
			alert("등록 완료");
			$("#msg").val("");
			init();
		})
		.fail(function(error){
			alert("등록 실패");
		})
})
//삭제
function fdel(cnum){
	//type: 'DELETE'는 controller의 deletemapping을 받는다.
	//url: rest형식으로 가기 때문에 controller에서 {cnum}, pathvariable 쓰기
	//dataType: 'json'을 적으면 json코드로 바뀐다. (지우면 기본값인 텍스트로 받아진다.) 
	//contentType: controller 갈때 가져가는 유형이 json
	$.ajax({
		type:'DELETE',
		url: "/board/reply/del/"+cnum,
		contentType: 'application/json;charset=utf-8'
	})
	.done(function(resp){
		alert(resp+"댓글 삭제");
		init();
	})
	.fail(function(error){
		alert("댓글 삭제 실패");
	})
}
</script>
</body>
</html>