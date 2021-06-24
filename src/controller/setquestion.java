package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Quesset;
import model.Validate;

import bean.Getset;


/**
 * Servlet implementation class setquestion
 */

public class setquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setquestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter();
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
	try{
		String id=(String) session.getAttribute("id");
		String desig=(String) session.getAttribute("desig");
		String ques=request.getParameter("ques");
		String ans=request.getParameter("ans");
		System.out.println(id);
		System.out.println(desig);
		Getset g=new Getset();
		g.setQues(ques);
		g.setAns(ans);
		g.setId(id);
		g.setDesig(desig);
		Quesset obj=new Quesset();
		int k=obj.setQues(g);
		System.out.println("k is"+k);
		if(k>0 && desig.equalsIgnoreCase("hr"))
		{
			response.sendRedirect("HRofficer_home.jsp");
		}
		else if(k>0 && desig.equalsIgnoreCase("uh"))
		{
			response.sendRedirect("Unithead_home.jsp");
		}
		else if(k>0 && desig.equalsIgnoreCase("BGCAdmin"))
		{
			response.sendRedirect("BGCadmin_home.jsp");
		}
		else
		{
		System.out.println("question & ans not set successfully");

		}
	
}catch(Exception e){}

}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
