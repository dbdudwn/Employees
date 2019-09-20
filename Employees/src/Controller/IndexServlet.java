package Controller;

import model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesdao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("./index URL 요청");
		
		this.employeesdao = new EmployeesDao();
		int employeesRowCount = employeesdao.SelectEmployeesCount();
		
		// /WEB-INF/views/Index.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Index.jsp");
		
		request.setAttribute("employeesRowCount", employeesRowCount); //Attribute는 map타입
		
		request.getRequestDispatcher("/WEB-INF/views/Index.jsp").forward(request, response);
	}
}
