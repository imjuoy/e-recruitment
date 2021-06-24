package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class VacancyIdListModel {
	static final Logger logger =Logger.getLogger(VacancyIdListModel.class);
	public VacancyIdListModel(){
		super();
	}
	
	public ResultSet getVacancyIdList(){
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select distinct vac_id from cand_profile_g1";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
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

	public ResultSet getVacancyIdListPC() {
		ResultSet rs = null;
		DBConnect dbc = new DBConnect();

		String query = "select distinct vac_id from vac_rqst_g1 a,rec_rqst_g1 b where a.vac_req_id=b.vac_req_id";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
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
