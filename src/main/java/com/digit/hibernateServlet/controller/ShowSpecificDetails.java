package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;

@WebServlet("/ShowSpecificDetails")
public class ShowSpecificDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String aadharNo = req.getParameter("id");
        
        HibernateManager hbm = new HibernateManager();
        AadharDetails user = hbm.showSpecific(aadharNo);
        HttpSession session = req.getSession();
        if(user!=null) {
            session.setAttribute("userDetail", user);
            res.sendRedirect("ShowUser.jsp");
        }else {
            res.sendRedirect("Fail.html");
        }

	}

}
