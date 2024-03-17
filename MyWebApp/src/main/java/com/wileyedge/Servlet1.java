package com.wileyedge;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		this.config=config;
//	}
	@Override
	public void init() throws ServletException {
		System.out.println("inside overridden init of servlet 1 "+this.getServletConfig().toString());
	}

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
		String fname=request.getParameter("fname");
		request.setAttribute("nickname", "judah");
		
		config=getServletConfig();
		String mname=(String)config.getInitParameter("middlename");
		System.out.println("inside servlet 1, middlename :"+mname);
		
		ServletContext context= config.getServletContext();
		String lname=(String)context.getInitParameter("lastname");
		System.out.println("inside servlet 1,with servlet context lastname :"+lname);
		
		RequestDispatcher rd=request.getRequestDispatcher("/servlet2");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
