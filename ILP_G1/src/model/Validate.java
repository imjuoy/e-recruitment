package model;
//import java.util.*;


import java.sql.*;
//import java.util.ArrayList;
import java.sql.ResultSet;

import util.connection;

import bean.*;

public class Validate
{
	Connection con;
	ResultSet rs;
    String id="";
	String pwd="";
	String desig="";
	int newuser=0;
	int k=0;
	public int loginValidate(Getset t)throws SQLException
	{
		try 
		{
			Connection con=connection.getConnection();
			Statement stmt =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String  query ="select desg,emp_id,pwd,ISNEW from emp_login_g1" ;
			ResultSet rs=stmt.executeQuery(query);
			
			String empid=t.getId();
			String emppwd=t.getPass();
			String empdesig=t.getDesig();
			
			
	while (rs.next())
	{
		desig=rs.getString(1);
		id=rs.getString(2);
		pwd=rs.getString(3);
		newuser=rs.getInt(4);
		
	
		
		
		
		//new user==0 means user is doing login for first time.
	if(id.equalsIgnoreCase(empid))
	{System.out.println("id IS from database:"+id);
		    System.out.println("Match1");
		    
    		if(pwd.equalsIgnoreCase(emppwd)&& desig.equalsIgnoreCase(empdesig)&& newuser==0)
    		{
    			System.out.println("PWD IS from db:"+pwd);
    			System.out.println("desig IS from database:"+desig);
    			System.out.println("value is"+newuser);
    			System.out.println("Match2");
			k=-1;
			}
    			else if(pwd.equalsIgnoreCase(emppwd)&& desig.equalsIgnoreCase(empdesig)&& newuser!=0)
    			{
    			k=1;
    			System.out.println("value is"+newuser);
    			}
	}
	}
	
   }//end of try
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return k;
	}//end of function
	
	
}//end of class






