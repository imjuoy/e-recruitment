package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class EmployeeIdListModel {
	static final Logger logger =Logger.getLogger(EmployeeIdListModel.class);
	public ResultSet getEmployeeIdList() {
		ResultSet rs = null;
		
		DBConnect dbc = new DBConnect();

		String query = "select distinct emp_id from emp_login_g1 where desg=?";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1, "basic");
			rs = ps.executeQuery();
			/*while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
