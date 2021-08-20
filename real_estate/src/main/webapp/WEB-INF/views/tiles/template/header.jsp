<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Business Frontpage - Start Bootstrap Template</title>
   <!-- Favicon-->
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/dd.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/effectiveness.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dd.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script>
// 전역변수 설정
var socket  = null;
$(document).ready(function(){
    // 웹소켓 연결
    sock = new SockJS('http://localhost:8009/push');
	socket = sock;
    // 연결확인
   	sock.onopen = function() {
        console.log('info: connection opened.');
    };
    // 데이터를 전달 받았을때 
    sock.onmessage = onMessage; // toast 생성

    sock.onerror = function (err) {console.log('Errors : ' , err);};

    sock.onclose = function() {
      	console.log('connect close');
      	/* setTimeout(function(){conntectWs();} , 1000); */
    };
});

             
// toast생성 및 추가
function onMessage(evt){
    var data = evt.data;
    // toast
   // let toast = "<div class='toast show' role='alert' aria-live='assertive' aria-atomic='true'>";
   // toast += "<div class='toast-header'><i class='fas fa-bell mr-2'></i><strong class='mr-auto'>알림</strong>";
   // toast += "<small class='text-muted'>just now</small><button type='button' class='ml-2 mb-1 close' data-dismiss='toast' aria-label='Close'>";
   // toast += "<span aria-hidden='true'>&times;</span></button>";
   // toast += "</div> <div class='toast-body'>" + data + "</div></div>";
   // $("#msgStack").append(toast);   // msgStack div에 생성한 toast 추가
   // $(".toast").toast({"animation": true, "autohide": false});
   // $('.toast').toast('show');
    $('.m-point').html($('.m-point').html()+1);
};	


</script>