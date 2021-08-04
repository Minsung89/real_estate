<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<!DOCTYPE html>
<html lang="en">
 <!-- Header-->
     <main class="ct-content" role="main">
		<h1>Update</h1>
		<hr>
		<div class="container-fluid">
			<!-- 그룹 태그로 role과 aria-multiselectable를 설정한다. -->
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				<!-- 하나의 item입니다. data-parent 설청과 href 설정만 제대로 하면 문제없이 작동합니다. -->
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" data-toggle="collapse" data-parent="#accordion" href="#collapse1" aria-expanded="false">
						<div class="row">
					   		<div class="col">
						     	<b>2verse</b>
						    </div>
						    <div class="col-7">
						     	title1
						    </div>
						    <div class="col">
						    	2021-08-04
						    </div>
				  		</div>
					</div>
					<div id="collapse1" class="panel-collapse collapse" role="tabpanel">
						<div class="panel-body">
							Congratulations on your subscription!!<br>
							We are a B2B product company to help business adopt 360 VR because we believe this will protect many businesses and open thousands business opportunities in the future. Our alpha platform for example is usable for some businesses with just clicking a few buttons. The app install section is just like an app store that allows different businesses get customized feature for their own particular needs. Our landtax will be given for those helping to use or share about our products where a 360 scan from their land location is required. This resembles a regional sales reps commission structure in an enterprise. This landtax is the very value of our virtual land. We are trying to provide VREaaS to companies to solve their issues or to bring their business to the next level.
						</div>
					</div>
				</div>
				<!-- 하나의 item입니다. -->
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false">
						<div class="row">
					   		<div class="col">
						     	<b>2verse</b>
						    </div>
						    <div class="col-7">
						     	title2
						    </div>
						    <div class="col">
						    	2021-08-04
						    </div>
				  		</div>
					</div>
					<div id="collapse2" class="panel-collapse collapse" role="tabpanel">
						<div class="panel-body">
							Hello world2
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false">
						<div class="row">
					   		<div class="col">
						     	<b>2verse</b>
						    </div>
						    <div class="col-7">
						     	title3
						    </div>
						    <div class="col">
						    	2021-08-04
						    </div>
				  		</div>
					</div>
					<div id="collapse3" class="panel-collapse collapse" role="tabpanel">
						<div class="panel-body">
							Hello world3
						</div>
					</div>
				</div>
			</div>
		</div>
     </main>
</html>
