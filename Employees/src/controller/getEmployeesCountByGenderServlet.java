package Controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmployeesDao;


@WebServlet("/employees/EmployeesCountByGender")
public class getEmployeesCountByGenderServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		
		List<Map<String , Object>> list = employeesDao.selectEMployeesCountGroupByGender();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/EmployeesCountByGender.jsp").forward(request, response);
	}
}
