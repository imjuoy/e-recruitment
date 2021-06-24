package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.viewbgc_admin;


/**
 * Servlet implementation class viewbgc_admin_servlet
 */
public class viewbgc_admin_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewbgc_admin_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{    
		 try
		 {
	 	viewbgc_admin obj=new viewbgc_admin();
	    ResultSet rs=obj.getbgcdata();
	    request.setAttribute("result",rs);
	    RequestDispatcher view=request.getRequestDispatcher("view_bgcadmin.jsp");
		view.forward(request, response);
	}
		 catch(Exception e)
		 {}

}
}
