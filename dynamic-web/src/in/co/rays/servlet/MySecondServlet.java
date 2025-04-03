package in.co.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MySecondServlet")
public class MySecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<div align='center'>");
		out.println("<h1>User Registration</h1>");
		out.println("<form action='MySecondServlet' method='post'>");
		out.println("<table>");
		out.println("<tr><th>First Name:</th><td><input type='text' name='firstName'></td></tr>");
		out.println("<tr><th>Last Name:</th><td><input type='text' name='lastName'></td></tr>");
		out.println("<tr><th>Login ID:</th><td><input type='text' name='loginId'></td></tr>");
		out.println("<tr><th>Password:</th><td><input type='text' name='password'></td></tr>");
		out.println("<tr><th>DOB:</th><td><input type='date' name='dob' style='width: 98%'></td></tr>");
		out.println("<tr><th>Address:</th><td><input type='text' name='address'></td></tr>");
		out.println("<tr><td></td><td><input type='submit'></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</div>");

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(loginId);
		System.out.println(password);
		System.out.println(dob);
		System.out.println(address);
		
		
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<div align='center'>");
		out.println("<h1>User Registration</h1>");
		out.println("<form action='MySecondServlet' method='post'>");
		out.println("<table>");
		out.println("<tr><th>First Name:</th><td><input type='text' name='firstName'></td></tr>");
		out.println("<tr><th>Last Name:</th><td><input type='text' name='lastName'></td></tr>");
		out.println("<tr><th>Login ID:</th><td><input type='text' name='loginId'></td></tr>");
		out.println("<tr><th>Password:</th><td><input type='text' name='password'></td></tr>");
		out.println("<tr><th>DOB:</th><td><input type='date' name='dob' style='width: 98%'></td></tr>");
		out.println("<tr><th>Address:</th><td><input type='text' name='address'></td></tr>");
		out.println("<tr><td></td><td><input type='submit'></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</div>");

		out.close();

	}

}
