package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance_practicals", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(9, 109, 'aaa', 98, 76, 66)");

		int i = ps.executeUpdate();

		System.out.println("data inserted = " + i);

	}

}
