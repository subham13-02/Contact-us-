package io.mountblue.contactus.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.mountblue.contactus.dao.UsersDao;

@WebServlet("/changeStatus")
public class ChangeStatus extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		boolean currentStatus=Boolean.parseBoolean(request.getParameter("status"));
		
		UsersDao usersDao=new UsersDao();
		
		usersDao.changeStatus(id, !currentStatus);
		
		response.sendRedirect("adminPage.jsp");
	}

}
