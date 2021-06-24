package model;

import java.sql.*;

import util.connection;

import bean.*;


public class empcls {
	static Connection conn = null;
	static Connection conn1 = null;
	static Connection conn2 = null;
	static Connection conn3 = null;
	ResultSet rs = null;
	String empid=null;

	public int empdetails(empbean e) {
		int j = 0;
		PreparedStatement ps = null;
		String query = "insert into emp_details_g1 values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			conn=connection.getConnection();
			sequence obj=new sequence();
			ResultSet rs=obj.getval();
			ps = conn.prepareStatement(query);
			ps.setString(5, e.getUhid());
			ps.setString(7, e.getPrid());
			ps.setString(2, e.getEname());
			ps.setString(8, e.getDob());
			ps.setString(12, e.getLoc());
			ps.setString(10, e.getGen());
			ps.setInt(4, e.getCtc());
			ps.setInt(3,e.getExp());
			ps.setString(6,e.getDomain());
			ps.setString(9, e.getDOJ());
			ps.setString(11,e.getEmpid());
			while(rs.next())
			{
				empid=rs.getString(1);
				ps.setString(1,empid);	
			}
			
			j = ps.executeUpdate();
			System.out.println("j is:" + j);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return j;
	}

	public int dispdetails(empbean e) {
		int k=0;
		try {
			conn1=connection.getConnection();
			PreparedStatement ps=null;
			String qry = "insert into emp_login_g1(emp_id,emp_name,pwd,desg,isnew,candidate_id)values(?,?,?,?,?,?)";
			ps = conn1.prepareStatement(qry);
			ps.setString(6,e.getEmpid());
			ps.setString(2,e.getEname());
			ps.setString(3,e.getEmpid());
			ps.setString(4,e.getDesig());
			ps.setInt(5,0);
			ps.setString(1,empid);
			k=ps.executeUpdate();
			System.out.println("k is"+k);
		}		
	        catch (Exception ex)
	        {
			System.out.println(ex);
	     	}
		
		return k;
	}

	public int editctc(empbean t) {
		int r = 0;
		try {
			conn2=connection.getConnection();
			
			int c = t.getCtc();
			String id =t.getEmpid();
			System.out.println("ctc is"+c+"id is"+id);
	PreparedStatement pst = conn2.prepareStatement("update emp_details_g1 set ctc=? where emp_id=?");
           	pst.setInt(1, c);
			pst.setString(2,id);
			r = pst.executeUpdate();
			System.out.println(r);

		} catch (Exception k) {
			System.out.println(k);
		}
		return r;
	}
    public int editdesig(empbean t)
    {
    	int s = 0;
		try {
			conn3=connection.getConnection();
			
			String b =t.getDesig();
			String id =t.getEmpid();
			System.out.println("desg is"+b+"id is"+id);
	PreparedStatement pst =conn3.prepareStatement("update emp_login_g1 set desg=? where emp_id=?");

			pst.setString(1, b);
			pst.setString(2,id);
			s = pst.executeUpdate();
			System.out.println(s);

		} catch (Exception k) {
			System.out.println(k);
		}
		return s; 	

}
}
