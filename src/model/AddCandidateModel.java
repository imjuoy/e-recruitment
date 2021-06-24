package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;
import bean.CandidateProfileBean;

public class AddCandidateModel {
	static final Logger logger =Logger.getLogger(AddCandidateModel.class);
	public int addCandidate(CandidateProfileBean cpb) {
		DBConnect dbc = new DBConnect();
		String q1 = "insert into cand_profile_g1 values (?,?,?,?,?,?,?,?,?,?,?)";
		String q2 = "insert into cand_status_g1 (cand_profile_id) values (?)";

		int r1 = 0, r2 = 0;

		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;

		try {
			ps1 = dbc.conn.prepareStatement(q1);
			ps2 = dbc.conn.prepareStatement(q2);
			ps1.setString(1, cpb.getCandidateProfileID());
			ps1.setString(2, cpb.getVacancyID());
			ps1.setString(3, cpb.getCandidateName());
			ps1.setString(4, cpb.getCandidateDOB());
			ps1.setString(5, cpb.getCandidateLocation());
			ps1.setString(6, cpb.getCandidateSex());
			ps1.setDouble(7, cpb.getPerc10th());
			ps1.setDouble(8, cpb.getPerc12th());
			ps1.setString(9, cpb.getGapInEducation());
			ps1.setString(10, cpb.getGapInExperience());
			ps1.setInt(11, cpb.getExperience());
			ps2.setString(1, cpb.getCandidateProfileID());
			r1 = ps1.executeUpdate();
			r2 = ps2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r1 + r2;
	}
}
