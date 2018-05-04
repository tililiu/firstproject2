package com.first.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.first.service.studentInfoService;

/**
 * Servlet implementation class displayStuServlet
 */
@WebServlet("/student/displayStuServlet")
public class displayStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List stus = new studentInfoService().queryAllStu();
		HttpSession session = request.getSession();
		session.setAttribute("stus", stus);
		String osid = request.getParameter("osid");
		if(osid.equals("query")) {
			response.sendRedirect("../displayStuInfo.jsp");
		}else if(osid.equals("modify")) {
			response.sendRedirect("../modifyStuInfo.jsp");
		}else {
			response.sendRedirect("../deleteStuInfo.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
