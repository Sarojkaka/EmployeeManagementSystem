package com.modelview.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.controller.ems.DbConnect;

public class deleteEmployee {
	public static Scanner sc = new Scanner(System.in);
	public static String again;
	public static int choose;
	public static int empid;

	public static void main(String[] args) {
		deleteemp();

	}

	
	static void deleteemp() {
		System.out.println("Enter id you want to delete data :");
		empid = sc.nextInt();
		
		Connection con = DbConnect.connect();
		PreparedStatement ps = null;
		
		try {
			String sql = "delete from login WHERE id =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,+empid);
			ps.execute();
			System.out.println("Data has been deleted Successfully");
			System.out.println("Do you want to see Again? ");
			System.out.println("Press Y for Yes and N for N : ");
			again = sc.next();
			if (again.equalsIgnoreCase("Y")) {
				deleteemp();// call the method you to create
			}else
			{
				AdminDashboard ad = new AdminDashboard();
				ad.AdminDash();
			}
		} catch (Exception e){
			System.out.println(e.toString());
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}