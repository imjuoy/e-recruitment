package controller;

import java.io.IOException;
//import java.io.PrintStream;
import java.sql.ResultSet;
//import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Selectcriteria;


 

public class BGCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BGCServlet() {
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
	ResultSet s=obj.Retrievedata();
	request.setAttribute("result",s);
	//int size=dbq.addit.size();
	//ArrayList b= new ArrayList();
	/*for(int i=0;i<=size;i++)
	{
	System.out.println("The persons are"+dbq.addit.get(i));
	}*/
	RequestDispatcher rd=request.getRequestDispatcher("select_bgcadmin.jsp");
	rd.forward(request, response);
		}
		catch(Exception e)
		{
		}
		}
	}
	

