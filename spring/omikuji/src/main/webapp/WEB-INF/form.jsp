<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/createomikuji" method="post">
	<label for="number">Pick any number from 5 to 25</label>
	<input type="number" name="number" min="5" max="25">
	<label for="city">Enter the name of any city.</label>
	<input type="text" name="city">
	<label for="person">Enter the name of any real person.</label>
	<input type="text" name="person">
	<label for="endeavor">Enter professional endeavor or hobby.</label>
	<input type="text" name="endeavor">
	<label for="livingThing">Enter any type of living thing.</label>
	<input type="text" name="livingThing">
	<label for="message">Say something nice to someone.</label>
	<textarea name="message" cols="30" rows="10"></textarea>
	<input type="submit" value="Send">
	</form>
</body>
</html>