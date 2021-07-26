<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <main class="col-9 py-md-3 pl-md-5 bd-content" role="main">
      <h1>MY_PROFILE</h1>
      <sec:authentication property="name"/>
      <sec:authentication property="authorities"/>

    </main>
