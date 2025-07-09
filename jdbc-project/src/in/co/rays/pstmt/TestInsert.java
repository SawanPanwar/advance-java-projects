package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(3, 103, 'kkk', 22, 22, 22)");

		int i = pstmt.executeUpdate();

		System.out.println("data inserted: " + i);
	}
}