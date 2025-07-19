package in.co.rays.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundleApp_hi {

	public static void main(String[] args) {

//		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

//		 ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hi");

//		 ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_sp");

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("hi"));

//		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("sp"));
//
		System.out.println(rb.getString("greeting"));

	}

	public void selectLanguage(String lang) {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale(lang));

		System.out.println(rb.getString("greeting"));

	}

}
