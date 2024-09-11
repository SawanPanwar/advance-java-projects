package in.co.rays.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into emp values(13, 'tvs', 1000, 1)");

		System.out.println("data inserted => " + i);

	}
}
