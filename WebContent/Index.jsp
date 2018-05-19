<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Writing Assistant</title>
</head>
<body>
	<h1>
		Writing Assistant
	</h1>
	<a href="Help.jsp">?</a>
	<img src="http://via.placeholder.com/350x150">
	
	First time here? set your goals in the <strong>settings</strong>
	
	<form action="Index" method="GET">
		<button type="submit" name="button" value="startWriting">Start writing</button>
		<button type="submit" name="button" value="settings">Settings</button>
	</form>
</body>
</html>