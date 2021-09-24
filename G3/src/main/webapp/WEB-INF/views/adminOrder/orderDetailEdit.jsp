<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/orderDetailEdit.jsp</title>

    <!--jQuery 라이브러리 추가-->
    <script
	  src="https://code.jquery.com/jquery-3.6.0.js"
	  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	  crossorigin="anonymous">
    </script>
    
	<script type="text/javascript">
		$(document).ready(function(){
			var fr = $("#orderDetailEditForm");
			var o_d_num = "${o_d_num }";
			var backDest = "${backDest }";
			var currentPageNum = "${currentPageNum }";
			var numOfItemsPerPage = "${numOfItemsPerPage }";
			var u_id = "${u_id}";

			
			$("#edit").click(function(){
				fr.submit();
			});
			
			$("#cancel").click(function(){
				self.location = "./orderDetailOutput?o_d_num="+o_d_num+"&backDest="+backDest+"&currentPageNum="+currentPageNum+"&numOfItemsPerPage="+numOfItemsPerPage+"&u_id="+u_id;
			});
		});
	</script>
</head>
<body>
	<h1>WEB-INF/views/adminOrder/orderDetailEdit.jsp</h1>
	<h2>주문 상세정보 수정(AdminOrderController)</h2>
	
	<form action="" id="orderDetailEditForm" method="post">
		<c:set var="ovo1st" value="${listOfOrderDetail.get(0) }"/>
		
<%-- 		<input type="hidden" name="o_d_num" value="${ovo1st.o_d_num }">
		<input type="hidden" name="backDest" value="${backDest }"> 
		<input type="hidden" name="currentPageNum" value="${currentPageNum }"> 
		<input type="hidden" name="u_id" value="${u_id }">  --%>
				
		<table border="1">
			<tr>
				<td colspan="6">
					<h3>주문정보</h3>
				</td>
			</tr>
				
			<tr>
				<td>주문번호</td>
				<td>상품번호</td>
				<td>상품명</td>
				<td>구매수량</td>
				<td>상품옵션</td>
				<td>주문자 아이디</td>			
			</tr>
			
			<c:set var="sumTotal" value="${0 }"/>
			<c:forEach var="ovo" items="${listOfOrderDetail }">
				<c:set var="sumTotal" value="${sumTotal+ovo.o_sum_money }"/>
				
				<tr>
					<td>${ovo1st.o_d_num }</td>
					<td>${ovo.o_p_num }</td> 
					<td>${ovo.o_p_name }</td> 	
					<td>${ovo.o_p_amount }</td> 
					<td>${ovo.o_p_option }</td> 
					<td>${ovo.u_id }</td>
				</tr>
			</c:forEach>
		

			<tr>
				<td colspan="6">
					<h3>배송정보</h3>
				</td>
			</tr>
			
			
			<tr>
				<td colspan="6">
					<h5>수령자 이름: ${ovo1st.o_d_name }</h5>				
					<h5>전화번호: ${ovo1st.o_d_phone }</h5>				
					<h5>수령주소: ${ovo1st.o_d_add }</h5>								
					<h5>요청사항: ${ovo1st.o_d_msg }</h5>				
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<h3>결제정보</h3>
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<h5>결제금액: ${sumTotal }</h5>
					<h5>결제방법: ${ovo1st.o_acc_type }</h5>
					<h5>운송장 번호: ${ovo1st.o_way_num } </h5>
					<h5>주문상태:
						<select name="o_status" id="o_status">
							<option value="0" <c:if test="${ovo1st.o_status == 0 }"/>>대기중</option>
							<option value="1" <c:if test="${ovo1st.o_status == 1 }"/>>발송준비</option>
							<option value="2" <c:if test="${ovo1st.o_status == 2 }"/>>발송완료</option>
							<option value="3" <c:if test="${ovo1st.o_status == 3 }"/>>배송중</option>
							<option value="4" <c:if test="${ovo1st.o_status == 4 }"/>>배송완료</option>
							<option value="5" <c:if test="${ovo1st.o_status == 5 }"/>>주문취소</option>
						</select>
					</h5>
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<button type="submit" id="edit">수정하기</button>
					<button type="button" id="cancel">취소하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>