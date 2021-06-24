package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.connection;


public class disp_emp 
{
	Connection con=null;
	 Statement stmt=null;
	 ResultSet resultset=null;
public ResultSet dispData()throws SQLException
{
	 
	  try
	  {
	System.out.println("this is display employee class");
	con=connection.getConnection();
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String selectString="select * from emp_details_g1";
	resultset=(ResultSet)stmt.executeQuery(selectString);
	/*while(resultset.next())
	{
		//System.out.println(resultset.getString(1));
		//System.out.println(resultset.getString(2));

	}*/
	
	  }catch(Exception e)
	  {}
	  return resultset;
}


}
