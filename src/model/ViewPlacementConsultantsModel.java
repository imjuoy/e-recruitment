package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;

public class ViewPlacementConsultantsModel {
	static final Logger logger =Logger.getLogger(ViewPlacementConsultantsModel.class);
	public ResultSet getPlacementConsultants() {
		ResultSet rs = null;
		
		DBConnect dbc = new DBConnect();

		String query = "select * from plac_cons_g1";

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
			e.printStackTrace();
		}
		return rs;
	}

}
