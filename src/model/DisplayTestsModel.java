package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class DisplayTestsModel {
	static final Logger logger =Logger.getLogger(DisplayTestsModel.class);
	public ResultSet getTestSchedule() {
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select * from tests_g1";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);

			rs = ps.executeQuery();

			/*while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getTestScheduleTA(String id) {
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select * from tests_g1 where test_admin_id=?";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1,id);
			rs = ps.executeQuery();
			

			/*while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
