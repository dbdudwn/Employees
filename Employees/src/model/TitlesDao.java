package model;

import java.sql.*;
import java.util.*;
import db.DBHelper;

public class TitlesDao {
	//중복값 제거 출력 메소드
		public List<String> selectTitlesListDistinct(){
			List<String> list = new ArrayList<String>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "select distinct title from titles";
			
			try {
				conn = DBHelper.getConnection(); //DBHelper클래스의 getConnection메소드를 conn에 복사
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					list.add(rs.getString("title"));
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBHelper.close(rs, stmt, conn); //DBHelper클래스에 close 메소드호출
			}
			return list;
			
		}
		//전체 행 출력 메소드
	public int selectTitlesRowCount()  {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from titles";
		
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
