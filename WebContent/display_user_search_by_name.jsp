<%@page import="bean.usercompleteinfo"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
HttpSession se  = request.getSession();
	List<usercompleteinfo> li = (List<usercompleteinfo>)se.getAttribute("searchuser_by_name_list");
	
%>
<div class="search_users">
	<c:forEach items="${sessionScope.searchuser_by_name_list}" var="searchuser_by_name_list">
		<table border="1" class="searchtable" style="float: left;border-radius: 25px;">
			<c:url var="tempurl" value="viewprofile">
				<c:param name="username" value="${searchuser_by_name_list.username}"></c:param>
			</c:url>
			<tr>
				<td><img class="img-rounded" alt="" src="data:image/png;base64,${searchuser_by_name_list.photoimage}"
					style="height: 100px; width: 100px;border-radius: 25px"></td>
			</tr>
			<tr>
				<td><c:out value="${searchuser_by_name_list.name}"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${users.dob}"></c:out></td>
			</tr>

			<tr>
				<td><a href="${tempurl }" class="link">View Profile</a></td>
			</tr>

		</table>&nbsp;

	</c:forEach>
</div>
