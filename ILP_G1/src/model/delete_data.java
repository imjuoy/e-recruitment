package model;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

import util.connection;

public class delete_data 
{
    Connection con=null;
	Statement stmt=null;
	int result;
	public int delete_row(String id)
	{
  			  try
			  {
		   String admin_id=id;
		   System.out.println(admin_id);
		   	con=connection.getConnection();
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String selectString="delete from bgc_schedule_g1 where admin_id='"+admin_id+"'";
			System.out.println("delete from bgc_schedule_g1 where admin_id='"+admin_id+"'");
			result=stmt.executeUpdate(selectString);
			  }catch(Exception e)
			  {}
			  return result;
		}
	
	
			    	
	}

