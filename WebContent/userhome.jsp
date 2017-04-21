<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
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
<script type="text/javascript" src="js/userhome.js"></script>
<link rel="stylesheet" href="css/userhome.css">
<title>Hello User</title>
</head>
<body>
	<%
		HttpSession s = request.getSession();
		String usersession = (String) s.getAttribute("usersession");
		if (usersession == null) {
			request.getRequestDispatcher("index.jsp");
		}
		String username = (String) s.getAttribute("usersession");
		int theme = (Integer) s.getAttribute("theme");
		String image = (String) s.getAttribute("profilephoto");
	%>

	<input type="hidden" id="username" value="<%=username%>">
	<input type="hidden" id="usertheme" value="<%=theme%>">


	<!-- Header -->
	<nav>
	<div class="row">
		<div class="col-md-2 col-md-offset-5 visible-lg nav-image">
			<img alt="" src="css/images/company_logo_black.png"
				class="company_logo">
		</div>
		<div class="col-md-5">
			<div class="main-nav">
				<a href="#aboutme1">Home</a> <a href="#loginform"><img
					id="logout-btn" src="css/images/logos/logout.png"></a>
			</div>
		</div>
	</div>
	</nav>


	<div class="row">
		<div class="col-md-3 visible-lg visible-md side-header">
			<img class="img-rounded img-responsive" id="profilephoto"
				src="data:image/png;base64,<%=image%>"> <span id="status"></span><br>
			<a id="updatestatuslink">Update Status</a><br>
			<div id="statusbar">
				<form>
					<input id="statustextbox" type="text" maxlength="50" name="status"><input
						class="btn btn-success updatestatus" type="submit"
						value="Update status">
				</form>
			</div>
			<div class="side-header-data">
				<label for="name"><span class="required">Name : </span></label><span
					id="name"></span><br> <label for="age"><span
					class="required">Age : </span></label><span id="dob"></span><br> <label
					for="sex"><span class="required">sex : </span></label><span
					id="sex"></span><br> <label for="interest"><span
					class="required">Interested in : </span></label><span id="interest"></span><br>
				<label for="likes"><span class="required">Likes : </span></label><span
					class="badge" id="likes"></span><br> <label for="views"><span
					class="required">Views : </span></label><span class="badge" id="views"></span><br>
			</div>
		</div>

		<div class="col-md-5 main-content">
			<h2>Search People Here,</h2>
			<br> <a class="fancy-link" id="search_by_name_link">Search People by Name</a>&nbsp;&nbsp;
			<a class="fancy-link" id="advanced_search_link">Advanced Search</a>
			<div id="search_by_name">
				<form id="search_by_name_form">
					<div class="form-group">
						<p>Please Enter a name :</p>
						<input class="form-control" type="text" name="search_name"
							id="search_box" placeholder="Please enter a name"><span id="searchname-feedback"></span><br> 
							<input
							type="submit" value="Search" class="btn btn-success updatestatus">
					</div>
				</form>
			</div>
			
			<div id="advanced_search">
				<form id="advanced_search_form">
					<div class="form-group">
						<label for="sex"> <span class="required">Preferred
								Sex : </span></label> <select id="sex_search" name="user_sex">
							<option value="Any">Any</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
						</select><br>
					</div>
					<div class="form-group">
						<label for="Age"><span class="required">Age : </span></label> <input
							type="text" id="min_age" name="minage" class="form-control" maxlength="2"><br>
						<p>To</p>
						<input type="text" id="max_age" name="maxage" class="form-control"
							maxlength="2">
							<span id="age-feedback"></span>
					</div>

					<div class="form-group">
						<label for="Interest"><span class="required">Interested
								in : </span></label> <select id="interest_search" name="user_interest">
							<option value="Any">Any</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
						</select>
					</div>

					<div class="form-group">
						<label for="Distance"><span class="required">Distance
								: </span></label> <select id="distance" name="zipcode">
							<option value="0">Any</option>
							<option value="10">Within 10 Zipcode's away from your
								zipcode</option>
							<option value="25">Within 25 Zipcode's away from your
								zipcode</option>
							<option value="50">Within 50 Zipcode's away from your
								zipcode</option>
							<option value="100">Within 100 Zipcode's away from your
								zipcode</option>
						</select>
					</div>
					<input type="submit" value="Search" class="btn btn-success updatestatus">
					<br>
				</form>
			</div>
			<div id="search_user_by_name_display">
			<%@ include file="display_user_search_by_name.jsp" %>
			</div>
			<div id="advancedsearch_user">
			<%@ include file="display_user_advancedsearch.jsp" %>
			</div>
			
		</div>
	</div>

</body>
</html>