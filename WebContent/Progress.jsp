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
		Progress
	</h1>
		
	Start time: <%= request.getAttribute("startTime").toString() %>  <br>
	
	End time: <%= request.getAttribute("endTime").toString() %>  <br>
	
	Time spent: <%= request.getAttribute("timeSpent").toString() %> <%= request.getAttribute("timeSpentPeriod").toString() %> <br>
	
	Word goal: <%= request.getAttribute("wordGoal").toString() %> <br>
	
	Date goal: <%= request.getAttribute("dateGoal").toString() %> <br>
	
	Words written today: <%= request.getAttribute("todaysWords").toString() %> <br>
	
	Total words written: <%= request.getAttribute("totalWords").toString() %> <br>
	
	Words per minute: <%= request.getAttribute("wordsPerMin").toString() %> <br>
	
	Estimated time to finish: <%= request.getAttribute("timeToFinish").toString() %> <br>
	
	Words left: <%= request.getAttribute("wordsLeft").toString() %>
	
	<form action="Progress" method="POST">
		<button type="submit" name="button" value="done">Done</button>
	</form>
		
</body>
</html>