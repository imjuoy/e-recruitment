package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.update_bgcstatus;


/**
 * Servlet implementation class bgc_status_servlet
 */
public class bgc_status_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bgc_status_servlet() {
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
     update_bgcstatus obj=new update_bgcstatus();
     ResultSet rs=obj.getcandid();
     request.setAttribute("result",rs);
     RequestDispatcher view=request.getRequestDispatcher("update_bgc_status.jsp");
	 view.forward(request, response);
	
	}
		  catch(Exception e)
		  {}

}
}
