window.onload = function(){
	var passConfirmBtn =
		$('#passConfirmBtn').click(function(){
			var userId = $('input[name=userId]').val(); 
			var password = $('input[name=password]').val();
			let sendData = {'userId' : userId, 'password' : password}; 
		  
			$.ajax({
				type:'post',
				url:'/settings/password',  
				data:sendData,
				dataType:'text',
				success : function(data){
					console.log(data);
					if(data==='passwordConfirmOk'){
						location.replace('../password_change');
					}
					else{
						alert("패스워드 틀렷다잉");
						$('input[name=password]').val('');
					}
				},
				error: function (request, status, error){
					console.log(request); 
					console.log(status); 
					console.log(error); 
				}
		
			})
		});
	$('input[name=password]').keypress(function(event){ //엔터키
	     if ( event.which == 13 ) {
	         $('#passConfirmBtn').click();
	         return false;
	     }
	});
}

