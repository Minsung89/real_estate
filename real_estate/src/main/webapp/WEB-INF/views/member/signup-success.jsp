<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
    <main class="container"role="main">
    	<h1> &nbsp &nbsp</h1>
	    <div class="col-xs-5" style="padding: 10px 50px 10px 50px; text-align: center;">
			<img src="${pageContext.request.contextPath}/resources/assets/image/success_icon.png" style="margin-bottom: 20px;"><br/>
			<b style="font-size: 40px;">SIGN UP COMPLETE!</b>
	    	<a href="<c:url value='/login' />"><button type="submit" class="btn btn-default btn-black btn-lg btn-block" style="border-radius: 10px; margin-top: 40px; ">LOGIN</button></a>
  	    </div>
	    <div class="col-xs-7">
			<img alt="" class="img-fluid" src="${pageContext.request.contextPath}/resources/assets/image/login_bg.png">
		</div>
    </main>
