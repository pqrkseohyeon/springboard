<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ include file="includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				글 갯수(${count})
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th >번호</th>
							<th >제목</th>
							<th >작성자</th>
							<th >작성일</th>
							<th >조회수</th>
						</tr>
					</thead>

					<c:forEach items="${listResult}" var="board" varStatus="st">
						<tr>
							<td><c:out value="${rowNo - st.index}" /></td>
							<td>
							<a  href='/board/view?num=${board.num }'/>
							<c:out value="${board.title }"/>
							<b>[ <c:out value="${board.replyCnt }" />]</b>
						    </a>
							</td>
							<td><c:out value="${board.writer}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.regdate}" /></td>
							<td><c:out value="${board.hitcount }"/></td>
						</tr>
					</c:forEach>
				</table>
				<div class='row'>
					<div class="col-lg-12">

						<form id='searchForm' action="/board/list" method='get'>
							<select name='field'>
								<option value="writer"> 작성자</option>
								<option value="content">내용</option>
								
							</select> 
							<input type='text' name='word'>
							<button class='btn btn-default'>Search</button>
						</form>
					</div>
					 <a href="/board/get/2">상세보기</a>
				</div>
				

				<%@ include file="includes/footer.jsp"%>