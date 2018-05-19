package gui;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		if ("startWriting".equals(button)) {
			dbConnection db = new dbConnection();
			
			if (db.checkGoalsSet() == false) {
				response.sendRedirect("Settings.jsp");
			} else {
				Date time = new Date();
				db.setStartTime(time);
				response.sendRedirect("Write.jsp");
			}
		}
	}
}
