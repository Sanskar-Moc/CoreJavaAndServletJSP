package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */

// http://localhost:8080/MyWebApp/hello

public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public MyFirstServlet() {
        super();
        System.out.println("inside constructor of my servlet");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//        System.out.println("inside init");
//	}
    
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
        System.out.println("inside destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside doGet()");
        PrintWriter out=response.getWriter();
        request.setAttribute("myname", "sanskar");
       
        ServletContext context=getServletConfig().getServletContext();
        context.setAttribute("myname", "jesus");
        System.out.println("forwarding the reqto html");
        RequestDispatcher rd=request.getRequestDispatcher("loginpage.jsp");
        rd.forward(request, response);
        
//        String value=request.getParameter("name");
        
//        out.print("hello from the server welcome "+value);
//        out.println(
//        		"<html>"
//        		+ "<body> "
//        		+ "<h1>Login Page</h1>"
//        		+ "<form action='login' method='post' >\r\n"
//        		+ "  <label for=\"fname\">Enter Username:</label><br>\r\n"
//        		+ "  <input type='text' name='uname'\"><br>\r\n"
//        		+ "  <label for=\"lname\">Enter Password:</label><br>\r\n"
//        		+ "  <input type='password' name='pwd'\"><br><br>\r\n"
//        		+ "  <input type=\"submit\" value=\"Sign In\">\r\n"
//        		+ "</form> \r\n"
//        		+ "\r\n"
//        		+ "</body>"
//        		+ "</html>"
//        		);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside doPost()");
		doGet(request, response);
	}

}
