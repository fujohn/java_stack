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
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Dojos</h1>
	<a href="dojos/new">Add New Dojo</a>
	<a href="ninjas/new">Add New Ninja</a>
	
	<ul>
		<c:forEach var="dojo" items="${dojos}">
			<li><a href="dojos/${dojo.id}">${dojo.name}</a></li>
		</c:forEach>
	</ul>
</body>
</html>