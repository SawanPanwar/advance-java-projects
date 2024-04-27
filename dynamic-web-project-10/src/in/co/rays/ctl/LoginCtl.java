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

		if (op != null) {

			HttpSession session = req.getSession();

			session.invalidate();

		}

		resp.sendRedirect("LoginView.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = req.getParameter("loginId");

		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		UserModel model = new UserModel();

		try {
			UserBean bean = model.authenticate(loginId, password);

			if (bean != null) {

				// req.setAttribute("user", bean);

				// RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
				// rd.forward(req, resp);

				session.setAttribute("user", bean);

				resp.sendRedirect("Welcome.jsp");

			} else {
				resp.sendRedirect("LoginView.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
