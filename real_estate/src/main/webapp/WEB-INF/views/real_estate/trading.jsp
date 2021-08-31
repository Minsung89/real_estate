<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<!DOCTYPE html>
<html lang="en">
<script src='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css' rel='stylesheet' />
<script src="https://unpkg.com/@turf/turf@6/turf.min.js"></script>
<style>
.bd-navbar {
  width: 100%;
  position: absolute;
}
</style>
	<div id='map' style='width: 100%; height: 100%;'>
		<div style="width: 300px; background-color: rgba(0,0,0,0.5);" class="offcanvas offcanvas-start" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
		  <div class="offcanvas-header" style="margin-top: 80px;">
		    <h5 class="offcanvas-title" id="offcanvasScrollingLabel">Colored with scrolling</h5>
		    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close" style="color:#fff"></button>
		  </div>
		  <div class="offcanvas-body">
		    <div class="row align-items-center" style="padding: 0 5px 0 5px;">
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
			    					<div class="col re-info-val" id="assets_number">A2050024</div>
			    				</div>
			    				<div class="row">
			    					<div class="col re-info-name"><b>Owner</b></div>
			    					<div class="col re-info-val" id="real_estate_nickname">2VERSE</div>
			    				</div>
			    				<div class="row">
			    					<div class="col re-info-name"><b>Price</b></div>
			    					<div class="col re-info-val"><span id="real_estate_price">1000</span> VP</div>
			    				</div>
			    				<div class="col" style="text-align: right; color: red">(+200%)</div>
			    			</dd>
		    			</dl>
			    		<ul style="list-style:none; padding: 0">
			    			<li><button class="re-info-btn">Detail infomation</button></li>
			    			<li><button class="re-info-btn">Offer</button></li>
			    			<li><button class="re-info-btn" data-bs-toggle="modal" data-bs-target="#buyCheck">Buy</button></li>
			    		</ul>
		    			<label class="re-info-grade">Grade2</label>
		    		</div>
		    	</div>
			</div>
		</div>
		<div style="position: fixed; right: 0; top: 10%; z-index: 1">
				<button id ="selected_satellite">위성</button>
				<button id = "selected_2d">2d</button>
				<button id = "selected_3d">3d</button>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="buyCheck" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" style="background-color: rgba(0,0,0,0.2); z-index: 9999; ">
			<div class="modal-dialog" style="width: 400px;">
				<div class="modal-content" style="width: 100%;">
					<div class="modal-header row">
						<div class="col-10">
							<span class="modal-title" id="staticBackdropLabel " style="font-size: 18px; font-weight: bolder;">purchase confirmation</span>
						</div>
						<div class="col-2 text-end">
							<button type="button" class="btn-close " data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
					</div>
					<div class="modal-body">
						<p style="font-size: 22px; font-weight: lighter;">Are you sure you want to buy it?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCEL</button>
						<button type="button" class="btn btn-primary" id="buyCheckOkBtn">O K</button>
	    			</div>
	  			</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/map.js"></script>
</html>
