package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.connection;

import bean.candidate;


public class insert_bgcstatus 
{
	Connection con=null;
	 PreparedStatement ps=null;
	 int rs;
public int insertstatus(candidate obj)throws SQLException
{
	 
	  try
	  {
	System.out.println("this is candidate class");
	con=connection.getConnection();
	String cand_id=obj.getCandid();
	System.out.println(cand_id);
	int status=obj.getStatus();
	
	String selectString="update cand_status_g1 set BGC_TEST_STATUS=? where CAND_PROFILE_ID=?";
	ps=con.prepareStatement(selectString);
	ps.setInt(1,status);
	ps.setString(2,cand_id);
	rs=ps.executeUpdate();
	/*while(resultset.next())
	{
		//System.out.println(resultset.getString(1));
		//System.out.println(resultset.getString(2));

	}*/
	
	  }catch(Exception e)
	  {}
	return rs;  
}


}
