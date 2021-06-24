package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.PCLoginModel;

import bean.PlacementConsultantBean;

/**
 * Servlet implementation class PCLogin
 */
public class PCLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger =Logger.getLogger(PCLogin.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PCLogin() {
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
		
		RequestDispatcher rd = null;
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		PlacementConsultantBean pcb = new PlacementConsultantBean();
		pcb.setId(userName);
		pcb.setPassword(password);
		
		PCLoginModel pcl = new PCLoginModel();
		if(pcl.validate(pcb)){
			HttpSession session = request.getSession(true);
			String userView = new String("User");
			logger.info(pcb.getId());
			session.setAttribute(userView, pcb.getId());
			rd = request.getRequestDispatcher("pc_home.jsp");
			rd.forward(request, response);
		}
		else{
			rd = request.getRequestDispatcher("failed_pc_login.jsp");
			rd.forward(request, response);
		}
	}

}
