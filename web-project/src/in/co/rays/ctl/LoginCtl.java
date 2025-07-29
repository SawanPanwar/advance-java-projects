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

		if (op != null && op.equalsIgnoreCase("Logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			req.setAttribute("success", "Logout Successfully..!!");
		}

		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String op = req.getParameter("operation");

		if (op.equalsIgnoreCase("signIn")) {
			UserModel model = new UserModel();

			try {
				UserBean bean = model.authenticate(loginId, password);

				if (bean != null) {

					HttpSession session = req.getSession();

					session.setAttribute("user", bean);

					resp.sendRedirect("WelcomeCtl");

				} else {
					req.setAttribute("error", "Login & Password Invalid");
					RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
					rd.forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (op.equalsIgnoreCase("signUp")) {
			resp.sendRedirect("UserRegistrationCtl");
			return;
		}
	}
}