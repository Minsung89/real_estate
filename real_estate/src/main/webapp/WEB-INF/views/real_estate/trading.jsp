<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<!DOCTYPE html>
<html lang="en">
<script src='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css' rel='stylesheet' />

<style>
.bd-navbar {
  width: 100%;
  position: absolute;
}
</style>
	<div class="heading">
        <h1>Location</h1>  
    </div>
    <div id="listings" class="listings"></div>
	<div id='map' style='width: 100%; height: 100%;'></div>
	<div style="width: 300px; background-color: rgba(0,0,0,0.5);)" class="offcanvas offcanvas-start" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
	  <div class="offcanvas-header">
	    <h5 class="offcanvas-title" id="offcanvasScrollingLabel">Colored with scrolling</h5>
	    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
	  </div>
	  <div class="offcanvas-body">
	    <div class="row align-items-center" style="padding: 0 5px 0 5px; height: 100%;">
	    	<div style="height: 60%; width: 100%; background-color: #fff;  border-radius: 5px; padding: 5px 30px 0 30px; position: relative;">
	    		<dl style="margin-bottom: 10px;">
	    			<dt>
	    				<b style="display: block; font-size: 15px;">CIty Hall</b>
	    				<b style="display: block; font-size: 10px;">France 5th Lemres </b>
	    			</dt>
		    			<dd>
		    				<img src="${pageContext.request.contextPath}/resources/assets/image/real_estate_info_img.png" style="width: 100%; border-radius: 5px; margin-bottom: 5px;">
		    				<div class="row">
		    					<div class="col re-info-name"><b>B_Num</b></div>
		    					<div class="col re-info-val"><b>A2050024</b></div>
		    				</div>
		    				<div class="row">
		    					<div class="col re-info-name"><b>Owner</b></div>
		    					<div class="col re-info-val"><b>2VERSE</b></div>
		    				</div>
		    				<div class="row">
		    					<div class="col re-info-name"><b>Price</b></div>
		    					<div class="col re-info-val"><b>14,500 VP</b></div>
		    				</div>
		    				<div class="col" style="text-align: right; color: red">(+200%)</div>
		    			</dd>
	    			</dl>
		    		<ul style="list-style:none; padding: 0">
		    			<li><button class="re-info-btn">Detail infomation</button></li>
		    			<li><button class="re-info-btn">Offer</button></li>
		    			<li><button class="re-info-btn">Buy</button></li>
		    		</ul>
	    			<label class="re-info-grade">Grade2</label>
	    		</div>
	    	</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/map.js"></script>
</html>
