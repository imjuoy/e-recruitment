package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Getset2;
import Model.addDetails;


public class Addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
    public Addservlet() {
        super();
        }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	//response.getWriter();
	//PrintWriter out=response.getWriter();
	//HttpSession session=request.getSession();
	
	try
	{
	String adminid=request.getParameter("adminid");
	int test_id=Integer.parseInt(request.getParameter("test_id"));
	String fdate=request.getParameter("fdate");
	String tdate=request.getParameter("tdate");
	Getset2 g=new Getset2();
	g.setAdminid(adminid);
	g.setFdate(fdate);
	g.setTdate(tdate);
	g.setTestid(test_id);
	addDetails a=new addDetails();
	int k=a.addDate(g);
	int r=a.addbgcid(g);
	if(k==1 && r==1)
		response.sendRedirect("confirm_bgc.jsp");
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	
}

}
