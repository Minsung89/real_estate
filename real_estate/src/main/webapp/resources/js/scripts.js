/*!
* Start Bootstrap - Business Frontpage v5.0.2 (https://startbootstrap.com/template/business-frontpage)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-business-frontpage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
//=======
//* Start Bootstrap - Freelancer v7.0.2 (https://startbootstrap.com/theme/freelancer)
//* Copyright 2013-2021 Start Bootstrap
//* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-freelancer/blob/master/LICENSE)
//*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 72,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });
    
    $('#p-save').click(function() {
    	if($('input[name=pass]').val() == null || $('input[name=pass]').val() == ''){
    		return
    	}
    	console.log($('input[name=nickname]').val());
    	console.log($('input[name=pass]').val());
    	console.log($('input[name=description]').val());
    	console.log($('input[name=nation]').val());
	});
    
   var validationCode; //인증코드
   $('#send_email').click(function(){ //이메일 인증
	   var timeleft = 60;
	   $('#send_email').addClass('disabled');
	   $('#send_email').css('color','#ff0000');
	   $('#send_email').text(timeleft +"s");
		var downloadTimer= setInterval(function(){
			timeleft -= 1;
			$('#send_email').text(timeleft +"s");
			   if(timeleft <= 0){
				   $('#send_email').css('color','#111111');
				   $('#send_email').removeClass('disabled');
				   $('#send_email').text("재발송");
				   clearInterval(downloadTimer);
			   }
			   console.log(timeleft);
			 }, 1000);
		var email = $('#setting_userId').text(); 
		var nickname = $('#setting_nickname').text();
	    let sendData = {'email' : email, 'nickname' : nickname};//폼의 이름 값을 변수 안에 담아줌
		console.log(sendData);
		$.ajax({
			type:'post',   //post 방식으로 전송
			url:'/my_profile/auth-email',   //데이터를 주고받을 파일 주소
			data:sendData,   //위의 변수에 담긴 데이터를 전송해준다.
			dataType:'text',   //html 파일 형식으로 값을 담아온다.
			success : function(data){   //파일 주고받기가 성공했을 경우. data 변수 안에 값을 담아온다.
				validationCode = data;
				console.log(data);
			}
		});
	});
  
   $('#email_validation_ok').click(function(){ //이메일인증 Ok
	   var validationInput = $('#email_validation_data').val();
	   console.log(validationInput);
	   if(validationCode === validationInput){
		   let sendData = {'auth_state' : 'Y'};
		   $.ajax({
	  			type:'post',  
	  			url:'/settings/update',  
	  			data:sendData,   
	  			dataType:'text', 
	  			success : function(data){  
	  				if(data === 'success'){
	  					console.log(true);
	  					alert('인증완료');
//	  					$('.modal').modal("hide"); //닫기 
	  					location.reload();
	  				}
	  			}
	  		 });
		   
	   }else{
		   $('#email_validation_check').css('visibility','visible');
	   }
	   
   });
   
   	//나라설정
     $('#nationList').msDropDown(); 
     
     //나라 수정
     $('#nationList').change(function() {
    	 var selectNation = $("#nationList option:selected").val();
    	 let sendData = {'nation' : selectNation};
    	 $.ajax({
  			type:'post',  
  			url:'/settings/update',  
  			data:sendData,   
  			dataType:'text', 
  			success : function(data){  
  				if(data === 'success'){
  					$("#my_nation_edit").attr("src", "/resources/assets/image/nation/" + selectNation + ".png");
  				}
  			}
  		 });
    	 
     });
     
     //닉네임수정
     $('#nickname_update_btn').click(function() {
 		$('#nickname_update-group').css('visibility', 'visible');
      });

     $('#nickname_update_ok').click(function(){ 
    	 console.log($('#nickname_update_data').val());
    	 let sendData = {'nickname' : $('#nickname_update_data').val()};
    	 $.ajax({
 			type:'post',  
 			url:'/settings/update',  
 			data:sendData,   
 			dataType:'text', 
 			success : function(data){  
 				if(data === 'success'){
 					$('#setting_nickname').text($('#nickname_update_data').val());
 					$('#nickname_update-group').css('visibility','hidden');
 					$('#nickname_update_data').val('');
 				}
 			}
 		});
     });
	
     $('#nickname_update_cancel').click(function(){ //취소
    	 $('#nickname_update-group').css('visibility','hidden');
    	 $('#nickname_update_data').val('');
     });
});

