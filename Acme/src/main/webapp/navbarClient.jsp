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
		<a href="/Acme/clientController" class="nav=item">&#129382;&nbsp;Acme&nbsp;Grocers</a>
		</span>
		<div class="nav-items">
		    <a href="/Acme/listCart.jsp" class="nav-item">View&nbsp;Cart</a>
		    <form action="logoutServlet" >
				<button type="submit" class="nav-item">Logout</button>
			</form>
		</div>
	</div>
</body>
</html>