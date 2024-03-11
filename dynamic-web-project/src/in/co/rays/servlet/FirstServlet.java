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

		System.out.println("FirstServlet doGet");

		// resp.sendRedirect("SecondServlet");

		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("FirstServlet doPost");

		System.out.println("FirstServlet firstName = " + req.getParameter("firstName"));

		req.setAttribute("lastName", "xyz");

		// resp.sendRedirect("SecondServlet");

		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		rd.forward(req, resp);

	}

}
