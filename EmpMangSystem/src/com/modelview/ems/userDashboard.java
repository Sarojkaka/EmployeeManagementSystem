package com.modelview.ems;

import java.util.Scanner;

public class userDashboard {
	public static Scanner sc = new Scanner(System.in);
	public static int choose;
	public static String again;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDash();
	}

	public static void UserDash() {

			while(true) {
				System.out.println("\t\t\t\t+===================================+");
				System.out.println("\t\t\t\t           Welcome To EMS          ");
				System.out.println("\t\t\t\t   1. Sign In   	     		");
				System.out.println("\t\t\t\t   1. Sign Out  	     		");
				System.out.println("\t\t\t\t   2. Update informatiom		");
				System.out.println("\t\t\t\t   4. View  Data            	");
				System.out.println("\t\t\t\t   5. Cancel                 			");
				System.out.println("\t\t\t\t+====================================+");
			
				System.out.println("Press number you want to do : ");
				choose = sc.nextInt();
				
				// conditions
				if (choose == 1) 		{
					clockin();
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
						UserDash();
				}else {
					System.out.println("Thank You For Using EMS");
				}
				}
				
			}
				
				


		}
		public static void clockin() {
			ClockIn cln = new ClockIn();
			cln.clockin();
			
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
