package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestDelete {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "delete from marksheet where id = 9";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int i = pstmt.executeUpdate(sql);

		System.out.println("Data Deleted = " + i);

	}

}
