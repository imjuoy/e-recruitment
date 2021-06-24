package Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Selectcriteria;

/**
 * Servlet implementation class Schedule_BGC_servlet
 */

public class Schedule_BGC_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Schedule_BGC_servlet() {
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
	System.out.println("Hey");
	Selectcriteria obj=new Selectcriteria();
	ResultSet s=obj.bgctestadmin();
	ResultSet result=obj.gettest_id();
	request.setAttribute("result",s);
	request.setAttribute("test_id", result);
	RequestDispatcher rd=request.getRequestDispatcher("bgc_schedule.jsp");
	rd.forward(request, response);
		}
		catch(Exception e)
		{
		}
	}

}
