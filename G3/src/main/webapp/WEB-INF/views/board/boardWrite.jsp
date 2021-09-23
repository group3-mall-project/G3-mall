<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>
<script type="text/javascript"></script>
<script src="../resources/ckeditor/ckeditor.js"></script>

</head>
<body>

	
	<h3>고객 게시판</h3>
	<input type = "button" value = "전체" onclick = "location.href='../board/boardList'; " >
	<input type = "button" value = "공지" onclick = "location.href='../board/boardCategory?category=공지'; " >
	<input type = "button" value = "상품리뷰" onclick = "location.href='../board/boardCategory?category=상품리뷰'; " >
	<input type = "button" value = "상품문의" onclick = "location.href='../board/boardCategory?category=상품문의'; " >
		
<hr><hr>
	<form action="" method="post" enctype="multipart/form-data" >
		<table border="1">
			<tr>
				<td  width="100">ID</td>
				<td><input type="text" name="u_id" value="${id }"></td>
			</tr>
					
    		<tr>
     			<td>Subject</td>
     			<td>
     			<select name="bo_category">
     			<c:set var="id" value="${id }" />
     			<c:if test="${id=='admin' }" >
     				<option value="공지">공지</option>
     			</c:if>	
     				<option value="상품리뷰">상품리뷰
     				
     				
     				</option>
     				<option value="상품문의">상품문의
     			
     				</option>
       			</select>
     			<input type="text" name="bo_subject" size="30" id="subject" ></td>
    		</tr>
    		
    		
    		<tr>
     			<td>rating</td>
     			<td>
     			<select name="bo_p_rating">
     			
     				<option value=1>★☆☆☆☆</option>
     				<option value=2>★★☆☆☆</option>
     				<option value=3>★★★☆☆</option>
     				<option value=4>★★★★☆</option>
     				<option value=5>★★★★★</option>
       			</select>
     			
    		</tr>
    		
    		<tr>
     			<td>Content</td>
     			<td><textarea name= "bo_content" id = "bo_content" rows ="30" cols="100" id="content" maxlength="200"></textarea></td>
	    		<script>
				 var ckeditor_config = {
				   resize_enaleb : false,
				   enterMode : CKEDITOR.ENTER_BR,
				   shiftEnterMode : CKEDITOR.ENTER_P,
				   filebrowserUploadUrl : "../board/ckUpload"
				 };
				 
				 CKEDITOR.replace("bo_content", ckeditor_config);
				</script>
    		
    		</tr>
   			<tr>
     			<td>Upload</td>
     			<td><div class="inputArea">
			 <input type="file" id="bo_p_image" name="file" />
			 <div class="select_img"><img src="" /></div></div></td>
    		</tr>
    		
		</table>
		
			 
			 <script>
			  $("#bo_p_image").change(function(){
			   if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) {
			     $(".select_img img").attr("src", data.target.result).width(500);        
			    };
			    reader.readAsDataURL(this.files[0]);
			   };
			  });
			 </script>
			 
			 <%-- <%=request.getRealPath("/") %> --%>
</div>
		
     			<div align="center">
     			<input type="submit" value="등록" >&nbsp;&nbsp;
         		<input type="button" value="게시글 목록" onclick="location.href='../board/boardList'; ">
     			</div>
    		
    		
		
		
	</form> 

</body>
</html>