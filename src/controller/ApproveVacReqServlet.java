package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.ApproveVacReq;

public class ApproveVacReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(ApproveVacReqServlet.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN ApproveVacReqServlet getmethod()");
		
		ResultSet RS;
		
		ApproveVacReq AVR_obj = new ApproveVacReq();
		RS = AVR_obj.getVRtoApprove();
		
		request.setAttribute("VRList",RS);
		
		request.setAttribute("work","showlist");
		System.out.println("xxxxxxxxxxxxxxxxxxxx BEFORE Dispatching Unapproved VR list to approveVR.jsp");
		RequestDispatcher RD = request.getRequestDispatcher("ApproveVR.jsp");
		RD.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String vr_id=request.getParameter("VR_ID");
			// send to model
			ApproveVacReq AVR_obj = new ApproveVacReq();
			int status = 0;
			status = AVR_obj.approveVR(vr_id);
			if(status==1)
		    {
				response.sendRedirect("do.Approve");
				logger.debug("Successfully added!n\n");
		    }
		    else{
		    	RequestDispatcher RD = request.getRequestDispatcher("error.jsp");
				RD.forward(request, response);
				logger.error("Error found!n\n");
		    }
	}
	
}