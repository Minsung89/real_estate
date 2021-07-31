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
	    이메일:<sec:authentication property="principal.eMail"/><br/>
	    주소 : <sec:authentication property="principal.address"/><br/>
	    포인트:<sec:authentication property="principal.point"/> VP
	    국가 : <sec:authentication property="principal.nation"/>
	  </p>
	  <a href="<c:url value='/my_profile/edit' />">edit</a>
    </main>
