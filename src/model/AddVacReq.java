package model;

import java.sql.Connection;

import util.DB_Config;

import bean.VacReq;

public class AddVacReq {

	public int addVR(VacReq VR){
		
		int status=0;
		Connection conn = null;
		
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "INSERT INTO VAC_RQST_G1 VALUES('"+VR.getVRid()+"','"+VR.getVid()+"','"+VR.getPid()+"','"+VR.getEMPid()+"','"+VR.getLoc()+"',"+VR.getNo_of_vac()+",TO_DATE('"+VR.getReq_by_date()+"','YYYY-MM-DD'),TO_DATE('"+VR.getReq_on_date()+"','YYYY-MM-DD'),'"+VR.getStatus()+"','"+VR.getAprv_status()+"',1)"; 
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN AddVacReq MODEL: Query = "+ Q);
		
		try{
			status=DB_obj.fireQuery(conn,Q);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN AddVacReq MODEL: Update Status = "+ status);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return status;
	}
}
