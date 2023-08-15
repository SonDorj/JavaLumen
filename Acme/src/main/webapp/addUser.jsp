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
		<div class="form-container">
    <h2>Add User</h2>
    <form action="addUser" >
      <input type="text" class="form-field" name="username" placeholder="New Username">
      <input type="text" class="form-field" name="password" placeholder="New Password">
      <button type="submit" class="form-button">Submit</button>
    </form>
  </div>
	</div>
</body>
</html>