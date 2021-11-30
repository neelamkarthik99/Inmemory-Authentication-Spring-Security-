<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
	Hi all!
	<br>
	<br>
	Userid:- <sec:authentication property="principal.username"/>
	<br>
	<br>
	Role:- <sec:authentication property="principal.authorities"/>
	<br>
	<br>
	<sec:authorize access="hasRole('manager')">
		<p>
			<a href="${pageContext.request.contextPath}/manager">Managers meeting</a>
		</p>
	</sec:authorize>
	
	<sec:authorize access="hasRole('admin')">
		<p>
			<a href="${pageContext.request.contextPath}/admin">admins meeting</a>
		</p>
	</sec:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="logout"/>
	
	</form:form>
</body>
</html>