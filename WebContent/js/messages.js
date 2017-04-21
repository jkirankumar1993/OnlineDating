$(function() {
	 // return false;
	var theme = $("#usertheme").val();
	var g = $("body").css("backgroundImage","url('css/images/Themes/Theme_"+theme+".jpg')");
	$(".messages").hide();
	var form = $("#form");
	var user = "";
	$(".list").find("a").on("click",function(event){
	 user = event.target.id;
		$.ajax({
			type : "GET",
			url : "getuserconversation",
			data: {username: user},
			datatype: "json",
			success: function(data){				
				if(data.success){
					$(".messages").show();
					$(".messages").load("conversation_of_users.jsp").show();
					}
			},
			error: function() {
				console.log("error");
			}	
		});
		});
	setInterval(function(){
		if(user.trim()!=""){
			$.ajax({
				type : "GET",
				url : "getuserconversation",
				data: {username: user},
				datatype: "json",
				success: function(data){				
					if(data.success){
						$(".messages").load("conversation_of_users.jsp");
						var $mydiv = $("#msgs");
						 $mydiv.scrollTop($mydiv.height());
						$("#msgs").animate({ scrollTop: $("#msgs").height() }, "slow");
					}
				},
				error: function() {
					console.log("error");
				}	
			});
			 
		}		
	}, 5000);
	form.submit(function(event) {
		var message = $(".message_txt").val();
		if(user.trim()==""){
			event.preventDefault();
			alert("Select a user");
		}
		else{
			checkmessage(message,event);
			 console.log(user);
			$.ajax({
				type : "POST",
				url : "getuserconversation",
				data: {username: user,messages : $(".message_txt").val()},
				datatype: "json",
				success: function(data){				
					if(data.success){
						$(".messages").show();
						$(".messages").load("conversation_of_users.jsp");
					}
				},
				error: function() {
					console.log("error");
				}	
			});
			return false;
		}
	});
	function checkmessage(message,event) {
		if(message.trim()==""){
			event.preventDefault();
			alert("Please type a message");
		}
	}
});
