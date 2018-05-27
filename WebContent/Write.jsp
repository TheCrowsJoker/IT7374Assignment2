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
			Write
		</h1>

		<form action="Write" method="POST">
			<p>How many words did you write?</p>
			<input type="number" name="setWords" required autofocus />
			<div>
				<button type="submit" name="button" value="stopWriting">Stop writing</button>
			</div>
		</form>
	</div>
</body>
</html>
