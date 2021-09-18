<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/monthlySumTotalOutput.jsp</title>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/monthlySumTotalOutput.jsp</h1>
	<h2>월별정산(AdminOrderController)</h2>

	<h3>목록(총 <c:out default="0" value="${pvo.numOfItems }"/>개)</h3>

	<c:forEach var="ovo" items="${listOfMonthlySumTotal }">
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

	<c:if test="${pvo.pre }">
		<a href="./monthlySumTotalOutput?currentPageNum=${pvo.beginNumOfPage-1 }">&laquo;</a>
	</c:if>
	<c:forEach begin="${pvo.beginNumOfPage }" end="${pvo.endNumOfPage }" var="i">
		<a href="./monthlySumTotalOutput?currentPageNum=${i }">${i }</a>
	</c:forEach>
	<c:if test="${pvo.nxt }">
		<a href="./monthlySumTotalOutput?currentPageNum=${pvo.endNumOfPage+1 }">&raquo;</a>
	</c:if>		
</body>
</html>