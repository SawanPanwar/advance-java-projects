package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");

		System.out.println("FirstServlet doGet");

		System.out.println(fname);
		System.out.println(lname);

		// resp.sendRedirect("SecondServlet");

		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");

		System.out.println("FirstServlet doPost");

		System.out.println(fname);
		System.out.println(lname);

		req.setAttribute("address", "indore");

		// resp.sendRedirect("SecondServlet");

		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		rd.forward(req, resp);

	}

}
