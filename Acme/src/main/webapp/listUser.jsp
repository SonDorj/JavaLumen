<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Acme</title>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/navbar.jsp"%></style>
</head>
<body>
	<c:if test="${empty sessionScope.user }">
		<c:redirect url="/login.jsp"/>
	</c:if>
	<div class="container">
		<h1>Users</h1>
		<table>
		<caption>
			<em>Registered Users</em>
		</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th class="text-align-left">User&nbsp;name</th>
				<th class="text-align-left">Password</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" step="1">
				<tr>
					<td class="text-align-center">${user.userId}</td>
					<td class="text-align-left">${user.username}</td>
					<td class="text-align-left">${user.password}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" class="text-align-left">Total&nbsp;users:</td>
				<td colspan="3"><c:out value="${userSize}" /></td>
			</tr>
		</tfoot>
	</table>
	</div>
</body>
</html>