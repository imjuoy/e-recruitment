package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import bean.*;

import java.sql.*;


public class dispservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public dispservlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
		    try {
			disp_emp obj1 = new disp_emp();
			ResultSet rs=obj1.dispData();
			request.setAttribute("result",rs);
			RequestDispatcher rd = request.getRequestDispatcher("disp.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
