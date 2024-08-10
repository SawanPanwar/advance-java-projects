package in.co.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		if (id != null) {
			MarksheetModel model = new MarksheetModel();
			try {
				MarksheetBean bean = model.findByPk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rollNo = req.getParameter("rollNo");
		String name = req.getParameter("name");
		String physics = req.getParameter("physics");
		String chemistry = req.getParameter("chemistry");
		String maths = req.getParameter("maths");

		String op = req.getParameter("operation");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo(Integer.parseInt(rollNo));
		bean.setName(name);
		bean.setPhysics(Integer.parseInt(physics));
		bean.setChemistry(Integer.parseInt(chemistry));
		bean.setMaths(Integer.parseInt(maths));

		MarksheetModel model = new MarksheetModel();

		if (op.equals("save")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "Marksheet Added Successfully..!!");
			} catch (Exception e) {
				req.setAttribute("msg", e.getMessage());
			}
		}

		if (op.equals("update")) {
			try {
				String id = req.getParameter("id");
				bean.setId(Integer.parseInt(id));
				model.update(bean);
				bean = model.findByPk(bean.getId());
				req.setAttribute("bean", bean);
				req.setAttribute("msg", "Marksheet Updated Successfully..!!");
			} catch (Exception e) {
				req.setAttribute("msg", e.getMessage());
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(req, resp);

	}

}
