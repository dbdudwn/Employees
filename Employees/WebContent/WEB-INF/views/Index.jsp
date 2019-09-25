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
	<h1 class="text-center text-success">Index</h1>
	<h2 class="text-center">테이블 정보</h2>

		<table class="table table-bordered text-center">
			<thead class="thead-dark">
				<tr>
					<th>테이블이름</th>
					<th>전체 행의 수</th>
				</tr>
			</thead>
			<tbody >
				<tr>
					<th>Departments</th>
					<th>${DepartmentsRowCount}</th>
				</tr>
				<tr>
					<th>Employees</th>
					<th>${EmployeesRowCount}</th>
				</tr>
				<tr>
					<th>Emp_manager</th>
					<th>${DeptManagerRowCount}</th>
				</tr>
				<tr>
					<th>Dept_emp</th>
					<th>${DeptEmpRowCount}</th>
				</tr>
				<tr>
					<th>Salaries</th>
					<th>${SalariesRowCount}</th>
				</tr>
				<tr>
					<th>Titles</th>
					<th>${TitlesRowCount}</th>
				</tr>
			</tbody>
		</table>

	
	<div>
		<ul class="b">
			<li><a class="nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
			<li><a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a></li>	
			<li>
				정렬 -> FirstName 
				<a class="nav-link" href="${pageContext.request.contextPath}/employees/EmployeesListOrderBy?order=asc">오름차순↑</a>
				<a class="nav-link" href="${pageContext.request.contextPath}/employees/EmployeesListOrderBy?order=desc">내림차순↓</a>
			</li>
			<li>
				정렬 -> LastName
				<a class="nav-link" href="${pageContext.request.contextPath}/employees/EmployeesListOrderBy?order=asc">오름차순↑</a>
				<a class="nav-link" href="${pageContext.request.contextPath}/employees/EmployeesListOrderBy?order=desc">내림차순↓</a>
			</li>
			<li><a href="${pageContext.request.contextPath}/titles/TitlesListDistinct">업무 목록(중복제거)</a></li>
			<li><a href="${pageContext.request.contextPath}/salaries/SalariesStatistics">연봉 통계값 {count,sum,avg,max,min,std}</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/EmployeesCountByGender">사원 수(Gender)</a></li>
			<li><a href="${pageContext.request.contextPath}/departments/DepartmentsCountByDeptNo">부서별 사원수</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/EmployeesListByPage">사원 목록 (페이징{10})</a></li>
		</ul>
	<div>
		<form action="${pageContext.request.contextPath}/employees/EmployeesListBetween" method="post">
			<input type ="number" name="begin"> ~ <input type ="number" name="end">
			<button type="submit">사원 검색</button>
			(${min} ~ ${max})
		</form>
	</div>
		<h3>employees total Row Count :	${EmployeesRowCount} </h3>
	</div>
</body>
</html>
</body>
</html>