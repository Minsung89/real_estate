<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/password_change.js"></script>
    <main class="col-9 py-md-3 pl-md-5 bd-content l-main" role="main">
    	<h1>Password Settings</h1>
    	<div class="row" style="width: 30%; margin: 100px auto; text-align: center;">
			<div class="col-xs-5" style="padding: 10px 50px 10px 50px">
		      	<div class="form-group">
					<label style="font-size: 16px;">Password</label>
   					<input type="password" class="form-control" name="password">
   					<input type="text" name="userId" value="<sec:authentication property="name"/>" hidden="hidden">
				</div>
				<button id="passConfirmBtn" type="button" class="btn btn-default btn-black btn-lg btn-block" style="width: 60%;">O K</button>
  	  		</div>
    	</div>
      
    </main>
