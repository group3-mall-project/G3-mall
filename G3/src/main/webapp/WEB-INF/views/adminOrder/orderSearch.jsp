<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/orderSearch.jsp</title>

    <!--jQuery 라이브러리 추가-->
    <script
	  src="https://code.jquery.com/jquery-3.6.0.js"
	  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	  crossorigin="anonymous">
    </script>
    <!--jQuery 라이브러리 추가-->
        
    <!--jQuery 사용-->
	<script type="text/javascript">
		$(document).ready(function(){
			$("form").submit(function(){
				
				if($("#queryPeriod").val() !== ""){ // 사용자 지정 X
					// 모든 조건 선택 -> false
					if($("#beginningDate").val() !== "" && $("#endDate").val() !== ""){
						alert("1가지 조건만 선택할 수 있습니다.");
						return false; 
					// 날짜를 하나라도 지정 -> false
					}else if($("#beginningDate").val() !== "" || $("#endDate").val() !== ""){				
						alert("날짜를 지정할 수 없습니다.");						
						return false;
					}
					
				}else{ // 사용자 지정 O
					// 옵션에서 선택 -> false
					if($("#beginningDate").val() === "" && $("#endDate").val() === ""){
						alert("조회기간을 선택하세요.");
						return false;
					}else if($("#beginningDate").val() === "" && $("#endDate").val() !== ""){
						alert("시작날을 선택하세요.");
						return false;
					}else if($("#beginningDate").val() !== "" && $("#endDate").val() === ""){
						alert("끝날을 선택하세요.");
						return false;
					}else{
						if($("#beginningDate").val() > $("#endDate").val()){
							alert("시작날이 끝날보다 앞서야 합니다.");
							return false;
						}
					}
				}
				
				
				if($("#advancedSearch").val() === ""){
					alert("상세조건을 입력하세요.");
					return false;
				}
				
				
				if($("#searchQuery").val() === ""){
					alert("검색내용을 입력하세요.");
					return false;
				}
			});
		});
	</script>
    <!--jQuery 사용-->	
</head>
<body>
	<h1>WEB-INF/views/adminOrder/orderSearch.jsp</h1>
	<h2>주문검색(AdminOrderController)</h2>
	
	<form action="" method="post">
		<h3>조회기간(결제일 기준으로 조회, 1가지 조건만 선택하세요.)</h3>
		<select name="queryPeriod" id="queryPeriod">
			<option value="">선택하세요</option>
			<option value="today">오늘</option>
			<option value="oneWeek">1주일</option>
			<option value="oneMonth">1개월</option>
			<option value="threeMonths">3개월</option>
		</select>
		<br><br>
		<input type="date" name="beginningDate" id="beginningDate" min="2000-01-01" max="2099-12-31"> ~  <input type="date" name="endDate" id="endDate" min="2000-01-01" max="2099-12-31">
		<br><br>
		
		<h3>상세조건</h3>
		<select name="advancedSearch" id="advancedSearch">
			<option value="">선택하세요</option>
			<option value="receiverName">수령자</option>
			<option value="payerId">주문자 아이디</option>
			<option value="orderNumber">주문번호</option>
			<option value="productNumber">상품번호</option>			
			<option value="trackingNumber">운송장번호</option>			
		</select>
		<input type="text" name="searchQuery" id="searchQuery">
		<br><br>

		<input type="submit" value="검색">
	</form>	
	
</body>
</html>