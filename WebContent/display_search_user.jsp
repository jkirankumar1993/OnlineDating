<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.usercompleteinfo"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript" src="js/searchuserprofile.js"></script>
<link rel="stylesheet" href="css/searchuserprofile.css">
<title>Connect</title>
</head>
<body>

	<%
		HttpSession s = request.getSession();
		String usersession = (String) s.getAttribute("usersession");
		List<usercompleteinfo> li = (List<usercompleteinfo>) s.getAttribute("searchuserprofile");
		if (usersession == null) {
			request.getRequestDispatcher("index.jsp");
		}
		String name = li.get(0).getName();
		String username = li.get(0).getUsername();
		int theme = (Integer) li.get(0).getTheme();
		String image = li.get(0).getPhotoimage();
		int age = li.get(0).getage();
		String sex = li.get(0).getSex();
		String interest = li.get(0).getInterest();
		int likes = li.get(0).getLikes();
		int views = li.get(0).getViews();
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
		<div class="col-md-5 col-md-offset-3 main-content">
			<img class="img-rounded img-responsive" id="profilephoto"
				src="data:image/png;base64,<%=image%>"><label
				for="name"><span class="required">Name :<%= name %> </span></label><br> <label for="age"><span
				class="required">Age : <%= age %> </span></label><br> <label
				for="sex"><span class="required">sex : <%= sex %>  </span></label><br>
			<label for="interest"><span class="required">Interested
					in : </span></label><span id="interest"><%=interest %></span><br> <label for="likes"><span
				class="required">Likes : </span></label><span class="badge" id="likes"><%=likes %></span><br>
			<label for="views"><span class="required">Views : </span></label><span
				class="badge" id="views"><%= views %></span><br>
			
			<img class="like-btn" alt="" src="">
			<a href="messages.jsp"><img class="message-btn" alt="" src="css/images/message.png"></a>	
			
		</div>
	</div>

</body>
</html>