package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.add_emp_dropdown;


/**
 * Servlet implementation class emp_dropdown_servlet
 */
public class emp_dropdown_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emp_dropdown_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 try
		 {
		add_emp_dropdown obj=new add_emp_dropdown();
		ResultSet rs1=obj.selected_emp();
		ResultSet rs2=obj.unitheadid();
		ResultSet rs3=obj.projectid();
		/*while(rs1.next())
		{
			System.out.println(rs1.getString(1));
		}*/
		request.setAttribute("result1",rs1);
		request.setAttribute("result2", rs2);
	    request.setAttribute("result3",rs3 );
		RequestDispatcher rd= request.getRequestDispatcher("add_emp1.jsp");
		rd.forward(request,response);
		}
    catch(Exception e)
    {}
}
}
