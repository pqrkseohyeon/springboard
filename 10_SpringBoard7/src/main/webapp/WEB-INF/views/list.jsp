<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container"><br/>
  <h3 align="center">게시글(${count})</h3><br/>     
  <table class="table">

    <thead>
      <tr>
      	<th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${listResult}" var="board">
      <tr>
        <td>${board.num}</td>
        <td><a href='/board/view?num=${board.num}'>${board.title}</a>[${board.replycnt}]</td>
        <td>${board.writer}</td>
		<td>${board.regdate}</td>
        <td>${board.hitcount}</td>
      </tr>
	</c:forEach>
    </tbody>
  </table>
</div>
<!-- <a href="/board/get/2">상세보기</a> -->
<a href="boardInsert">글쓰기</a>
<br/>

<form name="search" id="search" align="center">
	<select name="field" id="field">
		<option value="writer">글쓴이</option>
		<option value="title">제목</option>
	</select>
	<input type="text" name="word" id="word">
	<input type="submit" value="찾기" id="btnSearch">
</form>

</body>
</html>