package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.empcls;

import bean.*;


public class Editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Editservlet() {
		super();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// getting form elements
		String empid = request.getParameter("empid");
		String desig = request.getParameter("sele");
		int ctc = Integer.parseInt(request.getParameter("sele2"));
		

		// getting into bean class
		empbean e = new empbean();
		e.setEmpid(empid);
		e.setDesig(desig);
		e.setCtc(ctc);
		

		// calling edit function
		empcls obj3 = new empcls();
		int i = obj3.editctc(e);
		int j = obj3.editdesig(e);

		if (i > 0 && j>0) 
		     {
			System.out.print("edited successfully");
			response.sendRedirect("confirm.jsp");
		     }
		else
			System.out.print("Unsuccessfull");
	}

}
