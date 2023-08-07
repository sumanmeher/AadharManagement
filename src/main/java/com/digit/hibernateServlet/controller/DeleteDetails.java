package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.model.HibernateManager;

@WebServlet("/DeleteDetails")
public class DeleteDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String aadharNo = req.getParameter("id");


        HibernateManager hbm = new HibernateManager();

        hbm.deleteData(aadharNo);

        res.sendRedirect("Success.html");
	}
}
