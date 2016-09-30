package model;

import java.sql.Connection;
import java.sql.ResultSet;

import util.DB_Config;

public class VED_VR {

	public ResultSet getVED_VRList(String emp_id)
	{
		Connection conn = null;
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "SELECT VR.VAC_REQ_ID, VR.REQ_BY, P.PROJ_NAME, P.PROJ_DOM, V.VAC_SKILL, V.VAC_EXP, VR.NO_OF_VAC, VR.LOCATION FROM VACANCY_G1 V, PROJECT_G1 P, VAC_RQST_G1 VR WHERE  VR.VAC_ID = V.VAC_ID AND VR.PROJ_ID = P.PROJ_ID AND APPROVAL_STATUS = 'Pending' AND STATUS = 'Open' AND EMP_ID = '" + emp_id + "'";
		//String Q = "SELECT * FROM VAC_RQST_G1 WHERE APPROVAL_STATUS = 'Pending' AND STATUS = 'Open' AND EXIST = 1 AND EMP_ID = '" + emp_id + "'";
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		RS = DB_obj.fireQuery(Q,conn);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN getVED_VRList() MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		
		return RS;
	}
	
	public ResultSet getVRDetails(String vr_id)
	{
		Connection conn = null;
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "SELECT VAC_REQ_ID, VAC_ID, PROJ_ID, LOCATION, NO_OF_VAC, REQ_BY FROM VAC_RQST_G1 WHERE VAC_REQ_ID = '"+vr_id+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		RS = DB_obj.fireQuery(Q,conn);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN getRRDetails() MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		
		return RS;
	}
	
	public int updateVRDetails(String VRid, String vactype, String proj, String loc, String no_of_vac, String req_by)
	{
		Connection conn = null;
		int status = 0;	
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "UPDATE VAC_RQST_G1 SET  REQ_BY = TO_DATE('"+req_by+"','YYYY-MM-DD'), VAC_ID = '" + vactype + "',PROJ_ID = '" + proj+ "', LOCATION = '" + loc + "', NO_OF_VAC = " + no_of_vac + "   WHERE VAC_REQ_ID = '"+VRid+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		status = DB_obj.fireQuery(conn,Q);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN updateRRDetails() MODEL: "+ status);
		
		return status;
	}
	
	public int deleteVR(String VR)
	{
		Connection conn = null;
		int status = 0;	
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "UPDATE VAC_RQST_G1 SET STATUS = 'Closed' WHERE VAC_REQ_ID = '"+VR+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		status = DB_obj.fireQuery(conn,Q);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN updateVRDetails() MODEL: "+ status);
		
		return status;
	}
}
