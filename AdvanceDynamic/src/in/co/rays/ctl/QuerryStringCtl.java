package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuerryStringCtl")
public class QuerryStringCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in QuerryStringCtl do get...");

		String name = req.getParameter("name");

		String[] address = req.getParameterValues("address");

		System.out.println("name = " + name);

		for (String add : address) {

			System.out.println(add);

		}

	}

}
