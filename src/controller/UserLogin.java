package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.util.HashMap;

import bean.User;
import model.LoginValidate;


public class UserLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(UserLogin.class);

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User UB = new User();
		UB.setUserDesg(request.getParameter("role"));
		UB.setUserID(request.getParameter("userName"));
		UB.setUserPass(request.getParameter("password"));
		
		HashMap<String,String> result;
		System.out.println("xxxxxxxxxxxxxxxxxxxxin servlet: parameter recieved");
		LoginValidate LV_obj = new LoginValidate();
		
		result = LV_obj.validate(UB);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxin servlet: Hash map recieved");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxin servlet: session valid="+result.get("valid"));
		if(result.get("valid").equals("true")) // valid user
		{
			// as TRUE : Create session and redirect to a JSP page
			
			HttpSession session = request.getSession();
			session.setAttribute("id",result.get("id"));
			session.setAttribute("name",result.get("name"));
			session.setAttribute("desg",result.get("desg"));
			session.setAttribute("valid","");  
			
			if(((String)session.getAttribute("desg")).equals("basic"))
			{
				RequestDispatcher RD = request.getRequestDispatcher("home_emp.jsp");
				RD.forward(request, response);
				logger.debug("Successfully added!n\n");
			}
			if(((String)session.getAttribute("desg")).equals("uh"))
			{
				RequestDispatcher RD = request.getRequestDispatcher("home_uh.jsp");
				RD.forward(request, response);
				logger.debug("Successfully added!n\n");
			}
			if(((String)session.getAttribute("desg")).equals("hr"))
			{
				RequestDispatcher RD = request.getRequestDispatcher("home_hr.jsp");
				RD.forward(request, response);
				logger.debug("Successfully added!n\n");
			}
			if(((String)session.getAttribute("desg")).equals("ta"))
			{
				RequestDispatcher RD = request.getRequestDispatcher("ta_home.jsp");
				RD.forward(request, response);
				logger.debug("Successfully added!n\n");
			}
			if(((String)session.getAttribute("desg")).equals("bgcadmin"))
			{
				RequestDispatcher RD = request.getRequestDispatcher("BGCadmin_home.jsp");
				RD.forward(request, response);
				logger.debug("Successfully added!n\n");
			}
			
		}
		else
		{
			// as FALSE: Redirect to login page
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxin servlet: rediredcted to login page");
			
			HttpSession session = request.getSession();  //to get the id of the user who has logged in.......
			session.setAttribute("valid","Invalid Credentials.....");  
			
			RequestDispatcher RD = request.getRequestDispatcher("index.html");
			RD.forward(request, response);
			logger.error("Error found!n\n");
		}
		
			
	}

}
