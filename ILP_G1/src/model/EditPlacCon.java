package model;

import java.sql.Connection;
import java.sql.ResultSet;

import bean.PlacCon;
import util.DB_Config;

public class EditPlacCon {

	public ResultSet pcDetail(String pc_id)
	{
		Connection conn = null;
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		String Q = "SELECT * FROM PLAC_CONS_G1 WHERE PC_ID = '"+pc_id+"'";
		RS = DB_obj.fireQuery(Q,conn);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN get PC Detail MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		return RS;
	}
	public int updatePC(PlacCon PC)
	{
		int status=0;
		Connection conn = null;
		DB_Config DB_obj = new DB_Config();
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "UPDATE PLAC_CONS_G1 SET PC_NAME = '"+PC.getPCname()+"', PC_CONTACT = '"+PC.getPCcon()+"' WHERE PC_ID = '"+PC.getPCid()+"'";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN UPDATE PC MODEL: Query = "+ Q);
		
		try{
			status=DB_obj.fireQuery(conn,Q);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN UPDATE PC MODEL: Update Status = "+ status);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return status;
	}
	public int deletePC(String PC)
		{
			int status=0;
			Connection conn = null;
			DB_Config DB_obj = new DB_Config();
			conn = DB_obj.createConnection();    // Connection Created
			
			String Q = "UPDATE PLAC_CONS_G1 SET PC_STATUS = 0 WHERE PC_ID = '"+PC+"'";
			
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN DELETE PC MODEL: Query = "+ Q);
			
			try{
				status=DB_obj.fireQuery(conn,Q);
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN DELETE PC MODEL: Update Status = "+ status);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			
			return status;
		}
}
