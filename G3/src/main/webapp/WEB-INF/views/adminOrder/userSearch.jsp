<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/adminOrder/userSearch.jsp</title>

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
			
		});
	</script>
    <!--jQuery 사용-->	
</head>
<body>
	<h1>WEB-INF/views/adminOrder/userSearch.jsp</h1>
	<h2>회원ID 검색(AdminOrderController)</h2>
	
	<form action="" method="post">
		<label for="u_id">회원ID: </label>
		<input type="text" id="u_id" name="u_id">
		<input type="submit" value="검색">
	</form>	
	
</body>
</html>