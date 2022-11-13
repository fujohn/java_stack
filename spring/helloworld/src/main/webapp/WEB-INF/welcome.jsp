<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Welcome <c:out value="${name}"/></h1>
 <h2>Session is <c:out value="${count}"/> and Model saved is <c:out value="${countToShow}"/></h2>
</body>
</html>