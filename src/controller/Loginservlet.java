package controller;
import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

import bean.*;



public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Loginservlet() {
        super();
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter();
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String str="";
	try{
		String desig=request.getParameter("desig");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		session.setAttribute("id",id);
		session.setAttribute("desig",desig);
		//Getset1 t=new Getset1();
		//t.setId(id);
		System.out.println(str);
		Getset g=new Getset();
		g.setId(id);
		g.setPass(pwd);
		g.setDesig(desig);
		
		session.setAttribute("id",id);
		session.setAttribute("desg",desig);
		Validate obj=new Validate();
		int k=obj.loginValidate(g);
		System.out.println("k is"+k);
		
		if(k==-1)
		{
			//str="Logged in successfully now change your password if you are logging in First time ";
			System.out.println("Logged in successfully now change your password if you are logging in First time ");
			response.sendRedirect("change_pwd.jsp");
		}
		
		else if(k==1)
		{
			//str="you logged in successfully";
			System.out.println("you logged in successfully");
			if(desig.equalsIgnoreCase("hr"))
			{
			response.sendRedirect("HRofficer_home.jsp");
			}
			else if(desig.equalsIgnoreCase("uh"))
			{
			response.sendRedirect("Unithead_home.jsp");
			}
			else if(desig.equalsIgnoreCase("BGCAdmin"))
			{
			response.sendRedirect("BGCadmin_home.jsp");
			}
			else
			{
				response.sendRedirect("emphomepage.jsp");
			}
		}
		else
		{
			//str="Empid & password does not match, re-enter your details";
			System.out.println("Empid & password does not match, re-enter your details");
			response.sendRedirect("login.jsp");
			}
		
	}catch(Exception e){}
	
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//doPost(request,response);
	}

}

	

