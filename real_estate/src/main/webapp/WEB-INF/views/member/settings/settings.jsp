<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <main class="col-9 py-md-3 pl-md-5 bd-content l-main" role="main">
      <h1>Settings</h1>
     	<div class="mp-info-setting row">
				<div class="col-3" style="height: 100%; line-height: 100%; display:flex; justify-content:center; align-items:center;">
					<img src="${pageContext.request.contextPath}/resources/assets/image/profile_face.png" style="vertical-align:middle;"/>
				</div>
				<div class="col row row-cols-1">
					<ul class="col row">
						<li class="col-8" style=" text-align: left;">
							<b style="font-size: 55px;"><sec:authentication property="principal.nickname"/></b>
							<sec:authentication property="name"/>	
						</li>
						<li>
							<div>
							<img src="${pageContext.request.contextPath}/resources/assets/image/nation/test.png" style="height:70px; border: 1px solid #111;"/>
							</div>
							<div>
								<select class="form-select form-select-lg mb-3" id="cars" name="cars">
								    <option value="volvo">Volvo</option>
								    <option value="saab">Saab</option>
								    <option value="fiat">Fiat</option>
								    <option value="audi">Audi</option>
								    <option value="audi">Audi</option>
								    <option value="audi">Audi</option>
							  	</select>
							</div>
						</li>
						<li>
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
						</li>
						<li>
							 <a href="<c:url value='/settings/password' />">Password Settings</a>
						</li>
					</ul>
				</div>
			</div>
			
	      <div>
			<button id="p-save">save</button>
			<button id="p-cancel">cancel</button>
			
	      </div>
      
    </main>
