package io.mountblue.contactus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mountblue.contactus.dao.UsersDao;
import io.mountblue.contactus.model.User;

@WebServlet("/insertData")
public class UserData extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String message=request.getParameter("message");
		User user =new User();
		user.setName(name);
		user.setMail(email);
		user.setMessage(message);
		UsersDao userDao=new UsersDao();
		
		userDao.insertData(user);
		
		response.sendRedirect("contactus.jsp");
	}
}
