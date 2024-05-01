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

@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBean bean = null;

		int pageNo = 1;

		int pageSize = 5;

		UserModel model = new UserModel();

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextlist = model.search(null, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("nextlist", nextlist);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");

			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBean bean = null;

		int pageNo = 1;

		int pageSize = 5;

		UserModel model = new UserModel();

		pageNo = Integer.parseInt(req.getParameter("pageNo"));

		String firstName = req.getParameter("firstName");

		String[] ids = req.getParameterValues("ids");

		String op = req.getParameter("operation");

		if (op.equals("next")) {

			pageNo++;

		}

		if (op.equals("previous")) {

			pageNo--;

		}

		if (op.equals("add")) {

			resp.sendRedirect("UserCtl.do");

		}

		if (op.equals("search")) {

			bean = new UserBean();
			bean.setFirstName(firstName);

		}

		if (op.equals("delete")) {

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

			List nextlist = model.search(bean, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("nextlist", nextlist);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");

			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
