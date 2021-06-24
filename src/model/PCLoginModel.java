package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;
import bean.PlacementConsultantBean;

public class PCLoginModel {
	static final Logger logger =Logger.getLogger(PCLoginModel.class);
	public boolean validate(PlacementConsultantBean pcb) {
		DBConnect dbc = new DBConnect();
		ResultSet rs = null;
		String qry = "select count(*) from plac_cons_g1 where pc_id=? and pc_pwd=?";
		PreparedStatement ps = null;
		
		try {
			ps = dbc.conn.prepareStatement(qry);
			ps.setString(1,pcb.getId());
			ps.setString(2, pcb.getPassword());
			rs = ps.executeQuery();
			rs.next();
			if(rs.getInt(1)==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
