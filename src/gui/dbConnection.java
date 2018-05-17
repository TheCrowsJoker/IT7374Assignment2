package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class dbConnection {

	public void dbConn() {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/times?autoReconnect=true&useSSL=false";
		String user = "admin";
		String pass = "Passworda";
		
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from times");
			while (myRs.next()) {
				System.out.println(myRs.getString("startTime"));
				System.out.println(myRs.getString("endTime"));
			}
			myStmt.close();
			myConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
