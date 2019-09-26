<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Login</title>
</head>
<body class="container">
	<h1 class="text-center text-success">Login</h1>
	<div>
		<a class="nav-link" href="${pageContext.request.contextPath}/">홈</a>
	</div>
	<form method="post" action="${pageContext.request.contextPath}/login">
		<table class="table table-bordered text-center">
			<thead class="thead-dark">
				<tr>
					<th>EmpNo :</th>
					<th><input type="text" name="empNo"></th>
				</tr>
				<tr>
					<th>FirstName :</th>
					<th><input type="text" name="firstName"></th>
				</tr>
				<tr>
					<th>LastName:</th>
					<th><input type="text" name="lastName"></th>
				</tr>
				
			</thead>
		</table>		
			<button type="submit">로그인</button>
	</form>
</body>
</html>