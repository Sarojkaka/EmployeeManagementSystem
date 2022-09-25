package com.modelview.ems;

import com.controller.ems.DbConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class testems {
	static int id;
	static String Fname;
	static String Lname;
	static String Username;
	static String Password;
	static String Usertype;
	static int empid;
	public static Scanner sc = new Scanner(System.in);
	public static String again;

    public static void update() {
//    	System.out.println("Enter id you want to update data :");
//		empid = sc.nextInt();
//		System.out.println("Enter First Name :  ");
//		Fname = sc.next();
//		System.out.println("Enter Last Name : ");
//		Lname = sc.next();
//		System.out.println("Enter Username : ");
//		Username = sc.next();
//		System.out.println("Enter Password");
//		Password = sc.next();
//		System.out.println("Choose UserType");
//		Usertype = sc.next();
//        String sql = "UPDATE login SET fname = ? , " + "lname = ? " + "username = ? " + "password = ? "+ "usertype = ? " + "WHERE id = " + empid;
//
//        try  {
//        	Connection con = DbConnect.connect();
//        	PreparedStatement ps;
//        	ps = con.prepareStatement(sql);
//            // set the corresponding param
//			ps.setString(1, Fname);
//			ps.setString(2, Lname);
//			ps.setString(3, Username);
//			ps.setString(4, Password);
//			ps.setString(5, Usertype);
//            // update 
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    	// user data input
    			System.out.println("Enter Username :  ");
    			Username = sc.next();
    			System.out.println("Enter Password : ");
    			Password = sc.next();
//    			System.out.println("Enter Usertype : ");
//    			Usertype = sc.next();
    			Usertype = "admin";
    			// select
    			// calling databse connection from Dbconnect
    			Connection con = DbConnect.connect();
    			PreparedStatement ps = null;
    			ResultSet rs = null;

    			try {
    				String sql = "Select username, password, usertype from login where username=? and password=? and usertype="+Usertype;
    				ps = con.prepareStatement(sql);
    				ps.setString(1, Username);
    				ps.setString(2, Password);
    				//ps.setString(3, Usertype);
    				rs = ps.executeQuery();

    				if (rs.next()) {
    					
    					//calling object
    					AdminDashboard ad = new AdminDashboard();
    					ad.AdminDash();
    				
    					
    				}else {
    					System.out.println("Login Failed");
    					System.out.println("Do you want to login Again? ");
    					System.out.println("Press Y for Yes and N for N : ");
    					again = sc.next();
    					if (again.equalsIgnoreCase("Y")) {
    						update();// call the method you to create
    				
    					}else
    					{
    						System.out.println("Thank you for using EMS");
    					}
    				}
    			}
    			 catch (Exception e){
    			}

    		}	

    public static void main(String[] args) {
        
        update();
    }

}