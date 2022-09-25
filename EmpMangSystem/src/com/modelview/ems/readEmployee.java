package com.modelview.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.controller.ems.DbConnect;

public class readEmployee {
	public static Scanner sc = new Scanner(System.in);
	public static String again;
	public static int choose;
	public static int empid;

	public static void main(String[] args) {
		reademp();

	}

	public static void reademp() {
		//calling databse connection from Dbconnect
		Connection con = DbConnect.connect();
		//
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			System.out.println("Enter id you want to view data :");
			empid = sc.nextInt();
			String sql = "SELECT * FROM login where id = "+empid;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("Employee Information\n");
			//checking data
			while(rs.next()) {
				int id = rs.getInt("id");
				String Fname = rs.getString("fname");
			    String Lname= rs.getString("lname");
				String Username = rs.getString("username");
				String Password = rs.getString("password");
				String Usertype = rs.getString("usertype");
				
				
				System.out.println("Employee ID : "+id);
				System.out.println("First Name : "+Fname);
				System.out.println("Last Name : "+Lname);
				System.out.println("Username : "+Username);
				System.out.println("Password : "+Password);
				System.out.println("Usertype : "+Usertype);
				System.out.println("\n");
				
			}
			System.out.println("Do you want to see Again? ");
			System.out.println("Press Y for Yes and N for N : ");
			again = sc.next();
			if (again.equalsIgnoreCase("Y")) {
				reademp();// call the method you to create
			}else
			{
				AdminDashboard ad = new AdminDashboard();
				ad.AdminDash();
			}
			
		}catch(SQLException e) {
			
		}finally {
			
		}try {
			rs.close();
			ps.close();
			con.close();
			
		}catch(SQLException e) {
			
			System.out.println(e.toString());
		}
		
		
	}
}



