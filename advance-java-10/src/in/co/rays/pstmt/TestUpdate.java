package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdate {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "update marksheet set name = 'arun', physics = 100 where id = 9";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int i = pstmt.executeUpdate(sql);

		System.out.println("Data Updated = " + i);

	}

}
