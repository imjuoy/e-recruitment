package model;

import java.sql.*;

import util.connection;

import bean.Getset;

public class Quesset {
	
	int k=0;
	Connection conn=null;
	 PreparedStatement ps=null;
	int rs=0;
	
	public int setQues(Getset g)
	{
	
		try
		{
			conn=connection.getConnection();
			String question=g.getQues();
			String answer=g.getAns();
			String empid=g.getId();
			System.out.println(answer);
			System.out.println(empid);
			String quer="update emp_login_g1 SET sec_ques=?,sec_ans=? where emp_id=?";
			 ps = conn.prepareStatement(quer);
			 ps.setString(1,question);
			 ps.setString(2,answer);
			 ps.setString(3,empid);
			 rs=ps.executeUpdate();
			System.out.println("value of rs is"+rs);

		}
		catch(Exception e)
		{
			
		}
		return rs;
	}

}
