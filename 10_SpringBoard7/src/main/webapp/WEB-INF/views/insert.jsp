<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/board/resources/js/board.js"></script>
</head>
<body>
<h2>글작성</h2>
<form action="boardInsert" method="post">
      <label>글쓴이</label>
    <div class="form-group">
      <input type="text" size="20" id="writer" name="writer" >
    </div>
      <label>제목</label>
    <div class="form-group">
      <input type="text" size="37" id="title" name="title" >
    </div>
      <label>내용</label>
    <div class="form-group">
      <textarea rows="5" cols="40" id="content" name="content"></textarea>
    </div>
    <div class="form-group">
      <label>비밀번호</label>
      <input type="password" size="20" id="password" name="password" >
      <input type="hidden" id="replycnt" name="replycnt">
    </div>
    <br/>
    	<input type="button" id="submit" name="submit" value="입력">
    	<input type="reset" value="취소">
</form>
<br/>
<!-- 페이징 영역 paging-->
<div id="pageArea" align="center"></div>
</body>
</html>