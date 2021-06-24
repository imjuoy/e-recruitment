package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.AddRecReq;
import util.ID_Generator;
import bean.RecReq;

public class AddRecReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(AddRecReqServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecReq RR = new RecReq(); // RecReq Bean class object created....
		
		ID_Generator ID_G = new ID_Generator();  // to get the automatic id of recruitment request......
       	RR.setRRid(ID_G.createRecReqID());
      	
       	RR.setVRid(request.getParameter("VR_ID"));
       	
		HttpSession session = request.getSession();  //to get the id of the user who has logged in.......
      	RR.setHRid((String)session.getAttribute("id"));
		
    	RR.setPC_id(request.getParameter("PC_ID"));
      	
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");  // to get current system date.......
	    Date now = new Date();
	    RR.setCDate(sdfDate.format(now));

	    
		// form data elements are taken.....now proceeding for other details.....
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN AddRecReq Servlet: parameter recieved");
	    
		// now rec req model will be called and it's bean will sent
		
	    AddRecReq ARR_obj = new AddRecReq();
	    
	    int status = ARR_obj.addRR(RR);
	    status  = status + ARR_obj.changeVRstatus(RR);
	    
	    if(status==2)
	    {
	    	RequestDispatcher RD = request.getRequestDispatcher("success.jsp");
			RD.forward(request, response);
			logger.debug("Successfully added!n\n");
	    }
	    else{
	    	RequestDispatcher RD = request.getRequestDispatcher("error.jsp");
			RD.forward(request, response);
			logger.error("Error found!n\n");
	    }
	}
}