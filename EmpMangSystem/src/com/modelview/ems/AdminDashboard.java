package com.modelview.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.controller.ems.DbConnect;

public class AdminDashboard {
	
	public static Scanner sc = new Scanner(System.in);
	public static int choose;
	public static String again;


	public static void AdminDash() {

		while(true) {
			System.out.println("\t\t\t\t+===================================+");
			System.out.println("\t\t\t\t           Welcome To EMS          ");
			System.out.println("\t\t\t\t   1. Add Employee  				");
			System.out.println("\t\t\t\t   2. Update Employee				");
			System.out.println("\t\t\t\t   3. Delete Employee				");
			System.out.println("\t\t\t\t   4. View Employee Data            ");
			System.out.println("\t\t\t\t   5. Cancel                        ");
			System.out.println("\t\t\t\t+====================================+");
		
			System.out.println("Press number you want to do : ");
			choose = sc.nextInt();
			
			// conditions
			if (choose == 1) 		{
				empinsert();
			} else if (choose == 2) {
				empupdate();
				
			} else if (choose == 3) {
				empdelete();
				
			} else if (choose == 4) {
				empread();

			} else if (choose == 5) {
				System.out.println("Thank you for using EMS");
				break;
			}else 
			{	System.out.println("Invalid Entry");
				System.out.println("Do you want to Try Again? ");
				System.out.println("Press Y for Yes and N for N : ");
				again = sc.next();
				if (again.equalsIgnoreCase("Y")) {
					AdminDash();
			}else {
				System.out.println("Thank You For Using EMS");
			}
			}
			
		}
			
			


	}
	public static void empinsert() {
		addEmployee ade = new addEmployee();
		ade.empinsert();
		
	}	private static void empupdate() {
		
		updateEmployee ude = new updateEmployee();
		ude.updateemp();	
	}
	private static void empdelete() {
		deleteEmployee dde = new deleteEmployee();
		dde.deleteemp();
	}private static void empread() {
		readEmployee rae = new readEmployee();
		rae.reademp();
	}

}
