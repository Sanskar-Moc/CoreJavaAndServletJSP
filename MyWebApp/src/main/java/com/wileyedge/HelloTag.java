package com.wileyedge;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	private String name;
	private PageContext pageContext = null;

	public HelloTag() {
		System.out.println("Inside constructor of hello tag");
	}

	public void setName(String name) {
		System.out.println("Inside setName() of HelloTag");
		this.name = name;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("Inside doTag() of HelloTag");
		pageContext=(PageContext) getJspContext();
		JspWriter out= pageContext.getOut();
		out.print("Welcome, "+name+" comment estas?");
	}



}
