package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.AddCandidateModel;
import model.VacancyIdListModel;
import bean.CandidateProfileBean;



/**
 * Servlet implementation class AddCandidate
 */
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(AddCandidate.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCandidate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		VacancyIdListModel vil = new VacancyIdListModel();
		
		//HttpSession session = request.getSession(true);

		//String user = (String) session.getAttribute("User");
		ResultSet VacIdList = vil.getVacancyIdListPC();
		request.setAttribute("VacancyIdList", VacIdList);
		logger.info("The data is updated into the request object \n");
		RequestDispatcher rd = request.getRequestDispatcher("add_candidate.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String vacid = request.getParameter("vacancyId");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String sex = request.getParameter("sex");
		String location = request.getParameter("location");
		double perc10th  = Double.parseDouble(request.getParameter("perc10th"));
		double perc12th  = Double.parseDouble(request.getParameter("perc12th"));
		String gapined = request.getParameter("gapined");
		String gapinex = request.getParameter("gapinex");
		int exp = Integer.parseInt(request.getParameter("exp"));
		//File resume = request.getParameter("dob");
		
		CandidateProfileBean cpb = new CandidateProfileBean();
		cpb.setCandidateProfileID(id);
		cpb.setVacancyID(vacid);
		cpb.setCandidateName(name);
		cpb.setCandidateDOB(dob);
		cpb.setCandidateSex(sex);
		cpb.setCandidateLocation(location);
		cpb.setPerc10th(perc10th);
		cpb.setPerc12th(perc12th);
		cpb.setGapInEducation(gapined);
		cpb.setGapInExperience(gapinex);
		cpb.setExperience(exp);
		
		/*CandidateStatusBean csb = new CandidateStatusBean();
		csb.setId(id);
		csb.setVacancyId(vacid);*/
		AddCandidateModel acm = new AddCandidateModel();
		int result = acm.addCandidate(cpb);
		System.out.println(result);
		if(result==0){
			request.getRequestDispatcher("pc_failed_add_candidate.jsp").forward(request,response);
			logger.error("The sucess page is not linking \n");
		}
		else if(result==2){
			request.getRequestDispatcher("pc_success_add_candidate.jsp").forward(request, response);
			logger.debug("The sucess page is linking \n");
		}
	}

}
