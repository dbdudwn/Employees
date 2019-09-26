<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<meta charset="UTF-8">
<title>DeptEmpList</title>
</head>
<body class="container">
	<h1 class="text-center text-success">사원 목록 ()</h1>
	<div>
		<a class="nav-link" href="${pageContext.request.contextPath}/">홈</a>
	</div>
	<table class="table table-bordered text-center">
		<thead class="thead-dark">
			<tr>
				<th>부서 번호</th>				
				<th>부서 이름</th>
				<th>사원 번호</th>
				<th>사원 이름</th>
				<th>부서 배정일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}">
			<tr>
				<th>${list.departments.deptNo}</th>				
				<th>${list.departments.deptName}</th>
				<th>${list.employees.empNo}</th>
				<th>${list.employees.firstName}</th>
				<th>${list.toDate}</th>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${currentPage > 1 }">
		<a href="${pageContext.request.contextPath}/deptemp/DeptEmpList?currentPage=${currentPage-1}">이전</a>
	</c:if>
	<c:if test="${currentPage < lastPage }">
		<a href="${pageContext.request.contextPath}/deptemp/DeptEmpList?currentPage=${currentPage+1}">다음</a>
	</c:if>
</body>
</html>