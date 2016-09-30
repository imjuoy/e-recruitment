package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.connection;


public class update_bgcstatus
{
	Connection con=null;
	 Statement stmt=null;
	 ResultSet resultset=null;
public ResultSet getcandid()throws SQLException
{
	 
	  try
	  {
	System.out.println("this is candidate class");
	con=connection.getConnection();
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String selectString="select cand_profile_id from cand_status_g1";
	resultset=stmt.executeQuery(selectString);
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
