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
import javax.servlet.http.HttpSession;

@WebServlet("/departments/getDepartmentsList")
public class getDepartmentsListServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//처음접속이거나 로그인을 하지 않았을때
				HttpSession session = request.getSession();
				if(session.getAttribute("sessionEmpNo") == null) { 
					response.sendRedirect(request.getContextPath()+"/login");
					return;
				}
		
		departmentsDao = new DepartmentsDao(); //메소드 호출을 위해 객체 선언
	
		List<Departments> list = departmentsDao.selectDepartmentsList();
		
	request.setAttribute("list", list); //"다른곳에서 호출할 이름" , 보낼값
	
	request.getRequestDispatcher("/WEB-INF/views/departments/DepartmentsList.jsp").forward(request, response); //주소값
	}

}
