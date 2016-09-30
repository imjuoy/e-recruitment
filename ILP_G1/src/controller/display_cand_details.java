package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PdfTest;
import model.get_details;

import bean.candidate;



/**
 * Servlet implementation class display_cand_details
 */
public class display_cand_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display_cand_details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 try
		 {
	
	int status=Integer.parseInt(request.getParameter("bgc_status"));
	candidate obj=new candidate();
	obj.setStatus(status);
	get_details obj1=new get_details();
	ResultSet rs=obj1.getcandid(obj);
	request.setAttribute("result",rs);
	ResultSet rs1=obj1.getcandid(obj);
	String cpath= request.getContextPath();
	System.out.println(cpath);
	String path=PdfTest.createPdf(request.getSession(),request.getContextPath(),rs1,"candidate_profile");
	System.out.println(path);
	request.setAttribute("filepath",path);
	RequestDispatcher rd=request.getRequestDispatcher("view_candidates.jsp");
	rd.forward(request,response);
	}
    catch(Exception e)
    {}
}
	

}
