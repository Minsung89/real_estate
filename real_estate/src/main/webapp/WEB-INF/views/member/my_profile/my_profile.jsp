<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<main class="col-9 py-md-3 pl-md-5 bd-content l-main" role="main">
		<h1>My Profile</h1>
		<p>
			ID : <sec:authentication property="name"/><br/>
			권한 : <sec:authentication property="authorities"/><br/>
			닉네임:<sec:authentication property="principal.nickname"/><br/>
			이메일:<span id="m_email"><sec:authentication property="principal.eMail"/></span><br/>
			주소 : <sec:authentication property="principal.address"/><br/>
			포인트:<sec:authentication property="principal.point"/> VP <br/>
			국가 : <sec:authentication property="principal.nation"/> <br/>
	 		<sec:authentication property="principal.authState" var="authState"/>
			<c:choose>
   			    <c:when test="${authState eq 'N'}">
					<!-- <div class="bottom"> 
					        <button class="btn btn-default btn-ico" data-toggle="modal" data-target="#authModal">
					                인증하기
					        </button> 
					</div> -->
					<!-- Modal --> 
					<!-- <div class="modal fade " id="authModal" tabindex="-1" role="dialog" aria-labelledby="authModalLabel" aria-hidden="true"> 
					        <div class="modal-dialog"> 
					                <div class="modal-content"> 
					                        <div class="modal-header"> 
					                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> 
					                                <h4 class="modal-title" id="authModalLabel">이메일 인증하기</h4> 
					           	             </div> 
					                        <div class="modal-body"> 
					                              <input placeholder="인증번호를 입력하시오"> <button>인증번호 발송</button>
					                        </div> 
					                </div> 
					        </div> 
					</div> -->
					<h2>이메일 인증하기</h2>
                    <input placeholder="인증번호를 입력하시오"> <button id="send_email">인증번호 발송</button><br/>
                    <button>인증확인</button>
					
		        </c:when>
				<c:when test="${authState eq 'Y'}">
					인증했어
		        </c:when>
			</c:choose>
		</p>
		<a href="<c:url value='/my_profile/edit' />">edit</a>
	</main>
