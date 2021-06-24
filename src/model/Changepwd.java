package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.*;

import bean.*;
//import java.sql.Statement;

public class Changepwd {
	Connection con;
	ResultSet rs=null;
	String opwd=null;
	int k=0;
	PreparedStatement ps = null;
	PreparedStatement pstmt = null;
	public int changePwd (ChangePassword t)throws SQLException
	{
		try {
			Connection con=connection.getConnection();
			//Statement stmt =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			System.out.println("this is servlet 2");
			String pwd;
			String o=t.getoldPwd();
			String n=t.getnewPwd();
			String c=t.getconfPwd();
			String empid=t.getId();
			
			//System.out.println("this from model class"+empid);
			//System.out.println("this from model class"+n);
			
		  
			String selectString ="select pwd,isnew FROM EMP_LOGIN_G1 where emp_id=?";
			System.out.println("this from form"+empid);
			pstmt = con.prepareStatement(selectString);
			pstmt.setString(1, empid); // set input parameter
			rs = pstmt.executeQuery();
		//newuser's value is 0, if he is going to change first time.
	while (rs.next())
	{
		
		opwd=rs.getString(1);
		//System.out.println("this from database"+opwd);
		//int newuser=rs.getInt(2);
		if(!(opwd.equalsIgnoreCase(o)))
		 {
			k=-1;
			System.out.println(o);
			System.out.println(opwd);
			
		 }
		else if(!(n.equalsIgnoreCase(c)))
		{
		k=2;
		System.out.println(n);
		}
		else if(opwd.equalsIgnoreCase(o))
    		 {
			
			if(n.equalsIgnoreCase(c))
    		{
    			pwd=n;
    			ps = con.prepareStatement("update emp_login_g1 set  pwd = ?,isnew=? where emp_id = ?");
    					  ps.setString(1, pwd);
    					  ps.setInt(2, 1);
    					  ps.setString(3, empid);
    					  ps.executeUpdate();
    			System.out.println(" password changed succefully & now u cant change");
    			k=1;
    		 }
    		 
    		else
    		{ 
    			System.out.println("didnt work man");
    		 }
    		 
	}
		
	}
		} //end of try
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


