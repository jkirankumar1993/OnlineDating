<%@page import="bean.usercompleteinfo"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="conversation_of_users table-responsive">
<table border="1" class="table"  style="border-radius: 25px; width: 85%;margin: 25px;height: 470px;">
	<tbody id="msgs">
	<c:forEach items="${sessionScope.conversationofusers}" var="msg">
		
			<tr>
				<td>
				<h4>${msg.username1} : </h4>
				<p>${msg.message}</p>
				</td>
			</tr>

	</c:forEach>
	</tbody>
	</table>
	</div>