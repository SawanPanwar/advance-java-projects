package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		if (id != null) {

			UserModel model = new UserModel();

			try {
				UserBean bean = model.findByPk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.forward(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			resp.sendRedirect("UserRegistrationView.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String id = req.getParameter("id");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String op = req.getParameter("operation");

		UserBean bean = new UserBean();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLoginId(loginId);
		bean.setPassword(password);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setAddress(address);

		UserModel model = new UserModel();

		if (op.equals("signUp")) {
			try {
				model.add(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}

			req.setAttribute("msg", "User Registered Successfully..!!!");

			RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(req, resp);
		}

		if (op.equals("update")) {

			bean.setId(Integer.parseInt(id));

			try {
				model.update(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}

			resp.sendRedirect("UserListCtl.do");

		}

		if (op.equals("list")) {

			resp.sendRedirect("UserListCtl.do");

		}

	}

}
