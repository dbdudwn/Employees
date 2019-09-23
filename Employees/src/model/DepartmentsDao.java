package model;
import java.sql.*;
import vo.*;
import java.util.*;

public class DepartmentsDao {
	public DepartmentsDao(){ //생성자 선언
		
	}
	
	public int selectDepartmentsRowCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from departments";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("cnt");
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
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
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
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
			try {
				conn.close();
				stmt.close();
				rs.close();
				
			}catch(Exception e) {
				e.printStackTrace(); //예외를 강제로 출력
			}
		}
		return list;
	}
}
