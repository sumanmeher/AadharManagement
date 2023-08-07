package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.model.HibernateManager;

@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String aadharNo = req.getParameter("id");
		String chngVal = req.getParameter("choice");
		String newVal = req.getParameter("newVal");

		HibernateManager hbm = new HibernateManager();

		hbm.update(aadharNo, chngVal, newVal);

		res.sendRedirect("Success.html");

	}

}
