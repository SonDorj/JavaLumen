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
	
		<h1>Inventory</h1>
		<table>
		<caption>
			<em>Available Groceries</em>
		</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th class="text-align-left">Grocery&nbsp;Name</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${groceries}" var="grocery" step="1">
	                <tr>
	                    <td class="text-align-center">${grocery.groceryId}</td>
	                    <td class="text-align-left">${grocery.name}</td>
	                    <td>${grocery.price}</td>
	                    <td>${grocery.stock}</td>
	                    <td class="text-align-center">
						<form action="processGrocery">
	                        <button type="submit" class="edit-button" name="update"  value="${grocery.groceryId}">&#9998;</button>
	                        <button type="submit" class="edit-button" name="delete" value="${grocery.groceryId}">&#128465;</button>
        		    	</form>
	                    </td>
	                </tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" class="text-align-left">Total&nbsp;Groceries:</td>
				<td colspan="3"><c:out value="${size}" /></td>
			</tr>
		</tfoot>
	</table>
	</div>
</body>
</html>