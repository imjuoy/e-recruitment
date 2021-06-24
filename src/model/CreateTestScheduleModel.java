package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import util.DBConnect;
import bean.TestScheduleBean;

public class CreateTestScheduleModel {
	static final Logger logger =Logger.getLogger(CreateTestScheduleModel.class);
	public int createTestSchedule(TestScheduleBean tsb) {
		DBConnect dbc = new DBConnect();
		
		String query = "insert into tests_g1 values (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = dbc.conn.prepareStatement(query);
			ps.setInt(1, tsb.getId());
			ps.setString(2, tsb.getTaid());
			ps.setString(3, tsb.getVacid());
			ps.setString(4, tsb.getWtdate());
			ps.setString(5, tsb.getTidate());
			ps.setString(6, tsb.getHrdate());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}

}
