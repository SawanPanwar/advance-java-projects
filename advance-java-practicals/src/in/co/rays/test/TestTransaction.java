package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance11", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into emp values(17, 'jay' , 2200, 3)");
			i = stmt.executeUpdate("insert into emp values(18, 'jay' , 2200, 3)");
			i = stmt.executeUpdate("insert into emp values(19, jay , 2200, 3)");

			System.out.println("Data inserted = " + i);

			conn.commit();
			conn.close();

		} catch (Exception e) {
			conn.rollback();
		}

	}

}
