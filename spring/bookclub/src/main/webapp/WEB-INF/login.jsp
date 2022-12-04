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
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Book Club</h1>
	<p>A place for friends to share thoughts on books.</p>
	
	<div>
		<div>
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:errors path="name" class="error"/>
					<form:input path="name" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="email">Email:</form:label>
					<form:errors path="email" class="error"/>
					<form:input path="email" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="password">Password:</form:label>
					<form:errors path="password" class="error"/>
					<form:input path="password" type="password" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="confirm">Confirm PW:</form:label>
					<form:errors path="confirm" class="error"/>
					<form:input path="confirm" type="password" class="form-control"/>
				</div>
				<input type="submit" value="Submit" class="btn-primary"/>
			</form:form>
		</div>
		<div>
			<h2>Log in</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<div class="form-group">
					<form:label path="email">Email:</form:label>
					<form:errors path="email" class="error"/>
					<form:input path="email" type="text" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="password">Password:</form:label>
					<form:errors path="password" class="error"/>
					<form:input path="password" type="password" class="form-control"/>
				</div>
				<input type="submit" value="Submit" class="btn-primary"/>
			</form:form>
		</div>
	</div>
</body>
</html>