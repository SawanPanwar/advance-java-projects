package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdate {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update marksheet set name = 'xyz' where id = 1");

		int i = pstmt.executeUpdate();

		System.out.println("data updated: " + i);
	}
}