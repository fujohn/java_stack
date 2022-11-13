<!-- Here we have to import the Date class. -->
<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Omikuji</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<div class="omikuji">
		<p><c:out value="${omikuji}"/></p>
	</div>
	<a href="/omikuji">Go Back</a>
</body>
</html>