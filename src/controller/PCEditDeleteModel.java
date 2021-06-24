package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.EditDeleteCandidateModel;

/**
 * Servlet implementation class PCEditDeleteModel
 */
public class PCEditDeleteModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(PCEditDeleteModel.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PCEditDeleteModel() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd =null;
		String type = request.getParameter("button");
		logger.info("in edit delete cand servlet");
		
		if(type.equals("Edit")){
			String id = request.getParameter("id");
			EditDeleteCandidateModel et = new EditDeleteCandidateModel();
			ResultSet rs = et.getCandInfo(id);
			request.setAttribute("CandInfo", rs);
			if(rs!=null){
				logger.info("Result not empty");
			}
			request.getRequestDispatcher("pc_edit_cand.jsp").forward(request,response);
			
		}
		
			else if(type.equals("Delete")){
				String id = request.getParameter("id");
				EditDeleteCandidateModel et = new EditDeleteCandidateModel();
				int result = et.deleteCand(id);
				if(result==0){
					// TODO create failed_delete_test
					rd = request.getRequestDispatcher("pc_failed_delete_cand.jsp");
					rd.forward(request, response);
				}
				else{
					// TODO create success_delete_test
					rd = request.getRequestDispatcher("pc_success_delete_cand.jsp");
					rd.forward(request, response);
				}
			}
		
	
	}
}
