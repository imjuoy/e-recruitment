package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class EditDeleteCandidateModel {
	static final Logger logger =Logger.getLogger(EditDeleteCandidateModel.class);
	public ResultSet getCandInfo(String id) {
		ResultSet rs=null;
		DBConnect dbc = new DBConnect();

		String query = "select * from cand_profile_g1 where cand_profile_id=?";

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
			e.printStackTrace();
		}
		return rs;
	}

	public int deleteCand(String id) {
		int r1=0,r2 = 0;
		DBConnect dbc = new DBConnect();
		String query = "delete from cand_status_g1 where cand_profile_id=?";
		String query1 = "delete from cand_profile_g1 where cand_profile_id=?";
		
		try {
			PreparedStatement ps1 = dbc.conn.prepareStatement(query);
			PreparedStatement ps2 = dbc.conn.prepareStatement(query1);

			ps1.setString(1, id);
			ps2.setString(1, id);
			r1 = ps1.executeUpdate();
			r2 = ps2.executeUpdate();
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
		return r1+r2;
	}

}
