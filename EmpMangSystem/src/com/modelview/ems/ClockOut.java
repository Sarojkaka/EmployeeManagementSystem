package com.modelview.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.controller.ems.DbConnect;

public class ClockOut {
	static int id;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		clockout();

	}

	private static void clockout() {
		// calling database connection from DBconnect
		Connection con = DbConnect.connect();
		// calling statement
		PreparedStatement ps = null;
		try {
			System.out.println("Enter id you want to update data :");
			id = sc.nextInt();
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
			String sql = "UPDATE PunchClock SET signout = ? WHERE id = " + id;
			ps = con.prepareStatement(sql);
			ps.setTimestamp(1, sqlTime);
			ps.executeUpdate();
			System.out.println("Clock Out successfully");
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}