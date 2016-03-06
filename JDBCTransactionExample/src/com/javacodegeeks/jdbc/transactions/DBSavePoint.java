/**
 * 
 */
package com.javacodegeeks.jdbc.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * @author Andres.Cespedes
 *
 */
public class DBSavePoint {

	private static String INSERT = "INSERT INTO test.department (idDepartment, name) VALUES (?, ?)";

	public static void insertRow(Connection conn, int idRow, String contentRow)
			throws SQLException {
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(INSERT);
		pstmt.setInt(1, idRow);
		pstmt.setString(2, contentRow);
		pstmt.execute();
		pstmt.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = null;
		Savepoint savepoint = null;
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
			insertRow(connection, 1, "Madrid");
			insertRow(connection, 2, "Mali");
			savepoint = connection.setSavepoint("SavePoint1");
			insertRow(connection, 3, "Galicia");

			connection.commit();
			System.err.println("The transaction was successfully executed");
		} catch (SQLException e) {
			try {
				// We rollback the transaction, to the last SavePoint!
				connection.rollback(savepoint);
				System.err.println(e.getMessage());
				System.err
						.println("The transaction was rollback to the last savepoint");
			} catch (SQLException e1) {
				System.err.println("There was an error making a rollback");
			}
		}
	}

}
