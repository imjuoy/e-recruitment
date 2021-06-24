package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Config {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet RS = null;
	String Driver = "oracle.jdbc.driver.OracleDriver";
	
	String URL = "jdbc:oracle:thin:@172.25.192.71:1521:javadb";
	String UserName="H52ORAUSER2D";
	String Password="tcshyd";
	/*
	String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String UserName="system";
	String Password="system"; */
	
	public Connection createConnection(){
		
		try
		{	
			Class.forName(Driver).newInstance();
			conn = (Connection)DriverManager.getConnection(URL,UserName,Password);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx CONNECTION MADE!");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return conn;
	    }
	
	public ResultSet fireQuery(String Q,Connection conn){  // TO FIRE SELECT QUERY WHICH RETURNS ResultSet...
		
		ResultSet RS=null;
		try
		{
			Statement stmt =  ((java.sql.Connection)conn).createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			RS = stmt.executeQuery(Q);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN DB_CONFIG: After execute query");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return RS;
	}
	
	public int fireQuery(Connection conn,String Q){  // TO FIRE INSERT, UPDATE etc....
		Statement stmt = null;
		int status = 0;
		try {
			stmt =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			status = stmt.executeUpdate(Q);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public int countRow(ResultSet RS)
	{
		int size =0;  
		if (RS != null)   
		{  
		  try{
		  RS.beforeFirst();  
		  RS.last();  
		  size = RS.getRow();
		  }
		  catch(Exception ex){
			  ex.printStackTrace(); 
		  }
		} 
		return size;
	}
}
	// Methods startTransac() & endTransac() will be added and forwarded to u in due course of time....

