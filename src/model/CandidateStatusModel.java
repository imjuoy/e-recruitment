package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import bean.CandidateStatusBean;

import util.DBConnect;

public class CandidateStatusModel {
	static final Logger logger =Logger.getLogger(CandidateStatusModel.class);
	public ResultSet getCandidateStatus() {

		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select * from cand_status_g1";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);

			rs = ps.executeQuery();
			/*
			 * while (rs.next()) { System.out.println(rs.getString(1));
			 * System.out.println(rs.getString(2));
			 * System.out.println(rs.getString(3));
			 * System.out.println(rs.getString(4));
			 * System.out.println(rs.getString(5)); }
			 */
		} catch (SQLException e) {
			logger.error(e);
		}
		return rs;

	}

	public ResultSet getStatusInfo(String id) {
		ResultSet rs=null;
		DBConnect dbc = new DBConnect();

		String query = "select * from cand_status_g1 where cand_profile_id=?";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1, id);
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
			logger.error(e);
		}
		return rs;
	}

	public int updateStatus(CandidateStatusBean csb) {
		int result=0;
		DBConnect dbc = new DBConnect();
		String query = "update cand_status_g1 set cand_profile_id=?, test_id=?, wt_status=?, ti_status=?, hri_status=?, medical_test_status=? where cand_profile_id=? ";
		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1, csb.getId());
			ps.setInt(2, csb.getTestId());
			ps.setInt(3, csb.getWtStatus());
			ps.setInt(4, csb.getTiStatus());
			ps.setInt(5, csb.getHriStatus());
			ps.setInt(6, csb.getMedicalStatus());
			ps.setString(7, csb.getId());
			result = ps.executeUpdate();

			/*while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
*/
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	
	}

	public ResultSet getCandidateStatus(String user) {
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select a.cand_profile_id, a.test_id, a.wt_status, a.ti_status from cand_status_g1 a, tests_g1 b where a.test_admin_id=b.test_admin_id and b.test_admin_id=?";

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
			logger.error(e);
		}
		return rs;
	}

}
