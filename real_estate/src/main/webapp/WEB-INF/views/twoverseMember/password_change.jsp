<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <main class="container"role="main">
    	<h1>Password Change</h1> 
		<div class="col-xs-5" style="padding: 10px 50px 10px 50px">
		    <form action="<c:url value='/password_change' />" method="POST" >
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
 				<input type="text" name="userId" value="<sec:authentication property="name"/>" hidden="hidden">
				<button type="submit" class="btn btn-default btn-black btn-lg btn-block">Complete</button>
		    </form>
    	</div>
		<div class="col-xs-7">
			<img alt="" class="img-fluid" src="${pageContext.request.contextPath}/resources/assets/image/login_bg.png">
		</div>
      
    </main>
