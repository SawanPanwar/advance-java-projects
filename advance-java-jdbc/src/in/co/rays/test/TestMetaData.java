package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TestMetaData {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

		ResultSet rs = pstmt.executeQuery();

		ResultSetMetaData metaData = rs.getMetaData();

		System.out.println(metaData);

		System.out.println("Catalog Name: " + metaData.getCatalogName(1));

		System.out.println("Table Name: " + metaData.getTableName(1));

		System.out.println("Column Count: " + metaData.getColumnCount());
	}
}
