package model;

import java.sql.Connection;
import java.sql.ResultSet;

import util.DB_Config;

public class GetVacList {

	public ResultSet getList()
	{
		Connection conn = null;
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		String Q = "SELECT * FROM VACANCY_G1 ORDER BY VAC_SKILL,VAC_EXP";
		RS = DB_obj.fireQuery(Q,conn);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN get vac list MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		return RS;
	}
}
