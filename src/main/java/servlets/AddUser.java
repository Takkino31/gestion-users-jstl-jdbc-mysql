package servlets;

import java.io.IOException;

import beans.User;
import dao.UserDao;
import forms.UserForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddUser extends HttpServlet {
	private static final String VIEW_ADD_USER = "/WEB-INF/addUser.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VIEW_ADD_USER).forward(request, response);;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserForm form = new UserForm(request);
		if (form.ajouter()) {
			response.sendRedirect(request.getContextPath() + "/list");
		}else {
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("erreurs", form.getErreurs());
			request.setAttribute("user", form.getUser());
			getServletContext().getRequestDispatcher(VIEW_ADD_USER).forward(request, response);
		}
	} 
}
