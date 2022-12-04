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
<title>Book Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<header>
		<h1>Change your Entry</h1>
		<a href="/books">Back to the Shelves</a>
	</header>
	<main>
		<form:form action="/editbook/${book.id}" method="post" modelAttribute="book">
			<input type="hidden" name="_method" value="put"/>
			<div class="form-group">
				<form:label path="title">Title</form:label>
				<form:errors path="title" class="error"/>
				<form:input path="title" type="text" value="${book.title}" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="author">Author</form:label>
				<form:errors path="author" class="error"/>
				<form:input path="author" type="text" value="${book.author}" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="thoughts">My Thoughts</form:label>
				<form:errors path="thoughts" class="error"/>
				<form:textarea path="thoughts" value="${book.thoughts}" class="form-control"/>
			</div>
			<input type="submit" value="Submit" class="btn-primary"/>
		</form:form>
	</main>
</body>
</html>