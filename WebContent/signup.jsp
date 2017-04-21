<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<!-- jquery file -->
<script type="text/javascript" src="js/index.js"></script>
<!-- Style Sheet -->
<link rel="stylesheet" href="css/index.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/signup.css">
<script type="text/javascript" src="js/signup.js"></script>
<title>Sign-Up</title>
</head>
<body>
	<div class="row">
		<div class="col-md-offset-4 col-md-5 signup-form">
			<h3>Hello, Thanks for Choosing us.</h3>
			<br>
			<form id="form" action="signup" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name"> <span class="required">please
							type your name name:</span>
					</label> <input type="text" class="form-control" name="name" id="name"
						placeholder="please enter your name"><br> <span
						class="label label-danger" id="name-feedback"></span>
				</div>
				<div class="form-group">
					<label for="email"> <span class="required">please
							type your email:</span>
					</label> <input type="email" class="form-control" name="email" id="email"
						placeholder="please enter your email"><br> <span
						class="label label-danger" id="email-feedback"></span>
				</div>
				<div class="form-group">
					<label for="username"> <span class="required">please
							select a username:</span>
					</label> <input type="text" class="form-control" name="username"
						id="username" placeholder="please enter a username"><br> <span
						class="label label-danger" id="username-feedback"></span>
				</div>
				<div class="form-group">
					<label for="password"> <span class="required">please
							type a password:</span>
					</label> <input type="password" class="form-control" name="password"
						id="password" placeholder="please type a password"><br> <span
						class="label label-danger" id="password-feedback"></span>
				</div>
				<div class="form-group">
					<label for="dob"> <span class="required">please
							select your Date of Birth:</span>
					</label> <input type="date" class="form-control" name="dob" id="dob"><br>
					<span class="label label-danger" id="dob-feedback"></span>
				</div>
				<div>
					<label for="sex"> <span class="required">please
							select your sex: </span>
					</label> <select id="sex" name="sex">
						<option>Male</option>
						<option>Female</option>
					</select>
				</div>
				<div>
					<label for="interest"> <span class="required">please
							select your interest: </span>
					</label> <select id="interest" name="interest">
						<option>Male</option>
						<option>Female</option>
					</select>
				</div>
				<div class="form-group">
					<label for="zipcode"> <span class="required">please
							type your zipcode:</span>
					</label> <input type="text" maxlength="5" name="zipcode"
						class="form-control" id="zipcode"><br> <span
						class="label label-danger" id="zipcode-feedback"></span>
				</div>
				<div class="form-group">
					<label for="profilephoto"> <span class="required">Please
							upload your profile photo</span></label> <input type="file" name="profilephoto"
						class="form-control" id="profilephoto"><br> <span
						class="label label-danger" id="profilephoto-feedback"></span>
				</div>
				<div class="form-group">
					<label for="theme">Please select your profile theme : </label><br>
					<input type="radio" name="themes" value="1" checked><img
						style="width: 200px; height: 150px;" class="image-responsive"
						alt="" src="css/images/Themes/Theme_1.jpg"><br> <br>
					<input type="radio" name="themes" value="2"><img alt=""
						style="width: 200px; height: 150px;" class="image-responsive"
						src="css/images/Themes/Theme_2.jpg"><br> <br> <input
						type="radio" name="themes" value="3"><img alt=""
						style="width: 200px; height: 150px;" class="image-responsive"
						src="css/images/Themes/Theme_3.jpg"><br> <br> <input
						type="radio" name="themes" value="4"><img alt=""
						style="width: 200px; height: 150px;" class="image-responsive"
						src="css/images/Themes/Theme_4.jpg"><br> <br>
				</div>
				<input class="btn btn-success" id="btn" type="submit"
					value="Sign Up"> <br> <br>
			</form>
		</div>


	</div>
</body>
</html>