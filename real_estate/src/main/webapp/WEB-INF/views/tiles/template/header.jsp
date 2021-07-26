<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Business Frontpage - Start Bootstrap Template</title>
   <!-- Favicon-->
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css' rel='stylesheet' />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/map.js"></script>
<style>
.bd-navbar {
  position: sticky;
  top: 0;
  z-index: 1071;
  min-height: 4rem;
  box-shadow: 0 0.5rem 1rem rgba(0,0,0,.05), inset 0 -1px 0 rgba(0,0,0,.1);
}
.bd-sidebar {
  position: fixed;
  z-index: 1000;
  height: calc(100vh - 4rem);
  background: #212529;
  border-right: 1px solid rgba(0,0,0,.1);
  overflow-y: auto;
  min-width: 160px;
  max-width: 220px;
  width: 25%;	
}
.bd-sidebar .nav {
  display: block;
  padding-top: 30px;
}
.bd-sidebar .nav>li>a {
  display: block;
  padding: .25rem 1.5rem;
  font-size: 25px;
  color: #ffffff;
  text-decoration: none;
  font-style: normal;
  font-weight: bold;
}
.bd-sidebar .nav>li>a:focus, .bd-sidebar .nav>li>a:hover{
	text-decoration: none;
	color: rgba(255, 255, 255, 0.75);
	background-color: #212529;
}
.l-main{
	margin-left: 220px;
}
</style>

