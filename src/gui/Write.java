package gui;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Writing
 */
@WebServlet("/Writing")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Date start;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write() {
        startTimer();
        dbConnection db = new dbConnection();
//        db.dbConn();
    }

	private void startTimer() {
		start = new Date();
	}
	
	private String readTimer() {
		return start.toString();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		if ("startWriting".equals(button)) {
			dbConnection db = new dbConnection();
			Date time = new Date();
			String results = db.dbConn(time, 'i', 0);
			response.sendRedirect("Index.jsp");
	//		doGet(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String button = request.getParameter("button");
		if ("startWriting".equals(button)) {
//			response.sendRedirect("Write.jsp");
		} else {
//			response.sendRedirect("Write.jsp");
		}
		
		
	}

}
