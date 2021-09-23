<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/orderSearchOutput.jsp</title>
    <!--jQuery 라이브러리 추가-->
    <script
	  src="https://code.jquery.com/jquery-3.6.0.js"
	  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	  crossorigin="anonymous">
    </script>
    <!--jQuery 라이브러리 추가-->
        
	<script type="text/javascript">
		if(!!window.performance && window.performance.navigation.type == 2){
	    	window.location.reload();
	    	// !!는 변수를 불리언으로 형변환하는 방법
		}
		
		$(document).ready(function(){
			$("select").change(function(){
				var numOfItemsPerPage = $(this).val();
				self.location = "./orderSearchOutput?numOfItemsPerPage="+numOfItemsPerPage;
			});
		});
	</script>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/orderSearchOutput.jsp</h1>
	<h2>주문검색(AdminOrderController)</h2>
	<h3>목록(총 <c:out default="0" value="${pvo.numOfItems }"/>개)</h3>
	
	<select id="numOfItemsPerPage" name="numOfItemsPerPage">
		<option value="">선택</option>
		<option value="5">5개씩 보기</option>
		<option value="10">10개씩 보기</option>
		<option value="50">50개씩 보기</option>
		<option value="100">100개씩 보기</option>	
	</select>		
	
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
	
		<c:forEach var="ovo" items="${listOfOrderSearch }">
			<tr>
				<td>
					<a href="./orderDetailOutput?o_d_num=${ovo.o_d_num }&backDest=${backDest}&currentPageNum=${pvo.cri.currentPageNum }&numOfItemsPerPage=${pvo.cri.numOfItemsPerPage }">${ovo.o_d_num }</a>
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
		<a href="./orderSearchOutput?numOfItemsPerPage=${pvo.cri.numOfItemsPerPage }&currentPageNum=${pvo.beginNumOfPage-1 }">&laquo;</a>
	</c:if>
	<c:forEach begin="${pvo.beginNumOfPage }" end="${pvo.endNumOfPage }" var="i">
		<a href="./orderSearchOutput?numOfItemsPerPage=${pvo.cri.numOfItemsPerPage }&currentPageNum=${i }">${i }</a>
	</c:forEach>
	<c:if test="${pvo.nxt }">
		<a href="./orderSearchOutput?numOfItemsPerPage=${pvo.cri.numOfItemsPerPage }&currentPageNum=${pvo.endNumOfPage+1 }">&raquo;</a>
	</c:if>
</body>
</html>