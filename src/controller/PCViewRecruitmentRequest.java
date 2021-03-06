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

import model.RecruitmentRequestModel;

/**
 * Servlet implementation class PCViewRecruitmentRequest
 */
public class PCViewRecruitmentRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(PCViewRecruitmentRequest.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PCViewRecruitmentRequest() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RecruitmentRequestModel rrm = new RecruitmentRequestModel();
		HttpSession session = request.getSession(true);

		String user = (String) session.getAttribute("User");
		ResultSet RecReq = rrm.getAll(user);
		request.setAttribute("RecruitmentRequests", RecReq);

		RequestDispatcher rd = request.getRequestDispatcher("view_rec_pc.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
