package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class RecruitmentRequestModel {
	static final Logger logger =Logger.getLogger(RecruitmentRequestModel.class);
	public ResultSet getRecruitmentRequestModel(String user) {
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select * from rec_rqst_g1 where hr_id=?";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1, user);
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

	public ResultSet getAll(String user) {
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select * from rec_rqst_g1 where pc_id=?";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
