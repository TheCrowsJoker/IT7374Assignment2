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
		Write
	</h1>
	
	<form action="Write" method="POST">
		How many words did you write?
		<input type="text" name="setWords" required />
		<button type="submit" name="button" value="stopWriting">Stop writing</button>
	</form>
</body>
</html>