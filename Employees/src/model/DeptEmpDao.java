package model;

import java.sql.*;

import vo.*;
import java.util.*;
import db.DBHelper;

public class DeptEmpDao {
public DeptEmpDao() {
		
	}
	//마지막 페이지 구하는 메소드
	public int selectLastPage(int rowperPage) {
		int lastPage = 0;
		int cnt = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) cnt from dept_emp";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if(cnt%rowperPage != 0) {
				lastPage = cnt/rowperPage+1;
			}else {
				lastPage = cnt/rowperPage;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		
		return lastPage;
	}
	
	
	
	
	// 페이징 메소드
	public List<DeptEmp> selectDeptEmpList(int currentPage , int rowperPage) {
		List<DeptEmp> list = new ArrayList<DeptEmp>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT d.dept_no, d.dept_name , e.emp_no, " + 
				"CONCAT(e.first_name,e.last_name) 'name', de.to_date " + 
				"FROM dept_emp de " + 
				"INNER JOIN employees e " + 
				"INNER JOIN departments d " + 
				"ON e.emp_no = de.emp_no AND de.dept_no = d.dept_no " + 
				"ORDER BY to_date ASC limit ?,?";
		try {
			int startRow = (currentPage-1)*rowperPage;
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startRow);
			stmt.setInt(2, rowperPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
			DeptEmp deptEmp = new DeptEmp();
			deptEmp.setDepartments(new Departments());
			deptEmp.setEmployees(new Employees());
				deptEmp.getEmployees().setEmpNo(rs.getInt("e.emp_no"));
				deptEmp.getEmployees().setFirstName(rs.getString("name"));
				deptEmp.getDepartments().setDeptNo(rs.getString("d.dept_no"));
				deptEmp.getDepartments().setDeptName(rs.getString("d.dept_name"));
				deptEmp.setToDate(rs.getString("to_date"));
			list.add(deptEmp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
	
	//전체 행을 출력하는 메소드
	public int selectDeptEmpRowCount()  {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from dept_emp";
		
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
