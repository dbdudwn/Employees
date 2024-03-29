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

@WebServlet("/employees/EmployeesListByPage")
public class getEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//처음접속이거나 로그인을 하지 않았을때
				HttpSession session = request.getSession();
				if(session.getAttribute("sessionEmpNo") == null) { 
					response.sendRedirect(request.getContextPath()+"/login");
					return;
				}
		
		employeesDao = new EmployeesDao();
		int rowperPage = 10;
		int currentPage = 1;
		int lastPage = employeesDao.selectLastPage(rowperPage);
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		List<Employees> list = employeesDao.selectEmployeesByPage(currentPage, rowperPage);
		System.out.println("currentPage :" + currentPage);
		
		request.setAttribute("list", list);
		System.out.println("list :" + list);
		
		request.setAttribute("currentPage", currentPage);
		System.out.println("currentPage :" + currentPage);
		
		request.setAttribute("lastPage", lastPage);
		System.out.println("lastPage :" + lastPage);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/EmployeesListByPage.jsp").forward(request, response);	
	}

}
