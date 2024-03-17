package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        System.out.println("inside constructor of login servelet");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doGet()");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost()");
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		System.out.println("forwarding");
		
		
		
		HttpSession session=request.getSession(true);
		if(username.equals(password)) {
			session.setAttribute("uname", username);
			
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.include(request, response);
			out.println("request is included");
//			out.println("<html>"
//					+ "<body>"
//					+ "<h2>Authentication Successful</h2>"
//					+ "</body>"
//					+ "</html>");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
//			out.println("<html>"
//					+ "<body>"
//					+ "<h2>Please enter credentials again</h2>"
//					+ "</body>"
//					+ "</html>");
		}
	}

}
