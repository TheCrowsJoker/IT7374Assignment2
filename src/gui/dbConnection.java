package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class dbConnection {	
	public ResultSet dbConn(Date date, char choice) {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/times?autoReconnect=true&useSSL=false";
		String user = "admin";
		String pass = "Passworda";
				
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			String record = "";
			
			// Choose whether to update or insert into the database
			if (choice == 'i') {
				record = "INSERT INTO times (`startTime`) VALUES (?);";
			} else if (choice == 'u') {
				record ="Update times set endTime = timestamp(?) order by id desc limit 1;"; // update the last row of the table
			} else if (choice == 's') {
				record = "select * from times order by id desc limit 1;"; // select the last row
			}
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
			Timestamp sqlDate = new Timestamp(date.getTime());
			if (choice != 's') {
				pstmt.setTimestamp(1, sqlDate);
			}
			
			if (choice == 's') {
				ResultSet myRs = pstmt.executeQuery();
				return myRs;
			} else {
				pstmt.executeUpdate();
			}
			
			
			myConn.commit();
			
			pstmt.close();
			myConn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void setGoals(int wordGoal, Date dateGoal) {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/times?autoReconnect=true&useSSL=false";
		String user = "admin";
		String pass = "Passworda";
		
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			
			String record = "INSERT INTO goals (`wordGoal`, `dateGoal`) VALUES (?, ?);" + 
					"";
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
				
			Timestamp sqlDate = new Timestamp(dateGoal.getTime());
			
			pstmt.setInt(1, wordGoal);
			pstmt.setTimestamp(2, sqlDate);
			
			pstmt.executeUpdate();
				
			myConn.commit();
			
			pstmt.close();
			myConn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkGoalsSet() {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/times?autoReconnect=true&useSSL=false";
		String user = "admin";
		String pass = "Passworda";
				
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			
			String record = "select * from goals;";
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
				
			ResultSet myRs = pstmt.executeQuery();
			if (myRs.next()) {
				myConn.commit();
				pstmt.close();
				myConn.close();
				
				return true;
			} else {
				myConn.commit();
				pstmt.close();
				myConn.close();
				
				return false;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
