package Controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;


@WebServlet("/departments/DepartmentsCountByDeptNo")
public class getDepartmentsCountByDeptNoServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		departmentsDao = new DepartmentsDao();
		
		List<Map<String , Object>> list = departmentsDao.selectDepartmentsCountByDeptNo();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/departments/DepartmentsCountByDeptNo.jsp").forward(request, response);
	
	}

}