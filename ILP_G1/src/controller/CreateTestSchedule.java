package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.CreateTestScheduleModel;

import bean.TestScheduleBean;

/**
 * Servlet implementation class CreateTestSchedule
 */
public class CreateTestSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(CreateTestSchedule.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTestSchedule() {
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
		RequestDispatcher rd = null;
		System.out.print("Before");

		int id = Integer.parseInt(request.getParameter("id"));
		String taid = request.getParameter("taid");
		String vacid = request.getParameter("vacid");

		String wtdate = request.getParameter("wtdate");
		String tidate = request.getParameter("tidate");
		String hrdate = request.getParameter("hrdate");

		TestScheduleBean tsb = new TestScheduleBean();

		tsb.setId(id);
		tsb.setTaid(taid);
		tsb.setVacid(vacid);
		tsb.setWtdate(wtdate);
		tsb.setTidate(tidate);
		tsb.setHrdate(hrdate);

		CreateTestScheduleModel cts = new CreateTestScheduleModel();
		int result = 0;
		result = cts.createTestSchedule(tsb);
		if (result == 0) {
			logger.warn("The test schedule is not created");
			rd = request.getRequestDispatcher("failed_schedule_test.jsp");
			rd.forward(request, response);
		} else {
			logger.info("The test schedule is created");
			rd = request.getRequestDispatcher("success_schedule_test.jsp");
			rd.forward(request, response);
		}
	}

}
