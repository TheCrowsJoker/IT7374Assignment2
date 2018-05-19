package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class dbConnection {

	public void dbConn(Date date, char choice, int id) {
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
				record = "select * from times where id = ?;";
			}
			
			PreparedStatement pstmt = myConn.prepareStatement(record);
			Timestamp sqlDate = new Timestamp(date.getTime());
			pstmt.setTimestamp(1, sqlDate);
			
			if (choice == 's') {
				pstmt.setInt(1, id);
			}
			
			pstmt.executeUpdate();
			myConn.commit();
			
			pstmt.close();
			myConn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		Date time = new Date();
//		dbConn(time, 'i', 0);
//	}

}
