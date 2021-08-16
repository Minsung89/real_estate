<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <header class="navbar navbar-expand navbar-dark bg-dark bd-navbar">
	    <div class="container">
	        <a class="navbar-brand" href="<c:url value='/' />"><img src="${pageContext.request.contextPath}/resources/assets/image/2verse_logo.png" /></a>
	        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav ms-0 mb-2 mb-lg-0">
	                <li class="nav-item"><a class="nav-link" href="<c:url value='/map' />">MAP</a></li>
	                <li class="nav-item"><a class="nav-link" href="<c:url value='/market' />">MARKET</a></li>
	                <li class="nav-item"><a class="nav-link" href="<c:url value='/notice' />">NOTICE</a></li>
	            </ul>
	        </div>
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
 					<sec:authorize access="!isAuthenticated()">
        	 			<li class="nav-item"><a class="nav-link" href="<c:url value='/login' />"><button class="btn btn-secondary btn-sm px-2">Login</button></a></li>
	              		<li class="nav-item"><a class="nav-link" href="<c:url value='/signup' />"><button class="btn btn-secondary btn-sm px-2">Sign-up</button></a></li>
                	</sec:authorize>
               		<sec:authorize access="isAuthenticated()">
                  		<li class="nav-item"><a class="nav-link m-point" href="/"><sec:authentication property="principal.point"/>VP</a></li>
 	              		<li class="nav-item">
 	              			<div class="dropdown nav-link" style="">
 	              				<img src="${pageContext.request.contextPath}/resources/assets/image/profile_icon.png" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false" id="profileDropdownMenu" style="height: 20px; width: 20px;"/>
						  		<ul class="dropdown-menu dropdown-menu-lg-end" aria-labelledby="profileDropdownMenu">
								    <li><a href="<c:url value='/my_profile' />">MY PROFILE</a></li>
								    <li><a href="<c:url value='/wallet/deposit' />">WALLET</a></li>
								    <li><a href="<c:url value='/assets/holdings' />">ASSETS</a></li>
								    <li><a href="<c:url value='/settings' />">SETTING</a></li>
		            	       		<li><a href="<c:url value='/logout' />" style="color:red;">LOGOUT</a></li>
								    
							 	</ul>	
					 		</div>
 	              		</li>
        	       		
               		</sec:authorize>
               		<li class="nav-item"><a class="nav-link" href="<c:url value='/' />"><img src="${pageContext.request.contextPath}/resources/assets/image/language_icon.png" style="height: 20px; width: 20px;"/></a></li>
	            </ul>
	        </div>
	    </div>
	</header>
    