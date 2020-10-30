<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">글보기</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">글보기</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<div class="form-group">
					<label>번호</label> <input class="form-control" name='bno'  id="bno"
						value='<c:out value="${board.num }"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>제목</label> <input class="form-control" name='title'
						value='<c:out value="${board.title }"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" rows="3" name='content'
						readonly="readonly"><c:out value="${board.content}" /></textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> <input class="form-control" name='writer'
						value='<c:out value="${board.writer }"/>' readonly="readonly">
				</div>

			
				<button data-oper='modify' class="btn btn-default">수정하기</button>
			
				<button data-oper='list' class="btn btn-info">리스트</button>
				<div align="center">
				<textarea rows="5" cols="50" id="msg"></textarea>
				<input type="button" value="댓글쓰기"  id="commentBtn">
			</div>
			<div id ="area"></div>	
			<script>
           var init= function(){
	              $.ajax({
						type:"get",
						url : "/board/reply/commentList",
						data : {"num" : $("#bno").val()}
				  })
				  .done(function(resp){
	           				alert("성공 : "+resp.length);
	           			 var htmlCont ="";  //테이블 내용
	           			/*  $.each(resp,function(key, val){
	           				htmlCont +=val.content+"<br>"; 
 							htmlCont +=val.regdate+"<br>"; 
 							htmlCont +="<a href='javascript:fdel("+val.cnum+")'>삭제</a><hr>";  */
     					  $.each(resp,function(key, val){
	 						       	htmlCont +=val.content+"<br>"; 
		 							htmlCont +=val.regdate+"<br>"; 
		 							htmlCont +="<a data-cnum="+val.cnum+">삭제</a><hr>"; 
		 						
		 		 		 })	//each
	 		 			$("#area").html(htmlCont);//테이블 내용

	 		 			$("#area").on("click","a",function(e){
							var cnum = $(this).data("cnum");
							alert(cnum);
							fdel(cnum)
	 		 			});  //area on
				        
				  })      //done
				  .fail(function(error){
							alert("실패");
				 }) //fail
          }

          $("#commentBtn").on("click",function(){
                 var data ={
					bnum : $("#bno").val(),
					content : $("#msg").val()	
                  }
                 alert(data);
        	  $.ajax({
					type: "post",
					url :"/board/reply/commentInsert",
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(data)
	          })
	          .done(function(){
						alert("등록 완료");
						init();
			   })
             .fail(function(error){
                	 alert("등록 실패");
                 })
           })
 
  init();

          function fdelete(cnum){
				$.get("reply/delete",{"cnum" : cnum} ,function(resp){
						if(resp=="success"){
							 alert("삭제성공");
							 init();
						}
				});
          }

          function fdel(cnum){
				$.ajax({
					type : 'DELETE',
					url : "/board/reply/del/"+cnum,
					contentType : 'application/json;charset=utf-8'
				})
				.done(function(resp){
					alert(resp + "글 삭제");
					init();
				})
				. fail(function(error){
					alert("글 삭제실패");
				})
          }
			

			</script>			
			
			
			
			
			
			
			
			
			