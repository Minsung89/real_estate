<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <main class="col-9 py-md-3 pl-md-5 bd-content l-main" role="main">
      <h1>My Profile Edit</h1>
      <div>
      	<h5>Nick Name</h5>
      	<input name="nickname">
      </div>
       <div>
      	<h5>Password</h5>
      	<input name="pass" type="password">
      </div>
   	  <div>
      	<h5>Description</h5>
      	<input name="description">
      </div>
      <div>
      	<h5>Nation</h5>
      	<input name="nation">
      </div>
      <div>
		<button id="p-save">save</button>
		<button id="p-cancel">cancel</button>
		
      </div>
    </main>
