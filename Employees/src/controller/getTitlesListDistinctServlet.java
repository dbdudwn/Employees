package controller;

import java.io.IOException;
import model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;


@WebServlet("/titles/TitlesListDistinct")
public class getTitlesListDistinctServlet extends HttpServlet {
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//처음접속이거나 로그인을 하지 않았을때
				HttpSession session = request.getSession();
				if(session.getAttribute("sessionEmpNo") == null) { 
					response.sendRedirect(request.getContextPath()+"/login");
					return;
				}
		
		titlesDao = new TitlesDao(); //객체변수 생성
		List<String> list = titlesDao.selectTitlesListDistinct();
		
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/titles/TitlesListDistinct.jsp").forward(request, response);
	}

}
