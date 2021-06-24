package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.SelectTAModel;

/**
 * Servlet implementation class SelectTA
 */
public class SelectTA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(SelectTA.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectTA() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		System.out.println("entered select ta servlet");
		SelectTAModel st = new SelectTAModel();
		// HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		// String user = (String) session.getAttribute("User");
		int result = st.addTA(id);
		if (result == 1) {

			RequestDispatcher rd = request
					.getRequestDispatcher("success_select_ta.jsp");
			rd.forward(request, response);

		}

		else {
			RequestDispatcher rd = request
					.getRequestDispatcher("failed_select_ta.jsp");
			rd.forward(request, response);
		}
	}
}
