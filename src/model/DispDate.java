package model;

import java.sql.*;

import util.connection;


public class DispDate {
	
	Connection con=null;
	 Statement stmt=null;
	 ResultSet resultset=null;
public ResultSet disDate()throws SQLException
 {
	 
	  try
	  {
	System.out.println("this is displaydate class");
	con=connection.getConnection();
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String selectString="select * from bgc_schedule_g1";
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
