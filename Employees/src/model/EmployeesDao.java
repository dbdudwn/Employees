package model;
import java.sql.*;
import vo.*;
import java.util.*;

import db.DBHelper;

public class EmployeesDao {
	public EmployeesDao() { // 생성자 선언코드

	}

	//사원의 성별 별 인원 수 출력 메소드
	public List<Map<String , Object>> selectEMployeesCountGroupByGender() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT gender , COUNT(gender) cnt FROM employees GROUP BY gender";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map<String , Object> map = new HashMap<String , Object>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getInt("cnt"));
				list.add(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
		
	//?~?값을 출력해주는 메소드
	public List<Employees> selectEmployeesListBetween(int begin, int end){
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, birth_date , first_name, last_name, gender, hire_date from employees where emp_no between ? and ?";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}	
		
	//emp_no의 최소값과 최대값을 구하는 메소드
	public int selectEmpNo(String str) {
		int empNo = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		if(str.equals("max")) {
			sql = "select max(emp_no) from employees ";
		}else if(str.equals("min")) {
			sql = "select min(emp_no) from employees ";
		}
		try {
		conn = DBHelper.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		if(rs.next()) {
			empNo = rs.getInt(1);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return empNo;
	}	
		
	
	//lastname순으로 정렬 메소드
	public List<Employees> SelectEmployeesListOrderByLastName(String order) {
		List<Employees> list = new ArrayList<Employees>();
		System.out.println("EmployeesDao selectEmployeesListOrderByLastName param order : " + order);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		if(order.equals("asc")) {
			sql = "select emp_no , birth_date , first_name , last_name , gender , hire_date from employees order by last_name asc limit 50";
		}else if(order.equals("desc")) {
			sql = "select emp_no , birth_date , first_name , last_name , gender , hire_date from employees order by last_name desc limit 50";
		}
		try {
		conn = DBHelper.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
			System.out.println("employees rsNext() param :" + list);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
			
	}
	
		
	//정렬 메소드
	public List<Employees> selectEmployeesListOrderBy(String order) {
		System.out.println("EmployeesDao selectEmployeesListOrderBy param order : " + order);
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		if(order.equals("asc")) {
			sql = "select emp_no , birth_date , first_name , last_name , gender , hire_date from employees order by first_name asc limit 50";
		}else if (order.equals("desc")) {
			sql = "select emp_no , birth_date , first_name , last_name , gender , hire_date from employees order by first_name desc limit 50";
		}
		try {
			conn = DBHelper.getConnection(); //DBHelper클래스의 getConnection메소드를 conn에 복사
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(); 
			
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace(); //예외 강제 출력
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		
		return list;
	}
	
	
	//리스트 출력 메소드
	public List<Employees> selectEmployeesListByLimit(int limit){
		System.out.println("EmployeesDao selectEmployeesListByLimit param limit : " + limit);
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, birth_date , first_name, last_name, gender, hire_date from employees limit ?";
		
		try {
			conn = DBHelper.getConnection(); //DBHelper클래스의 getConnection메소드를 conn에 복사
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
			rs = stmt.executeQuery(); 
		
		while(rs.next()) {
			Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);//employees를 list에 복사한다
		}
			}catch(Exception e) {
				e.printStackTrace(); //예외 강제 출력	
			}finally {
				DBHelper.close(rs, stmt, conn); //DBHelper클래스에 close 메소드호출
			}
		return list;
	}
	
	//총 행의 갯수 메소드
	public int SelectEmployeesCount() {
		int count = 0; //총 갯수변수
		final String sql = "select count(*) cnt from employees"; //쿼리는 변하면 안되기 때문에 변할 수 없는 final을 붙여준다
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; //ResultSet은 이터레이터화 되어 있다
		//변수선언 후 초기화를 try밖에 한 이유는 try catch finally에서 각각 쓸 수 있도록 하려고 꺼내서 선언
		try {
			conn = DBHelper.getConnection(); //DBHelper클래스의 getConnection메소드를 conn에 복사
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(); 
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
				e.printStackTrace();//예외가 나면 콘솔창에 예외를 출력
		} finally {
			DBHelper.close(rs, stmt, conn); //DBHelper클래스에 close 메소드호출
		}		
		return count;
	}
}
