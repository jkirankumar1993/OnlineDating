<%@page import="bean.usercompleteinfo"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
HttpSession set  = request.getSession();
	List<usercompleteinfo> list = (List<usercompleteinfo>)set.getAttribute("advancedsearchuser_by_name_list");
	
%>
<div class="advancedsearch_users">
	<c:forEach items="${sessionScope.advancedsearchuser_by_name_list}" var="advancedsearchuser">
		<table border="1" class="searchtable" style="float: left;border-radius: 25px;">
			<c:url var="tempurl" value="view profile">
				<c:param name="username" value="${advancedsearchuser.name}"></c:param>
			</c:url>
			<tr>
				<td><img class="img-rounded" alt="" src="data:image/png;base64,${advancedsearchuser.photoimage}"
					style="height: 100px; width: 100px;border-radius: 25px"></td>
			</tr>
			<tr>
				<td><c:out value="${advancedsearchuser.name}"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${advancedsearchuser.dob}"></c:out></td>
			</tr>

			<tr>
				<td><a href="" class="link">View Profile</a></td>
			</tr>

		</table>&nbsp;

	</c:forEach>
	</div>