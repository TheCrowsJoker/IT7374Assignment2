package gui;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Write
 */
@WebServlet("/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		if ("stopWriting".equals(button)) {
			dbConnection db = new dbConnection();
			Date time = new Date();
			db.dbConn(time, 'u'); // update table
			
			ResultSet myRs = db.dbConn(time, 's'); // get info for next page			
			
			Date startTime = null;
			Date endTime = null;
			
			try {
				while (myRs.next()) {
					startTime = myRs.getTimestamp("startTime");
					endTime = myRs.getTimestamp("endTime");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			long timeSpent = (endTime.getTime() - startTime.getTime()) / 1000; // how many seconds where spent writing
			
			// Stats to show
			////////////////
			// time started
			// time finished
			// word goal
			// finish goal
			// time spent writing
			
			// words written today
			// total words written			
			// how long it would take to finish if this many words are written a day
			// words left
			
			request.setAttribute("startTime", startTime);
			request.setAttribute("endTime", endTime);
//			request.setAttribute("wordGoal", wordGoal);
//			request.setAttribute("finishGoal", finishGoal);
			request.setAttribute("timeSpent", timeSpent);
			
			request.getRequestDispatcher("Progress.jsp").forward(request, response);	
		}
	}
}
