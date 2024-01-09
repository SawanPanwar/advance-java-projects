package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PSTMTCrud {

	public static void main(String[] args) throws Exception {

		// testAdd(14, 114, "fgh", 89, 67, 78);
		// testUpdate(15, 115, "samay", 80, 80, 80);
		// testDelete(15);
		// testRead();
		// testFindByID(11);

	}

	private static void testAdd(int id, int rollNo, String name, int phy, int chem, int maths) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance11", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, id);
		pstmt.setInt(2, rollNo);
		pstmt.setString(3, name);
		pstmt.setInt(4, phy);
		pstmt.setInt(5, chem);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted = " + i);

	}

	private static void testUpdate(int id, int rollNo, String name, int phy, int chem, int maths) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance11", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update marksheet set roll_no = ?, name = ?, physics = ?, chemistry = ?, maths = ? where id = ?");

		pstmt.setInt(1, rollNo);
		pstmt.setString(2, name);
		pstmt.setInt(3, phy);
		pstmt.setInt(4, chem);
		pstmt.setInt(5, maths);
		pstmt.setInt(6, id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Updated = " + i);

	}

	private static void testDelete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance11", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted = " + i);

	}

	private static void testRead() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance11", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

	private static void testFindByID(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance11", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}
}
