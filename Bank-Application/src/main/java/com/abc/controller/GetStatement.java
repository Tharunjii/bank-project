package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.abc.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetStatement")
public class GetStatement extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			ArrayList al = m.getStatement();
			
			if(al.isEmpty()==true) {
				response.sendRedirect("/Bank-Application/StatementFail.html");
			}
			else {
				session.setAttribute("sal", m.sal);
				session.setAttribute("ral", m.ral);
				session.setAttribute("al", m.al);
				response.sendRedirect("/Bank-Application/StatementSuccess.jsp");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
