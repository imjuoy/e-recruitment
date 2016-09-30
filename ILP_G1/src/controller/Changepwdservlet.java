package controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

import bean.*;


public class Changepwdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public Changepwdservlet() {
        super();
        }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter();
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String str1="";
		try{
	    String id=(String) session.getAttribute("id");
	//	String empid=request.getParameter("uid");
		String oldpwd1=request.getParameter("oldpass");
		String newpwd1=request.getParameter("newpass");
		String confpwd1=request.getParameter("conpass");
		
		ChangePassword t=new ChangePassword();
		t.setoldPwd(oldpwd1);
		t.setnewPwd(newpwd1);
		t.setconfPwd(confpwd1);
		t.setId(id);
		Changepwd obj=new Changepwd();
		int k=obj.changePwd(t);
		if(k==-1)
		{
			//str1="Entered password does not match with old password";
			System.out.println("Entered password does not match with old password");
			response.sendRedirect("change_pwd.jsp");
		}
		else if(k==2)
		{
			//str1="New password does not match with re-entered password";
			System.out.println("New password does not match with re-entered password");
			response.sendRedirect("change_pwd.jsp");
		}
		else if(k==1)
		{
			//str1="You changed your password successfully";
			//out.println(str1);
			//session.invalidate();
			response.sendRedirect("Setsecurity.jsp");
			System.out.println("you changed your password succefully");
		}
		
		else
		{
						response.sendRedirect("change_pwd.jsp");
		}
	}catch(Exception e){}
	session.setAttribute("result1",str1);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request,response);
	}

}
