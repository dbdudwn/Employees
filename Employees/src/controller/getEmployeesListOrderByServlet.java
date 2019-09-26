package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.*;
import model.*;
import java.util.*;

@WebServlet("/employees/EmployeesListOrderBy")
public class getEmployeesListOrderByServlet extends HttpServlet {
	private EmployeesDao employeesDao ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		
		String order = request.getParameter("order");
		
		List<Employees> list = employeesDao.selectEmployeesListOrderBy(order);
		 
		request.setAttribute("list", list); //1 = list라 부르고 2 = list값을 request안에 복사
		
		System.out.println("getEmployeesListOrderByServlet param order :" + order); //값이 넘어왔는지 확인
		
		request.getRequestDispatcher("/WEB-INF/views/employees/EmployeesListOrderBy.jsp").forward(request, response); //forward = (1,2) 값을 ("/")으로 보내줌
	}

}
