package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseCtl extends HttpServlet {

	public boolean validate(HttpServletRequest req) {
		return true;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		if (op != null) {
			if (!validate(req)) {
				RequestDispatcher rd = req.getRequestDispatcher(getView());
				rd.forward(req, resp);
				return;
			}
		}
		super.service(req, resp);
	}

	public String getView() {
		return null;
	}

}
