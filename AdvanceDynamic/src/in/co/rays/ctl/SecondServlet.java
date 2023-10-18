package in.co.rays.ctl;

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

		System.out.println("in second servlet do get...!!");

		System.out.println("firstname = " + req.getParameter("firstName"));
		System.out.println("lastname = " + req.getParameter("lastName"));

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in second servlet do post...!!");

		System.out.println("firstname = " + req.getParameter("firstName"));
		System.out.println("lastname = " + req.getParameter("lastName"));
		System.out.println("address = " + req.getAttribute("address"));

	}

}
