package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;



import model.GetProjList;
import model.GetVacList;
import model.VED_VR;

public class VED_VR_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(VED_VR_Servlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN VED_VR_Servlet getmethod()");
		
		ResultSet RS;
		
		HttpSession session = request.getSession();  //to get the id of the user who has logged in.......
		String emp_id = (String)session.getAttribute("id");  
		
		VED_VR VED_ob = new VED_VR();
		RS = VED_ob.getVED_VRList(emp_id);
		
		request.setAttribute("VED_VRList",RS);
		request.setAttribute("work","showlist");
		System.out.println("xxxxxxxxxxxxxxxxxxxx BEFORE Dispatching RR list to VED_VR.jsp");
		RequestDispatcher RD = request.getRequestDispatcher("VED_VR.jsp");
		RD.forward(request,response);
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("button").toString().equals("Edit"))
		{
			System.out.println("!FROM JSP TO SERVLET AFTER CLICKING EDIT******************");
			String vr_id=request.getParameter("VR_ID");
			// send to model
			VED_VR VED_ob = new VED_VR();
			
			ResultSet RS1,RS2,RS3;
			System.out.println("!!!!!!!!!@@@@@@@^^^^^^^^ VR ID RECIEVED = "+vr_id);
			RS1 = VED_ob.getVRDetails(vr_id);
			request.setAttribute("VR",RS1);
			
			GetVacList VL_obj = new GetVacList();
			RS2 = VL_obj.getList();
			request.setAttribute("VacList", RS2);
			
			GetProjList PL_obj = new GetProjList();
			RS3 = PL_obj.getList();
			request.setAttribute("ProjList", RS3);
						
			
			
			request.setAttribute("work","vrdetail");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%???????????? IN VED VR SERVLET ......EDIT CONDITION ---VR = "+RS1+"");
			RequestDispatcher RD = request.getRequestDispatcher("VED_VR.jsp");
			RD.forward(request,response);
		}
		
		if(request.getParameter("button").toString().equals("Update"))
		{
			int stat; 
			String VRid = request.getParameter("vr_id");
			String vactype = request.getParameter("vactype");
			String proj = request.getParameter("proj");
			String loc = request.getParameter("loc");
			String no_of_vac = request.getParameter("no_of_vac");
			String req_by = request.getParameter("date");
		  
			
			
			// send to model.......
			
			VED_VR VED_ob = new VED_VR();
			stat = VED_ob.updateVRDetails(VRid,vactype,proj,loc,no_of_vac,req_by);
			if(stat==1)
			{
				response.sendRedirect("do.VRwork");
				logger.debug("successfully added!n\n");
			}
			else{
			  	RequestDispatcher RD = request.getRequestDispatcher("error.jsp");
				RD.forward(request, response);
				logger.error("error found!n\n");
		    }

		}
		
		if(request.getParameter("button").toString().equals("Delete"))
		{
			String VR_id=request.getParameter("VR_ID");
			VED_VR VED_ob = new VED_VR();
			int status = VED_ob.deleteVR(VR_id);
			if(status==1)
		    {
				response.sendRedirect("do.VRwork");
				logger.debug("successfully deleted!n\n");
		    }
		    else{
		    	RequestDispatcher RD = request.getRequestDispatcher("error.jsp");
				RD.forward(request, response);
				logger.error("error found!n\n");
		    }
		}
	}
}
