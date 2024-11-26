package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		if (op != null && op.equalsIgnoreCase("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		resp.sendRedirect("LoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		if (op.equalsIgnoreCase("signIn")) {
			String loginId = req.getParameter("loginId");
			String password = req.getParameter("password");

			UserModel model = new UserModel();

			HttpSession session = req.getSession();

			try {
				UserBean bean = model.authenticate(loginId, password);
				if (bean != null) {
					session.setAttribute("user", bean);
					resp.sendRedirect("WelcomeCtl");
					return;
				} else {
					req.setAttribute("msg", "Invalid Login ID & Password");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
			rd.forward(req, resp);

		}

		if (op.equalsIgnoreCase("signUp")) {
			resp.sendRedirect("UserRegistrationCtl");
		}
	}
}
