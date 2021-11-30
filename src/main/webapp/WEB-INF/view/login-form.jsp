<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
	.failed 
	{
		color: red;
	}
	.success 
	{
		color: green;
	}
</style>
</head>
<body>
	<h2>Custom Login</h2>
	<form:form action="${pageContext.request.contextPath}/AuthenticateUser" method="POST">
		<c:if test="${param.error!=null}">
			<i class="failed">Invalid Credentials:-(</i>
		</c:if>
		<br>
		<c:if test="${param.logout!=null}">
			<i class="success">Successfully logged out!</i>
		</c:if>
		<br>		
		User Name:- <input type="text" name="username"/>
		<br>
		<br>
		Password:- <input type="password" name="password">
		<br>
		<br>
		<input type="submit" value="login">
	</form:form>
</body>
</html>