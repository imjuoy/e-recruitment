package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.ViewPlacementConsultantsModel;

/**
 * Servlet implementation class ViewPlacementConsultants
 */
public class ViewPlacementConsultants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(ViewPlacementConsultants.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPlacementConsultants() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ViewPlacementConsultantsModel vpc = new ViewPlacementConsultantsModel();
		//HttpSession session = request.getSession(true);

		//String user = (String) session.getAttribute("User");
		ResultSet PCList = vpc.getPlacementConsultants();
		request.setAttribute("PlacementConsultants", PCList);

		RequestDispatcher rd = request.getRequestDispatcher("hr_view_pc.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
