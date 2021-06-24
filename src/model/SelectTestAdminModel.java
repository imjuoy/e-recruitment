package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class SelectTestAdminModel {
	static final Logger logger =Logger.getLogger(SelectTestAdminModel.class);
	public ResultSet EmployeeList(){
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();
		PreparedStatement ps = null;
		String desg="emp";
		String query = "select emp_id from emp_login_g1 where desg=?";
		try {
			ps = dbc.conn.prepareStatement(query);
			ps.setString(1, desg);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
