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
<title>Create New Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/game_add_edit.css">
</head>
<body>
	<header>
		<h1>New Game</h1>
		<a href="/home">Dashboard</a>
	</header>
	<main>
		<form:form action="/creategame" method="post" modelAttribute="game">
			<form:errors path="name" class="error text-danger"/>
			<form:errors path="genre" class="error text-danger"/>
			<form:errors path="description" class="error text-danger"/>
			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:input path="name" type="text" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="genre">Genre</form:label>
				<form:input path="genre" type="text" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:textarea path="description" class="form-control"/>
			</div>
			<input type="submit" value="Submit" class="btn-primary"/>
		</form:form>
	</main>
</body>
</html>