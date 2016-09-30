package model;

import java.sql.Connection;
import java.sql.ResultSet;

import util.DB_Config;

public class Search {
	
	public ResultSet getPCList(String id,String name, String contact)
	{
		StringBuffer search_name = new StringBuffer(" AND UPPER(PC_NAME) LIKE UPPER('%");
		StringBuffer search_contact = new StringBuffer(" AND PC_CONTACT LIKE '%");
		String Q=null;
		for(int i=0;i<name.length();i++)  // for name substring
			{
				search_name.append(name.charAt(i));
				search_name.append("%");
			}
		
		search_name.append("')");
		
		for(int i=0;i<contact.length();i++)  // for contact substring
			{
				search_contact.append(contact.charAt(i));
				search_contact.append("%");
			}
		
		search_contact.append("'");
		
		if(id.length()>0)
		{
			Q = "SELECT * FROM PLAC_CONS_G1 WHERE PC_STATUS = 1" + search_name.toString() + search_contact.toString()+" AND UPPER(PC_ID) LIKE UPPER('%"+id+"%')";
		}
		else
		{
			Q = "SELECT * FROM PLAC_CONS_G1 WHERE PC_STATUS = 1" + search_name.toString() + search_contact.toString();
		}
		// Query Generated......
		
		
		System.out.println("-----------------------------------------------   Search PC Query: " + Q);
		
		
		// Starting Database work.......
		
		
		Connection conn = null;
		
		ResultSet RS = null;
				
		DB_Config DB_obj = new DB_Config();
		
		conn = DB_obj.createConnection();    // Connection Created
		
		RS = DB_obj.fireQuery(Q,conn);
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN PC SEARCH MODEL: RS.getrow = "+ DB_obj.countRow(RS));
		
		return RS;
	}

}
