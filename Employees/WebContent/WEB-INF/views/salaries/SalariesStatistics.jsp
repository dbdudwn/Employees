<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SalariesStatistics</title>
</head>
<body>
	<h1>연봉 집계 (count , sum , avg , max , min , std)</h1>
	<div>
		<a href="${pageContext.request.contextPath}/">홈</a>
	</div>
	<table border="1">
		<thead>
			<tr>
				<th>count</th>
				<th>sum</th>
				<th>avg</th>
				<th>max</th>
				<th>min</th>
				<th>std</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>${map.count}</th>
				<th>${map.sum}</th>
				<th>${map.avg}</th>
				<th>${map.max}</th>
				<th>${map.min}</th>
				<th>${map.std}</th>
			</tr>
		</tbody>
	</table>
</body>
</html>