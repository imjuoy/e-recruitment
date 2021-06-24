package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class SelectTAModel {
	static final Logger logger =Logger.getLogger(SelectTAModel.class);
	public int addTA(String id) {
		int result = 0;
		
		DBConnect dbc = new DBConnect();
		
		
		String query2 = "update emp_login_g1 set desg=? where emp_id=?";
		PreparedStatement ps = null;
		
		try {
			ps = dbc.conn.prepareStatement(query2);
			ps.setString(1, "ta");
			ps.setString(2,id);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
