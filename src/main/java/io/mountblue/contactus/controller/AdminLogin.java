package io.mountblue.contactus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import io.mountblue.contactus.model.*;
import io.mountblue.contactus.dao.*;
@WebServlet("/login")
public class AdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);
		AdminDao dao = new AdminDao();
		if(dao.check(admin)){
			HttpSession session = request.getSession();
			session.setAttribute("username",name);
			response.sendRedirect("adminPage.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
