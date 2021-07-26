<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="en">
	<main class="pl-md-5 bd-content" role="main">
		<div>
			<img class="m-t-img" alt="notice_main" src="${pageContext.request.contextPath}/resources/assets/image/notice_main_img.png">
		</div>
		<div>
		  <ul class="navbar-nav ms-0 mb-2 mb-lg-0">
               <li class="nav-item"><a class="nav-link" href="<c:url value='/notice/faq/faq_sub?q=account' />">Account</a></li>
               <li class="nav-item"><a class="nav-link" href="<c:url value='/notice/faq/faq_sub?q=commercial' />">Commercial</a></li>
               <li class="nav-item"><a class="nav-link" href="<c:url value='/notice/faq/faq_sub?q=trade_issue' />">Trade Issue</a></li>
           </ul>
		</div>
	</main>
</html>
