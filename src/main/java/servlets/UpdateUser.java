package servlets;

import java.io.IOException;
import java.util.ArrayList;

import beans.User;
import dao.UserDao;
import forms.UserForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final String VIEW_EDIT_USER = "/WEB-INF/updateUser.jsp";
	private static final String VIEW_LIST_USER = "/WEB-INF/listUsers.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int  id = Integer.parseInt(request.getParameter("id"));
		
		ArrayList<User> users = UserDao.getUsers();
		for (User user : users) {
			if (user.getId() == id) {
				request.setAttribute("user", user);
			}
		}
	    request.getRequestDispatcher(VIEW_EDIT_USER).forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserForm userForm = new UserForm(request); 
	    boolean status = userForm.modifier();
	    
	    request.setAttribute("user", userForm.getUser());
	    request.setAttribute("erreurs", userForm.getErreurs());
	    request.setAttribute("statusMessage", userForm.getStatusMessage());
	    
	    
	    if (status) {
			response.sendRedirect(request.getContextPath() + "/list");

	    } else {
	        request.getRequestDispatcher(VIEW_EDIT_USER).forward(request, response); 
	    }
	}
}
