<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
    <main class="py-md-3 pl-md-5 bd-content container-fluid"role="main">
    	<h1>Sign-up</h1>
	    <div class="col-xs-5" style="padding: 10px 50px 10px 50px">
		    <form action="<c:url value='/signup' />" method="POST">
		  	    <div class="form-group">
					<label for="userId">E-mail</label>
   					<input type="email" class="form-control" id="userId" name="userId" placeholder="Please enter your email">
				</div>
		      	<div class="form-group">
				    <label for="password">Password</label>
				    <input type="password" class="form-control" id="password" name="pass" placeholder="password">
			    </div>
			    <div class="form-group">
				    <label for="confirmpassword">Confirm Password</label>
				    <input type="password" class="form-control" id="confirmpassword">
			    </div>
			    <div class="form-group">
				    <label for="nickname">Nick name</label>
				    <input type="text" class="form-control" id="nickname" name="nickname">
			    </div>
		      <button type="submit" class="btn btn-default btn-black btn-lg btn-block">SIGN-UP</button>
		    </form> <br>
  	    </div>
	    <div class="col-xs-7">
			<img alt="" class="img-fluid" src="${pageContext.request.contextPath}/resources/assets/image/login_bg.png">
		</div>
    </main>
