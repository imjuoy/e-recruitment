package controller;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.GetVacList;
import model.GetProjList;

public class FetchCreateVacReqDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(FetchCreateVacReqDetailServlet.class);
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN FetchVacList servlet");
		
		ResultSet RS1,RS2;
		
		GetVacList VL_obj = new GetVacList();
		RS1 = VL_obj.getList();
		request.setAttribute("VacList", RS1);
		
		GetProjList PL_obj = new GetProjList();
		RS2 = PL_obj.getList();
		request.setAttribute("ProjList", RS2);
		
		RequestDispatcher view = request.getRequestDispatcher("CreateVacReq.jsp");
		view.forward(request,response);
		logger.debug("Successfully added!n\n");
	}

}
