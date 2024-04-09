package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicPSTMT {

	public static void main(String[] args) throws Exception {

		//testAdd();
		testAdd(11, 111, "pqr", 78, 56, 78);

	}

	public static void testAdd() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "insert into marksheet values(?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, 10);
		pstmt.setInt(2, 110);
		pstmt.setString(3, "abcd");
		pstmt.setInt(4, 90);
		pstmt.setInt(5, 90);
		pstmt.setInt(6, 90);

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted = " + i);

	}

	public static void testAdd(int id, int rollNo, String name, int phy, int chem, int maths) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "insert into marksheet values(?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, id);
		pstmt.setInt(2, rollNo);
		pstmt.setString(3, name);
		pstmt.setInt(4, phy);
		pstmt.setInt(5, chem);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted = " + i);

	}

}
