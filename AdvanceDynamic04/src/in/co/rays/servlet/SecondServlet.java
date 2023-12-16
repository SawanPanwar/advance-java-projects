package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");

		System.out.println("SecondServlet doGet");

		System.out.println(fname);
		System.out.println(lname);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String address = (String) req.getAttribute("address");

		System.out.println("SecondServlet doPost");

		System.out.println(fname);
		System.out.println(lname);
		System.out.println(address);

	}

}
