package gui;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Settings
 */
@WebServlet("/Settings")
public class Settings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		if ("save".equals(button)) {
			dbConnection db = new dbConnection();
			
			java.util.Date date = null;
			try {
				date = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("dateGoal"));
				db.setGoals(Integer.parseInt(request.getParameter("wordGoal")), date);
			} catch (ParseException e) {
				
			}
			
			
			
			response.sendRedirect("Index.jsp");
		}
	}

}
