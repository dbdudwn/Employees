package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeptEmpDao;
import model.EmployeesDao;
import vo.DeptEmp;
import vo.Employees;


@WebServlet("/deptemp/DeptEmpList")
public class getDeptEmpListServlet extends HttpServlet {
	private DeptEmpDao deptempDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//처음접속이거나 로그인을 하지 않았을때
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionEmpNo") == null) { 
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		deptempDao = new DeptEmpDao();
		
		
		
		deptempDao = new DeptEmpDao();
		int rowperPage = 10;
		int currentPage = 1;
		int lastPage = deptempDao.selectLastPage(rowperPage);
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		List<DeptEmp> list = deptempDao.selectDeptEmpList(currentPage, rowperPage);
		System.out.println("currentPage :" + currentPage);
		
		request.setAttribute("list", list);
		
		request.setAttribute("currentPage", currentPage);
		System.out.println("currentPage :" + currentPage);
		
		request.setAttribute("lastPage", lastPage);
		System.out.println("lastPage :" + lastPage);
	
		
		request.getRequestDispatcher("/WEB-INF/views/deptemp/DeptEmpList.jsp").forward(request, response);
		
	}

}
