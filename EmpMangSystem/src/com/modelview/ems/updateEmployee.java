package com.modelview.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.controller.ems.DbConnect;

public class updateEmployee {
	static int id;
	static String Fname;
	static String Lname;
	static String Username;
	static String Password;
	static String Usertype;
	public static Scanner sc = new Scanner(System.in);
	public static String again;
	public static int choose;
	static int empid;

	public static Connection con = DbConnect.connect();

	public static void main(String[] args) {
		updateemp();

	}

	static void updateemp() {

//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//	
//
//			System.out.println("Enter id you want to update data :");
//			empid = sc.nextInt();
//			String sql = "SELECT * FROM login where id = " + empid;
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			System.out.println("Employee Information\n");
//			// checking data
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String Fname = rs.getString("fname");
//				String Lname = rs.getString("lname");
//				String Username = rs.getString("username");
//				String Password = rs.getString("password");
//				String Usertype = rs.getString("usertype");
//
//				System.out.println("Employee ID : " + id);
//				System.out.println("First Name : " + Fname);
//				System.out.println("Last Name : " + Lname);
//				System.out.println("Username : " + Username);
//				System.out.println("Password : " + Password);
//				System.out.println("Usertype : " + Usertype);
//				System.out.println("\n");
//				System.out.println("Do you update this data : ");
//				System.out.println("Press Y for Yes and N for N : ");
//				
//			}	
//	
//
//		try {
//			// user data input
//			System.out.println("Enter id you want to update data :");
//			empid = sc.nextInt();
//			
//			System.out.println("Enter First Name :  ");
//			Fname = sc.next();
//			System.out.println("Enter Last Name : ");
//			Lname = sc.next();
//			System.out.println("Enter Username : ");
//			Username = sc.next();
//			System.out.println("Enter Password");
//			Password = sc.next();
//
//			String sql = "UPDATE login set fname = ?,lname = ?,username = ?,password = ? WHERE id = "+id;
//			ps = con.prepareStatement(sql);
//			ps.setString(1,Fname);
//			ps.setString(2, Lname);
//			ps.setString(3,Username);
//			ps.setString(4, Password);
//			ps.execute();
//			System.out.println("Data Updated Successfully");
//			System.out.println("Do you want to login Again? ");
//			System.out.println("Press Y for Yes and N for N : ");
//			again = sc.next();
//			if (again.equalsIgnoreCase("Y")) {
//				updateemp();// call the method you to create
//
//			} else {
//				System.out.println("Thank you for using EMS");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.toString());
//		}
		// calling database connection from DBconnect
		Connection con = DbConnect.connect();
		// calling statement
		PreparedStatement ps = null;
		try {
			System.out.println("Enter id you want to update data :");
			empid = sc.nextInt();
			System.out.println("Enter First Name :  ");
			Fname = sc.next();
			System.out.println("Enter Last Name : ");
			Lname = sc.next();
			System.out.println("Enter Username : ");
			Username = sc.next();
			System.out.println("Enter Password");
			Password = sc.next();
			String sql = "UPDATE login set fname = ?,lname = ?,username = ?,password = ? WHERE id = "+id;
			ps = con.prepareStatement(sql);
			ps.setString(1,Fname);
			ps.setString(2, Lname);
			ps.setString(3,Username);
			ps.setString(4, Password);
			ps.executeUpdate();
			System.out.println("Clock Out successfully");
			//ps.close();
			//con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
