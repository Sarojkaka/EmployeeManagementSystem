package com.modelview.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.controller.ems.DbConnect;

public class Login {

	static String Username;
	static String Password;
	static 	usertype emptype;
	public static Scanner sc = new Scanner(System.in);
	public static String again;
	static int choose;

	public static void main(String[] args) {
		select();
	}

	private static void select() {
		// user data input
		System.out.println("Enter Username :  ");
		Username = sc.next();
		System.out.println("Enter Password : ");
		Password = sc.next();
		System.out.println("Choose UserType");
		//Usertype = sc.next();
		System.out.println("1.admin\t2.user");
		choose=sc.nextInt();
		if(choose==1) {
			emptype=usertype.ADMIN;
		}else
		{
			emptype=usertype.EMPLOYEE;
		}

		// select
		// calling databse connection from Dbconnect
		Connection con = DbConnect.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "Select username, password from login where username=? and password=? and usertype=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, Username);
			ps.setString(2, Password);
			ps.setString(3, emptype.value);
			rs = ps.executeQuery();

			if (rs.next()) {
				if(choose==1) {
					emptype=usertype.ADMIN;
					AdminDashboard ad = new AdminDashboard();
					ad.AdminDash();
				}else
				{
					userDashboard ud = new userDashboard();
					ud.UserDash();
					//usertype.admin();
					//calling object
				}
				
			}else {
				System.out.println("Login Failed");
				System.out.println("Do you want to login Again? ");
				System.out.println("Press Y for Yes and N for N : ");
				again = sc.next();
				if (again.equalsIgnoreCase("Y")) {
					select();// call the method you to create
			
				}else
				{
					System.out.println("Thank you for using EMS");
				}
			}
		}
		 catch (Exception e){
		}

	}	
}
