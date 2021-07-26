<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
    <main class="col-9 py-md-3 pl-md-5 bd-content" role="main">
    	<h1>Sign Up</h1> <hr>
	    <form action="<c:url value='/signup' />" method="POST">
	      user_id : <input type="text" name="userId"> <br>
	      password : <input type="password" name="pass"> <br>
	      <button type="submit">Join</button>
	    </form> <br>
	
	    <a href="<c:url value='/login' />">Go to login →</a>
    </main>
