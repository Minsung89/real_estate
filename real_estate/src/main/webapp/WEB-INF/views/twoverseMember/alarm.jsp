<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main class="col-9 py-md-3 pl-md-5 bd-content l-main" role="main">
      <h1>Alarm</h1>
		<button id="pushBtn">알람보내기</button>
		<script type="text/javascript">
		// notifySend
		$('#pushBtn').click(function(e){
		    let type = '70';
		    let target ='minsung0217@gmail.com';
		    let content = 'test';
		    let url = '/notice/faq';
            // 소켓에 전달되는 메시지
            // 위에 기술한 EchoHandler에서 ,(comma)를 이용하여 분리시킨다.
            console.log("pushBtn");
            socket.send("관리자,"+target+","+content+","+url);	
		    });
		</script>
		<div id="msgStack"></div>
    </main>
