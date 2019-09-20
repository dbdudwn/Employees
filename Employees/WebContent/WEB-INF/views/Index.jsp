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
	<div>
		<ul class="b">
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a></li>
		</ul>
	</div>
	
	<div>
		EL ->	employees total Row Count :	${employeesRowCount} 
		<br>
		<!--  표현식 ->	employees total Row Count :	<%=request.getAttribute("employeesRowCount")%> -->
	</div>
</body>
</html>
</body>
</html>