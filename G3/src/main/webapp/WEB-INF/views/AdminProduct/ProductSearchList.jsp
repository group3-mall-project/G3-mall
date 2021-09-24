<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>productList</h1>

<h4><a href="./addProduct">상품등록</a></h4>
<table border="1" >
 <thead>
  <tr>
   <th>상품번호</th>
   <th>썸네일</th>
   <th>상품이름</th>
   <th>카테고리</th>
   <th>가격</th>
   <th>수량</th>
   <th>등록날짜</th>
   <th>수정/삭제</th>

   
  </tr>
 </thead>
 <tbody>
  <c:forEach items="${list}" var="list">
  <tr>
   <td>${list.p_num}</td>
   <td>
   <img src="${pageContext.request.contextPath }/resources/${list.p_thumbimg}">
   </td>
   <td>
<a href="./ProductDetail?p_num=${list.p_num}&pgnum=${select}">${list.p_name}</a>   
	</td>
   <td>
<%--    <option value="${list.p_category}" ${list.p_category == provider ? 'selected="selected"' : '' }>${list.p_category}</option> --%>
   ${list.cate_name}
   </td>

   <td>${list.p_price}</td>
   <td>${list.p_amount}</td>
   <td>${list.p_date}</td>
<!--    <td><a href="./update">수정</a>/<a href="./delete">삭제</a></td> -->
   <td><a href="./ProductUpdate?p_num=${list.p_num}&pgnum=${select}">수정</a>/<a href="./delete?p_num=${list.p_num}">삭제</a></td>

  </tr>   
  </c:forEach>
 </tbody>
</table>
<div>
<!-- 페이징 처리를 위한 코드 -->
<c:if test="${prev}">
 <span>[ <a href="./ProductSearchList?pgnum=${startPageNum - 1}${searchTypeKeyword}">이전</a> ]</span>
</c:if>

<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
 <span>
 
  <c:if test="${select != num}">
   <a href="./ProductSearchList?pgnum=${num}${searchTypeKeyword}">${num}</a>
  </c:if>    
  
  <c:if test="${select == num}">
   <b>${num}</b>
  </c:if>
    
 </span>
</c:forEach>
<c:if test="${next}">
 <span>[ <a href="./ProductSearchList?pgnum=${endPageNum + 1}${searchTypeKeyword}">다음</a> ]</span>
</c:if>

<!-- 이전 버튼과 다음버튼을 만들기전에 만들어놓은 코드 -->
<%--  <c:forEach begin="1" end="${pageNum}" var="p_num"> --%>
<!--     <span> -->
<%--      <a href="./ProductList?p_num=${p_num}">${p_num}</a> --%>
<!--   </span> -->
<%--  </c:forEach> --%>

<!-- 검색 -->
<div>
  <select name="searchType">
      <option value="p_name">상품이름</option>
         <option value="p_content">내용</option>
      <option value="productname_content">상품이름+내용</option>
      
  </select>
  
  <input type="text" name="keyword" value=${keyword }/>
  
  <button type="button" id="searchBtn">검색</button>
 </div>
</div>
<script>

 document.getElementById("searchBtn").onclick = function () {
    
  let searchType = document.getElementsByName("searchType")[0].value;
  let keyword =  document.getElementsByName("keyword")[0].value;
  
  location.href = "./ProductSearchList?pgnum=1" + "&searchType=" + searchType + "&keyword=" + keyword;
 };
</script>

</body>
</html>