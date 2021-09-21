<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
 <script src="https://cdn.ckeditor.com/ckeditor5/26.0.0/classic/ckeditor.js"></script>
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>﻿

</head>
<body>

<h1>수정하기</h1>
  <fieldset>
      <form action="./ProductUpdate" method="post" >
      <input type="hidden" name="p_num" value="${avo.p_num}">
         상품이름 : <input type="text" name="p_name" value="${avo.p_name }"><br>
		 카테고리 : <select name="p_category">
					<option value="eat"> 식비
					<option value="must"> 생필품
					<option value="play"> 여가
					<option value="etc"> 기타 
 				  </select><br>
         상품옵션 : <input type="text" name="p_option" value="${avo.p_option }"><br>
         상품가격 : <input type="text" name="p_price" value="${avo.p_price }"><br>
         상품수량 : <input type="text" name="p_amount" value="${avo.p_amount} "><br>
	     내용 :<textarea name="p_content" id="bookIntro_textarea">${avo.p_content }</textarea><br>
	     상품이미지 : <input type="file" multiple id ="file" name="file" style="height: 30px;">
         해외배송소요일수: <input type="text" name="ship_date"value="${avo.ship_date }"><br>
         반품시 고객부담가격:<input type="text" name="p_return_fee" value="${avo.p_return_fee }"><br>
         <hr>
          <input type="submit" value="수정하기">
      </form>
   </fieldset>
   <h4><a href="./ProductSearchList?pgnum=${pgnum} ">상품목록</a></h4>
<script >




ClassicEditor
.create(document.querySelector('#bookIntro_textarea'))
.catch(error=>{
   console.error(error);
});





</script>
<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>
<script type="text/javascript">




let regex = new RegExp("(.*?)\.(jpg|png)$");
let maxSize = 1048576; //1MB	

function fileCheck(fileName, fileSize){

	if(fileSize >= maxSize){
		alert("파일 사이즈 초과");
		return false;
	}
		  
	if(!regex.test(fileName)){
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	
	return true;	
	
}
	
	/* 이미지 업로드 */

  $('input[type="file"]').change(function(e) {
        let fileName = e.target.files[0].name;
       alert('The file name is : "' + fileName);
      });
});

</script>





</body>
</html>