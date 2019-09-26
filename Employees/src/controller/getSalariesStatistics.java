package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import model.*;


@WebServlet("/salaries/SalariesStatistics")
public class getSalariesStatistics extends HttpServlet {
	private SalariesDao salariesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//처음접속이거나 로그인을 하지 않았을때
				HttpSession session = request.getSession();
				if(session.getAttribute("sessionEmpNo") == null) { 
					response.sendRedirect(request.getContextPath()+"/login");
					return;
				}
		
		salariesDao = new SalariesDao();
		Map<String , Long> map = salariesDao.selectSalariesStatistics();
		
		
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/WEB-INF/views/salaries/SalariesStatistics.jsp").forward(request, response);
	}

}
