package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class SessionTracker
 */
public class SessionTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger( SessionTracker.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionTracker() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		trackSession(request, response);
	}

	private void trackSession(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null)
			try {
				getServletContext().getRequestDispatcher("index.html").forward(
						request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (session != null) {
			String user = (String) session.getAttribute("id");
			if (user == null) {
				logger.info("User not logged in");
				try {
					getServletContext().getRequestDispatcher("index.html")
							.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				logger.info("User still logged in");
			}
		}

	}
}
