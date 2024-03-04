package io.mountblue.contactus.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.mountblue.contactus.dao.RequestDao;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean currentStatus = Boolean.parseBoolean(request.getParameter("status"));
		RequestDao usersDao = new RequestDao();
		usersDao.changeStatus(id, !currentStatus);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
	}
}
