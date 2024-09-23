package in.co.rays.test;

public class Person {

	String name = "abc";
	String address = "indore";

	@Override
	public String toString() {
		System.out.println("to string method");
		return name + " " + address;
	}

}
