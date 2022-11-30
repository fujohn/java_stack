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
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/createninja" method="post" modelAttribute="ninja">
		<div class="form-group">
			<form:label path="dojo">Dojo:</form:label>
			<form:errors path="dojo" class="error"/>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<option value="${dojo.id}">${dojo.name}</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName" class="error"/>
			<form:input path="firstName" type="text" class="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName" class="error"/>
			<form:input path="lastName" type="text" class="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="age">Age:</form:label>
			<form:errors path="age" class="error"/>
			<form:input path="age" type="number" class="form-control"/>
		</div>
			
		<input type="submit" value="Create" class="btn-primary"/>
		
	</form:form>
</body>
</html>