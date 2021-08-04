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
	</body>
</html>
