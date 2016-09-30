package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.insert_bgcstatus;

import bean.candidate;


/**
 * Servlet implementation class submit_status
 */
public class submit_status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submit_status() {
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
	String candidate_id=request.getParameter("cand_id");
	int status=Integer.parseInt(request.getParameter("bgc_status"));
	candidate obj=new candidate();
	obj.setStatus(status);
	obj.setCandid(candidate_id);
	insert_bgcstatus obj1=new insert_bgcstatus();
	int rs=obj1.insertstatus(obj);
	System.out.println(rs);
	if(rs>0)
	{
		 response.sendRedirect("confirm_bgc.jsp");
	}
	}
    catch(Exception e)
    {}
}
}
