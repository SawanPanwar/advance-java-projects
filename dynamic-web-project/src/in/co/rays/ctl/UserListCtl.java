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

		UserModel model = new UserModel();

		try {
			List list = model.search(null, pageNo, pageSize);
			List nextList = model.search(null, pageNo + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
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
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		int pageSize = 5;

		String firstName = req.getParameter("firstName");
		String op = req.getParameter("operation");

		if (op.equals("search")) {
			bean = new UserBean();
			bean.setFirstName(firstName);
			pageNo = 1;
		}

		if (op.equals("add")) {
			resp.sendRedirect("UserCtl");
		}

		if (op.equals("next")) {
			pageNo++;
		}

		if (op.equals("previous")) {
			pageNo--;
		}

		UserModel model = new UserModel();

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
