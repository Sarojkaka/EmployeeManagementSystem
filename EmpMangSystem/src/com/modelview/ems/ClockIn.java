package com.modelview.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.controller.ems.DbConnect;

public class ClockIn {

	public static void main(String[] args) {
		clockin();
		
	}

	static void clockin() {
		// calling database connection from DBconnect
				Connection con = DbConnect.connect();
				//calling statement
				PreparedStatement ps = null;
				try {
								java.util.Date date = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
					String sql = "insert into PunchClock (date,signIn,signOut) values(?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setDate(1, sqlDate);
					ps.setTimestamp(2, sqlTime);
					ps.setTimestamp(3, sqlTime);
					ps.executeUpdate();
					System.out.println("Clock in successfully");
					ps.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
}