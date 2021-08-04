<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
	<main class="container"role="main">
		<h1>Login</h1> 
		<div class="col-xs-5" style="padding: 10px 50px 10px 50px">
		    <form action="<c:url value='/loginAuth' />" method="POST" >
				<div class="form-group">
					<label for="userId">E-mail</label>
   					<input type="email" class="form-control" id="userId" name="userId" placeholder="Please enter your email">
				</div>
				<div class="form-group">
				    <label for="password">Password</label>
				    <input type="password" class="form-control" id="password" name="pass" placeholder="password">
			    </div>
				<button type="submit" class="btn btn-default btn-black btn-lg btn-block">Login</button>
		    </form>
		    <div style="display: flex; justify-content: space-between;">
		    	<a href="<c:url value='/forgot-password' />"><strong style=" padding: 0">Forgot password?</strong></a>
			    <a href="<c:url value='/signup' />"><strong  style= "padding: 0">SIGN-UP</strong></a>
		    </div>
		   
    		<div style="margin-top: 50px">
    			<h4>Sns Login</h4>
    			<hr style="background-color: #111111"/>
    		</div>
    	</div>
		<div class="col-xs-7">
			<img alt="" class="img-fluid" src="${pageContext.request.contextPath}/resources/assets/image/login_bg.png">
		</div>
    </main>
