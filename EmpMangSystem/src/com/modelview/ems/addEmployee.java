
package com.modelview.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.controller.ems.DbConnect;


public class addEmployee {
	static int id;
	static String Fname;
	static String Lname;
	static String Username;
	static String Password;
	static 	usertype emptype;
	static Scanner sc = new Scanner(System.in);
	public static String again;
	public static int choose;
	
	public static void main(String[] args) {
		empinsert();
	}
	
	
	
	static void empinsert() {
	// user data input
		System.out.println("Enter First Name :  ");
		Fname = sc.next();
		System.out.println("Enter Last Name : ");
		Lname = sc.next();
		System.out.println("Enter Username : ");
		Username = sc.next();
		System.out.println("Enter Password");
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

		// calling database connection from DBconnect
		Connection con = DbConnect.connect();
		//calling statement
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO login (fname, lname, username, password, usertype) VALUES (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, Fname);
			ps.setString(2, Lname);
			ps.setString(3, Username);
			ps.setString(4, Password);
			ps.setString(5, emptype.value);
			ps.execute();
			System.out.println("Data Insert Successfully");
			System.out.println("Do you want to login Again? ");
			System.out.println("Press Y for Yes and N for N : ");
			again = sc.next();
			if (again.equalsIgnoreCase("Y")) {
				empinsert();// call the method you to create
		
			}else
			{
				System.out.println("Thank you for using EMS");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

	}

}


