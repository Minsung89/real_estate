<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <div class="col-3 bd-sidebar">
      <ul class="nav panel-group accordion" id="accordionPanelsStayOpenExample">
        <li ><a href="<c:url value='/my_profile' />">MY PROFILE</a></li>
        <li style="cursor: pointer;">
        	<a class="accordion-header" id="s-h-wallet" data-bs-toggle="collapse"  data-bs-target="#s-wallet"  aria-expanded="true" aria-controls="s-wallet">
		        WALLET
		    </a>
		    <div id="s-wallet" class="accordion-collapse collapse" aria-labelledby="s-h-wallet">
		      <div class="accordion-body">
		      	<a href="<c:url value='/wallet/deposit' />">Deposit</a>
		      	<a href="<c:url value='/wallet/withdraw' />">Withdraw</a>
		      	<a href="<c:url value='/wallet/details' />">Details</a>
		      </div>
		    </div>
        </li>
        <li style="cursor: pointer;">
        	<a class="accordion-header" id="s-h-assets" data-bs-toggle="collapse"  data-bs-target="#s-assets"  aria-expanded="true" aria-controls="s-assets">
		        ASSETS
		    </a>
		    <div id="s-assets" class="accordion-collapse collapse" aria-labelledby="s-h-assets">
		      <div class="accordion-body">
		      	<a href="<c:url value='/assets/holdings' />">Holdings</a>
		      	<a href="<c:url value='/assets/history' />">History</a>
		      </div>
		    </div>
        </li>
        <li><a href="<c:url value='/settings' />">SETTING</a></li>
      </ul>
      <br>
	</div>