<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style><%@include file="/css/style.css"%></style>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}
</style>
</head>
<body>
	<div class="login-container">
		<h1>&#129382;Acme Grocers</h1>
		<form action="loginServlet" method="post" >
			<input type="text" class="input-field" placeholder="&#129302;" name="username">
			<input type="password" class="input-field" placeholder="&#128273;" name="password">
			<button type="submit" class="login-button">Login</button>
		</form>
	</div>
</body>
</html>