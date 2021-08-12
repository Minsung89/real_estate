<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
    <main class="container"role="main">
    	<h1>Sign-up</h1>
	    <div class="col-xs-5" style="padding: 10px 50px 10px 50px">
		    <form action="<c:url value='/signup' />" method="POST" style="margin-bottom: 0;">
		  	    <div class="form-group">
					<label for="userId">E-mail</label>
   					<input type="email" class="form-control signup-validation" id="userId" name="userId" placeholder="Please enter your email">
   					<span class="signup-validation-paragraph" id="userId-vp">* Please enter a valid email</span>
				</div>
		      	<div class="form-group">
				    <label for="password">Password</label>
				    <input type="password" class="form-control signup-validation" id="password" name="pass" placeholder="password" autocomplete="off">
				    <span class="signup-validation-paragraph" id="password-vp">* Please enter at least 10 characters, <br/>
  						  including uppercase/lowercase and special characters</span>
			    </div>
			    <div class="form-group">
				    <label for="confirmpassword">Confirm Password</label>
				    <input type="password" class="form-control signup-validation" id="confirmpassword" autocomplete="off">
				     <span class="signup-validation-paragraph"  id="confirmpassword-vp">* do not match<br/></span>
			    </div>
			    <div class="form-group">
				    <label for="nickname">Nick name</label>
				    <input type="text" class="form-control signup-validation" id="nickname" name="nickname">
				    <span class="signup-validation-paragraph" id="nickname-vp">* Nickname In use</span>
			    </div>
			    <div class="form-group">
			   		<label>Terms and Condition </label><br>
				    <input  type="checkbox" id="terms-checkbox">
				    <label  for="terms-checkbox" style="user-select:none">I agree to 2Verse <a href="#">Privacy Policy</a> & <a href="#">Terms.</a></label>
			    </div>
			   	<hr style="margin-bottom: 30px; background-color: #111; height: 2px; border-radius: 20px">
		      <button type="submit" class="btn btn-default btn-black btn-lg btn-block" id="signup-validation">SIGN-UP</button>
		      
		    </form> <br>
		    <div class="row">
		    	<div class="col">Already have an ID?</div>
		    	<div class="col text-end"><a href="<c:url value='/login' />"><b>Login</b></a></div>
		    </div>
  	    </div>
	    <div class="col-xs-7">
			<img alt="" class="img-fluid" src="${pageContext.request.contextPath}/resources/assets/image/login_bg.png">
		</div>
    </main>
