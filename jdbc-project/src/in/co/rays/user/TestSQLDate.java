package in.co.rays.user;

import java.util.Date;

public class TestSQLDate {

	public static void main(String[] args) {

		Date d = new Date();

		System.out.println(d);

		System.out.println(d.getTime());

		java.sql.Date dSQL = new java.sql.Date(d.getTime());

		System.out.println(dSQL);

	}
}