package io.mountblue.contactus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import io.mountblue.contactus.model.*;
import io.mountblue.contactus.dao.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		LoginDao dao = new LoginDao();
		if(dao.check(user)){
			HttpSession session = request.getSession();
			session.setAttribute("username",name);
			response.sendRedirect("dashboard");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1 style = 'color:red; text-align:center'>Enter the valid id & password!</h1>");
            rd.include(request, response);
		}
	}
}