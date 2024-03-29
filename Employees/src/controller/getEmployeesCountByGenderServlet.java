package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;


@WebServlet("/employees/EmployeesCountByGender")
public class getEmployeesCountByGenderServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//처음접속이거나 로그인을 하지 않았을때
				HttpSession session = request.getSession();
				if(session.getAttribute("sessionEmpNo") == null) { 
					response.sendRedirect(request.getContextPath()+"/login");
					return;
				}		
		
		employeesDao = new EmployeesDao();
		
		List<Map<String , Object>> list = employeesDao.selectEMployeesCountGroupByGender();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/EmployeesCountByGender.jsp").forward(request, response);
	}
}
