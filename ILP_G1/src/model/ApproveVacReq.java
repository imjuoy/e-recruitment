package model;

import java.sql.Connection;
import java.sql.ResultSet;

import util.DB_Config;

public class ApproveVacReq {
	
	public ResultSet getVRtoApprove()
	{
		Connection conn = null;
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "SELECT VR.VAC_REQ_ID, VR.REQ_BY, VR.REQST_ON, P.PROJ_NAME, P.PROJ_DOM, VR.LOCATION, V.VAC_SKILL, V.VAC_EXP, VR.NO_OF_VAC, E.EMP_NAME, VR.EMP_ID FROM VAC_RQST_G1 VR, PROJECT_G1 P, VACANCY_G1 V, EMP_LOGIN_G1 E WHERE VR.PROJ_ID = P.PROJ_ID AND VR.VAC_ID = V.VAC_ID AND VR.EMP_ID = E.EMP_ID AND VR.APPROVAL_STATUS = 'Pending' AND VR.STATUS = 'Open' ORDER BY VR.REQ_BY, VR.REQST_ON";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx QUERY =  " + Q);
		RS = DB_obj.fireQuery(Q,conn);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN getVRtoApprove() MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		return RS;
	}
	
	public int approveVR(String vr_id)
	{
		int status=0;
		Connection conn = null;
		DB_Config DB_obj = new DB_Config();
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "UPDATE VAC_RQST_G1 SET APPROVAL_STATUS = 'Approved' WHERE VAC_REQ_ID = '"+vr_id+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN to approve VR model: Query = "+ Q);
		
		try{
			status=DB_obj.fireQuery(conn,Q);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN to approve VR model: Update Status = "+ status);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return status;
	}

}
