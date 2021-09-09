<%@page import="com.g3.domain.OrderVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/allUser.jsp</title>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/allUser.jsp</h1>
	<h2>총 주문조회(AdminOrderController)</h2>
	
	<c:forEach var="ovo" items="${allOrdersOfAllUsersList }">
		<tr>
			<td><h3>주문 테이블</h3></td>
			<td>주문 테이블번호(o_num): ${ovo.o_num }</td> <br>
			
			
			<td><h3>주문정보</h3></td>			
			<td>주문번호(o_d_num): ${ovo.o_d_num }</td> <br>	
			<td>주문한 상품번호(o_p_num): ${ovo.o_p_num }</td> <br>	
			<td>주문한 상품이름(o_p_name): ${ovo.o_p_name }</td> <br>	
			<td>주문한 상품수량(o_p_amount): ${ovo.o_p_amount }</td> <br>	
			<td>주문한 상품옵션(o_p_option): ${ovo.o_p_option }</td> <br>	
			<td>주문한 아이디(u_id): ${ovo.u_id }</td> <br>	
			
			
			<td><h3>배송정보</h3></td>		
			<td>배송받는 사람이름(o_d_name): ${ovo.o_d_name }</td> <br>	
			<td>배송받는 주소(o_d_add): ${ovo.o_d_add }</td> <br>	
			<td>배송받는 전화번호(o_d_phone): ${ovo.o_d_phone }</td> <br>	
			<td>배송 메세지(o_d_msg): ${ovo.o_d_msg }</td> <br>
			
			
			<td><h3>결제정보</h3></td>		
			<td>총 결제금액(o_sum_money): ${ovo.o_sum_money }</td> <br>	
			<td>결제종류(o_acc_type): ${ovo.o_acc_type }</td> <br>	
			<td>결제하는 사람(o_acc_payer): ${ovo.o_acc_payer }</td> <br>	
			<td>결제하는 날짜(o_acc_date): ${ovo.o_acc_date }</td> <br>
			
			<td><h3>운송장정보</h3></td>							
			<td>운송장 번호(o_way_num): ${ovo.o_way_num }</td> <br>	
			<td>주문날짜(o_date): ${ovo.o_date }</td> <br>	
			<td>주문상태(o_status): ${ovo.o_status }</td> <br>	
								
			<hr><hr><hr>
		</tr>
	</c:forEach>
	
	
	
</body>
</html>
