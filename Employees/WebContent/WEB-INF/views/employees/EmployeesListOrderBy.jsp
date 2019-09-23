<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>getEmployeesListOrderBy</title>
</head>
<body class="container">
	<h1 class="text-center text-success">사원 정렬</h1>
	<div>
		<a class="nav-link" href="${pageContext.request.contextPath}/">홈</a>
	</div>
	
	<table class="table text-center">
		<thead class="thead-dark">
			<tr>
				<th>사원 번호</th>
				<th>사원 생일</th>
				<th>사원 성</th>
				<th>사원 이름</th>
				<th>사원 성별</th>
				<th>사원 입사일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employees" items="${list}">
				<tr>
					<th>${employees.empNo}</th>
					<th>${employees.birthDate}</th>
					<th>${employees.firstName}</th>
					<th>${employees.lastName}</th>
					<th>${employees.gender}</th>
					<th>${employees.hireDate}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>