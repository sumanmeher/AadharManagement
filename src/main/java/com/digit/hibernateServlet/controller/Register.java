package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;



@WebServlet("/Register")
public class Register extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		
		AadharDetails ad=new AadharDetails();
		ad.setId(id);
		ad.setName(name);
		ad.setPhone(phone);
		ad.setEmail(email);
		ad.setAddress(address);
		ad.setCity(city);
		ad.setState(state);
	
		HibernateManager hbm = new HibernateManager();
		boolean isRegistered=hbm.register(ad);
		if(isRegistered==true) {
			res.sendRedirect("Success.html");
		}else {
			res.sendRedirect("Fail.html");
		}
		
		
	}
	
}
