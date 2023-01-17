package fr.formation.inti.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
			request.getServletContext().getRequestDispatcher("/session").forward(request, response);
		}else {	
			request.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userService.findByEmail(email, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);			
			session.setMaxInactiveInterval(3600); // 1 heure
			request.getServletContext().getRequestDispatcher("/session").forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			out.print("<div class=bg-danger><div class=text-center> <font class=fw-bold> email ou mot de passe incorrect !</font></div></div>");
			rd.include(request, response);
		} 


	}

}
