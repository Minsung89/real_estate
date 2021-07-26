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
	 		<tiles:insertAttribute name="nav"/>
		</nav>
		<div class="container-fluid">
			<div class="row flex-nowrap">
				<tiles:insertAttribute name="sidebar"/>
		 		<tiles:insertAttribute name="body"/>
	 		</div>
		</div>

		 <!-- Footer-->
	    <footer class="py-5 bg-dark my-footer">
			<tiles:insertAttribute name="footer"/>
	    </footer>
		        <!-- Bootstrap core JS-->
	        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
	        <!-- Core theme JS-->
	        <script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
	        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	        <!-- * *                               SB Forms JS                               * *-->
	        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
	</body>
</html>
