package fr.formation.inti.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.EmployeeServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private EmployeeService empService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        empService = new EmployeeServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer idEmp = Integer.parseInt(id);
		Employee emp = empService.findById(idEmp);
		request.setAttribute("emp", emp);
		request.getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String startdate = request.getParameter("startdate");
		
		String id = request.getParameter("empId");
		Integer idEmp = Integer.parseInt(id);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate_conv;
		try {
			startdate_conv = simpleDateFormat.parse(startdate);    //convertion du string en date
			Employee e = new Employee(firstName, lastName, startdate_conv, title);
			e.setEmpId(idEmp);
			empService.save(e);
			response.sendRedirect("/TPweb/list");
		} catch (ParseException e1) {		
			e1.printStackTrace();
		}
	}

}
