package com.wileyEdge.demos;

public class JDBCDemo {

	public static void main(String[] args) {
		//1. load and register the JDBC driver(type 4)
		//2. get the connection object by passing URL,Username,Password
		//3. get the Statements from the Connection
		//4. get the ResultSet from Statement
		//5. print the result
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Type 4 driver of mysql is loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		}
	}

}
