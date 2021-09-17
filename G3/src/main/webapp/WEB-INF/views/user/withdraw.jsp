<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link href="join.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>정말로 탈퇴하시겠습니까?</h3>
	
	<form action="./withdraw" method="post">	
	 
	 <input type="hidden" name="u_id" value="${vo.u_id}"><hr>
  	 
  	 <input type="password" name="u_pw" placeholder="비밀번호"><hr>
	 
	 <input type="submit" value="탈퇴하기">
	
	</form>
	<button ><a href="./main">돌아가기</a></button>

</body>
</html>