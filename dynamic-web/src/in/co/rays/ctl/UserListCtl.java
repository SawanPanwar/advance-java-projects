package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		UserModel model = new UserModel();

		UserBean bean = null;

		int pageNo = 1;

		int pageSize = 5;

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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel model = new UserModel();

		UserBean bean = null;

		int pageNo = 1;

		int pageSize = 5;

		String op = req.getParameter("operation");
		pageNo = Integer.parseInt(req.getParameter("pageNo"));

		if (op.equals("previous")) {
			pageNo--;
		}
		if (op.equals("next")) {
			pageNo++;
		}
		if (op.equals("add")) {
			resp.sendRedirect("UserCtl.do");
		}
		if (op.equals("search")) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			pageNo = 1;

			bean = new UserBean();

			bean.setFirstName(req.getParameter("firstName"));
			try {
				bean.setDob(sdf.parse(req.getParameter("dob")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (op.equals("delete")) {

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
				req.setAttribute("msg", "Record Deleted Successfully..!!");
			} else {
				req.setAttribute("msg", "Select atleast One Record..!!");
			}
		}

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
