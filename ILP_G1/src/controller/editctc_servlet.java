package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Selectcriteria;


/**
 * Servlet implementation class editctc_servlet
 */
public class editctc_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editctc_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
	System.out.println("Hey");
	Selectcriteria obj=new Selectcriteria();
	ResultSet s=obj.getempid();
	ResultSet v=obj.getdesg();
	request.setAttribute("result",s);
	request.setAttribute("result1",v);
	//int size=dbq.addit.size();
	//ArrayList b= new ArrayList();
	/*for(int i=0;i<=size;i++)
	{
	System.out.println("The persons are"+dbq.addit.get(i));
	}*/
	RequestDispatcher rd=request.getRequestDispatcher("editjsp.jsp");
	rd.forward(request, response);
		}
		catch(Exception e)
		{
		}	
	
	}

}
