package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		bean.setId(15);
		bean.setRollNo(115);
		bean.setName("qwe");
		bean.setPhysics(87);
		bean.setChemistry(78);
		bean.setMaths(67);

		testAdd(bean);

	}

	private static void testAdd(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance11", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted = " + i);

	}

}
