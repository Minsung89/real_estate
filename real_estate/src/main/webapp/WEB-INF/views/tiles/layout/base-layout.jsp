<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
				xmlns:th="http://www.w3.org/1999/xhtml"
				xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
	<head>
		<tiles:insertAttribute name="header"/>
	
	</head>
	<!-- Responsive navbar-->
	<body>
		<nav>
	 		<tiles:insertAttribute name="nav" />
		</nav>
	 		<tiles:insertAttribute name="body"/>
		 <!-- Footer-->
		 <!--  <div style="background-color: #212529; width: 100%; height: 50px; position: absolute; bottom: 0; filter: brightness(50%)"></div> -->
	    <footer class="py-5 bg-dark my-footer">
			<tiles:insertAttribute name="footer"/>
	    </footer>
	</body>
</html>
