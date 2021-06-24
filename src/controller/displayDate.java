package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DispDate;


/**
 * Servlet implementation class displayDate
 */

public class displayDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public displayDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try
	{
		ResultSet rs1=null;
		ResultSet rs=null;
		
		DispDate d=new DispDate();
		rs1=d.disDate();
		//ResultSet rs=excuteQuery(sql);
		System.out.println("Hello");
		request.setAttribute("ResultSet",rs1);
		/*while(rs1.next())
		{
			System.out.println(rs1.getString(1));

		}*/
		RequestDispatcher view=request.getRequestDispatcher("/displayDate.jsp");
		view.forward(request, response);
		//response.sendRedirect("dispDate.jsp");
	} catch(Exception e)
	{
	}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
