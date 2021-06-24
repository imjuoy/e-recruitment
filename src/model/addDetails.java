package model;
import Dao.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import Bean.Getset;
import Bean.Getset2;
//import Bean.Getsetadd;

public class addDetails{
	
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	static Connection conn=null;
	static Connection conn1=null;
	int bgc_id;
	//static Connection conn1=null;
	//ResultSet rs=null;
	public int addDate(Getset2 t)throws Exception
	{
		
		int k=0;
		try 
		{ 
			//Jdbconection obj1=new Jdbconection();
			Connection conn=connection.getConnection();
			sequence obj=new sequence();
			ResultSet rs=obj.getbgc_id();
			//Statement stmt =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String quer="insert into bgc_schedule_g1 values(?,?,?,?)";
		System.out.println("model class");
					ps1=conn.prepareStatement(quer);
					ps1.setString(1,t.getAdminid());
					ps1.setString(2,t.getFdate());
					ps1.setString(3,t.getTdate());
					while(rs.next())
					{ 
                        bgc_id=rs.getInt(1);
						ps1.setInt(4,bgc_id);
					}
					k=ps1.executeUpdate();
					System.out.println("k is:"+k);
			} 
			catch (SQLException ex) 
			{
					System.out.println(ex);
			}
						return k;
		}
        public int addbgcid(Getset2 t)
              {
        	int k=0;
        	try
        	{
        	Connection conn1=connection.getConnection();
        	String quer="update cand_status_g1 set bgc_test_id=? where test_id=?";
        	ps=conn1.prepareStatement(quer);
        	ps.setInt(1,bgc_id);
        	ps.setInt(2,t.getTestid());
        	System.out.println("");
        	k=ps.executeUpdate();
			System.out.println("k is:"+k);
            }
       catch(SQLException e)
       {}
            
              
             return k; 
              }
           }
      




		    	



