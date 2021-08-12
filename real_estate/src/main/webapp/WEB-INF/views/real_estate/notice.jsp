<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">
	<main class="pl-md-5 bd-content" role="main">
		<div class="row-cols-2">
			<img class="m-t-img" alt="notice_main" src="${pageContext.request.contextPath}/resources/assets/image/notice_main_img.png">
			<div>
				 <ul class="navbar-nav ms-0 mb-2 mb-lg-0">    
		             <li class="nav-item"><a class="nav-link" href="<c:url value='/notice/faq' />">FAQ</a></li>
		             <li class="nav-item"><a class="nav-link" href="<c:url value='/notice/qna' />">1:1</a></li>
		             <li class="nav-item"><a class="nav-link" href="<c:url value='/notice/nontification' />">Nontification</a></li>
	    		 </ul>
			</div>
		</div>
	</main>
</html>
