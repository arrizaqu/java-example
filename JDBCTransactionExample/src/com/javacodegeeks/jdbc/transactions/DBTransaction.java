package com.javacodegeeks.jdbc.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Andres.Cespedes
 *
 */
public class DBTransaction {

	private static String INSERT = "INSERT INTO test.department (idDepartment, name) VALUES (?, ?)";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			System.err.println("There was an error getting the connection");
		}
		try {
			connection.setAutoCommit(false);
			System.err.println("The autocommit was disabled!");
		} catch (SQLException e) {
			System.err.println("There was an error disabling autocommit");
		}
		// Starts JDBC Transaction
		try {
			pstmt = connection.prepareStatement(INSERT);
			pstmt2 = connection.prepareStatement(INSERT);
			
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Madrid");
			pstmt.execute();
			
			pstmt2.setInt(1, 2);
			pstmt2.setString(2, "Galicia");
			pstmt2.execute();
			
			connection.commit();
			System.err.println("The transaction was successfully executed");
		} catch (SQLException e) {
			try {
				//We rollback the transaction, atomicity!
				connection.rollback();
				System.err.println(e.getMessage());
				System.err.println("The transaction was rollback");
			} catch (SQLException e1) {
				System.err.println("There was an error making a rollback");
			}
		}
	}
}
