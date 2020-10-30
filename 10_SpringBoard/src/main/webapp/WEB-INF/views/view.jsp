<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %> 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<input type="hidden" value=${board.num } id="bnum">
<h3>${board.writer }님의 상세 정보</h3>
<form>
<table>

    <tr>
 	 <th>제목</th>
 	 <td>${board.title}</td>
 	</tr>
 	
 	<tr>
      <th>작성자</th>
      <td>${board.writer}</td>
    </tr>  
    
    <tr>
      <th>내용</th>
      <td>${board.content }</td>
    </tr>
    
    <tr>  
      <th>작성일</th>
      <td>${board.regdate }</td>
    </tr>
    
    <tr>  
      <th>조회수</th>
      <td>${board.hitcount }</td>
	</tr>

<tr align="center">
<td colspan="5"><input type="button" value="수정하기" onclick="location.href='bUpdate?num=${board.num}'">
<input type="reset" value="다시 입력"></td>
</tr>

</table>
</form>
<br>
<div align="center">
<textarea rows="5" cols="50" id="msg"></textarea>
<input type="button" value="댓글쓰기" id="commentBtn">
</div>
<div id="area"></div>
<script>
function cdelete(cnum){
	if(confirm(cnum+"번째 댓글을 삭제하시겠습니까?")){
		$.ajax({
		  type:'DELETE',
		  url:"/board/reply/del/"+cnum,
		  // contentType : 보내는 유형 (text)
		  contentType:"application/json;charset=UTF-8"
		})
		.done(function(resp){
			alert("글 삭제"+resp)
		})
		.fail(function(error){
			alert("글 삭제 실패")			
		})
/* 		
		$.get("/board/reply/commentDelete", {"cnum":cnum},
			function(resp){
				if(resp=="success") init(); 
		})*/
	}
}

var init = function(){
	$.ajax({
		type:"get",
		url:"/board/reply/commentList",
		//datatype : data를 처리하고 난 다음, 리턴되어지는 데이터 형식
	//	dataType : json,
		data : {"bnum":$("#bnum").val()}
		// contentType : url에 갈때, data형식 타입
//		contentType : "application/json;charset=UTF-8",	
	})
	
		.done(function(resp){			
 			var htmlStr = "<table>";
			htmlStr += "<tr>";
			htmlStr += "<th scope='col'> 댓글번호 </th>";
			htmlStr += "<th scope='col'> 작성자 </th>";
			htmlStr += "<th scope='col'> 내용 </th>";
			htmlStr += "<th scope='col'> 작성일 </th>";
			htmlStr += "<th scope='col'> 글번호 </th>";
			htmlStr += "<th scope='col'> 삭제 </th></tr>"; 
			// $.each > foreach문
			$.each(resp, function(key,val){				
				
				htmlStr += "<div class='commentArea'>";
				htmlStr += "<tr>";
				htmlStr += "<td align='center'>"+val.cnum+"</td>";
				htmlStr += "<td align='center'>"+val.userid+"</td>";
				htmlStr += "<td align='center'>"+val.content+"</td>";
				htmlStr += "<td align='center'>"+val.regdate+"</td>";
				htmlStr += "<td align='center'>"+val.bnum+"</td>";
				htmlStr += "<td align='center'><a data-cnum="+val.cnum+">삭제</td>";
		//		htmlStr += "<td align='center'><a href='javascript:cdelete("+val.cnum+")'>삭제</td>";
				htmlStr += "</tr>";
				htmlStr += "</div>";
								
			});			
			
			htmlStr += "</table>";
			$("#area").html(htmlStr);

			$("#area").on("click","a",function(e){
				var cnum = $(this).data("cnum"); //data-cnum 의미 cnum이름 내 맘대로 준다.
				alert(cnum);
				cdelete(cnum);
		});
	})
		.fail(function(error){
			alert("실패");
	})
}

$("#commentBtn").on("click",function(){
	var data = {
		"bnum" : $("#bnum").val(),
		"content" : $("#msg").val()
	}
	
	$.ajax({
		type:"post",
		url:"/board/reply/commentInsert",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(data)	
		// stringify : json > string으로 변환 // 여기서 data는 > var data 의미	
		// JSON.stringify(바꿀값이름)
		// parse : string > json으로 // stringify과 parse는 반대의미
			
	})
	
	.done(function(resp){
		alert("등록 완료");
		init();
	})
	
	.fail(function(error){
		alert("실패");
	})
})

init();

</script>



</body>
</html>