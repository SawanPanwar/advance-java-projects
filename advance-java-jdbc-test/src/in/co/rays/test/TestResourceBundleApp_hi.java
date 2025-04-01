package in.co.rays.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundleApp_hi {

	public static void main(String[] args) {

		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hi");

		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_sp");

		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("hi"));

		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("sp"));

		// System.out.println(rb.getString("greeting"));

		selectLanguage("en");

	}

	public static void selectLanguage(String code) {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale(code));

		System.out.println(rb.getString("greeting"));

	}
}