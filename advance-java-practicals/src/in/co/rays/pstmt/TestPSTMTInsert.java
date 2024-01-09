package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPSTMTInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance11", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(11, 111, 'pqr', 79, 59, 89)");

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted = " + i);

	}

}
