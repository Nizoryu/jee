package fr.formation.inti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class RegistrastionServlet
 */
@WebServlet("/registre")
public class RegistrastionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrastionServlet() {
		this.userService = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") !=null) {			
			getServletContext().getRequestDispatcher("/WEB-INF/view/addUser.html").forward(request, response);
		} 	else {	
			request.getServletContext().getRequestDispatcher("/WEB-INF/views/pasbien.html").forward(request, response);
		}
		getServletContext().getRequestDispatcher("/WEB-INF/view/addUser.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		response.setContentType("text/html");
		String roleName = request.getParameter("roleName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		
		PrintWriter out = response.getWriter();
		User user = userService.findByUniqueEmail(email);
		if(user != null) {  //si la méthode trouve un user avec le même email inscrit
			RequestDispatcher rd = request.getRequestDispatcher("/registre"); 
			out.println("<font color=red>email déjà utilisé </font>");
			
		}else { //si la méthode ne trouve pas d'email dans la bdd
			User u = new User(roleName, email, password, firstName, lastName, new GregorianCalendar().getTime());
			userService.save(u);
			response.sendRedirect("/TPweb/login.jsp");
			
		}
		
		
//		User u = new User(roleName, email, password, firstName, lastName, new GregorianCalendar().getTime());
//		userService.save(u);
//		response.sendRedirect("/TPweb/login.jsp");

	

	}

}
