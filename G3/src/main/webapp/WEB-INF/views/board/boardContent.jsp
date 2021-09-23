<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE>
<html>
<head>
<style type="text/css">
.ck.ck_editor{
	max-width: 1000px;
}

.ck-editor_editable {
	min-height: 800px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../resources/ckeditor/ckeditor.js"></script>
<title>게시판</title>
</head>
<body>

	
	<input type = "button" value = "전체" onclick = "location.href='../board/boardList'; " >
	<input type = "button" value = "공지" onclick = "location.href='../board/boardCategory?category=공지'; " >
	<input type = "button" value = "상품리뷰" onclick = "location.href='../board/boardCategory?category=상품리뷰'; " >
	<input type = "button" value = "상품문의" onclick = "location.href='../board/boardCategory?category=상품문의'; " >
		
<hr><hr>
	<form action="" method="get" >
		<input type = "hidden" name = "bo_num" value="${vo.bo_num }">
		<table border="1">
			<tr>
				<td  width="100">ID</td>
				<td><input type="text" name="u_id" value="${vo.u_id }"></td>
			</tr>
		
    		<tr>
     			<td>category</td>
     			<td>
     			<input type="text" name="bo_category" value="${vo.bo_category }">
     		
    		</tr>
    		<c:if test="${vo.bo_category == '상품리뷰' }">
    		<tr>
    			<td>rating</td>
    			<td><c:if test="${vo.bo_p_rating ==1 }">★☆☆☆☆	</c:if>
    			<c:if test="${vo.bo_p_rating ==2 }">★★☆☆☆</c:if>
    			<c:if test="${vo.bo_p_rating ==3 }">★★★☆☆	</c:if>
    			<c:if test="${vo.bo_p_rating ==4 }">★★★★☆	</c:if>
    			<c:if test="${vo.bo_p_rating ==5 }">★★★★★	</c:if></td>
    			
    			
    		</tr>
    		</c:if>
    		<tr>
    			<td>subject</td>
    			<td><input type="text" name="bo_subject"  id="subject" value="${vo.bo_subject }" ></td>
    		</tr>
    		
    	
    		<tr>
     			<td>Content</td>
     		<%-- 	<td><textarea name=bo_content rows ="100" cols="100" id="content" >${bovo.bo_content }</textarea></td> --%>
     			<td ><div contenteditable="true" id="bo_content" class="img" style="font-size: large;" >${vo.bo_content }
     				 <c:set var="img" value="${vo.bo_p_image}"/>
						<c:if test="${img != null }">
						<div class="inputArea">
						
						 
						 <img src="../resources/${vo.bo_p_image}" class="oriImg" width="500px" height="500px" />
						
						 
						 <p>썸네일</p>
						 <img src="../resources/${vo.bo_p_thumbImg}" class="thumbImg"/>
						</div>
						</c:if>
     			
     			
     			</div>
     			</td>
     			
    			<!-- <script>
				 var ckeditor_config = {
				   resize_enaleb : true,
				   enterMode : CKEDITOR.ENTER_BR,
				   shiftEnterMode : CKEDITOR.ENTER_P,
				   filebrowserUploadUrl : "../board/ckUpload"
				 };
				 CKEDITOR.replace("bo_content", ckeditor_config);
				</script> -->
    		
    		</tr>
   			<tr>
     			<td colspan=2><hr size=1></td>
    		</tr>
    		
		</table>
	
		
		
	</form> 
	<%-- <c:set var="u_id" value="${bovo.u_id }"/> 회원모듈 연결시 작성한 회원일 경우만 수정 삭제 버튼 활성화 
	<c:set var="id" value="${id }" />
	<c:if test="${id==u_id}" > --%>
	
	<input type = "button" value = "수정하기" onclick = "location.href='../board/modify?bo_num=${vo.bo_num}'" >
	<input type = "button" value = "삭제하기" onclick = "deleteContent(); " >
	<%-- </c:if> --%>
	<script type="text/javascript">
	function deleteContent() {
		var cf = confirm("삭제하시겠습니까?");
		if(cf==true){
			location.href="deleteContent?bo_num=${bovo.bo_num}";
		}
		
	}
	
	
	</script>
	
	
	
	<input type = "button" value = "답글달기" onclick = "location.href='../board/reBoardWrite?bo_num=${vo.bo_num}'; " >
	
	<a href="../board/boardList"> <h3>목록으로</h3> </a>
	
	
	

</body>
</html>