package in.co.rays.user;

import java.util.Date;

public class TestDate {

	public static void main(String[] args) {

		Date today = new Date();

		System.out.println(today);

		System.out.println(today.getTime());

		System.out.println(new java.sql.Date(today.getTime()));

	}

}
