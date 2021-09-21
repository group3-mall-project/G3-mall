<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/singleUserOrdersOuput.jsp</title>
	<script type="text/javascript">
		if(!!window.performance && window.performance.navigation.type == 2){
	    	window.location.reload();
		}
	</script>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/singleUserOrdersOuput.jsp</h1>
	<h2>회원별 주문조회(AdminOrderController)</h2>
	
	<h3>목록(총 <c:out default="0" value="${pvo.numOfItems }"/>개)</h3>
		
	<table border="1">
		<tr>
			<td>주문번호(o_d_num)</td>
			<td>상품명(o_p_name)</td>
			<td>상품번호(o_p_num)</td>
			<td>주문수량(o_p_amount)</td>
			<td>주문자 아이디(u_id)</td>
			<td>수령자(o_d_name)</td>
			<td>수령주소(o_d_add)</td>
			<td>결제금액(o_sum_money)</td>
			<td>결제일(o_acc_date)</td>
			<td>주문상태(o_status)</td>
			<td>운송장번호(o_way_num)</td>
		</tr>	
	
		<c:forEach var="ovo" items="${listOfOrdersOfUser }">
			<tr>
				<td>
					<a href="./orderDetailOutput?o_d_num=${ovo.o_d_num }&backDest=${backDest}&currentPageNum=${pvo.cri.currentPageNum }&u_id=${u_id}">${ovo.o_d_num }</a>
				</td> 	
				<td>${ovo.o_p_name }</td> 	
				<td>${ovo.o_p_num }</td> 	
				<td>${ovo.o_p_amount }</td> 
				<td>${ovo.u_id }</td> 
				<td>${ovo.o_d_name }</td> 
				<td>${ovo.o_d_add }</td> 
				<td>${ovo.o_sum_money }</td> 
				<td>${ovo.o_acc_date }</td> 
				<td>
					<c:if test="${ovo.o_status == 0 }">
						대기중
					</c:if>
					<c:if test="${ovo.o_status == 1 }">
						발송준비
					</c:if>
					<c:if test="${ovo.o_status == 2 }">
						발송완료
					</c:if>
					<c:if test="${ovo.o_status == 3 }">
						배송중
					</c:if>
					<c:if test="${ovo.o_status == 4 }">
						배송완료
					</c:if>
					<c:if test="${ovo.o_status == 5 }">
						주문취소
					</c:if>
				</td> 
				<td>${ovo.o_way_num }</td> 
			</tr>
		</c:forEach>
	</table>
	
	<c:if test="${pvo.pre }">
		<a href="./singleUserOrdersOutput?u_id=${u_id }&currentPageNum=${pvo.beginNumOfPage-1 }">&laquo;</a>
	</c:if>
	<c:forEach begin="${pvo.beginNumOfPage }" end="${pvo.endNumOfPage }" var="i">
		<a href="./singleUserOrdersOutput?u_id=${u_id }&currentPageNum=${i }">${i }</a>
	</c:forEach>
	<c:if test="${pvo.nxt }">
		<a href="./singleUserOrdersOutput?u_id=${u_id }&currentPageNum=${pvo.endNumOfPage+1 }">&raquo;</a>
	</c:if>
</body>
</html>