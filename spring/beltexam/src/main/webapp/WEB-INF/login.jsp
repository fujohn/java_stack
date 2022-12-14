<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Workshop</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
	<h1>Welcome to the Game Workshop!</h1>
	
	<main>
		<div>
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<form:errors path="name" class="error text-danger"/>
				<form:errors path="email" class="error text-danger"/>
				<form:errors path="password" class="error text-danger"/>
				<form:errors path="confirm" class="error text-danger"/>
				<div class="form-group">
					<form:label path="name">User Name:</form:label>
					<form:input path="name" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="email">Email:</form:label>
					<form:input path="email" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="password">Password:</form:label>
					<form:input path="password" type="password" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="confirm">Confirm PW:</form:label>
					<form:input path="confirm" type="password" class="form-control"/>
				</div>
				<input type="submit" value="Register" class="btn-primary"/>
			</form:form>
		</div>
		<div>
			<h2>Log in</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<form:errors path="email" class="error text-danger"/>
				<form:errors path="password" class="error text-danger"/>
				<div class="form-group">
					<form:label path="email">Email:</form:label>
					<form:input path="email" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="password">Password:</form:label>
					<form:input path="password" type="password" class="form-control"/>
				</div>
				<input type="submit" value="Log In" class="btn-primary"/>
			</form:form>
		</div>
	</main>
</body>
</html>