package controller;

import vo.Departments;
import model.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/departments/getDepartmentsList")
public class getDepartmentsListServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		departmentsDao = new DepartmentsDao(); //메소드 호출을 위해 객체 선언
	
		List<Departments> list = departmentsDao.selectDepartmentsList();
		
	request.setAttribute("list", list); //"다른곳에서 호출할 이름" , 보낼값
	
	request.getRequestDispatcher("/WEB-INF/views/departments/DepartmentsList.jsp").forward(request, response); //주소값
	}

}
