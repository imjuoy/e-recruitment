package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bean.TestScheduleBean;

import model.EditTestModel;

/**
 * Servlet implementation class EditDeleteTests
 */
public class EditDeleteTests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(EditDeleteTests.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeleteTests() {
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
		response.setContentType("text/html");
		RequestDispatcher rd =null;
		String type = request.getParameter("button");
		logger.info("in edit delete servlet");
		if(request.getAttribute("Tests")!=null){
			logger.debug("list of test still in request");
		}
		if(type.equals("Edit")){
			int id = Integer.parseInt(request.getParameter("id"));
			EditTestModel et = new EditTestModel();
			ResultSet rs = et.getTestInfo(id);
			request.setAttribute("TestInfo", rs);
			request.getRequestDispatcher("edit_test.jsp").forward(request,response);
			
		}
		else if(type.equals("Delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			EditTestModel et = new EditTestModel();
			int result = et.deleteTest(id);
			if(result==0){
				// TODO create failed_delete_test
				logger.error("The result set is null for del option");
				rd = request.getRequestDispatcher("failed_delete_test.jsp");
				rd.forward(request, response);
			}
			else{
				// TODO create success_delete_test
				logger.info("The resultset is not null for del option");
				rd = request.getRequestDispatcher("success_delete_test.jsp");
				rd.forward(request, response);
			}
		}
		else if(type.equals("Update")){
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
			
			EditTestModel et = new EditTestModel();
			
			int result = et.editTest(tsb);
			if(result==0){
				// TODO create failed_edit_test
				logger.error("The result set is null for update option");
				rd = request.getRequestDispatcher("failed_edit_test.jsp");
				rd.forward(request, response);
			}
			else{
				// TODO success_edit_test
				logger.error("The result set is not null for update option");
				rd = request.getRequestDispatcher("success_edit_test.jsp");
				rd.forward(request, response);
			}
		}
	}	

}
