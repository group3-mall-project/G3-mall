<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<input type = "button" value = "전체" onclick = "location.href='../board/boardList'; " >
	<input type = "button" value = "공지" onclick = "location.href='../board/boardCategory?category=공지'; " >
	<input type = "button" value = "상품리뷰" onclick = "location.href='../board/boardCategory?category=상품리뷰'; " >
	<input type = "button" value = "상품문의" onclick = "location.href='../board/boardCategory?category=상품문의'; " >
		
<hr><hr>
	

	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>분류</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>날짜</td>
			<td>조회수</td>
			
		</tr>
		<c:forEach var="board" items="${boardList}" >
		
		<tr>
			 <c:set value="" var="wid" />
			<c:set value="0" var="wid11" />
			 
			<c:if test="${board.bo_re_seq > wid11}">
			 <c:set value="└[답변]" var="wid" />
			
			
			</c:if>
			
			
		
		
		
			<td>${board.bo_num}</td>
			<td>${board.bo_category}</td>
			<td><c:out value="${wid}"/><a href="./boardContent?bo_num=${board.bo_num}">${board.bo_subject}</a></td>
			<td>${board.u_id}</td>
			<td>${board.bo_updatedate}</td>
			<fmt:parseDate var="parseRegDate" value="${board.bo_updatedate}" pattern="yyyy-MM-dd"/>
			
			<td>${board.bo_readcount}  </td>
		</tr>
		</c:forEach>
	</table>
	<a href="./boardWrite"> 글쓰기 </a><br>

	<a href="../board/boardList"> <h3>목록으로</h3> </a>


</body>
</html>