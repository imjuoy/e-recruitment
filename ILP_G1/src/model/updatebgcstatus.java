package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import util.connection;

import bean.bgcadmin_bean;



public class updatebgcstatus 
{
	Connection conn=null;
	PreparedStatement ps=null;
	int rs=0;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date=new Date(rs);
	public int updateit(bgcadmin_bean obj)throws SQLException
	{
		//java.sql.Date today = new java.sql.Date(date.getTime()); 
		  try
		  {
		conn=connection.getConnection();
		String empid=obj.getid();
		String status=obj.getstatus();
		int condition=Integer.parseInt(status);
		System.out.println("Employee is"+empid+"Status is"+condition);
	    String Query="Update bgc_admin_g1 SET status=? where EMP_ID=?";
	    ps=conn.prepareStatement(Query);
	    ps.setInt(1,condition);
	   // ps.setDate(2,today);
	    
	   // ps.setDate(dateFormat.format(date));
	    ps.setString(2,empid);
	    rs=ps.executeUpdate();
		}
		  catch(Exception e)
		  {}
		  return rs;
	}
	
}
