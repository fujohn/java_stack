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
	<header>
		<h1><c:out value="${book.title}"/></h1>
		<a href="/books">Back to the Shelves</a>
	</header>
	<main>
		<c:choose>
			<c:when test="${user.id == book.user.id}">
				<h5><strong>You read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</strong></h5>
				<h5>Here are your thoughts:</h5>
			</c:when>
			<c:otherwise>
				<h5><strong><c:out value="${book.user.name}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</strong></h5>
				<h5>Here are <c:out value="${book.user.name}"/>'s thoughts:</h5>
			</c:otherwise>
		</c:choose>
		<p><c:out value="${book.thoughts}"/></p>
	</main>
	<footer>
		<a href="/books/${book.id}/edit"><button>Edit</button></a>
		<form action="/books/${book.id}/delete" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete" class="btn-danger">
		</form>
		
	</footer>
</body>
</html>