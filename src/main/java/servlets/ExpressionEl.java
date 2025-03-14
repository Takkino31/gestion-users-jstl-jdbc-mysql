package servlets;

import java.io.IOException;

import beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/demo-el")
public class ExpressionEl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/demo-el.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User("Ahmed","Seck","ama","1234"); 
		request.setAttribute("message", "Ajout avec succes");
		request.setAttribute("user", user );
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	public ExpressionEl() {
		// TODO Auto-generated constructor stub
	}
}
 