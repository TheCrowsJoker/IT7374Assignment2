package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class dbConnection {

	public String dbConn(Date date, char choice, int id) {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/times?autoReconnect=true&useSSL=false";
		String user = "admin";
		String pass = "Passworda";
				
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			Statement myStmt = myConn.createStatement();
			String record = "";
			// Choose whether to update or insert into the database
			if (choice == 'i') {
				record = "INSERT INTO times (`startTime`) VALUES (?)";
			} else if (choice == 'u') {
				record ="Update times set endTime = timestamp(?) where id = ?;";
			}
			PreparedStatement pstmt = myConn.prepareStatement(record);
			Timestamp sqlDate = new Timestamp(date.getTime());
			pstmt.setTimestamp(1, sqlDate);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
			ResultSet myRs = myStmt.executeQuery("select * from times");
			System.out.println("startTime             | endTime");
			System.out.println("======================|======================");
			while (myRs.next()) {
				System.out.println(myRs.getString("startTime") + " | " + myRs.getString("endTime"));
			}
			myStmt.close();
			myConn.close();
			
			return myRs.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
//	public static void main(String[] args) {
//		Date time = new Date();
//		dbConn(time, 'u', 7);
//	}

}
