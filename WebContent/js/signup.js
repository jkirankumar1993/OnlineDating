$(function() {
	var form = $("#form");
	var nameInput = form.find("#name");
	var emailInput = form.find("#email");
	var usernameInput = form.find("#username");
	var passwordInput = form.find("#password");
	var dobInput = form.find("#dob");
	var zipcodeInput = form.find("#zipcode");
	var theme = form.find("input:radio");
	var profilephoto = form.find("#profilephoto");

	form.submit(function(event) {
		var name = $("#name").val();
		checkname(name, event);
		var email = $("#email").val();
		checkemail(email, event);
		var username = $("#username").val();
		checkusername(username, event);
		var password = $("#password").val();
		checkpassword(password, event);
		var dob = $("#dob").val();
		var dateofbirth = new Date(dob);
		checkage(dateofbirth, event);
		var zipcode = $("#zipcode").val();
		checkzipcode(zipcode,event);
		var photo = $("#profilephoto").val();
		checkprofilephoto(photo, event);
	});

	nameInput.blur(function(event) {
		var name = $("#name").val();
		checkname(name, event);
	});

	emailInput.blur(function(event) {
		var email = $("#email").val();
		checkemail(email, event);
	});

	usernameInput.blur(function(event) {
		var username = $("#username").val();
		checkusername(username, event);
	});

	passwordInput.blur(function(event) {
		var password = $("#password").val();
		checkpassword(password, event);
	});

	dobInput.blur(function(event) {
		var dob = $("#dob").val();
		var dateofbirth = new Date(dob);
		console.log(dob);
		checkage(dateofbirth, event);
	});

	zipcodeInput.blur(function(event) {
		var zipcode = $("#zipcode").val();
		checkzipcode(zipcode, event);

	});

	profilephoto.blur(function(event) {
		var photo = $("#profilephoto").val();
		checkprofilephoto(photo, event);
	});

	theme.click(function() {
		console.log("image clicked");
		var val = $(this).val();
		var src = "css/images/Themes/Theme_" + val + ".jpg";
		$("body").css("backgroundImage", "url('" + src + "')");
	});

	function checkprofilephoto(val, event) {
		if (val.trim() == "") {
			$("#profilephoto-feedback")
					.text("please upload your profile photo");
			event.preventDefault();
		} else {
			switch (val.substring(val.lastIndexOf('.') + 1).toLowerCase()) {
			case 'gif':
			case 'jpg':
			case 'png':
				$("#profilephoto-feedback").text("");
				break;
			default:
				$("#profilephoto-feedback").text(
						"photo must be a type of gif or jpg or png");
				event.preventDefault();
				break;
			}
		}

	}

});

function checkusername(username, event) {
	if (username.length > 5) {
		$.ajax({
			type : "GET",
			url : "checkusername",
			data: {username : $("#username").val()},
			success : function(data) {
				if (data == "true") {
					$("#username-feedback").text("username available");
				} else {
					$("#username-feedback").text("username not available");
					event.preventDefault();
				}
			}
		});
	} else {
		$("#username-feedback").text("username must be atleast 6 characters");
		event.preventDefault();
	}
}

function checkname(name, event) {
	if (!isvalidname(name)) {
		$("#name-feedback").text("A name must have atleast two characters");
		event.preventDefault();
	} else {

		$("#name-feedback").text("");
	}
}

function isvalidname(name) {
	if (name.length > 2) {
		return true;
	} else {
		return false;
	}
}

function checkpassword(password, event) {
	if (!isvalidpassword(password)) {
		$("#password-feedback").text("password must have atleast 8 letters");
		event.preventDefault();
	} else {
		$("#password-feedback").text("");
	}
}

function isvalidpassword(password) {
	if (password.length >= 8) {
		return true;
	} else {
		return false;
	}
}

function checkemail(email, event) {
	if (!isvalidemail(email)) {
		$("#email-feedback").text("invalid email address");
	} else {
		$("#email-feedback").text("");
	}
}

function isvalidemail(email) {
	if (email.match(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/)) {
		return true;
	} else {
		return false;
	}
}

function checkage(dob, event) {
	if (dob != "" && dob != null) {
		if (!validage(dob)) {
			$("#dob-feedback").text("you must be atleast 18 years old")
		} else {
			$("#dob-feedback").text("");
		}
	} else {
		$("#dob-feedback").text("Please select a date");
		event.preventDefault();
	}
}

function validage(dob) {
	var today = new Date();
	console.log(today);
	var dayDiff = Math.ceil(today - dob) / (1000 * 60 * 60 * 24 * 365);
	var age = parseInt(dayDiff);
	if (age > 18) {
		return true;
	} else {
		return false;
	}
}

function checkzipcode(zipcode, event) {
	if (zipcode.trim() == "") {
		$("#zipcode-feedback").text("please type your zipcode");
		event.preventDefault();
	} else {
		if ($.isNumeric(zipcode)) {
			if (zipcode.length != 5) {
				$("#zipcode-feedback").text("zipcode must be 5 digits");
				event.preventDefault();
			} else {
				$("#zipcode-feedback").text("");
			}
		} else {
			$("#zipcode-feedback").text("zipcode must be a number");
			event.preventDefault();
		}
	}

}
