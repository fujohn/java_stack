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
<title>Game Workshop Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/game_list.css">
</head>
<body>
	<header>
		<h1>Welcome, <c:out value="${user.name}"/>!</h1>
		<a href="/logout">Log Out</a>
	</header>
	<main>
		<h2>Current Games</h2>
		<h3>Game</h3>
		<hr />
		<c:forEach var="game" items="${games}">
			<div>
				<h5><a href="/games/${game.id}"><c:out value="${game.name}"/></a></h5>
				<p>Genre: <c:out value="${game.genre}"/></p>
			</div>
		</c:forEach>
	</main>
	<footer>
		<a href="/games/new"><button class="btn-primary">Create New Game</button></a>
	</footer>
</body>
</html>