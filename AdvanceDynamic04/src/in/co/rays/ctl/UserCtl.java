package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		System.out.println("id =====> " + id);

		if (id != null) {

			UserModel model = new UserModel();

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

		String id = req.getParameter("id");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");

		UserBean bean = new UserBean();
		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setLoginId(login);
		bean.setPassword(pass);
		bean.setDob(DataUtility.stringToDate(dob));
		bean.setAddress(address);

		UserModel model = new UserModel();

		if (op.equals("save")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "User added Successfully..!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (op.equals("update")) {
			bean.setId(Integer.parseInt(id));
			try {
				model.update(bean);
				bean = model.findByPk(bean.getId());
				req.setAttribute("msg", "User updated Successfully..!!");
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);

	}

}
