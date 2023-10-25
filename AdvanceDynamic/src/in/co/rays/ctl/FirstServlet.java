package in.co.rays.ctl;

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

		System.out.println("in first servlet do get...!!");

		// resp.sendRedirect("SecondServlet");

		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");

		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in first servlet do post...!!");

		// resp.sendRedirect("SecondServlet");

		req.setAttribute("address", "indore");

		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");

		rd.forward(req, resp);

	}

}
