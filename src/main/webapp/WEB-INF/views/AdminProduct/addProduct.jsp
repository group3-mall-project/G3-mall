<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="../resources/ckeditor/ckeditor.js"></script>

<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>

<h1>addProduct.jsp</h1>
  <fieldset>
      <form action="./addProduct" method="post" enctype="multipart/form-data" >
         상품이름 : <input type="text" name="p_name"><br>
		 카테고리 : <select name="p_category">
					<option value="eat"> 식비
					<option value="must"> 생필품
					<option value="play"> 여가
					<option value="etc"> 기타 
 				  </select><br>
         상품옵션 : <input type="text" name="p_option" ><br>
         상품가격 : <input type="text" name="p_price"><br>
         상품수량 : <input type="text" name="p_amount"><br>
	     내용 :<textarea name="p_content" id="p_content"></textarea><br>
	     상품이미지 : <input type="file" multiple="multiple" id ="file" name="file" style="height: 30px;"><br>
	     썸네일이미지 : <div class="select_img"><img src="" /></div>
		<%=request.getRealPath("/") %><br>
         해외배송소요일수: <input type="text" name="ship_date"><br>
         반품시 고객부담가격:<input type="text" name="p_return_fee"><br>
         
          <input type="submit" value="상품등록">
      </form>
   </fieldset>
   <h4><a href="./ProductList?pgnum=1">상품목록</a></h4>

<script>
 var ckeditor_config = {
   resize_enaleb : false,
   enterMode : CKEDITOR.ENTER_BR,
   shiftEnterMode : CKEDITOR.ENTER_P,
   filebrowserUploadUrl : "${pageContext.request.contextPath}/AdminProduct/ckUpload"
 };
 
 CKEDITOR.replace("p_content", ckeditor_config);
// $(function(){
// 	CKEDITOR.replace('p_content',{
// 	filebrowserUploadUrl : '${pageContext.request.contextPath}/AdminProduct/ckUpload'
		
// 	});
	
// });
 
 $("#file").change(function(){
  if(this.files && this.files[0]) {
   var reader = new FileReader;
   reader.onload = function(data) {
    $(".select_img img").attr("src", data.target.result).width(500);        
   }
   reader.readAsDataURL(this.files[0]);
  }
 });
</script>







</body>
</html>