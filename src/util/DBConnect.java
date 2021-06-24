package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public Connection conn = null;

	public DBConnect() {
		this.conn = getConnection();
	}

	public Connection getConnection() {
		//System.out.println("connect to database");
		String url = "jdbc:oracle:thin:@172.25.192.71:1521:javadb";
		String username = "H52ORAUSER2D";
		String password = "tcshyd";
//		String url = "jdbc:oracle:thin:@localhost:1521/xe";
//		String username = "admin";
//		String password = "password";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return conn;
	}

}
