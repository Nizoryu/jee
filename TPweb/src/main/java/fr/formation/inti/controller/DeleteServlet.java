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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService empService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		empService = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer idEmp = Integer.parseInt(id);
		empService.deleteById(idEmp);
		request.getServletContext().getRequestDispatcher("/list").forward(request, response);
	}

}
