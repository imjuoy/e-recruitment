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

import model.AddVacReq;
import util.ID_Generator;
import bean.VacReq;


public class AddVacReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(AddVacReqServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VacReq VR = new VacReq(); // VacReq Bean class object created....
      
		VR.setVid(request.getParameter("vactype"));
		VR.setPid(request.getParameter("proj"));
		VR.setLoc(request.getParameter("loc"));
		VR.setNo_of_vac(request.getParameter("nmbrvac"));
		VR.setReq_by_date(request.getParameter("req_by_date"));
		
		// form data elements are taken.....now proceeding for other details.....
		
		ID_Generator ID_G = new ID_Generator();  // to get the automatic id of vacancy request......
		VR.setVRid(ID_G.createVacReqID());
		
		HttpSession session = request.getSession();  //to get the id of the user who has logged in.......
		VR.setEMPid((String)session.getAttribute("id"));  
				
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");  // to get current system date.......
	    Date now = new Date();
	    VR.setReq_on_date(sdfDate.format(now));
	    
	    VR.setStatus("Open");  // Status set 1 by default and will be 0 (zero) when HR creates a Recruitment request of this Vac Req
	    
	    if(((String)session.getAttribute("desg")).equals("basic"))
	    {
	    	VR.setAprv_status("Pending");
	    	logger.debug("Successfully added!n\n");
	    }
	    else if(((String)session.getAttribute("desg")).equals("uh"))
	    {
	    	VR.setAprv_status("Approved");
	    	logger.error("Error found!n\n");
	    }
	    
	    System.out.println("xxxxxxxxxxxxxxxxxxxx IN AddVacReq Servlet: parameter recieved");
	    
	    AddVacReq AVR_obj = new AddVacReq();
	    int status = AVR_obj.addVR(VR);
	    if(status==1)
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