package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import model.EmployeesDao;
import vo.Employees;

@WebServlet("/employees/EmployeesListBetween")
public class getEmployeesListBetweenServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//처음접속이거나 로그인을 하지 않았을때
				HttpSession session = request.getSession();
				if(session.getAttribute("sessionEmpNo") == null) { 
					response.sendRedirect(request.getContextPath()+"/login");
					return;
				}
		
		int begin = Integer.parseInt(request.getParameter("begin"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		employeesDao = new EmployeesDao();
		
		List<Employees> list = employeesDao.selectEmployeesListBetween(begin, end);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/EmployeesListBetween.jsp").forward(request, response);
	}

}
