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


public class SearchPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(SearchPCServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pc_id = request.getParameter("pcid");
		String pc_name = request.getParameter("pcname");
		String pc_con = request.getParameter("con");
				
		// form data elements are taken.....now proceeding for other details.....
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx IN SearchPC Servlet parameters: PC_ID: "+pc_id+" + PC_NAME: "+pc_name+" + PC_CON: "+pc_con);
		
		ResultSet RS;
		
		Search S_obj = new Search();
		RS = S_obj.getPCList(pc_id,pc_name,pc_con);
		request.setAttribute("PCList", RS);
		
		RequestDispatcher view = request.getRequestDispatcher("ShowPCList.jsp");
		view.forward(request,response);
		logger.debug("Successfully added!n\n");
	}
}