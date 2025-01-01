package in.co.rays.test;

import java.util.ResourceBundle;

public class TestRB {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

		System.out.println(rb.getString("greeting"));

	}

}
