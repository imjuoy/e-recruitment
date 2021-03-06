package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class DisplayTAModel {
	static final Logger logger =Logger.getLogger(DisplayTAModel.class);
	public ResultSet displayTA() {
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select emp_id,emp_name from emp_login_g1 where desg=?";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1, "ta");
			rs = ps.executeQuery();
			/*
			 * while (rs.next()) { System.out.println(rs.getString(1));
			 * System.out.println(rs.getString(2));
			 * System.out.println(rs.getString(3));
			 * System.out.println(rs.getString(4));
			 * System.out.println(rs.getString(5)); }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

}
