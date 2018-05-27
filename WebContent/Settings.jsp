<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Writing Assistant</title>
</head>
<body>
	<div>
		<h1>
			Settings
		</h1>
		
		<form action="Settings" method="POST">
			<p>What is your word goal?</p>
			<input type="number" name="wordGoal" required autofocus />
			
			<p>When would you like to have this finished?</p>
			<input type="date" name="dateGoal" required />
			
			<div>
				<button type="submit" name="button" value="save">Save</button>
			</div>
		</form>
	</div>

</body>
</html>