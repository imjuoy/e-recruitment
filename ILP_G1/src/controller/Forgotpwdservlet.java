package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

import bean.*;

public class Forgotpwdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public  Forgotpwdservlet() {
        super();
         }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter();
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String str3="";
		String security_question="";
		String answer="";
		String id="";
		String newpass="";
		String conpass="";
		
		id=request.getParameter("id");
		security_question=request.getParameter("security_question");
		answer=request.getParameter("answer");
		newpass=request.getParameter("newpass");
		conpass=request.getParameter("conpass");
		
		
		ChangePassword g=new ChangePassword();
		g.setId(id);
		g.setAns(answer);
		g.setQues(security_question);
		g.setNewpass(newpass);
		g.setConpass(conpass);
		
		
		Forgotpwd f=new Forgotpwd();
		int k=f.forgetPwd(g);
		
		try
		{
			if(k==-2)
			{
				System.out.println("value of k is"+k);
				
				response.sendRedirect("forgotpwd.jsp");
				
			}
			else if(k==-1)
			{
				System.out.println("value of k is"+k);
				
				response.sendRedirect("login.jsp");
				System.out.println("you got your new password set");
			}
			else if(k>=1&&k<4)
			{
				System.out.println("value os k is"+k);
				
				//str3="Wrong!try again, maximum  3 trials,this is your trial number"+"\t"+(k++);	
				response.sendRedirect("forgotpwd.jsp");
				System.out.println("Wrong!try again, maximum  3 trials,this is your trial number"+"\t"+(k++));
;				}
			else
			{
				
				System.out.println("value of k is"+k);
				System.out.println("your id does not exist or all trial is over");
			response.sendRedirect("forgotpwd.jsp");
			}
		}catch(Exception e)
		{}
		//session.setAttribute("result3",str3);
	}


}
