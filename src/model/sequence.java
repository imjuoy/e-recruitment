package Model;
import Dao.*;

import java.sql.*;

public class sequence 
{
	ResultSet rs=null;
	static Connection conn=null;
	Statement stmt=null;
	public ResultSet getval()
	{
		 try
		 {
		 conn = connection.getConnection();
		 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		 String query="select seq_empid.nextval from dual";
		 rs = (ResultSet) stmt.executeQuery(query);
		 }
		  catch(Exception e)
		  {}
         return rs;
}
	public ResultSet getbgc_id()
	{
		 try
		 {
		 conn = connection.getConnection();
		 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		 String query="select seq_bgcid.nextval from dual";
		 rs = (ResultSet) stmt.executeQuery(query);
		 }
		  catch(Exception e)
		  {}
         return rs;
}
}
