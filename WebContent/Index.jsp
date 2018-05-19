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
	
	<form action="Index" method="GET">
	<% Date time = new Date(); %>
		<input type="hidden" name="startTime" value="<%= time.getTime() %>">
		<button type="submit" name="button" value="startWriting">Start writing</button>
	</form>
	
	<a href="Progress.jsp">View Progress</a>
</body>
</html>