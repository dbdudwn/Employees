package model;
import java.sql.*;
import vo.*;
import java.util.*;

import db.DBHelper;

public class DepartmentsDao {
	public DepartmentsDao(){ //생성자 선언
		
	}
	//부서 이름 , 부서 번호 , 부서 인원 출력 메소드
		public List<Map<String , Object>> selectDepartmentsCountByDeptNo() {
			List<Map<String , Object>> list = new ArrayList<Map<String , Object>>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT d.dept_no dno , d.dept_name dna , COUNT(d.dept_no) cnt "
					+ "FROM dept_emp de "
					+ "INNER JOIN departments d ON de.dept_no = d.dept_no "
					+ "WHERE de. to_date = '9999-01-01' "
					+ "GROUP BY d.dept_no "
					+ "ORDER BY COUNT(d.dept_no) desc ";
			
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String , Object> map = new HashMap<String , Object>();
						map.put("dno",rs.getString("dno"));
						map.put("dna",rs.getString("dna"));
						map.put("cnt",rs.getInt("cnt"));
						list.add(map);
					}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBHelper.close(rs, stmt, conn);
			}
			return list;
			
		}
	
	
	
	//전체 행을 출력하는 메소드
	public int selectDepartmentsRowCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from departments";
		
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
	
	//DepartmentsDao List를 출력하는 메소드
	public List<Departments> selectDepartmentsList() {
		List<Departments> list = new ArrayList<Departments>(); //List타입의 arraylist를 생성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select dept_no , dept_name from departments";
		
		try {
			conn = DBHelper.getConnection(); //DBHelper클래스의 getConnection메소드를 conn에 복사
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			Departments departments;
			while(rs.next()) {
				departments = new Departments();
				departments.setDeptNo(rs.getString("dept_no"));
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments); //departments를 list에 복사
			}
			
		}catch(Exception e) {
			e.printStackTrace(); //예외를 강제로 출력
		}finally {
			DBHelper.close(rs, stmt, conn); //DBHelper클래스에 close 메소드호출
		}
		return list;
	}
}
