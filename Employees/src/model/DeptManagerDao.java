package model;

import java.sql.*;

import db.DBHelper;

public class DeptManagerDao {
	//전체 행을 출력하는 메소드
	public int selectDeptManagerRowCount()  {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from dept_manager";
		
		try {
			conn = DBHelper.getConnection(); //DBHelper클래스의 getConnection메소드를 conn에 복사
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("cnt");
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn); //DBHelper클래스에 close 메소드호출
		}
		return count;
		
	}
}
