<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
    
<div class="container">

  <form action="join" method="post" id="frm">
    <div class="row">
	    <div class="col">
	      <label for="userid">id:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id"  readonly="readonly">
	    </div>
      <div class="col align-self-end" >
          <button  type="button"  id="idcheckBtn"  class="btn btn-primary">중복확인</button>
    </div>
    </div>
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">

    </div>

    <div class="form-group">
      <label for="pass">Password:</label>
      <input type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
    </div>
    <div class="form-group">
      <label for="pwd_check">Password Confirm:</label>
      <input type="password" class="form-control" id="pass_check" placeholder="Enter password Confirm" name="pass_check">
    </div>
    <div class="form-group">
      <label for="addr">Addr:</label>
      <input type="text" class="form-control" id="addr" placeholder="Enter addr" name="addr">
    </div>
    <div class="form-group">
      <label for="memo">Memo:</label>
      <input type="text" class="form-control" id="memo" placeholder="Enter memo" name="memo">
    </div>
    
<br/>
 <button  id="send"  class="btn btn-primary">Submit</button>
  </form>
</div>
