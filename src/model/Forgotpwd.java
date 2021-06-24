package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.connection;

import bean.*;
//import java.sql.Statement;



public class Forgotpwd {
	Connection con;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	PreparedStatement ps = null;
	int k;
	int trialno=0;
	//String empid;
	String id;
	String ques;
	String ans;
	String empid;
	String storedques;
	String storedans;
	//String pwd;
	//String newpass;
	//String conpass;
public int forgetPwd(ChangePassword t)
{
	try
	{
	    
		Connection con=connection.getConnection();
				
		ques=t.getQues();
		ans=t.getAns();
		empid=t.getId();
		//newpass=t.getNewpass();
		//conpass=t.getConpass();
		System.out.println("ques is"+ques);
		System.out.println("ans is"+ans);
		System.out.println("id is"+id);
		//System.out.println("newpass is"+newpass);
		//System.out.println("conpass is"+conpass);
		String selectString ="select emp_id,pwd,sec_ques,sec_ans,trialno FROM EMP_LOGIN_G1 where emp_id=?";
		pstmt = con.prepareStatement(selectString);
		pstmt.setString(1, id); // set input parameter
		rs = pstmt.executeQuery();
	
		while (rs.next())
		{
		id=rs.getString(1);	
		//pwd=rs.getString(2);
		storedques=rs.getString(3);
		storedans=rs.getString(4);
		trialno=rs.getInt(5);
		System.out.println(id);
		//System.out.println(pwd);
		System.out.println(storedques);
		System.out.println(storedans);
		System.out.println(trialno);
		
		if(id.equalsIgnoreCase(empid))
		{ 
			System.out.println("your id exist");
			
			if(storedques.equalsIgnoreCase(ques)&& storedans.equalsIgnoreCase(ans))
			{
				System.out.println("your answers match") ;
				k=-1;
				
				/*if(newpass.equalsIgnoreCase(conpass))
				{
					System.out.println("your new & confrm password match") ;
					System.out.println("trying to update") ;
				ps = con.prepareStatement("update emp_login_g1 set  pwd = ? where empid = ?");
				ps.setString(1,newpass);
				ps.setString(2,empid);
				ps.executeUpdate();
				k=-1;
				System.out.println("updated") ;
				}*/
				/*else
				{
					k=-2;
					System.out.println("your new password doesnot match with re-entered password");
				}*/
				
			}
				else if(!(storedques.equalsIgnoreCase(ques)&& storedans.equalsIgnoreCase(ans)))
						{
						k=trialno;
						k++;
						ps = con.prepareStatement("update emp_login_g1 set  trialno = ? where emp_id = ?");
						ps.setInt(1,k );
						ps.setString(2,empid);
						ps.executeUpdate();
						}
				}
		/*else
		{
			System.out.println("your id doesnot exist");
		}*/
		}
		 
			
	}catch(Exception e){}
	return k;
	}

}
