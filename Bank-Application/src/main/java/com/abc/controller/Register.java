package com.abc.controller;

import java.io.IOException;

import com.abc.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String custid = request.getParameter("custid");
		int accno = Integer.parseInt(request.getParameter("accno"));
		String pwd = request.getParameter("pwd");
		int bal = Integer.parseInt(request.getParameter("bal"));
		String email =request.getParameter("email");
		
		try {
			Model m = new Model();
			m.setName(name);
			m.setCustid(custid);
			m.setAccno(accno);
			m.setPwd(pwd);
			m.setBal(bal);
			m.setEmail(email);
			
			boolean b = m.register();
			
			if(b == true) {
				response.sendRedirect("/Bank-Application/SuccessReg.html");
			}
			else {
				response.sendRedirect("/Bank-Application/FailureReg.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
