package com.javacodegeeks.jdbc.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Andres.Cespedes
 *
 */
public class DBConnection {

	private static String DB_URL = "jdbc:mysql://localhost:3307/test";
	private static String DB_USER = "admin";
	private static String DB_PASSWORD = "admin";

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.err.println("The connection is successfully obtained");
		return connection;
	}
}