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
<title>DepartmentsCountByDeptNo</title>
</head>
<body>
	<h1 class="text-center text-success">부서 목록</h1>
	<table class="table table-bordered text-center">
		<thead class="thead-dark">
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>부서 인원</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<th>${list.dno}</th>
						<th>${list.dna}</th>
						<th>${list.cnt}</th>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<div>
		<a href="${pageContext.request.contextPath}">홈</a>
	</div>
</body>
</html>