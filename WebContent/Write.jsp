<%@page import="gui.dbConnection"%>
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
		Write
	</h1>
	<a href="Help.jsp">?</a>
	
	<%
		Date endTime = new Date();
	
		String button = request.getParameter("button");
		if ("startWriting".equals(button)) {
			dbConnection db = new dbConnection();
			Date time = new Date();
			String results = db.dbConn(time, 'i', 0);
			//response.sendRedirect("Index.jsp");
	//		doGet(request, response);
		}
	 %>
	 
	 <%= request.getParameter("res") %>
	 	
	<%= request.getParameter("startTime") != null ? endTime.getTime() - Long.parseLong(request.getParameter("startTime"), 10) : "Placeholder" %>
	
	<form action="Write" method="GET">
		<button type="submit" name="button" value="stopWriting">Stop writing</button>
	</form>
</body>
</html>