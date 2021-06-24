package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.CandidateStatusModel;
import bean.CandidateStatusBean;

/**
 * Servlet implementation class DisplayEditDeleteCandidateStatus
 */
public class DisplayEditDeleteCandStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(DisplayEditDeleteCandStatus.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayEditDeleteCandStatus() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		logger.info("entered display status servlet");
		CandidateStatusModel cs = new CandidateStatusModel();
		// HttpSession session = request.getSession(true);
		// String vacancyId = request.getParameter("vacancyId");
		// String user = (String) session.getAttribute("User");
		ResultSet result = cs.getCandidateStatus();
		if (result != null) {

			logger.info("result not null");

		}
		request.setAttribute("StatusInfo", result);

		RequestDispatcher rd = request.getRequestDispatcher("cand_status.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd = null;
		String type = request.getParameter("button");
		//System.out.println("in editing servlet");
		
		if (type.equals("Edit")) {
			logger.info("Edit candidate Status in DisplayeditdeletecandStatus");
			String id = request.getParameter("id");
			CandidateStatusModel cs = new CandidateStatusModel();
			ResultSet rs = cs.getStatusInfo(id);
			if (rs != null) {

				System.out.println("result not null");

			}
			request.setAttribute("StatusInfo", rs);
			request.getRequestDispatcher("edit_status.jsp").forward(request,
					response);
		} else if (type.equals("Update")) {
			logger.info("update candidate Status in DisplayeditdeletecandStatus");
			String id = request.getParameter("id");
			int testid = Integer.parseInt(request.getParameter("testid"));
			int wtstatus = Integer.parseInt(request.getParameter("wtstatus"));
			int tistatus = Integer.parseInt(request.getParameter("tistatus"));
			int hristatus = Integer.parseInt(request.getParameter("hristatus"));
			int medicalstatus = Integer.parseInt(request.getParameter("medicalstatus"));

			System.out.println(id+testid+wtstatus+tistatus+hristatus+medicalstatus);

			CandidateStatusBean csb = new CandidateStatusBean();

			csb.setId(id);
			csb.setTestId(testid);
			csb.setWtStatus(wtstatus);
			csb.setTiStatus(tistatus);
			csb.setHriStatus(hristatus);

			csb.setMedicalStatus(medicalstatus);
			CandidateStatusModel et = new CandidateStatusModel();

			int result = et.updateStatus(csb);
			if (result == 0) {
				rd = request.getRequestDispatcher("failed_update_status.jsp");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("success_update_status.jsp");
				rd.forward(request, response);
			}

		}
	}
}