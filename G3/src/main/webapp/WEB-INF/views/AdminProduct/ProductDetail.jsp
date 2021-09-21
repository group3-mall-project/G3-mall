<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">
<tr>
<th>상품번호</th>
<td>${avo.p_num }</td>
<th> 상품이름 
</th>
<td>
${avo.p_name }
</td>
<th>카테고리</th>
<td>${avo.p_category }</td>
</tr>
<tr>
<th>상품옵션</th>
<td>${avo.p_option}</td>
<th>상품가격</th>
<td>${avo.p_price }</td>
<th>상품수량</th>
<td>${avo.p_amount }</td>
</tr>
<tr>
<td colspan="6">${avo.p_content }</td>
</tr>
<tr>
<th>해외배송 소요 일수</th>
<td>${avo.ship_date }</td>
<th>반품시 고객 부담가격</th>
<td>${avo.p_return_fee }</td>
<th>이미지</th>
<td></td>
</tr>



</table>
   <h4><a href="./ProductSearchList?pgnum=${pgnum}">상품목록</a></h4>
   <h4><a href="./ProductUpdate?p_num=${avo.p_num}">상품수정</a></h4>
   <h4><a href="./delete?p_num=${avo.p_num}">삭제</a></h4>



</body>
</html>