<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <header class="navbar navbar-expand navbar-dark bg-dark bd-navbar">
	    <div class="container px-5">
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
	           		 <!--  <li>
						<div class="dropdown">
							<button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    		Dropdown trigger
				    		<span class="caret"></span>
				  	  		</button>
				 	  		<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					    	  	<li><a href="#!">Metket</a></li>
				            	<li><a href="#!">Tutorial</a></li>
					            <li><a href="#!">About</a></li>
					            <li><a href="#!">Notice</a></li>
				  			</ul>
						</div>
					</li> -->
					
 					<sec:authorize access="isAnonymous()">
        	 			<li class="nav-item"><a class="nav-link" href="<c:url value='/login' />"><button class="btn btn-secondary btn-sm px-2">Login</button></a></li>
	              		<li class="nav-item"><a class="nav-link" href="<c:url value='/signup' />"><button class="btn btn-secondary btn-sm px-2">Sign-up</button></a></li>
                	</sec:authorize>
               		<sec:authorize access="isAuthenticated()">
 	              		<li class="nav-item"><a class="nav-link" href="<c:url value='/my_profile' />"><img src="${pageContext.request.contextPath}/resources/assets/image/profile_icon.png" style="height: 20px; width: 20px;"/></a></li>
        	       		<li class="nav-item"><a class="nav-link" href="<c:url value='/logout' />"><button class="btn btn-secondary btn-sm px-2">Logout</button></a></li>
               		</sec:authorize>
               		<li class="nav-item"><a class="nav-link" href="<c:url value='/' />"><img src="${pageContext.request.contextPath}/resources/assets/image/language_icon.png" style="height: 20px; width: 20px;"/></a></li>
	            </ul>
	        </div>
	    </div>
	</header>
    