package in.co.rays.txn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransactionHandling2 {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into marksheet values(13, 113, 'aryant', 89, 22, 34)");

			i = stmt.executeUpdate("insert into marksheet values(13, 113, 'aryant', 89, 22, 34)");

			i = stmt.executeUpdate("insert into marksheet values(14, 114, 'aryant', 89, 22, 34)");

			System.out.println("data inserted => " + i);

		} catch (Exception e) {

			System.out.println("exception: " + e.getMessage());

		} finally {
			conn.close();
		}
	}
}