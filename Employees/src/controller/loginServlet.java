package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employees;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	//login Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response); 
	}
	//login Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employees employees = new Employees();
		employeesDao = new EmployeesDao();
		
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
	
//		System.out.println("empNo data :" + empNo);
//		System.out.println("firstName data :" + firstName);
//		System.out.println("lastName data :" + lastName);
		
		employees.setEmpNo(empNo);
		employees.setFirstName(firstName);
		employees.setLastName(lastName);
				
		String sessionEmpNo = employeesDao.login(employees);
		HttpSession session = request.getSession();
		session.setAttribute("sessionEmpNo", sessionEmpNo);
		
		if(sessionEmpNo != null) {
			response.sendRedirect(request.getContextPath()+"/");
		}else {
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
	}

}
	