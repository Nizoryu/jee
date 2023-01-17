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
			getServletContext().getRequestDispatcher("/logout").forward(request, response);
		} 	else {	
			getServletContext().getRequestDispatcher("/WEB-INF/view/addUser.html").forward(request, response);
		}
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
		String adminkey = request.getParameter("admin_key");
		
		PrintWriter out = response.getWriter();
		User user = userService.findByUniqueEmail(email);
		if(user != null) {  //si la méthode trouve un user avec le même email inscrit
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addUser.html");
			out.print("<div class=bg-danger><div class=text-center> <font class=fw-bold> email déjà utilisé !</font></div></div>");
			rd.include(request, response);
			
		}else if(adminkey != "yohanlefou" && roleName.equals("ADMIN")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addUser.html");
			out.print("<div class=bg-danger><div class=text-center> <font class=fw-bold> mauvaise clé admin</font></div></div>");
			rd.include(request, response);			
		}else {
		
		User u = new User(roleName, email, password, firstName, lastName, new GregorianCalendar().getTime());
			userService.save(u);
			request.getServletContext().getRequestDispatcher("/login").forward(request, response);
			
		}
		
	

	}

}
