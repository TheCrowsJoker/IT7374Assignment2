package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class dbConnection {
	private String dbURL = "jdbc:mysql://127.0.0.1:3306/times?autoReconnect=true&useSSL=false";
	private String user = "admin";
	private String pass = "Passworda";
	
	public void setStartTime(Date date) {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			String record = "INSERT INTO times (`startTime`) VALUES (?);";
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
			Timestamp sqlDate = new Timestamp(date.getTime());
			pstmt.setTimestamp(1, sqlDate);
			
			pstmt.executeUpdate();			
			myConn.commit();
			
			pstmt.close();
			myConn.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setEndTime(Date date) {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			String record ="Update times set endTime = timestamp(?) order by id desc limit 1;"; // update the last row of the table
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
			Timestamp sqlDate = new Timestamp(date.getTime());
			pstmt.setTimestamp(1, sqlDate);
			
			pstmt.executeUpdate();			
			myConn.commit();
			
			pstmt.close();
			myConn.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Date[] getTimes() {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			String record = "select * from times order by id desc limit 1;"; // select the last row
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
			ResultSet myRs = pstmt.executeQuery();
			
			Date[] dateArr = new Date[2];
			
			while (myRs.next()) {
				dateArr[0] = myRs.getTimestamp("startTime");
				dateArr[1] = myRs.getTimestamp("endTime");
			}
						
			pstmt.close();
			myConn.close();
			
			return dateArr;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void setGoals(int wordGoal, Date dateGoal) {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			
			String record = "INSERT INTO goals (`wordGoal`, `dateGoal`) VALUES (?, ?);";
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
				
			java.sql.Date sqlDate = new java.sql.Date(dateGoal.getTime());
			
			pstmt.setInt(1, wordGoal);
			pstmt.setDate(2, sqlDate);
			
			pstmt.executeUpdate();
				
			myConn.commit();
			
			pstmt.close();
			myConn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkGoalsSet() {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			
			String record = "select * from goals;";
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
				
			ResultSet myRs = pstmt.executeQuery();
			if (myRs.next()) {
				pstmt.close();
				myConn.close();
				
				return true;
			} else {
				pstmt.close();
				myConn.close();
				
				return false;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public int getWordGoal() {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			
			String record = "select wordGoal from goals;";
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
				
			ResultSet myRs = pstmt.executeQuery();
			int wordGoal = 0;
			
			while (myRs.next()) {
				wordGoal = myRs.getInt("wordGoal");
			}
			
			pstmt.close();
			myConn.close();
			
			return wordGoal;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public Date getDateGoal() {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			
			String record = "select dateGoal from goals;";
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
				
			ResultSet myRs = pstmt.executeQuery();
			Date dateGoal = null;
			
			while (myRs.next()) {
				dateGoal = myRs.getDate("dateGoal");
			}
			
			pstmt.close();
			myConn.close();
			
			return dateGoal;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void setWords(int words) {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			String record ="Update times set words = ? order by id desc limit 1;"; // update the last row of the table
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
			pstmt.setInt(1, words);
			
			pstmt.executeUpdate();			
			myConn.commit();
			
			pstmt.close();
			myConn.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getWords() {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			
			String record = "select words from times order by id desc limit 1;"; // get the last row of the table
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
				
			ResultSet myRs = pstmt.executeQuery();
			int words = 0;
			
			while (myRs.next()) {
				words = myRs.getInt("words");
			}
			
			pstmt.close();
			myConn.close();
			
			return words;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int getTotalWords() {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			myConn.setAutoCommit(false);
			
			String record = "select sum(words) as totalWords from times;";
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
				
			ResultSet myRs = pstmt.executeQuery();
			int words = 0;
			
			while (myRs.next()) {
				words = myRs.getInt("totalWords");
			}
			
			pstmt.close();
			myConn.close();
			
			return words;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
