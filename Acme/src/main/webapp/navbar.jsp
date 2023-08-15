<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>&#129382;Acme</title>
<style><%@include file="/css/style.css"%></style>
</head>
<body>
	<div class="nav-container">
		<span class="nav-span">
		<a class="nav-item" href="/Acme/homeCotroller">&#129382;&nbsp;Acme&nbsp;Grocers</a>
		</span>
		<form action="nameSearch" class="nav-span">
			<input type="text" class="nav-item" placeholder="Search by name" name="grocery">
			<button type="submit" class="nav-item">&#128269;</button>
		</form>
		<div class="nav-items">
			<a href="userController" class="nav-item">List&nbsp;User</a>
			<a href="/Acme/addUser.jsp" class="nav-item">Add&nbsp;User</a>
			<a href="/Acme/deleteUser.jsp" class="nav-item">Delete&nbsp;User</a>
		    <a href="/Acme/addItem.jsp" class="nav-item">Add&nbsp;Item</a>
		    <form action="logoutServlet" >
				<button type="submit" class="nav-item">Logout</button>
			</form>
		</div>
	</div>
</body>
</html>