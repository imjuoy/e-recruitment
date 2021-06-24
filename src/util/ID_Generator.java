package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ID_Generator {

	public String createVacReqID(){
		
		Connection conn = null;
		ResultSet RS = null;
		String ID = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q="SELECT COUNT(*) AS  TOTAL FROM VAC_RQST_G1";
		
		RS = DB_obj.fireQuery(Q,conn);
		
		try {
			RS.next();
			ID = "VAC_REQ_" + (RS.getInt("TOTAL")+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return ID;
	}
	
	public String createRecReqID(){
		
		Connection conn = null;
		ResultSet RS = null;
		String ID = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q="SELECT COUNT(*) AS TOTAL FROM REC_RQST_G1";
		
		RS = DB_obj.fireQuery(Q,conn);
		try {
			RS.beforeFirst();
			RS.next();
			ID = "REC_REQ_" + (RS.getInt("TOTAL")+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ID;
	}
	
	
	public String createPCID(){
		
		Connection conn = null;
		ResultSet RS = null;
		String ID = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q="SELECT COUNT(*) AS TOTAL FROM PLAC_CONS_G1";
		
		RS = DB_obj.fireQuery(Q,conn);
		
		try {
			RS.next();
			ID = "PC_" + (RS.getInt("TOTAL")+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return ID;
	}
	
	public String PassGenerator(int length) { 
		
		String ALPHA_NUM = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ"; 
	    StringBuffer sb = new StringBuffer(length);  
	    for (int i=0;  i<length;  i++)
	    {  
	    	int ndx = (int)(Math.random()*ALPHA_NUM.length());  
	    	sb.append(ALPHA_NUM.charAt(ndx));  
	    }  
	    return sb.toString();  
	}  
	
	
}
