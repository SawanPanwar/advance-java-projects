package in.co.rays.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into marksheet values(20, 111, 'satya', 78, 67, 98)");
			i = stmt.executeUpdate("insert into marksheet values(21, 111, 'satya', 78, 67, 98)");
			i = stmt.executeUpdate("insert into marksheet values(21, 116, 'satya', 78, 67, 98)");

			conn.commit();
			conn.close();
			System.out.println("Data Inserted = " + i);
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Exception: " + e.getMessage());
		}

	}

}
