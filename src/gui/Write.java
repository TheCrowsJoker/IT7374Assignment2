package gui;

import java.io.IOException;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		if ("stopWriting".equals(button)) {
			dbConnection db = new dbConnection();
			Date time = new Date();
			db.setEndTime(time); // update table			
			db.setWords(Integer.parseInt(request.getParameter("setWords")));
			
			Date[] dates = db.getTimes();
			Date startTime = dates[0];
			Date endTime = dates[1];
			
			double timeSpent = (endTime.getTime() - startTime.getTime()) / 1000; // how many seconds where spent writing
			String timeSpentPeriod = "second(s)";
			if (timeSpent >= 60) {
				timeSpent /= 60;  // Minutes
				timeSpentPeriod = "minute(s)";
			}
			if (timeSpent >= 60) {
				timeSpent /= 60; // Hours
				timeSpentPeriod = "hour(s)";
			}
			int wordGoal = db.getWordGoal();
			Date dateGoal = db.getDateGoal();
			int todaysWords = db.getWords();
			int totalWords = db.getTotalWords();
			int wordsLeft = wordGoal - totalWords;
			double wordsPerMin;
			
			if (timeSpentPeriod.equals("second(s)")) {
				wordsPerMin = todaysWords / (timeSpent / 60);
			} else if (timeSpentPeriod.equals("minute(s)")) {
				wordsPerMin = todaysWords / (timeSpent / 60 / 60);
			} else {
				wordsPerMin = todaysWords / (timeSpent / 60 / 60 / 60);
			}
			
			double timeToFinish = wordsLeft / wordsPerMin;
			String timeToFinishPeriod = "minute(s)";
			if (timeToFinish > 60) {
				timeToFinish /= 60;
				timeToFinishPeriod = "hour(s)";
			}
			
			request.setAttribute("startTime", startTime);
			request.setAttribute("endTime", endTime);
			request.setAttribute("wordGoal", wordGoal);
			request.setAttribute("dateGoal", dateGoal);
			request.setAttribute("timeSpent", timeSpent);
			request.setAttribute("timeSpentPeriod", timeSpentPeriod);
			request.setAttribute("todaysWords", todaysWords);
			request.setAttribute("totalWords", totalWords);
			request.setAttribute("wordsPerMin", wordsPerMin);
			request.setAttribute("timeToFinish", timeToFinish);
			request.setAttribute("timeToFinishPeriod", timeToFinishPeriod);
			request.setAttribute("wordsLeft", wordsLeft);
			
			request.getRequestDispatcher("Progress.jsp").forward(request, response);
			
			
		}
	}
}
