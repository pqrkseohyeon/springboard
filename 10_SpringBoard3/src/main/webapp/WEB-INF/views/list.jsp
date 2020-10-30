<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@include file="include/header.jsp" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
function bdelete(num){
	if(confirm(num+"번째 게시글을 삭제하시겠습니까?")){
		$.get("bDelete", {"num":num},
			function(resp){			
				if(resp=="success") location.href="/board";
								
			}
		)
	}	
}

</script>
<style>
#aclass{
	margin:10px;
}
#a{
	margin:10px;
	margin-right:10px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<form>
<br>
<div align="center"><b> 총 게시물 수 : ${count }</b></div><br>
 <table class="table" id="aclass">
   <thead class="thead-dark">
    <tr>
    <th scope='col'>번호</th>	
	<th scope='col'>글번호</th>			
	<th scope='col'>작성자</th>
	<th scope='col'>제목</th>
	<th scope='col'>내용</th>
	<th scope='col'>작성일</th>
	<th scope='col'>조회수</th>
	<c:choose>
	 <c:when test="${empty sessionScope.id }">
		
	 </c:when>
	 <c:otherwise>
	 	<th scope='col'>삭제</th>
	 </c:otherwise>
	</c:choose>	
    </tr>
    </thead>

	<tbody>
    <c:forEach items="${listResult }" var ="list" varStatus="st">
    <tr>
    <th><c:out value="${rowNo - st.index }"/></th> 
  	<td>${list.num}</td>
  	<td>${list.writer}</td>
	<td><a href='/board/get/${list.num }'>
		<c:out value="${list.title}"/>    
    	<b> [<c:out value="${list.replyCnt }"/>]</b> 
    </a></td>				 
    <td>${list.content}</td>
    <td>${list.regdate}</td>
	<td>${list.hitcount}</td>
    <c:choose>
	 <c:when test="${empty sessionScope.id }">
		
	 </c:when>
	 <c:otherwise>
	 	<td><a href="javascript:bdelete(${list.num})">삭제</a></td>
	 </c:otherwise>
	</c:choose>	
	</tr>
	</c:forEach>
	</tbody>	

</tbody>        
</table>    
</form>    
<div align="center">
<form name="search" id="search" action="list">
 <select name="field" id="field">
 <option value="writer">이름</option>
 <option value="content">내용</option>
</select>
<input type="text" name="word" id="word">
<input type="submit" value="찾기">
<br><br>
</form>
</div>

<a href="/board/get/2">상세보기</a>
</body>
</html>