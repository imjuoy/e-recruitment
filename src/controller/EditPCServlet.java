package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import util.DB_Config;

import bean.PlacCon;

import model.EditPlacCon;


public class EditPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(EditPCServlet.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN Edit PC Servlet getmethod()");
		
		request.setAttribute("work","showlist");
		System.out.println("xxxxxxxxxxxxxxxxxxxx BEFORE Dispatching PC list to editpc.jsp");
		RequestDispatcher RD = request.getRequestDispatcher("SearchPC.jsp");
		RD.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("IN DOpost of edit pc servlet.....-------button value: "+request.getParameter("button"));	
		if(request.getParameter("button").toString().equals("Edit"))
		{
			String pc_id=request.getParameter("PC_ID");
			// send to model
			EditPlacCon EPC = new EditPlacCon();
			ResultSet RS;
			RS = EPC.pcDetail(pc_id);
			DB_Config DB_obj = new DB_Config();
			
			request.setAttribute("PC",RS);
			request.setAttribute("work","pcdetail");
			if(DB_obj.countRow(RS)==0)
			{
				response.sendRedirect("error.jsp");
				logger.error("Error found!n\n");
			}
			else
			{
				RequestDispatcher RD = request.getRequestDispatcher("EditPC.jsp");
				RD.forward(request,response);
				logger.debug("Successfully added!n\n");
			}
			
		}
		
		if(request.getParameter("button").toString().equals("Update"))
		{
			PlacCon PC = new PlacCon(); // PC Bean class object created....
		    int status; 
			PC.setPCname(request.getParameter("pcname"));
			PC.setPCcon(request.getParameter("pc_con"));
			PC.setPCid(request.getParameter("pc_id"));
			
			// send to model.......
			
			EditPlacCon EPC = new EditPlacCon();
			status = EPC.updatePC(PC);
			if(status==1)
			{
				response.sendRedirect("do.EditPC");
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
			String pc_id=request.getParameter("PC_ID");
			EditPlacCon EPC = new EditPlacCon();
			int status = EPC.deletePC(pc_id);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN DELETE PC SERVLET: Update Status = "+ status);
			if(status==1)
		    {
				response.sendRedirect("do.EditPC");
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

