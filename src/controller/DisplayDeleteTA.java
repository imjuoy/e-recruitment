package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.DisplayTAModel;

/**
 * Servlet implementation class DisplayDeleteTA
 */
public class DisplayDeleteTA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(DisplayDeleteTA.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDeleteTA() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		logger.info("entered display test admin servlet");
		DisplayTAModel dta = new DisplayTAModel();
		// HttpSession session = request.getSession(true);
		// String vacancyId = request.getParameter("vacancyId");
		// String user = (String) session.getAttribute("User");
		ResultSet result = dta.displayTA();
		if (result != null) {

			logger.info("result not null");

		}
		request.setAttribute("TA", result);

		RequestDispatcher rd = request.getRequestDispatcher("view_ta.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
