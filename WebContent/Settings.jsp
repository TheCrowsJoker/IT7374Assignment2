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
		Settings
	</h1>
	
	<form action="Settings" method="GET">
		What is your word goal?
		<input type="text" name="wordGoal" />
		
		When would you like to have this finished?
		<input type="datetime-local" name="dateGoal" />
		
		<button type="submit" name="button" value="save">Save</button>
	</form>

</body>
</html>