package servlets;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListUser extends HttpServlet {
	
	private static final String VIEW_LIST_USER = "/WEB-INF/listUsers.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  request.setAttribute("users", UserDao.getUsers());
		  getServletContext().getRequestDispatcher(VIEW_LIST_USER).forward(request, response);;
	}
}
