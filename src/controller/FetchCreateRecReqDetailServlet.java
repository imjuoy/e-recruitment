package controller;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.GetVacRecList;
import model.Search;


public class FetchCreateRecReqDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(FetchCreateRecReqDetailServlet.class);
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN FetchRecReqList servlet");
		
		ResultSet RS1,RS2;
		
		GetVacRecList VRL_obj = new GetVacRecList();
		RS1 = VRL_obj.getList();
		request.setAttribute("VacReqList", RS1);
		
		Search S_obj = new Search();
		RS2 = S_obj.getPCList("","","");
		request.setAttribute("PCList",RS2);
		
		RequestDispatcher RD = request.getRequestDispatcher("CreateRecReq.jsp");
		RD.forward(request,response);
		logger.debug("Successfully added!n\n");
	}

}
