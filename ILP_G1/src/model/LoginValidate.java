package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import bean.User;
import util.DB_Config;

public class LoginValidate {
	
	
	public HashMap<String,String> validate(User UB){
		
		Connection conn = null;
		
		ResultSet RS = null;
		
		HashMap<String,String> result = new HashMap<String,String>();
		
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "SELECT * FROM EMP_LOGIN_G1 WHERE EMP_ID = '" + UB.getUserID() + "' AND PWD = '" + UB.getUserPass() + "' AND DESG = '" + UB.getUserDesg() + "'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN MODEL: Query = "+ Q);
		try {
				RS = DB_obj.fireQuery(Q,conn);
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN MODEL: ResultSet = "+ RS);
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN MODEL: RS.getrow = "+ DB_obj.countRow(RS));
				if(DB_obj.countRow(RS)==1)
				{
					String id = RS.getString("EMP_ID");
					String name = RS.getString("EMP_NAME");
					String desg = RS.getString("DESG");
					result.put("valid","true");
					result.put("id",id);
					result.put("name",name);
					result.put("desg",desg);
					return result;
				}
				else
				{
					result.put("valid","false");
					return result;
				}
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}

