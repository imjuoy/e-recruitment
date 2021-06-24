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

import model.DisplayTestsModel;

/**
 * Servlet implementation class TADisplayTests
 */
public class TADisplayTests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger( TADisplayTests.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TADisplayTests() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		logger.info("entered ta display test servlet");
		DisplayTestsModel dt = new DisplayTestsModel();
		HttpSession session = request.getSession(true);
		
		String user = (String) session.getAttribute("User");
		ResultSet TestSchedule = dt.getTestScheduleTA(user);
		if(TestSchedule!=null){
			
		System.out.println("result not null");
			
		}
		request.setAttribute("Tests", TestSchedule);

		RequestDispatcher rd = request.getRequestDispatcher("ta_view_tests.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
