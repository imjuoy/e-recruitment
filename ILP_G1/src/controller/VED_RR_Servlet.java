package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.Search;
import model.VED_RR;

public class VED_RR_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(VED_RR_Servlet.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN VED_RR_Servlet getmethod()");
		
		ResultSet RS;
		
		VED_RR VED_obj = new VED_RR();
		RS = VED_obj.getVED_RRList();
		
		request.setAttribute("VED_RRList",RS);
		request.setAttribute("work","showlist");
		System.out.println("xxxxxxxxxxxxxxxxxxxx BEFORE Dispatching RR list to VED_RR.jsp");
		RequestDispatcher RD = request.getRequestDispatcher("VED_RR.jsp");
		RD.forward(request,response);
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("button").toString().equals("Edit"))
		{
			System.out.println("!FROM JSP TO SERVLET AFTER CLICKING EDIT******************");
			String rr_id=request.getParameter("RR_ID");
			// send to model
			VED_RR VED_obj = new VED_RR();
			
			ResultSet RS1;
			System.out.println("!!!!!!!!!@@@@@@@^^^^^^^^ RR ID RECIEVED = "+rr_id);
			RS1 = VED_obj.getRRDetails(rr_id);
			request.setAttribute("RR",RS1);
						
			ResultSet RS2;
			Search S_obj = new Search();
			RS2 = S_obj.getPCList("","","");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!result set of pc in SERVLET OF edit rr BEFORE SENDING TO JSP page : "+RS2);
			request.setAttribute("PCList",RS2);
			
			request.setAttribute("work","rrdetail");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%???????????? IN VED RR SERVLET ......EDIT CONDITION ---RR = "+RS1+"  PC = "+RS2);
			RequestDispatcher RD = request.getRequestDispatcher("VED_RR.jsp");
			RD.forward(request,response);
		}
		
		if(request.getParameter("button").toString().equals("Update"))
		{
			int status; 
			String RRid = request.getParameter("rr_id");
			String req_by = request.getParameter("date");
			String pc_id = request.getParameter("PC_ID");
			
			// send to model.......
			
			VED_RR VED_obj = new VED_RR();
			status = VED_obj.updateRRDetails(RRid,req_by,pc_id);
			if(status==1)
			{
				response.sendRedirect("do.RRwork");
				logger.debug("Successfully added!n\n");
			}
			else{
			  	RequestDispatcher RD = request.getRequestDispatcher("error.jsp");
				RD.forward(request, response);
				logger.error("Error found!n\n");
		    }

		}
		
		if(request.getParameter("button").toString().equals("Delete"))
		{
			String RR_id=request.getParameter("RR_ID");
			VED_RR VED_obj = new VED_RR();
			int status = VED_obj.deleteRR(RR_id);
			if(status==1)
		    {
				response.sendRedirect("do.RRwork");
				logger.debug("Successfully added!n\n");
		    }
		    else{
		    	RequestDispatcher RD = request.getRequestDispatcher("error.jsp");
				RD.forward(request, response);
				logger.error("Error found!n\n");
				
		    }
		}
	}
}
