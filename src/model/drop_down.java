package model;


import java.sql.*;

import util.connection;

import controller.*;

public class drop_down {

	static Connection conn = null;
	ResultSet rs = null;
	Statement st = null;

	public ResultSet droplist() {
		try {
			conn=connection.getConnection();
			Statement st = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String query = "select uhid from add_employee";
			rs = (ResultSet) st.executeQuery(query);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return rs;
	}
}
