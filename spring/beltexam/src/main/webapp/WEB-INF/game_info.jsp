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
<title>Game Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/game_info.css">
</head>
<body>
	<header>
		<h1><c:out value="${game.name}"/></h1>
		<a href="/home">Dashboard</a>
	</header>
	<main>
		<p>
			<strong>Name:</strong> <c:out value="${game.name}"/><br />
			<strong>Developer:</strong> <c:out value="${game.user.name}"/><br />
			<strong>Description:</strong> <br />
			<c:out value="${game.description}"/>
		</p>
	</main>
	<footer>
		<c:if test="${user.id == game.user.id}">
			<a href="/games/${game.id}/edit"><button>Edit</button></a>
			<form action="/games/${game.id}/delete" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete" class="btn-danger">
			</form>
		</c:if>
	</footer>
</body>
</html>