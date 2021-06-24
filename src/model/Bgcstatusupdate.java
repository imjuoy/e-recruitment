package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.connection;


public class Bgcstatusupdate
{
	Connection con=null;
	Statement stmt=null;
	ResultSet resultset=null;
public ResultSet getdata()throws SQLException
{
	 
	  try
	  {
	System.out.println("this is displaydate class");
	con=connection.getConnection();
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String selectString="select emp_id from bgc_admin_g1";
	resultset=(ResultSet)stmt.executeQuery(selectString);
	}
	  catch(Exception e)
	  {}
	  return resultset;
}
}
