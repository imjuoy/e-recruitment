package util;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connection {
	static Connection conn=null;
	ResultSet rs=null;
	public static Connection getConnection ()
	{  
		try
		{
			System.out.println("connect to database");
			String url="jdbc:oracle:thin:@172.25.192.71:1521:javadb";
			String username="H52ORAUSER2D";
			String password="tcshyd";
			/*String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		      String username="system";
		      String password="vicky";*/
			
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn=(Connection) DriverManager.getConnection(url, username, password);
			System.out.println("connected to database:" +conn);
			
				}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return conn;
           }
	
	
	
      }

