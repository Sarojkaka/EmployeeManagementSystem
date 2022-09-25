package com.controller.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {


	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/ems","root","");
			//System.out.println("Connected");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e + "");

		}
		return con;
	}
}
