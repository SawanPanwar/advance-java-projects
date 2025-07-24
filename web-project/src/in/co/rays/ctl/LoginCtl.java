package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("LoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String op = req.getParameter("operation");

		if (op.equalsIgnoreCase("signIn")) {
			System.out.println("login Id: " + loginId);
			System.out.println("password: " + password);
		} else if (op.equalsIgnoreCase("signUp")) {
			resp.sendRedirect("UserRegistrationCtl");
			return;
		}

		resp.sendRedirect("LoginView.jsp");
	}
}