package model;

import java.sql.Connection;

import bean.RecReq;

import util.DB_Config;

public class AddRecReq {
	
	public int addRR(RecReq RR)
	{
		int status=0;
		Connection conn = null;
		
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q1 = "INSERT INTO REC_RQST_G1 VALUES('"+RR.getRRid()+"','"+RR.getVRid()+"','"+RR.getHRid()+"','"+RR.getPC_id()+"',TO_DATE('"+RR.getCDate()+"','YYYY-MM-DD'),1)";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN AddRecReq MODEL: Query 1 = "+ Q1);
		
		try{
			status=DB_obj.fireQuery(conn,Q1);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN AddRecReq MODEL: Update Status = "+ status);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public int changeVRstatus(RecReq RR)
	{
		int status=0;
		Connection conn = null;
		
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q2 = "UPDATE VAC_RQST_G1 SET STATUS = 'Closed' WHERE VAC_REQ_ID = '"+RR.getVRid()+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN AddRecReq MODEL: Query 2 = "+ Q2);
		
		try{
			status=DB_obj.fireQuery(conn,Q2);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN AddRecReq MODEL: Update Status = "+ status);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return status;
	}
	
}
