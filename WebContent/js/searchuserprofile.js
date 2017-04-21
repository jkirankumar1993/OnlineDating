$(function() {
	var username = $("#username").val();
	var theme = $("#usertheme").val();
	var g = $("body").css("backgroundImage","url('css/images/Themes/Theme_"+theme+".jpg')");
	
	$.ajax({
		type : "GET",
		url : "get_liked_or_not_info",
		data: {username: $("#username").val()},
		datatype: "json",
		success: function(data){				
			if(data.success){
				$(".like-btn").attr("src","css/images/heart.png");
			}
			else{
				$(".like-btn").attr("src","css/images/blackheart.png");
			}
		},
		error: function() {
			console.log("error");
		}	
	});
	
	$(".like-btn").click(function(){
		$.ajax({
			type : "POST",
			url : "get_liked_or_not_info",
			data: {username: $("#username").val()},
			datatype: "json",
			success: function(data){				
				if(data.success){
					$(".like-btn").attr("src","css/images/heart.png");
				}
				else{
					$(".like-btn").attr("src","css/images/blackheart.png");
				}
				$("#likes").empty();
				$("#likes").text(data.likes);
			},
			error: function() {
				console.log("error");
			}	
		});
	});
	
	$(".message-btn").click(function(){
		$.ajax({
			type:"GET",
			url: "conversation",
			data: {username: $("#username").val()},
			datatype: "json",
			success: function(data){
				if(data.success){
					console.log("success");
				}
			}
		});
	});
	
	
});