package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.connection;

import bean.candidate;


public class get_details 
{
	Connection con=null;
	 Statement stmt=null;
	 ResultSet resultset=null;
public ResultSet getcandid(candidate obj)throws SQLException
{
	  try
	  {
    int status=obj.getStatus();
    System.out.println(status);
	System.out.println("this is displaybgcadmin class");
	con=connection.getConnection();
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String selectString="select * from cand_profile_g1 where cand_profile_id IN (select cand_profile_id from cand_status_g1 where bgc_test_status="+status+")";
	resultset=stmt.executeQuery(selectString);
	  }catch(Exception e)
	  {}
	  return resultset;
}
}
