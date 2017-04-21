$(function() {
	var username = $("#username").val();
	var theme = $("#usertheme").val();
	$("#statusbar").hide();
	$("#search_by_name").hide();
	$("#advanced_search").hide();
	$("#search_user_by_name_display").hide();
	$("#advancedsearch_user").hide();
	var g = $("body").css("backgroundImage","url('css/images/Themes/Theme_"+theme+".jpg')");
	
	
	$("#search_by_name_link").click(function() {
		$("#search_by_name").toggle();
		$("#advanced_search").hide();
		$("#advancedsearch_user").hide();
	});
	
	$("#advanced_search_link").click(function() {
		$("#advanced_search").toggle();
		$("#search_by_name").hide();
		$("#search_user_by_name_display").hide();
	});
	
	
	$("#updatestatuslink").click(function() {
		$("#statusbar").toggle();
	});
	
	var search_by_name_form = $("#search_by_name_form");
	var advanced_search_form = $("#advanced_search_form");
	$("#search_box").blur(function(event){
		var name = $("#search_box").val();
		if(name){
			$("#searchname-feedback").text("");
		}
		else{
			$("#searchname-feedback").text("Please type a search string");
			event.preventDefault();
		}
	});
	
	
	search_by_name_form.submit(function(event){
		var name = $("#search_box").val();
		if(name){
			$("#searchname-feedback").text("");
			//Here Ajax Call
			$.ajax({
				type : "POST",
				url : "searchuser",
				data: {username: $("#search_box").val()},
				success: function(data){		
					if(data.success){
						console.log(data);
						console.log(data.success);
						$("#search_user_by_name_display").show();
						$("#search_user_by_name_display").load("display_user_search_by_name.jsp").fadeIn();
					}
					$("#search_user_by_name_display").show();
					$("#search_user_by_name_display").load("display_user_search_by_name.jsp").fadeIn();
				},
				error: function() {
					console.log("error");
				}	
			});
			return false;
		}
		else{
			$("#searchname-feedback").text("Please type a search string");
			event.preventDefault();
		}
	});
	
	advanced_search_form.submit(function(event){
		var minage = $("#min_age").val();
		var maxage = $("#max_age").val();
		var sex = $("#sex_search option:selected").val();
		var interest = $("#interest_search option:selected").val();
		var distance = $("#distance option:selected").val();
			if ($.isNumeric(minage) && $.isNumeric(maxage)){
				if(maxage>minage){
					$("#age-feedback").text("");
					// Here ajax call
					//var datastring = {'sex': $("#sex_search option:selected").val(),'minage': $("#min_age").val(),'maxage': $("#max_age"),'interest': $("#interest_search option:selected").val(),'distance': $("#distance").val()};
					$.ajax({
						type : "POST",
						url : "advancedsearch",
						data: $("#advanced_search_form").serialize(),
						success: function(data){		
							if(data.success){
								$("#advancedsearch_user").show();
								$("#advancedsearch_user").load("display_user_advancedsearch.jsp").fadeIn();
							}
							$("#advancedsearch_user").show();
							$("#advancedsearch_user").load("display_user_advancedsearch.jsp").fadeIn();
						},
						error: function() {
							console.log("error");
						}	
					});
					return false;
				}
				else{
					$("#age-feedback").text("min age can't be more than max age.");
					event.preventDefault();
				}
			}
			else{
				$("#age-feedback").text("Age is compulsary and must be a number.");
				event.preventDefault();
			}
		
		
		
	});
	
	
	// Getting user information for side header for the first time.
	$.ajax({
		type : "GET",
		url : "getuserinformation",
		data: {username: $("#username").val()},
		datatype: "json",
		success: function(data){				
			$.each(data, function(index, element) {
			    $("#name").text(element.name);
			    $("#dob").text(element.dob);
			    $("#sex").text(element.sex);
			    $("#interest").text(element.interest);
			    $("#likes").text(element.likes);
			    $("#views").text(element.views);
			    
			});
		},
		error: function() {
			console.log("error");
		}	
	
	});
	
	
	//Getting user side header information
	setInterval(function() {
		$.ajax({
			type : "GET",
			url : "getuserinformation",
			data: {username: $("#username").val()},
			datatype: "json",
			success: function(data){				
				$.each(data, function(index, element) {
				    $("#name").text(element.name);
				    $("#dob").text(element.dob);
				    $("#sex").text(element.sex);
				    $("#interest").text(element.interest);
				    $("#likes").text(element.likes);
				    $("#views").text(element.views);
				    
				});	
			},
			error: function() {
				console.log("error");
			}	
		
		});
	}, 25000);
});

function search_name(username) {
	if(username.trim()==""){
		return false;
	}	
	else{
		return true;
	}
}