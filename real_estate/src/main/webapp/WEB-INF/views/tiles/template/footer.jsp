<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
	<div class="container">
		<div class="row">
			<div class="col">
				<img src="${pageContext.request.contextPath}/resources/assets/image/2verse_logo.png" style="height: 30px; margin-bottom: 5px;"/>
				<address style="padding-left: 10px;">주소 서울특별시 강북구 덕릉로 5길 10	/	상호명  2VERSE <br/>
							대표 조윤찬	/	사업자번호 111-11-11111   <br/>
							통신판매업신고  제2021-00000
				</address> <br/>
				<div style="padding-left: 10px;">
					Copyright © 2021 All rights reserved.
				</div>
			</div>
			<div class="col">
				<div class="row">
					<div class="col">
						<dl>
							<dt>About</dt>
							<dd><a href="<c:url value='/about/about_2verse' />">About 2verse</a></dd>
							<dd><a href="<c:url value='/about/contact_us' />">Updates</a></dd>
							<dd><a href="<c:url value='/about/update' />">Contact us</a></dd>
						</dl>
					</div>
					<div class="col">
						<dl>
							<dt>Regal</dt>
							<dd>Privacy policy</dd>
							<dd>Terms</dd>
							<dd>Disclaim</dd>
						</dl>
					</div>
					<div class="col">
						<dl>
							<dt>Help</dt>
							<dd></dd>
							<dd></dd>
							<dd></dd>
						</dl>
					</div>
					4
					<div class="col">
					</div>
				</div>
			</div>
		</div>
		<p class="m-0 text-center text-white">All trademarks and copyrights belong to their respective owners.</p>
	</div>
