package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import java.sql.*;

public class drop_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public drop_servlet() {
		super();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			System.out.println("dropdown servlet");
			drop_down obj = new drop_down();

			ResultSet rs = obj.droplist();
			request.setAttribute("result", rs);
			RequestDispatcher rd = request.getRequestDispatcher("editjsp.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

		}
	}
}
