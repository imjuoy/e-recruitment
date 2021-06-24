package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.SelectTestAdminModel;

/**
 * Servlet implementation class SelectTestAdmin
 */
public class SelectTestAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(SelectTestAdmin .class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTestAdmin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		SelectTestAdminModel sta = new SelectTestAdminModel();
		ResultSet rs = sta.EmployeeList();
		request.setAttribute("EmployeeList", rs);
		
		RequestDispatcher rd = request.getRequestDispatcher("select_ta.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
