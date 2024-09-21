package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("UserRegistrationView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("firstName"));
		System.out.println(req.getParameter("lastName"));
		System.out.println(req.getParameter("loginId"));
		System.out.println(req.getParameter("password"));
		System.out.println(req.getParameter("dob"));
		System.out.println(req.getParameter("address"));
		resp.sendRedirect("UserRegistrationView.jsp");
	}
}
