package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		this.config=config;
//	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init() throws ServletException {
		System.out.println("inside overridden init of servlet 2 "+this.getServletConfig().toString());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String nickname=(String) request.getAttribute("nickname");
//		
		config=getServletConfig();
		String mname=config.getInitParameter("middlename");
		System.out.println("inside servlet 2, middlename :"+mname);
		
		ServletContext context= config.getServletContext();
		String lname=(String)context.getInitParameter("lastname");
		System.out.println("inside servlet 2,with servlet context lastname :"+lname);
		
		PrintWriter out=response.getWriter();
		out.println("<h2>welcome "+fname+"</h2>");
		out.println("<h1>nickname: "+ nickname+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
