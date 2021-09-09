<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/dailyTotal.jsp</title>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/dailyTotal.jsp</h1>
	<h2>일일정산(AdminOrderController)</h2>
	
	<c:forEach var="ovo" items="${dailySumTotalList }">
		<table border="1">
			<tr>
				<td>일일정산</td>
				<td>날짜</td>
			</tr>
			<tr>
				<td>${ovo.o_sum_money }</td>
				<td>${ovo.o_acc_date }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>
