package in.co.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(req.getParameter("firstName"));
		System.out.println(req.getParameter("lastName"));
		System.out.println(req.getParameter("loginId"));
		System.out.println(req.getParameter("password"));
		System.out.println(req.getParameter("dob"));
		System.out.println(req.getParameter("address"));

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.print("<h1>" + req.getParameter("firstName") + "</h1>");

		out.close();

	}
}
