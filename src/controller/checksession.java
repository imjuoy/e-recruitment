package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checksession
 */
public class checksession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checksession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
	String designation=(String)session.getAttribute("desig");
	System.out.println("designation");
	if(designation.equalsIgnoreCase("hr"))
	    response.sendRedirect("HRofficer_home.jsp");
	if(designation.equalsIgnoreCase("bgcadmin"))
		response.sendRedirect("BGCadmin_home.jsp");
	}

}
