<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Yelee Page</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
 	  <c:choose>
 	    <c:when test="${empty sessionScope.id }"> 	     
	 	  <li class="nav-item">
	        <a class="nav-link" href="/board/member/joinform">회원가입</a>       
		  </li>
		  <li class="nav-item">
		      <a class="nav-link" href="/board/member/loginform">로그인</a>       
		  </li>
		</c:when> 
		<c:otherwise>
	      <li class="nav-item">
	        <a class="nav-link" href="/board/bInsert">게시글 추가</a> 
	      </li>
	     
		  	<li class="nav-item">
	        <a class="nav-link" href="/board/list">게시글 목록</a>  
	        </li>
		   	
		    <li class="nav-item">
	        <a class="nav-link" href="/board/member/logout">로그아웃</a>       
		  </li>
		</c:otherwise>
	  </c:choose>
   </ul>
  </div>  
</nav>
</body>
</html>