package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.connection;


public class add_emp_dropdown
{
	 Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
 public  ResultSet selected_emp()
   {
	  
	 try
	  {
	conn=connection.getConnection();
	System.out.println("hello this is add");
	st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	String query = "select CAND_PROFILE_ID from cand_status_g1 where BGC_TEST_STATUS=1";
	//String query = "select * from cand_status_g1";
	rs = st.executeQuery(query);
	/*while(rs.next())
	{
		System.out.println(rs.getString(1));
	}*/
} catch (Exception ex) {
	System.out.println(ex);
	
}

return rs;
}
 public ResultSet unitheadid()
 { 
	 Connection conn = null;
		ResultSet rs1  = null;
		Statement st1 = null;
	 try
	  {
	conn=connection.getConnection();
	st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	String query = "select emp_id from emp_login_g1 where desg='uh'";
	rs1 = (ResultSet) st1.executeQuery(query);
} catch (Exception ex) {
	System.out.println(ex);
}
return rs1;	 
 }
 public ResultSet projectid()
 { 
	 Connection conn = null;
		ResultSet rs2  = null;
		Statement st2 = null;
	 try
	  {
	conn=connection.getConnection();
	st2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	String query = "select proj_name from project_g1";
	rs2 = (ResultSet) st2.executeQuery(query);
} catch (Exception ex) {
	System.out.println(ex);
}
return rs2; 
}
}