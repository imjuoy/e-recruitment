package controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import bean.empbean;



public class empservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public empservlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try
		{
		System.out.println("inside empservlet");
		response.setContentType("text/jsp");
		//PrintWriter out = response.getWriter();
		// get form element data
		String emp_id=request.getParameter("empid");
		String ename = request.getParameter("ename");
		String dob = request.getParameter("dob");
		String loc = request.getParameter("loc");
		String gender = request.getParameter("gen");
		int ctc = Integer.parseInt(request.getParameter("ctc"));
		String desig =request.getParameter("desig");
		String uhid =request.getParameter("unithead_id");
		String prid = request.getParameter("prjid");
		int exp=Integer.parseInt(request.getParameter("exp"));
		String domain=request.getParameter("dom");
		String doj=request.getParameter("doj");

		// set data into bean object
		System.out.println("going into bean");
		empbean e = new empbean();
		e.setUhid(uhid);
		e.setPrid(prid);
		e.setEname(ename);
		e.setDob(dob);
		e.setLoc(loc);
		e.setGen(gender);
		e.setCtc(ctc);
		e.setDesig(desig);
		e.setEmpid(emp_id);
		e.setExp(exp);
		e.setDomain(domain);
		e.setDOJ(doj);

		// insert data into database by calling empcls.empdetails() method
		empcls obj = new empcls();
		System.out.println("going into empcls class");
		int i = obj.empdetails(e);
		int j= obj.dispdetails(e);
		if (i > 0 && j>0) {
			System.out.println("insertion successful");
			response.sendRedirect("confirm.jsp");
		} 
		else 
		{
			System.out.println("insertion in DB  unsuccessful. Please try again");
			response.sendRedirect("add_emp1.jsp");
		}
		
		}catch(Exception e)
		{
		}
		}
	}
		

