package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.connection;

public class updatebgcid
{
int rs=0;
PreparedStatement ps=null;
public int updatestatus(String a)
{
	try
	{
   Connection conn=connection.getConnection();
   String quer="insert into BGC_Admin_g1(ADMIN_ID,EMP_ID) values(SEQ_ADMIN_ID.nextval,?)";
   System.out.println("Preparing to Update");
   ps = conn.prepareStatement(quer);
   ps.setString(1,a);
   rs=ps.executeUpdate();
	}
	catch(Exception e)
	{
		 
	}
	return rs;
}
}
