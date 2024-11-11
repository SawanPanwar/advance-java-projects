package com.rays.txn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransactionHandling {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into marksheet values(32, 128, 'chanchal', 89, 88, 78)");

			i = stmt.executeUpdate("insert into marksheet values(32, 129, 'chanchal', 89, 88, 78)");

			i = stmt.executeUpdate("insert into marksheet values(33, 129, 'chanchal', 89, 88, 78)");

			conn.commit();

			System.out.println("data inserted => " + i);

		} catch (Exception e) {
			conn.rollback();
			System.err.println("exception: " + e.getMessage());
		} finally {
			conn.close();
		}
	}
}
