package db;

import java.sql.*;

public class DBHelper {
	public DBHelper() {
		
	}
	public static Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		
		return conn;
		
	}
	//DB close시키는 메소드
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		if(stmt != null) {
			try {
				stmt.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		if(conn != null) {
			try {
				conn.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
}
