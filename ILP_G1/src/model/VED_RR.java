package model;

import java.sql.Connection;
import java.sql.ResultSet;

import util.DB_Config;

public class VED_RR {

	public ResultSet getVED_RRList()
	{
		Connection conn = null;
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "SELECT RR.REC_RQST_ID, RR.REQ_BY, VR.LOCATION, P.PROJ_NAME, P.PROJ_DOM, V.VAC_SKILL, V.VAC_EXP, VR.NO_OF_VAC, PC.PC_NAME, PC.PC_STATUS FROM VACANCY_G1 V, PROJECT_G1 P, VAC_RQST_G1 VR, PLAC_CONS_G1 PC, REC_RQST_G1 RR WHERE RR.VAC_REQ_ID = VR.VAC_REQ_ID AND VR.VAC_ID = V.VAC_ID AND VR.PROJ_ID = P.PROJ_ID AND RR.PC_ID = PC.PC_ID AND RR.EXIST = 1";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		RS = DB_obj.fireQuery(Q,conn);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN getVED_RRList() MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		
		return RS;
	}
	
	public ResultSet getRRDetails(String rr_id)
	{
		Connection conn = null;
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "SELECT REC_RQST_ID, REQ_BY, PC_ID  FROM REC_RQST_G1 WHERE REC_RQST_ID = '"+rr_id+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		RS = DB_obj.fireQuery(Q,conn);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN getRRDetails() MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		
		return RS;
	}
	
	public int updateRRDetails(String RR, String Date, String PC)
	{
		Connection conn = null;
		int status = 0;	
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "UPDATE REC_RQST_G1 SET PC_ID = '"+PC+"', REQ_BY = TO_DATE('"+Date+"','YYYY-MM-DD') WHERE REC_RQST_ID = '"+RR+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		status = DB_obj.fireQuery(conn,Q);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN updateRRDetails() MODEL: "+ status);
		
		return status;
	}
	
	public int deleteRR(String RR)
	{
		Connection conn = null;
		int status = 0;	
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "UPDATE REC_RQST_G1 SET EXIST = 0 WHERE REC_RQST_ID = '"+RR+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		status = DB_obj.fireQuery(conn,Q);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN updateRRDetails() MODEL: "+ status);
		
		return status;
	}
}
