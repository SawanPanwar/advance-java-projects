package com.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn
				.prepareStatement("insert into marksheet values(25, 124, 'chanchal', 89, 88, 78)");

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);
	}
}
