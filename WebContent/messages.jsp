<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/messages.js"></script>
<link rel="stylesheet" href="css/messages.css">
<title>Messages</title>
<%
	HttpSession s = request.getSession();
	List<String> users = (List<String>) request.getAttribute("conversationlist");
	int theme = (Integer) s.getAttribute("theme");
%>
</head>
<body>

	<input type="hidden" id="usertheme" value="<%=theme%>">

	<nav>
	<div class="row">
		<div class="col-md-2 col-md-offset-5 visible-lg nav-image">
			<img alt="" src="css/images/company_logo_black.png"
				class="company_logo">
		</div>
		<div class="col-md-5" style="text-align: end;">
			<div class="main-nav">
				<a href="#aboutme1">Home</a> <a href="#loginform"><img
					id="logout-btn" src="css/images/logos/logout.png"></a>
			</div>
		</div>
	</div>
	</nav>

	<div class="">
		<div class="row list">
			<div class="col-md-3 userslist">
				<table id="table">
					<c:forEach items="${sessionScope.conversationlist}" var="user">
						<tr style="padding: 50px;">
							<td id="picture"><img
								style="width: 50px; height: 50px; border-radius: 30px;" alt=""
								src="data:image/png;base64,${user.photoimage}"></td>
							<td><h3>
									<a id="${user.username}">${user.username }</a>
								</h3></td>
						<tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-md-5">
				<div class="messages">
					<!-- Display messages here -->
					<%@ include file="conversation_of_users.jsp" %>
				</div>
				<div class="postmessage">
					<form id="form">
						<input class="message_txt" type="text"
							placeholder="Enter your message"><br> <input type="submit"
							value="send message" class="btn btn-success">
					</form>
				</div>
			</div>
		</div>

	</div>



</body>
</html>