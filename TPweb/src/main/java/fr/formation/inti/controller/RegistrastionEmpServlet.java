package fr.formation.inti.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.EmployeeServiceImpl;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class RegistrastionServlet
 */
@WebServlet("/registreemp")
public class RegistrastionEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService empService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrastionEmpServlet() {
		empService = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") !=null) {			
			getServletContext().getRequestDispatcher("/WEB-INF/view/addemp.jsp").forward(request, response);
		} 	else {	
			request.getServletContext().getRequestDispatcher("/WEB-INF/view/pasbien.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String startdate = request.getParameter("startdate");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate_conv;

		try {
			startdate_conv = simpleDateFormat.parse(startdate); // convertion du string en date
			Employee e = new Employee(firstName, lastName, startdate_conv, title);
			empService.save(e);
			response.sendRedirect("/TPweb/list");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

//		Employee e = new Employee();
//		e.setFirstName(firstName);
//		e.setStartDate(startdate);
//		e.setLastName(lastName);
//		e.setTitle(title);

	}

}
