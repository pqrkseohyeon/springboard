<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="include/header.jsp" %> <!-- header의 연장선~~ -->

<div class="container">
<br>
<h2>회원리스트(<span id="cntSpan">${count }</span>)</h2><br>
<form>
 <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>이름</th>
        <th>ID</th>
        <th>주소</th>
        <th>메모</th>
        <th>가입일자</th>
        <th>삭제</th> 
      </tr>
    </thead>
    <!-- 하나하나 돌리고자하는 변수명 : var -->
	<!-- if set = for(일반회원?:"관리자" -->   
    <tbody class="thead-light">
    <c:forEach items="${memlist}" var ="member">     
	 <tr>
	  <td>${member.name }</td>			
	  <td>${member.id }</td>
	  <td>${member.addr }</td>
	  <td>${member.memo }</td>
	  <td>${member.reg_date }</td>
	  <td>삭제</td>
	  </tr>	
	</c:forEach>
	
    </tbody>
  </table>
  </form>
</div>
<div align="center">
<form name="search" id="search" action="gList">
 <select name="field" id="field">
 <option value="name">이름</option>
 <option value="addr">주소</option>
</select>
<input type="text" name="word" id="word">
<input type="submit" value="찾기">
</form>
</div>
<div align="center">
	${pageHtml }
</div>


