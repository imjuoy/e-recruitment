package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Selectcriteria;
import model.delete_data;


/**
 * Servlet implementation class intermediate_servlet
 */

public class intermediate_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public intermediate_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id=request.getParameter("adminid");
	String fdate=request.getParameter("fdate");
	String tdate=request.getParameter("tdate");
	String button_val=request.getParameter("button");
	System.out.println(button_val);
	System.out.println(id);
	if(button_val.equalsIgnoreCase("EDIT"))
	{
	Selectcriteria obj=new Selectcriteria();
	ResultSet s=obj.bgctestadmin();	
	request.setAttribute("Id",id);
	request.setAttribute("Fdate",fdate);
	request.setAttribute("Tdate",tdate);
	request.setAttribute("result",s);
	RequestDispatcher rd =request.getRequestDispatcher("update_bgc_schedule.jsp");
	rd.forward(request,response);
	}
	else if(button_val.equalsIgnoreCase("DELETE"))
	{
	  delete_data obj1=new delete_data();
	  int i=obj1.delete_row(id);
	  System.out.println(i);
	  if(i>0)
	  {
	  response.sendRedirect("UpdateDate");
	  }
	}

}
}