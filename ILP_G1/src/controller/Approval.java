package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.updatebgcid;


/**
 * Servlet implementation class Approval
 */
public class Approval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approval() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
	String empid=request.getParameter("empname");
	//int EmpId=Integer.parseInt("empid");
	System.out.print("The selected BGC is"+empid);
	updatebgcid a=new updatebgcid();
	int rs=a.updatestatus(empid);
	System.out.println("Update status is"+rs);
	if(rs==1)
		response.sendRedirect("confirm.jsp");
	else
		response.sendRedirect("select_bgcadmin.jsp");
		}
		catch(Exception e)
		{
			
		}
	}

}
