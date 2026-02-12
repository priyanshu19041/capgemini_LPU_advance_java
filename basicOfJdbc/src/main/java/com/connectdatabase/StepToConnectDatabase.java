package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepToConnectDatabase {
		public static void main(String[] args) {
					//Load the driver class
			String url="jdbc:postgresql://localhost:5432/school";
			String un="postgres";
			String pwd="root";
			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Class loaded");
				//to establish connection.......
				Connection connect =DriverManager.getConnection(url,un,pwd);
				String sql="insert into student values(3,'Spiderman','FLYING','male')";
				
				//create statement
				Statement stmt=connect.createStatement();
				//Execute query
				stmt.execute(sql);
				connect.close();
				System.out.println("Data inserted");
				System.out.println("Connection created");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}