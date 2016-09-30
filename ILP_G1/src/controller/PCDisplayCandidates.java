package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.DisplayCandidateProfileModel;
import model.VacancyIdListModel;

/**
 * Servlet implementation class PCDisplayCandidates
 */
public class PCDisplayCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(PCDisplayCandidates.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PCDisplayCandidates() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		logger.info("entered pc display cand servlet");
		VacancyIdListModel vil = new VacancyIdListModel();
		//HttpSession session = request.getSession(true);

		//String user = (String) session.getAttribute("User");
		ResultSet VacIdList = vil.getVacancyIdListPC();
		request.setAttribute("VacancyIdList", VacIdList);

		
		if(VacIdList!=null){
			
		System.out.println("result not null");
			
		}
		

		RequestDispatcher rd = request.getRequestDispatcher("pc_view_cand.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		logger.info("entered pc display candidate servlet");
		DisplayCandidateProfileModel dcm = new DisplayCandidateProfileModel();
		//HttpSession session = request.getSession(true);
		String vacancyId = request.getParameter("vacancyId");
		//String user = (String) session.getAttribute("User");
		ResultSet CandPro = dcm.getCandidateProfiles(vacancyId);
		if(CandPro!=null){
			
		System.out.println("result not null");
			
		}
		request.setAttribute("CandidateProfiles", CandPro);

		RequestDispatcher rd = request.getRequestDispatcher("pc_cand_display.jsp");
		rd.forward(request, response);
	}

}
