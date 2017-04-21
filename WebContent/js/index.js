/**
 * 
 */
var images = [ "css/images/dating/dating1.jpg",
		"css/images/dating/dating2.jpg", "css/images/dating/dating3.jpg",
		"css/images/dating/dating4.png" ];
$(function() {
	console.log("jquery started");
	var i = 0;
	setInterval(function() {
		i = (i + 1) % images.length;
		$(".heading-text").find("img").fadeOut(function() {
			$(this).attr("src", images[i]);
			$(this).fadeIn(1000);
		});
	}, 5000);

	setInterval(function() {
		animatesearch();

	}, 2000);

	function animatesearch() {
		$(".feature").fadeOut(1000);
		$(".feature").css("color", "red");
		$(".feature").fadeIn(1000);
		$(".feature").fadeOut(1000);
	}

	$("#loginform").submit(function(event) {
	 	var username = $("#username").val();
	 	var validusername =	checkusername(username, event);
		var password = $("#password").val();
		var validpassword = checkpassword(password, event);
		
	});
	
	var form = $("#loginform");
	var usernameInput = form.find("#username");
	var passwordInput = form.find("#password");
	
	usernameInput.blur(function(event){
		var username = $("#username").val();
		checkusername(username, event);
	});
	
	passwordInput.blur(function(event){
		var password = $("#password").val();
		checkpassword(password, event);
	});

	function checkusername(username, event) {
		if (username.length < 6) {
			$("#username-feedback").text(
					"username must be atleast 6 characters");
			event.preventDefault();
			return false;
		}
		else{
			$("#username-feedback").text("");
			return true;
		}
	}

	function checkpassword(password, event) {
		if (!isvalidpassword(password)) {
			$("#password-feedback")
					.text("password must have atleast 8 letters");
			event.preventDefault();
			return false;
		} else {
			$("#password-feedback").text("");
			return true;
		}
	}

	function isvalidpassword(password) {
		if (password.length >= 8) {
			return true;
		} else {
			return false;
		}
	}

});