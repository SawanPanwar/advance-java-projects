package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int pageNo = 1;
		int pageSize = 5;
		UserBean bean = null;

		UserModel model = new UserModel();

		try {
			List list = model.search(bean, pageNo, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int pageNo = 1;
		int pageSize = 5;
		UserBean bean = null;

		String op = req.getParameter("operation");

		pageNo = Integer.parseInt(req.getParameter("pageNo"));

		UserModel model = new UserModel();

		if (op.equalsIgnoreCase("next")) {
			pageNo++;
		}
		if (op.equalsIgnoreCase("previous")) {
			pageNo--;
		}
		if (op.equalsIgnoreCase("add")) {
			resp.sendRedirect("UserCtl");
		}
		if (op.equalsIgnoreCase("search")) {
			bean = new UserBean();
			bean.setFirstName(req.getParameter("firstName"));
		}
		if (op.equalsIgnoreCase("delete")) {
			pageNo = 1;
			String[] ids = req.getParameterValues("ids");
			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		try {
			List list = model.search(bean, pageNo, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
