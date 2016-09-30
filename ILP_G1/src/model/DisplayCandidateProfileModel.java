package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class DisplayCandidateProfileModel {
	static final Logger logger =Logger.getLogger(DisplayCandidateProfileModel.class);
	public ResultSet getCandidateProfiles(String vacancyId) {
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select * from cand_profile_g1 where vac_id=?";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1, vacancyId);
			rs = ps.executeQuery();
			/*while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}*/
		} catch (SQLException e) {
			logger.error(e);
		}
		return rs;
	
	}

}
