package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import bean.TestScheduleBean;

import util.DBConnect;

public class EditTestModel {
	static final Logger logger =Logger.getLogger(EditTestModel.class);
	public ResultSet getTestInfo(int id){
		ResultSet rs=null;
		DBConnect dbc = new DBConnect();

		String query = "select * from tests_g1 where test_id=?";

		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setInt(1, id);
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

	public int editTest(TestScheduleBean tsb) {
		int result=0;
		DBConnect dbc = new DBConnect();
		String query = "update tests_g1 set test_admin_id=?, vac_id=?, written_test_date=?, technical_test_date=?, hr_interview=? where test_id=? ";
		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setString(1, tsb.getTaid());
			ps.setString(2,tsb.getVacid());
			ps.setString(3,tsb.getWtdate());
			ps.setString(4,tsb.getTidate());
			ps.setString(5, tsb.getHrdate());
			ps.setInt(6, tsb.getId());
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
			e.printStackTrace();
		}
		return result;
	}

	public int deleteTest(int id) {
		int result = 0;
		DBConnect dbc = new DBConnect();
		String query = "delete from tests_g1 where test_id=?";
		try {
			PreparedStatement ps = dbc.conn.prepareStatement(query);
			ps.setInt(1, id);
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
			e.printStackTrace();
		}
		return result;
	}
}
