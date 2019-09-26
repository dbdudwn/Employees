package controller;

import model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/Index","/"})
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao; //IndexServlet의 고유 객체처럼 밖에서 생성해주고 , 여기서만 사용 가능하도록 잠궈준다
	private DepartmentsDao departmentsDao;
	private DeptEmpDao deptEmpDao;
	private DeptManagerDao deptManagerDao;
	private SalariesDao salariesDao;
	private TitlesDao titlesDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("./index URL 요청");
	
		employeesDao = new EmployeesDao();
		departmentsDao = new DepartmentsDao();
		deptEmpDao = new DeptEmpDao();
		deptManagerDao = new DeptManagerDao();
		salariesDao = new SalariesDao();
		titlesDao = new TitlesDao();
		
		this.employeesDao = new EmployeesDao();		
		// /WEB-INF/views/Index.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Index.jsp");
		
		int employeesRowCount = employeesDao.SelectEmployeesCount();
		int departmentsRowCount = departmentsDao.selectDepartmentsRowCount();
		int deptEmpRowCount = deptEmpDao.selectDeptEmpRowCount();
		int deptManagerRowCount = deptManagerDao.selectDeptManagerRowCount();
		int salariesRowCount = salariesDao.selectSalariesRowCount();
		int titlesRowCount = titlesDao.selectTitlesRowCount(); 
		//count는 view(jsp)필요 , view는 request와 response만 넘길 수 있음
		
		request.setAttribute("EmployeesRowCount", employeesRowCount);
		request.setAttribute("DepartmentsRowCount", departmentsRowCount);
		request.setAttribute("DeptEmpRowCount", deptEmpRowCount);
		request.setAttribute("DeptManagerRowCount", deptManagerRowCount);
		request.setAttribute("SalariesRowCount", salariesRowCount);
		request.setAttribute("TitlesRowCount", titlesRowCount);
		request.setAttribute("EmployeesRowCount", employeesRowCount); //Attribute는 map타입
		
		request.getRequestDispatcher("/WEB-INF/views/Index.jsp").forward(request, response);
	}
}
