package in.co.rays.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into marksheet values(7, 107, 'aryant', 89, 22, 34)");

		System.out.println("data inserted => " + i);
	}
}
