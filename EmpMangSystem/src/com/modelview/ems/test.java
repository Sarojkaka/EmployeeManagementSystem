package com.modelview.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.controller.ems.DbConnect;

public class test {
	static int id;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		testing();

	}

	private static void testing() {
		System.out.println("Enter id you want to update data :");
		id = sc.nextInt();
		// calling database connection from DBconnect
		Connection con = DbConnect.connect();
		//calling statement
		PreparedStatement ps = null;
		try {
			//to get time
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
			
			//inserting data
			
			String sql = "INSERT INTO clockinout(id, fname, lname, username, date, signin, signout)\r\n"
					+ "SELECT id, fname, lname, username FROM login;"+id;
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