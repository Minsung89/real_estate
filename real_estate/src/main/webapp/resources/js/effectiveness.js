window.onload = function(){
	//유효성 검사
	validationKey($('#userId'));
	validationKey($('#password'));
	validationKey($('#confirmpassword'));
	validationKey($('#nickname'));
	
	$('#signup-validation').click(function(){
		if($('#serId').val() !== null 
			&& $('#userId').val().length > 0
			&& $('#password').val() !== null 
			&& $('#password').val().length > 0
			&& $('#confirmpassword').val() !== null 
			&& $('#confirmpassword').val().length > 0
			&& $('#nickname').val() !== null 
			&& $('#nickname').val().length > 0
			&& $('#userId-vp').css('visibility') === 'hidden'
			&& $('#password-vp').css('visibility') === 'hidden'
			&& $('#confirmpassword-vp').css('visibility') === 'hidden'
			&& $('#nickname-vp').css('visibility') === 'hidden'
			&& $("input:checkbox[id='terms-checkbox']").is(":checked")){
			return true;
		}else{
			alert("입력 제대로해라");
			return false;
		}
	});
}

var validationKey = function(id) {
	id.keyup(function(e) {
			switch (id[0].id) {
			case 'userId': //email 
				isUserId(id);
				break;
			case 'password': //password
				isPassword(id);
				break;
			case 'confirmpassword': //password 확인
				isConfirmpassword(id);
				break;
			case 'nickname': //nickname
				isNickname(id);
				break;
			default:
				break;
			}
	});
}

var hidden = function(id) {
	id.css('visibility','hidden');
}

var visible = function(id) {
	id.css('visibility','visible');
}

var isUserId = function(id) {
	var email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	
	if(id.val() == null || id.val().trim().length < 1 ){
		hidden($('#userId-vp'));
	}else if(email.test(id.val())){
		var userId = id.val(); 
	    let sendData = {'userId' : userId};
		console.log(userId);
		$.ajax({
			type:'post',
			url:'/signup/id-check',  
			data:sendData,
			dataType:'text',
			success : function(data){
				console.log(data);
				if(data==='true'){
					hidden($('#userId-vp'));
				}
				else{
					
					visible($('#userId-vp'));
				}
			},
			error: function (request, status, error){
				console.log(request); 
				console.log(status); 
				console.log(error); 
			}

		});
		
	}else {
		visible($('#userId-vp'));
	}
}

var isPassword = function(id) {
	var num = id.val().search(/[0-9]/g);
	var eng = id.val().search(/[a-z]/ig);
	var spe = id.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(id.val() == null || id.val().length < 1 ){
		hidden($('#password-vp'));	
		return;
	}
	if(id.val().length < 10){
		visible($('#password-vp'));
	}else if(id.val().search(/\s/) != -1){
		visible($('#password-vp'));
	}else if(num < 0 || eng < 0 || spe < 0 ){
		visible($('#password-vp'));
	}else {
		hidden($('#password-vp'));	
	}
}

var isConfirmpassword = function(id) {
	if(id.val() == null || id.val().length < 1 ){
		hidden($('#confirmpassword-vp'));	
		return;
	}
	if($('#password').val() !== id.val()){
		visible($('#confirmpassword-vp'));
	}else{
		hidden($('#confirmpassword-vp'));
	}
}

var isNickname = function(id) {
	var nik = /^[~`!@#$%^&*()_+=[\]\{}|;':",.\/<>?a-zA-Z0-9-]+$/;
	
	if(id.val() == null || id.val().trim().length < 1 ){
		hidden($('#nickname-vp'));
		return;
	}
	if(id.val().length > 10){
		visible($('#nickname-vp'));
	}else if(!nik.test(id.val())){
		visible($('#nickname-vp'));
	}else {
		hidden($('#nickname-vp'));	
	}
}

