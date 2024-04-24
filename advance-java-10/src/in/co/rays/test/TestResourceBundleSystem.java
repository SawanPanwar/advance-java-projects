package in.co.rays.test;

import java.util.ResourceBundle;

public class TestResourceBundleSystem {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");

		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("initialpoolsize"));
		System.out.println(rb.getString("acquireincrement"));
		System.out.println(rb.getString("maxpoolsize"));

	}

}
