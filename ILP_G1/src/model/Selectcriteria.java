package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Dao.connection;

public class Selectcriteria 
{
	 ResultSet rs=null;
public ResultSet Retrievedata()
{ 
	try
	{
   Connection conn=connection.getConnection();
   Statement st=null;
   st = ((java.sql.Connection) conn).createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY);
   rs = st.executeQuery("select Emp_Id from emp_details_g1 where Exp>=4");
	}
	catch(Exception e)
	{}
	return rs;
}
public ResultSet bgctestadmin()
{ 
	try
	{
   Connection conn=connection.getConnection();
   Statement st=null;
   st = ((java.sql.Connection) conn).createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY);
   rs = st.executeQuery("select Emp_Id from bgc_admin_g1 where STATUS=1");
     	}
	catch(Exception e)
	{}
	return rs;
}
public ResultSet getempid()
{
	try
	{
   Connection conn=connection.getConnection();
   Statement st=null;
   st = ((java.sql.Connection) conn).createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY);	
   rs = st.executeQuery("select Emp_Id from emp_details_g1");
   System.out.println("hiiee");
	}
	catch(Exception e)
	{}
	return rs;
}
public ResultSet getdesg()
{
	try
	{
   Connection conn=connection.getConnection();
   Statement st=null;
   st = ((java.sql.Connection) conn).createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY);	
   rs = st.executeQuery("select distinct(desg) from emp_login_g1");
   System.out.println("hiiee");
	}
	catch(Exception e)
	{}
	return rs;	
}
public ResultSet gettest_id()
{
	try
	{
   Connection conn=connection.getConnection();
   Statement st=null;
   st = ((java.sql.Connection) conn).createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY);	
   rs = st.executeQuery("select test_id from tests_g1");
   System.out.println("hiiee");
	}
	catch(Exception e)
	{}
	return rs;	
}
}



