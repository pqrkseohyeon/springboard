<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand/logo -->
		<h3>
			<a class="navbar-brand" href="#"> LOGO </a>
		</h3>

		<!-- Links -->
		<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
				href="/board/list">게시판</a></li>

		<c:choose>
			<c:when test="${empty sessionScope.user }"> <!-- 세션이 없을 때 -->
					<li class="nav-item"><a class="nav-link"
						href="/board/list/member/login">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/board/member/join">회원가입</a></li>
			</c:when>	
			<c:otherwise><!-- 세션이  있을때 -->
				<li class="nav-item"><a class="nav-link"
						href="/board/member/logout">로그아웃</a></li>
				 <li class="nav-item"><a class="nav-link"
						href="/board/member/view">회원 변경</a></li>	
			</c:otherwise>		
		</c:choose>				
		</ul>
	</nav>
	
	
	
	