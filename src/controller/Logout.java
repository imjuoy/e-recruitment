package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(Logout.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("SessionTracker");
//		rd.include(request, response);
		
		SessionTracker st = new SessionTracker();
		st.doPost(request, response);
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		logger.info("User logged out");
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request,response);
	}

}
