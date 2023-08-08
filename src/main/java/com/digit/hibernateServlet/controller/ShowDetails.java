package com.digit.hibernateServlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.digit.hibernateServlet.model.HibernateManager;



@WebServlet("/ShowAllDetails")
public class ShowDetails extends HttpServlet {
	public static Session session;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HibernateManager hbm = new HibernateManager();
		HttpSession session=req.getSession();
		List showAllDetails = hbm.showAllDetails();
		session.setAttribute("allUser", showAllDetails);
		if(showAllDetails==null) {
			res.sendRedirect("Fail.html");
		}else {
			res.sendRedirect("ShowAllDetails.jsp");
		}
		
	}

}