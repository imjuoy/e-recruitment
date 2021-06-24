package model;

import java.sql.Connection;

import util.DB_Config;
import bean.PlacCon;

public class AddPlacCon {

	public int addPC(PlacCon PC)
	{
		int status=0;
		Connection conn = null;
		DB_Config DB_obj = new DB_Config();
		conn = DB_obj.createConnection();    // Connection Created
		
		String Q = "INSERT INTO PLAC_CONS_G1 VALUES('"+PC.getPCid()+"','"+PC.getPCname()+"','"+PC.getPCpass()+"','"+PC.getPCcon()+"',1)";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN AddPlacCon MODEL: Query = "+ Q);
		
		try{
			status=DB_obj.fireQuery(conn,Q);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN AddPlacCon MODEL: Update Status = "+ status);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return status;
	}
}
