<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<main class="col-9 py-md-3 pl-md-5 bd-content l-main" role="main">
		<h1>My Profile</h1>
		<div>
			<div class="mp-info row">
				<div class="col-3" style="height: 100%; line-height: 100%; display:flex; justify-content:center; align-items:center;">
					<img src="${pageContext.request.contextPath}/resources/assets/image/profile_face.png" style="vertical-align:middle;"/>
				</div>
				<div class="col row row-cols-1">
					<ul class="mp-ul col row align-items-center">
						<li class="col-4">
							<!-- <b>nation</b><sec:authentication property="principal.nation"/> -->
						<sec:authentication property="principal.nation" var="myNation"/>
						<img src="${pageContext.request.contextPath}/resources/assets/image/nation/${myNation }.png"  style="height:70px; "/>
						</li>
						<li class="col-8" style=" text-align: left;">
							<b style="font-size: 55px;"><sec:authentication property="principal.nickname"/></b>
							<sec:authentication property="name"/>	
						</li>
					</ul>
					<ul class="mp-ul row col align-items-center">
						<li class="col"><b>Balance</b><br/><sec:authentication property="principal.point"/> VP</li>
						<li class="col"><b>Buliding</b><br/><sec:authentication property="principal.point"/> VP</li>
						<li class="col"><b>Wroth</b><br/><sec:authentication property="principal.point"/> VP</li>
					</ul>
				</div>
			</div>
			<div style="padding: 0 5rem;">
				<b>Authentication required</b>
				<sec:authentication property="principal.authState" var="authState"/>
				<c:choose>
	   			    <c:when test="${authState eq 'N'}">
	                    <button id="send_email" class="btn btn-secondary btn-sm">Certified</button><br/>
			        </c:when>
					<c:when test="${authState eq 'Y'}">
						<br/>인증완료
			        </c:when>
				</c:choose>
			</div>
		</div>
			
		<div id="msgStack"></div>
	</main>
