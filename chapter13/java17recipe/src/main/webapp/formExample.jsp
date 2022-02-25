<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Example</title>
</head>
<body>
	<form action="/java17recipe/FirstServlet" method="post">
		first name:<input type="text" value="" name="firstname"/>
		<input type = "submit" value="POST SUBMIT">
	</form>
	<form action="/java17recipe/FirstServlet" method="get">
		last name:<input type="text" value="" name="lastname"/>
		<input type = "submit" value="GET SUBMIT">
	</form>
</body>
</html>