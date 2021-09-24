<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	
	<input type = "button" value = "전체" onclick = "location.href='../board/boardList'; " >
	<input type = "button" value = "공지" onclick = "location.href='../board/boardCategory?category=공지'; " >
	<input type = "button" value = "상품리뷰" onclick = "location.href='../board/boardCategory?category=상품리뷰'; " >
	<input type = "button" value = "상품문의" onclick = "location.href='../board/boardCategory?category=상품문의'; " >
		
<hr><hr>
	<form action="" method="post" >
		<%-- <input type="hidden" name="bo_re_ref" value="${bo_num }"> --%>
		<table border="1">
			<tr>
				<td  width="100">ID</td>
				<td><input type="text" name="u_id" value="${id }"></td>
			</tr>
		
    		<tr>
     			<td>Subject</td>
     			<td>
     			
     			
     	 		<select name="bo_category">
     				<option value="상품리뷰">답글</option>
       			</select>
     			<input type="text" name="bo_subject" size="30" id="subject" ></td>
    		</tr>
    		<tr>
     			<td>Content</td>
     			<td><textarea name=bo_content rows ="30" cols="100" id="content" maxlength="200"></textarea></td>
    		</tr>
   			<tr>
     			<td colspan=2><hr size=1></td>
    		</tr>
    		<tr>
     			<td colspan="2"><div align="center">
     			<input type="submit" value="등록" >&nbsp;&nbsp;
         		<input type="button" value="게시글 목록" onclick="location.href='./boardList';"></div>
     			</td>
    		</tr> 
		</table>
	</form> 

</body>
</html>