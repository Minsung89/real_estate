<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<!DOCTYPE html>
<html lang="en">
<script src='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css' rel='stylesheet' />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/map.js"></script>
<style>
.bd-navbar {
  width: 100%;
  position: absolute;
}
</style>
	<div id='map' style='width: 100%; height: 100%;'></div>

</html>
