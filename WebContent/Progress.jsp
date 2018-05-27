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
			Progress
		</h1>
			
		<p>Start time: <%= request.getAttribute("startTime").toString() %></p>
		
		<p>End time: <%= request.getAttribute("endTime").toString() %></p>
		
		<p>Time spent: <%= request.getAttribute("timeSpent").toString() %> <%= request.getAttribute("timeSpentPeriod").toString() %></p>
		
		<p>Word goal: <%= request.getAttribute("wordGoal").toString() %></p>
		
		<p>Date goal: <%= request.getAttribute("dateGoal").toString() %></p>
		
		<p>Words written today: <%= request.getAttribute("todaysWords").toString() %></p>
		
		<p>Total words written: <%= request.getAttribute("totalWords").toString() %></p>
		
		<p>Words per minute: <%= String.format("%.0f", request.getAttribute("wordsPerMin")) %></p>
		
		<p>Estimated time to finish: <%= String.format("%.0f", request.getAttribute("timeToFinish")) %> <%= request.getAttribute("timeToFinishPeriod").toString() %></p>
		
		<p>Words left: <%= request.getAttribute("wordsLeft").toString() %></p>
		
		<form action="Progress" method="POST">
			<button type="submit" name="button" value="done">Done</button>
		</form>
	</div>
		
</body>
</html>