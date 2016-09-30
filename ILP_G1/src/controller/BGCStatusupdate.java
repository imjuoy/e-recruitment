package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.updatebgcstatus;

import bean.bgcadmin_bean;


/**
 * Servlet implementation class BGCStatusupdate
 */
public class BGCStatusupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BGCStatusupdate() {
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
		String empid=request.getParameter("emp_id");
		String status=request.getParameter("status");
		bgcadmin_bean obj=new bgcadmin_bean();
		obj.setid(empid);
		obj.setstatus(status);
		updatebgcstatus obj1=new updatebgcstatus();
		int rs=obj1.updateit(obj);
		System.out.println("Update status is"+rs);
		if(rs>0)
			response.sendRedirect("confirm.jsp");
	    else
	       response.sendRedirect("Approvebgc.jsp");
	}
catch(Exception e)
{}
}
}