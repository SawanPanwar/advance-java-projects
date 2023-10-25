package in.co.rays.ctl;

import java.io.IOException;
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
				UserBean bean = model.findById(Integer.parseInt(id));
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("in first servlet do post...!!");

		String op = req.getParameter("operation");

		String id = req.getParameter("id");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");

		UserBean bean = new UserBean();
		if (id != null) {
			bean.setId(Integer.parseInt(id));
		}
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

		if (op.equals("add")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "User added Successfully...!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (op.equals("update")) {
			try {
				model.update(bean);
				bean = model.findById(Integer.parseInt(id));
				req.setAttribute("msg", "User updated Successfully...!!!");
				req.setAttribute("bean", bean);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);

	}

}
