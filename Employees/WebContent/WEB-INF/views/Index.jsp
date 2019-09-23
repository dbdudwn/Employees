<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.b {
  list-style-type: square;
}
</style>
<meta charset="UTF-8">
<title>Index.jsp</title>
</head>
<body class="container">
	<h1 class="text-center">Index</h1>
	<h2 class="text-center">테이블 정보</h2>
	<div>
		<table class="table table-bordered text-center">
			<thead class="thead-dark">
				<tr>
					<td>테이블이름</td>
					<td>전체 행의 수</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<td>Departments</td>
					<td>${DepartmentsRowCount}</td>
				</tr>
				<tr>
					<td>Employees</td>
					<td>${EmployeesRowCount}</td>
				</tr>
				<tr>
					<td>Emp_manager</td>
					<td>${DeptManagerRowCount}</td>
				</tr>
				<tr>
					<td>Dept_emp</td>
					<td>${DeptEmpRowCount}</td>
				</tr>
				<tr>
					<td>Salaries</td>
					<td>${SalariesRowCount}</td>
				</tr>
				<tr>
					<td>Titles</td>
					<td>${TitlesRowCount}</td>
				</tr>
			</thead>
		</table>
	</div>
	
	<div>
		<ul class="b">
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a></li>	
			<li>
				정렬 -> FirstName 
				<a href="${pageContext.request.contextPath}/employees/EmployeesListOrderBy?order=asc">오름차순↑</a>
				<a href="${pageContext.request.contextPath}/employees/EmployeesListOrderBy?order=desc">내림차순↓</a>
			</li>
			<li>
				정렬 -> LastName
				<a href="${pageContext.request.contextPath}/employees/EmployeesListOrderBy?order=asc">오름차순↑</a>
				<a href="${pageContext.request.contextPath}/employees/EmployeesListOrderBy?order=desc">내림차순↓</a>
			</li>
		</ul>
	</div>
	
	<div>
		EL ->	employees total Row Count :	${employeesRowCount} 
	</div>
</body>
</html>
</body>
</html>