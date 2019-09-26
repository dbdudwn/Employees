package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import vo.Employees;
import model.EmployeesDao;

@WebServlet("/employees/getEmployeesList")
public class getEmployeesListServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		int limit = 10;
		
		if(request.getParameter("limit") != null) { //넘어온 limit의 값이 null이 아닐때 Integer(형변환)하여 limit을 보냄
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<Employees> list = employeesDao.selectEmployeesListByLimit(limit);
		
		request.setAttribute("list", list);
		System.out.println("getEmployeesListServlet param limit :" + limit);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/EmployeesList.jsp").forward(request, response);
	}
}
