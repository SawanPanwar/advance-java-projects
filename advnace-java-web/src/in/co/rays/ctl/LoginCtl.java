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
import in.co.rays.util.DataValidator;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	public boolean validate(HttpServletRequest req) {
		boolean checked = true;
		if (DataValidator.isNull(req.getParameter("loginId"))) {
			req.setAttribute("loginId", "login id is required");
			checked = false;
		}
		if (DataValidator.isNull(req.getParameter("password"))) {
			req.setAttribute("password", "password is required");
			checked = false;
		}
		return checked;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		if (op != null && op.equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
		}

		resp.sendRedirect("LoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String op = req.getParameter("operation");
		String uri = req.getParameter("uri");

		if (op.equals("signUp")) {
			resp.sendRedirect("UserRegistrationCtl");
		}

		if (op.equals("signIn")) {

			if (validate(req)) {

				UserModel model = new UserModel();

				HttpSession session = req.getSession();

				// session.setMaxInactiveInterval(30);

				try {
					UserBean bean = model.authenticate(loginId, password);
					if (bean != null) {
						session.setAttribute("user", bean);
						if (uri.equalsIgnoreCase("null")) {
							resp.sendRedirect("WelcomeCtl");
						} else {
							resp.sendRedirect(uri);
						}
						return;
					} else {
						req.setAttribute("msg", "Login ID & Password is invalid");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
			rd.forward(req, resp);
		}
	}
}
