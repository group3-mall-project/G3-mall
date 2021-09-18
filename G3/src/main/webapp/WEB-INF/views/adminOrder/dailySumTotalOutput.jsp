<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/dailySumTotalOutput.jsp</title>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/dailySumTotalOutput.jsp</h1>
	<h2>일일정산(AdminOrderController)</h2>
	
	<h3>목록(총 <c:out default="0" value="${pvo.numOfItems }"/>개)</h3>
	
	<c:forEach var="ovo" items="${listOfDailySumTotal }">
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
	
	<c:if test="${pvo.pre }">
		<a href="./dailySumTotalOutput?currentPageNum=${pvo.beginNumOfPage-1 }">&laquo;</a>
	</c:if>
	<c:forEach begin="${pvo.beginNumOfPage }" end="${pvo.endNumOfPage }" var="i">
		<a href="./dailySumTotalOutput?currentPageNum=${i }">${i }</a>
	</c:forEach>
	<c:if test="${pvo.nxt }">
		<a href="./dailySumTotalOutput?currentPageNum=${pvo.endNumOfPage+1 }">&raquo;</a>
	</c:if>	
</body>
</html>