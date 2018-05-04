package com.first.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.model.studentInfo;
import com.first.service.studentInfoService;

/**
 * Servlet implementation class addStuInfoServlet
 */
@WebServlet("/student/addStuInfoServlet")
public class addStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStuInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		studentInfo stu = new studentInfo();
		stu.setNickname(request.getParameter("nickname"));
		stu.setTruename(request.getParameter("truename"));
		stu.setSex(Byte.parseByte(request.getParameter("sex")));
		String birthday = request.getParameter("birthday");
		if(birthday.equals("")) {
			birthday = null;
		}
		stu.setBirthday(birthday);
		stu.setMajor(request.getParameter("major"));
		String courses[] = request.getParameterValues("course");
		if(courses != null) {
			stu.setCourse(courses);
		}
		String interests[] = request.getParameterValues("interest");
		if(interests != null) {
			stu.setInterest(interests);
		}
		stu.setRemark(request.getParameter("remark"));
		if(new studentInfoService().addStudent(stu)) {
			response.sendRedirect("../addstuinfo_success.jsp");
		} else {
			response.sendRedirect("../addstuinfo.jsp");
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
