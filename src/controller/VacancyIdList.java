package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.VacancyIdListModel;

/**
 * Servlet implementation class VacancyIdList
 */
public class VacancyIdList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(VacancyIdList.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VacancyIdList() {
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
		ResultSet VacIdList = vil.getVacancyIdList();
		request.setAttribute("VacancyIdList", VacIdList);

		RequestDispatcher rd = request.getRequestDispatcher("view_cand_profile.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
