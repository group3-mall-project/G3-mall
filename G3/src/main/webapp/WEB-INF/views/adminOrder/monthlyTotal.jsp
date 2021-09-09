<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/monthlyTotal.jsp</title>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/monthlyTotal.jsp</h1>
	<h2>월별정산(AdminOrderController)</h2>

	<c:forEach var="ovo" items="${monthlySumTotalList }">
		<table border="1">
			<tr>
				<td>월별정산</td>
				<td>연</td>
				<td>월</td>
			</tr>
			<tr>
				<td>${ovo.o_sum_money }</td>
				<td>${ovo.o_p_num }</td>
				<td>${ovo.o_p_amount }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>
