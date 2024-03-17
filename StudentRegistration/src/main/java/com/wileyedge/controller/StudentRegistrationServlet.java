package com.wileyedge.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wileyedge.dao.StudentDao;
import com.wileyedge.model.Student;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private StudentDao studentDao;

    
    public StudentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void init() throws ServletException {
        super.init();
        String url = "jdbc:mysql://localhost:3306/studentsdb?useSSL=false";
        String username = "root";
        String password = "password";
        studentDao = new StudentDao(url, username, password);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside do post");
		
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		long mob=Long.parseLong(request.getParameter("mobile"));
		String address=request.getParameter("address");
		
		Student student=new Student(name,age,mob,address);
		
		
		request.setAttribute("student", student);
		try {
			studentDao.registerStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("success.jsp").forward(request, response);
		
	}

}
