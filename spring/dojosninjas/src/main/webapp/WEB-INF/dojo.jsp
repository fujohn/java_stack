<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	
	
	
	<form:form action="/createdojo" method="post" modelAttribute="dojo">
		
		<div class="form-group">
			<form:label path="name">Name:</form:label>
			<form:errors path="name" class="error"/>
			<form:input path="name" type="text" class="form-control"/>
		</div>
			
		<input type="submit" value="Create" class="btn-primary"/>
		
	</form:form>
</body>
</html>