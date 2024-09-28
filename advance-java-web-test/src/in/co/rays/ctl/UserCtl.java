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

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		UserModel model = new UserModel();

		if (id != null) {
			try {
				UserBean bean = model.findByPk(Integer.parseInt(id));
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

		String op = req.getParameter("operation");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		bean.setFirstName(req.getParameter("firstName"));
		bean.setLastName(req.getParameter("lastName"));
		bean.setLoginId(req.getParameter("loginId"));
		bean.setPassword(req.getParameter("password"));
		try {
			bean.setDob(sdf.parse(req.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setAddress(req.getParameter("address"));

		UserModel model = new UserModel();

		if (op.equals("save")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "User Added Successfully...!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (op.equals("update")) {
			try {
				bean.setId(Integer.parseInt(req.getParameter("id")));
				model.update(bean);
				bean = model.findByPk(bean.getId());
				req.setAttribute("bean", bean);
				req.setAttribute("msg", "User Updated Successfully...!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);
	}
}
