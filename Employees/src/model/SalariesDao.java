package model;

import java.sql.Connection;


import java.sql.*;
import java.util.*;
import db.DBHelper;

public class SalariesDao {
	
	//통계 추출 메소드
	public Map<String, Long> selectSalariesStatistics() {
		Map<String , Long> map = new HashMap<String,Long>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(salary),sum(salary),avg(salary),MAX(salary),min(salary),std(salary) FROM salaries";
		try {
			conn = DBHelper.getConnection(); //DBHelper클래스의 getConnection메소드를 conn에 복사
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				map.put("count",(rs.getLong("Count(salary)")));
				map.put("sum",(rs.getLong("sum(salary)")));
				map.put("avg",(rs.getLong("avg(salary)")));
				map.put("max",(rs.getLong("max(salary)")));
				map.put("min",(rs.getLong("min(salary)")));
				map.put("std",(rs.getLong("std(salary)")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn); //DBHelper클래스에 close 메소드호출
		}
		return map;
	}
	//총 행의 갯수 출력 메소드
	public int selectSalariesRowCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from salaries";
		
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
