<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/index.js"></script>
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
<title>Connect</title>
</head>
<body>
	<nav>
	<div class="row">
		<div class="col-md-2 col-md-offset-5 visible-lg nav-image">
			<img alt="" src="css/images/company_logo_black.png"
				class="company_logo">
		</div>
		<div class="col-md-5">
			<div class="main-nav">
				<a href="#aboutme1">About Us</a> <a href="signup.jsp">Sign Up</a> <a href="#loginform">Login</a>
			</div>
		</div>
	</div>
	</nav>
	<div class="header jumbotron">
		<div class="row">
			<div class="col-sm-6 hidden-xs hidden-sm heading-text">
				<h2>Love is like a virus. It can happen to anybody at any time.</h2>
				<img class="img-rounded img-responsive" id="image"
					src="css/images/dating/dating1.jpg">
			</div>
			<div class="col-sm-4 login-form" id="loginform">
				<br>
				<h3>Hello</h3>
				<br>
				<form id="loginform" method="post" action="login">
					<div class="form-group">
						<label for="username"> <span class="required">Username:</span>
						</label> <input type="text" class="form-control" name="username"
							placeholder="please enter your username">
							<span id="username-feedback"></span>
					</div>
					<div class="form-group">
						<label for="password"> <span class="required">Password:</span>
						</label> <input type="password" class="form-control" name="password"
							placeholder="please enter your password">
							<span id="password-feedback"></span>
					</div>
					<input class="btn btn-success" id="btn" type="submit" value="Login">
				</form>
				<br> <a class="fancy-link">Forgot Password?</a> &nbsp; &nbsp;
				&nbsp; <a class="fancy-link">New User?</a>
			</div>
		</div>
	</div>
	<div>
		<div class="feature-div">
			<div class="row features">
				<div
					class="col-md-offset-2 col-md-4 hidden-sm hidden-xs feature-img">
					<img src="css/images/logos/search.png"
						class="image-rounded img-responsive" id="search_image">
				</div>
				<div class="col-md-6">
					<h3 class="feature">
						<i>Search your mate based on sex, city, state, zip code,
							height, interests etc...</i>
					</h3>
				</div>
			</div>
		</div>
		<div class="feature-div">
			<div class="row features">
				<div
					class="col-md-offset-2 col-md-4 hidden-sm hidden-xs feature-img">
					<img src="css/images/logos/message.png"
						class="image-rounded img-responsive" id="message_image">
				</div>
				<div class="col-md-6">
					<h3 class="feature">
						<i>View others profile and Chat with your Friends </i>
					</h3>
				</div>
			</div>
		</div>

		<div class="feature-div">
			<div class="row features">
				<div
					class="col-md-offset-2 col-md-4 hidden-sm hidden-xs feature-img">
					<img src="css/images/logos/camera.png"
						class="image-rounded img-responsive" id="photos_image">
				</div>
				<div class="col-md-6">
					<h3 class="feature">
						<i>Post your photos in your profile </i>
					</h3>
				</div>
			</div>
		</div>

		<div class="feature-div">
			<div class="row features">
				<div
					class="col-md-offset-2 col-md-4 hidden-sm hidden-xs feature-img">
					<img src="css/images/logos/themes_logo.png"
						class="image-rounded img-responsive" id="themes_image">
				</div>
				<div class="col-md-6">
					<h3 class="feature">
						<i>Different Themes for your profile </i>
					</h3>
				</div>
			</div>
		</div>

		<div class="aboutme" id="aboutme1">

			<div class="row aboutme-content">
				<div class="col-md-offset-2 col-md-3">
					<h3 class="feature">
						<i>About Me :</i>
					</h3>
					<br> <img alt="" src="css/images/profile_photo.jpg"
						class="img-responsive img-circle profile_image">
				</div>
				<div class="col-md-4" style="margin-top: 30px;">
					<p>
						Hi, I am Kiran Kumar Jonnada currently pursing masters in
						Management Information Systems in <a class="fancy-link"
							href="https://www.uhcl.edu">University of Houston Clear Lake</a>
						I have first used the internet when I am in my sixth grade. I was
						mesmerized by the its working. When I was in my 10th grade I have
						created an account in Facebook and literally it increased my
						interest towards websites. Then I had decided to pursue Computer
						Science degree.
					</p>
				</div>
			</div>
			<div class="row aboutme-content">
				<div class="col-md-offset-2 col-md-4">
					<p>I have completed my Bachelors in Computer Sciences with a
						CGPA of 7.48/10 from Vellore Institute of Technology University
						which is one of the top ten universities in India.</p>
				</div>
				<div class="col-md-3">
					<img alt="" src="css/images/logos/VIT-University.png"
						class="img-responsive img-rounded vit_image">
				</div>

			</div>

		</div>

	</div>
</body>
</html>