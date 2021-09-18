<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/orderSearchOutput.jsp</title>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/orderSearchOutput.jsp</h1>
	<h2>주문검색(AdminOrderController)</h2>
	
	<h3>목록(총 <c:out default="0" value="${numOfItems }"/>개)</h3>
		
	<table border="1">
		<tr>
			<td>주문번호(o_d_num)</td>
			<td>상품명(o_p_name)</td>
			<td>주문수량(o_p_amount)</td>
			<td>주문자(u_id)</td>
			<td>수령자(o_d_name)</td>
			<td>수령주소(o_d_add)</td>
			<td>결제금액(o_sum_money)</td>
			<td>결제일(o_acc_date)</td>
			<td>주문상태(o_status)</td>
			<td>운송장번호(o_way_num)</td>
		</tr>	
	
		<c:forEach var="ovo" items="${listOfOrderSearch }">
			<tr>
				<td>
					<a href="./orderDetailOutput?o_d_num=${ovo.o_d_num }">${ovo.o_d_num }</a>
				</td> 	
				<td>${ovo.o_p_name }</td> 	
				<td>${ovo.o_p_amount }</td> 
				<td>${ovo.u_id }</td> 
				<td>${ovo.o_d_name }</td> 
				<td>${ovo.o_d_add }</td> 
				<td>${ovo.o_sum_money }</td> 
				<td>${ovo.o_acc_date }</td> 
				<td>${ovo.o_status }</td> 
				<td>${ovo.o_way_num }</td> 
			</tr>
		</c:forEach>
	</table>
		
	<c:if test="${numOfItems > 0 }">
		<c:if test="${beginNumOfPage > numOfPagesPerPage }">
			<a href="./orderSearchOutput?currentPageNum=${beginNumOfPage-numOfPagesPerPage }">[이전]</a>
		</c:if>
		
		<c:forEach begin="${beginNumOfPage }" end="${endNumOfPage }" step="1" var="i">
			<a href="./orderSearchOutput?currentPageNum=${i }">[${i }]</a>
		</c:forEach>
		
		<c:if test="${endNumOfPage < numOfPages }">
			<a href="./orderSearchOutput?currentPageNum=${beginNumOfPage+numOfPagesPerPage }">[다음]</a>
		</c:if>
	</c:if>
</body>
</html>