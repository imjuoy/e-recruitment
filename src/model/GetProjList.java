package model;

import java.sql.Connection;
import java.sql.ResultSet;
import util.DB_Config;

public class GetProjList {
	
	public ResultSet getList()
	{
		Connection conn = null;
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		String Q = "SELECT * FROM PROJECT_G1";
		RS = DB_obj.fireQuery(Q,conn);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN get PROJ list MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		return RS;
	}
}
