package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DisplayTestsModel;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class DisplayTests
 */
public class DisplayTests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(DisplayTests.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTests() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		logger.info("entered displaytestservlet");
		DisplayTestsModel dt = new DisplayTestsModel();
		//HttpSession session = request.getSession(true);
		//String vacancyId = request.getParameter("vacancyId");
		//String user = (String) session.getAttribute("User");
		ResultSet TestSchedule = dt.getTestSchedule();
		if(TestSchedule!=null){
			
			logger.info("result not null");
			
		}
		request.setAttribute("Tests", TestSchedule);

		RequestDispatcher rd = request.getRequestDispatcher("view_test_schedule.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
