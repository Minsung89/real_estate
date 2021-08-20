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
				<ul class="col row" style="list-style: none;">
					<li style=" text-align: left; margin-bottom: 50px;">
						<b style="font-size: 55px;" id="setting_nickname"><sec:authentication property="principal.nickname"/></b>
						<img src="${pageContext.request.contextPath}/resources/assets/image/nickname_update_icon.png" id="nickname_update_btn">
						<span id="setting_userId"><sec:authentication property="name"/></span>
						<div class="input-group" style="position: absolute; bottom: -30px; width: 300px;" id="nickname_update-group">
							<input type="text" class="form-control" id="nickname_update_data">
							<button class="btn btn-outline-secondary" type="button" id="nickname_update_ok">ok</button>
							<button class="btn btn-outline-secondary" type="button" id="nickname_update_cancel">cancel</button>
						</div>
					</li>
					<li>
						<div>
						<sec:authentication property="principal.nation" var="myNation"/>
						<img src="${pageContext.request.contextPath}/resources/assets/image/nation/${myNation }.png" id="my_nation_edit" style="height:70px;"/>
						</div>
						<div>
							<select class="form-select form-select-lg mb-3" id="nationList" name="nationList">
							 <c:forEach var ="i" items = "${nation }">
								 <c:choose>
							         <c:when test = "${myNation eq i}">
								    	<option value="${i}" data-image="${pageContext.request.contextPath}/resources/assets/image/nation/${i }.png" selected="selected">${i}</option>
							         </c:when>
							         <c:otherwise>
								   		<option value="${i}" data-image="${pageContext.request.contextPath}/resources/assets/image/nation/${i }.png">${i}</option>
							         </c:otherwise>
							     </c:choose>
				    		</c:forEach>
						  	</select>
						</div>
					</li>
					<li>
						<div style="padding: 0 5rem;">
							<sec:authentication property="principal.authState" var="authState"/>
							<c:choose>
				   			    <c:when test="${authState eq 'N'}">
				                    <!-- Button trigger modal -->
									<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#authenticationBtn">
									  Authentication required
									</button>
				                    <!-- Modal -->
									<div class="modal fade" id="authenticationBtn" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" style="background-color: rgba(0,0,0,0.2); z-index: 9999">
									  <div class="modal-dialog">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h4 class="modal-title" id="staticBackdropLabel">Authentication</h4>
									        <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
									        <p>Send Email button and click<br/>
											Please check the email used in your account.</p>
									      </div>
									      <div class="modal-body">
									        <label for="password">Input code</label>
											<div class="input-group" id="">
												<input type="text" class="form-control" id="email_validation_data">
												<button class="btn btn-outline-secondary" type="button" id="send_email"  style="width: 80px; font-weight: bolder;">send to email</button>
											</div>	
											<span class="signup-validation-paragraph" id="email_validation_check">* Invalid code. </span>
											
										  </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCEL</button>
									        <button type="button" class="btn btn-primary" id="email_validation_ok">O K</button>
									      </div>
									    </div>
									  </div>
									</div>
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
					<li>
						 <h5>REFERRAL CODE:</h5>
					</li>
					<li>
						 cancel membership
					</li>
				</ul>
			</div>
		</div>
    </main>
