package model;
import java.sql.*;
import vo.*;
import java.util.*;

public class EmployeesDao {
	public EmployeesDao() { // 생성자 선언코드

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
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
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
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
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
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
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
				try {
					conn.close();
					stmt.close();
					rs.close();
				}catch (Exception e){
				e.printStackTrace(); //예외 강제 출력	
				}
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
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(); 
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
				e.printStackTrace();//예외가 나면 콘솔창에 예외를 출력
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();				
			}catch(Exception e) {
				e.printStackTrace();//예외가 나면 콘솔창에 예외를 출력
			}
		}		
		return count;
	}
}
