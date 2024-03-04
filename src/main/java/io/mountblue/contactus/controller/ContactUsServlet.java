package io.mountblue.contactus.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mountblue.contactus.dao.RequestDao;
import io.mountblue.contactus.model.Request;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("contactUs.jsp");
		requestDispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		Request requests = new Request();
		requests.setName(name);
		requests.setMail(email);
		requests.setMessage(message);
		RequestDao requestDao = new RequestDao();
		requestDao.insertData(requests);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("contactUs.jsp");
		requestDispatcher.forward(request, response);
	}
}
