<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Acme</title>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/navbarClient.jsp"%></style>
</head>
<body>
	<c:if test="${empty sessionScope.user }">
		<c:redirect url="/login.jsp"/>
	</c:if>
	<div class="container">
		<h1>Cart</h1>
		<table>
		<caption>
			<em>Items in the Cart</em>
		</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th class="text-align-left">Grocery&nbsp;name</th>
				<th class="text-align-left">Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart}" var="item" step="1">
				<tr>
					<td class="text-align-center">${item.groceryId}</td>
					<td class="text-align-left">${item.name}</td>
					<td >${item.price}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" class="text-align-left">Total&nbsp;Price:</td>
				<td colspan="3"><c:out value="${total}" /></td>
			</tr>
			<tr>
				<td colspan="3"> <form action="getBill" >
					<button type="submit" class="nav-item">Checkout</button>
				</form> </td>
			</tr>
		</tfoot>
	</table>
	</div>
</body>
</html>