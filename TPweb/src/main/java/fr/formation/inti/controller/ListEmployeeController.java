package fr.formation.inti.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.EmployeeServiceImpl;

/**
 * Servlet implementation class ListCustomerController
 */
@WebServlet("/list")
public class ListEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService empService ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployeeController() {
    	empService = new EmployeeServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") !=null) {		
				List<Employee> list = empService.findAll();
				request.setAttribute("employees", list);
				getServletContext().getRequestDispatcher("/WEB-INF/view/listemp.jsp").forward(request, response);		
		} 	else {	
			request.getServletContext().getRequestDispatcher("/WEB-INF/view/pasbien.jsp").forward(request, response);
		}
		}

		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
