package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import util.PdfTest;

import model.DisplayCandidateProfileModel;

/**
 * Servlet implementation class DisplayCandidateProfile
 */
public class DisplayCandidateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final Logger logger =Logger.getLogger(DisplayCandidateProfile.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayCandidateProfile() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		logger.info("entered displaycandprofservlet");
		DisplayCandidateProfileModel dcm = new DisplayCandidateProfileModel();
		// HttpSession session = request.getSession(true);
		String vacancyId = request.getParameter("vacancyId");
		// String user = (String) session.getAttribute("User");
		ResultSet CandPro = dcm.getCandidateProfiles(vacancyId);
		if (CandPro != null) {

			logger.info("result not null");

		}
		request.setAttribute("CandidateProfiles", CandPro);
		ResultSet rs = dcm.getCandidateProfiles(vacancyId);

		String filePath = PdfTest.createPdf(request.getSession(),
				getServletContext().getRealPath(""), "Candidate", rs,
				"candidate_profiles");
		request.setAttribute("path", filePath);
		RequestDispatcher rd = request
				.getRequestDispatcher("cand_prof_by_vac_id.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
