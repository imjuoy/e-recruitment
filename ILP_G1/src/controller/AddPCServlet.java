package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.AddPlacCon;
import util.ID_Generator;
import bean.PlacCon;


public class AddPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(AddPCServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlacCon PC = new PlacCon(); // PC Bean class object created....
      
		PC.setPCname(request.getParameter("pcname"));
		PC.setPCcon(request.getParameter("pc_con"));
				
		// form data elements are taken.....now proceeding for other details.....
		
		ID_Generator ID_G = new ID_Generator();  // to get the automatic ID and Password of PC......
		PC.setPCid(ID_G.createPCID());
		PC.setPCpass(ID_G.PassGenerator(8));
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN AddPC Servlet: parameter recieved");
	    
		//create model and import it, delete below line...
		
	    AddPlacCon APC = new AddPlacCon();
	    int status = APC.addPC(PC);
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