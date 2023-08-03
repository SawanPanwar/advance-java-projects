package in.co.rays.ctl;

import java.io.IOException;
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
		int pageNo = 1;
		int pageSize = 5;

		try {
			List list = model.search(null, pageNo, pageSize);
			List nextList = model.search(null, pageNo + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList.size());
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String firstName = req.getParameter("firstName");
		String dob = req.getParameter("dob");
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		int pageSize = 5;

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String op = req.getParameter("operation");

		if (op.equals("next")) {
			pageNo++;
		}

		if (op.equals("previous")) {
			pageNo--;
		}

		if (op.equals("add")) {
			resp.sendRedirect("UserCtl");
		}

		if (op.equals("delete")) {

			String[] ids = req.getParameterValues("ids");

			for (String id : ids) {

				try {
					model.delete(Integer.parseInt(id));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			pageNo = 1;

		}

		if (op.equals("search")) {
			try {

				bean.setFirstName(firstName);
				if (!(dob.equals(""))) {
					bean.setDob(sdf.parse(dob));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		List list;
		List nextList;
		try {
			list = model.search(bean, pageNo, pageSize);
			nextList = model.search(bean, pageNo + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList.size());
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
